package Util;
import com.datastax.oss.driver.api.core.CqlIdentifier;

public class CassandraNamespaces {

    public static final CqlIdentifier CINEMA_NAMESPACE = CqlIdentifier.fromCql("cinema");
    public static final CqlIdentifier CLIENTS_ID = CqlIdentifier.fromCql("clients_id");
        public static final CqlIdentifier CLIENT_ID = CqlIdentifier.fromCql("client_id");
        public static final CqlIdentifier BIRTHDAY = CqlIdentifier.fromCql("birthday");
        public static final CqlIdentifier PHONENUMBER = CqlIdentifier.fromCql("phoneNumber");
        public static final CqlIdentifier FIRSTNAME = CqlIdentifier.fromCql("firstName");
        public static final CqlIdentifier LASTNAME = CqlIdentifier.fromCql("lastName");
        public static final CqlIdentifier CLIENTTYPE = CqlIdentifier.fromCql("clientType");
    public static final CqlIdentifier SHOWS_ID = CqlIdentifier.fromCql("shows_id");
        public static final CqlIdentifier SHOW_ID = CqlIdentifier.fromCql("show_id");
        public static final CqlIdentifier ROOM_ID = CqlIdentifier.fromCql("room_id");
        public static final CqlIdentifier BEGINTIME = CqlIdentifier.fromCql("beginTime");
        public static final CqlIdentifier ENDTIME = CqlIdentifier.fromCql("endTime");
        public static final CqlIdentifier SHOWTYPE = CqlIdentifier.fromCql("showType");

    public static final CqlIdentifier ROOMS_ID = CqlIdentifier.fromCql("rooms_id");
        public static final CqlIdentifier CAPACITY = CqlIdentifier.fromCql("capacity");
    public static final CqlIdentifier TICKETS_ID = CqlIdentifier.fromCql("tickets_id");
        public static final CqlIdentifier TICKET_ID = CqlIdentifier.fromCql("ticket_id");
        public static final CqlIdentifier PRICE = CqlIdentifier.fromCql("price");
        public static final CqlIdentifier TICKETTYPE = CqlIdentifier.fromCql("ticketType");

}
