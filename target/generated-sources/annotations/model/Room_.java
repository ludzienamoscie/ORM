package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Room.class)
public abstract class Room_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Room, Long> room_id;
	public static volatile SingularAttribute<Room, Integer> roomNumber;
	public static volatile SingularAttribute<Room, Integer> capacity;

	public static final String ROOM_ID = "room_id";
	public static final String ROOM_NUMBER = "roomNumber";
	public static final String CAPACITY = "capacity";

}

