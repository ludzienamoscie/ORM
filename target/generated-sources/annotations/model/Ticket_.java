package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import model.Ticket.TicketType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ticket.class)
public abstract class Ticket_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Ticket, Double> price;
	public static volatile SingularAttribute<Ticket, Show> show;
	public static volatile SingularAttribute<Ticket, Client> client;
	public static volatile SingularAttribute<Ticket, TicketType> ticketType;
	public static volatile SingularAttribute<Ticket, Long> ticket_id;

	public static final String PRICE = "price";
	public static final String SHOW = "show";
	public static final String CLIENT = "client";
	public static final String TICKET_TYPE = "ticketType";
	public static final String TICKET_ID = "ticket_id";

}

