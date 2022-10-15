package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.ArrayList;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Room.class)
public abstract class Room_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Room, Long> room_id;
	public static volatile SingularAttribute<Room, Integer> roomNumber;
	public static volatile SingularAttribute<Room, Integer> columns;
	public static volatile SingularAttribute<Room, Integer> rows;
	public static volatile SingularAttribute<Room, ArrayList> seats;
	public static volatile SingularAttribute<Room, Integer> capacity;

	public static final String ROOM_ID = "room_id";
	public static final String ROOM_NUMBER = "roomNumber";
	public static final String COLUMNS = "columns";
	public static final String ROWS = "rows";
	public static final String SEATS = "seats";
	public static final String CAPACITY = "capacity";

}

