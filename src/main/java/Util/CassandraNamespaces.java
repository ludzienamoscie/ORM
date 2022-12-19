package Util;
import com.datastax.oss.driver.api.core.CqlIdentifier;

public class CassandraNamespaces {

    public static final CqlIdentifier CINEMA_NAMESPACE = CqlIdentifier.fromCql("cinema");
    public static final CqlIdentifier CLIENT_ID = CqlIdentifier.fromCql("clients_id");
    public static final CqlIdentifier SHOW_ID = CqlIdentifier.fromCql("shows_id");
    public static final CqlIdentifier ROOM_ID = CqlIdentifier.fromCql("rooms_id");
    public static final CqlIdentifier TICKET_ID = CqlIdentifier.fromCql("tickets_id");

}
