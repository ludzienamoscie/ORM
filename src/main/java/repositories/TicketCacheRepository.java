package repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import managers.TicketManager;
import model.Ticket;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import redis.clients.jedis.*;
import redis.clients.jedis.json.Path;
import java.io.ObjectInputFilter;
import java.util.Optional;
import java.util.UUID;

public class TicketCacheRepository extends TicketRepository {

    private JedisPooled pool;
    private Jedis jedis;
    private Gson gson;

    private long lastCheck;
    private boolean connected;

    public TicketCacheRepository(){
        try{
            gson = new GsonBuilder().create();

          Config config = ConfigProvider.getConfig();

          String host = config.getValue("jedis.host",String.class);
          int port = config.getValue("jedis.port",Integer.class);

            JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().socketTimeoutMillis(100).build();
//            jedis = new Jedis(new HostAndPort("localhost",6379),clientConfig);
//            pool = new JedisPooled(new HostAndPort("localhost",6379),clientConfig);
//
          jedis = new Jedis(new HostAndPort(host,port),clientConfig);
          pool = new JedisPooled(new HostAndPort(host,port),clientConfig);

            pool.set("ping","ping");
            connected = true;
        } catch (Exception e){
            connected = false;
        }
    }

    private boolean healthcheck(){
        if(System.currentTimeMillis() - lastCheck < 60000){
            return false;
        }
        try{
            pool.set("ping","ping");
        } catch (Exception e){
            return false;
        }

        if(!connected){
            jedis.flushDB();
            connected = true;
        }
        return true;
    }

    @Override
    public Ticket add(Ticket ticket){
        Ticket ticket1 = super.add(ticket);

        if(connected){
            try {
                addToCache(ticket);
            } catch (Exception e){
                jedisConnectionExceptionHandler(e);
            }
        } else {
            if(healthcheck()){
                add(ticket);
            }
        }
        return ticket1;
    }

    @Override
    public void remove(Ticket ticket){
        if(connected){
            try{
                pool.jsonDel("tickets:" + ticket.getUuid());
            } catch (Exception e){
                jedisConnectionExceptionHandler(e);
                remove(ticket);
            }
        } else {
            if(healthcheck()){
                remove(ticket);
            }
        }
        super.remove(ticket);
    }

    @Override
    public Ticket getByUUID(UUID uuid){
        if(connected){
            Ticket ticket = null;
            try{
                String json = pool.jsonGetAsPlainString("tickets:" + uuid, Path.ROOT_PATH);
                ticket = gson.fromJson(json,Ticket.class);
            } catch (Exception e){
                jedisConnectionExceptionHandler(e);
                getByUUID(uuid);
            }

            if(ticket != null){
                System.out.println("Got ticket from cache");
                return ticket;
            } else {
                Ticket ticket1 = super.getByUUID(uuid);
                try{
                    if(ticket1 != null){
                        addToCache(ticket1);
                    }
                } catch (Exception e){
                    jedisConnectionExceptionHandler(e);
                }
                return ticket1;
            }
        }else{
            if(healthcheck()){
                getByUUID(uuid);
            }
        }
        return super.getByUUID(uuid);
    }

    @Override
    public boolean update(Ticket ticket){
        boolean successful = super.update(ticket);
        if(connected && successful) {
            try{
                pool.jsonSet("tickets:" + ticket.getUuid(), gson.toJson(ticket));
            } catch (Exception e){
                jedisConnectionExceptionHandler(e);
                update(ticket);
            }
        }else if(!connected && successful){
            if(healthcheck()){
                update(ticket);
            }
        }
        return successful;
    }

    @Override
    public Ticket getByTicket(Long number) {
        if(connected){
            Ticket ticket = null;
            try{
                String json = pool.jsonGetAsPlainString("tickets:" + number, Path.ROOT_PATH);
                ticket = gson.fromJson(json,Ticket.class);
            } catch (Exception e){
                jedisConnectionExceptionHandler(e);
                getByTicket(number);
            }

            if(ticket != null){
                System.out.println("Got ticket from cache");
                return ticket;
            } else {
                Ticket ticket1 = super.getByTicket(number);
                try{
                    if(ticket1 != null){
                        addToCache(ticket1);
                    }
                } catch (Exception e){
                    jedisConnectionExceptionHandler(e);
                }
                return ticket1;
            }
        }else{
            if(healthcheck()){
                getByTicket(number);
            }
        }
        return super.getByTicket(number);
    }

    private void addToCache(Ticket ticket){
        pool.jsonSet("tickets:" + ticket.getTicket(), gson.toJson(ticket));
        pool.expire("tickets:" + ticket.getTicket(), 60);
    }
    private void jedisConnectionExceptionHandler(Exception e){
        e.printStackTrace();
        connected = false;
        lastCheck = System.currentTimeMillis();
    }
}
