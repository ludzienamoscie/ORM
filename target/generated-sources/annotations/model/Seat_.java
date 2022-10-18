package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Seat.class)
public abstract class Seat_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Seat, Ticket> ticket;
	public static volatile SingularAttribute<Seat, Boolean> isFree;
	public static volatile SingularAttribute<Seat, Long> seat_id;
	public static volatile SingularAttribute<Seat, Integer> column;
	public static volatile SingularAttribute<Seat, Integer> row;
	public static volatile SingularAttribute<Seat, Room> room;

	public static final String TICKET = "ticket";
	public static final String IS_FREE = "isFree";
	public static final String SEAT_ID = "seat_id";
	public static final String COLUMN = "column";
	public static final String ROW = "row";
	public static final String ROOM = "room";

}

