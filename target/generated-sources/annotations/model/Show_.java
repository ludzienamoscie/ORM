package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import model.Show.ShowType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Show.class)
public abstract class Show_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Show, Long> show_id;
	public static volatile SingularAttribute<Show, Integer> availableSeats;
	public static volatile SingularAttribute<Show, ShowType> showType;
	public static volatile SingularAttribute<Show, LocalDateTime> beginTime;
	public static volatile SingularAttribute<Show, LocalDateTime> endTime;
	public static volatile SingularAttribute<Show, Room> room;

	public static final String SHOW_ID = "show_id";
	public static final String AVAILABLE_SEATS = "availableSeats";
	public static final String SHOW_TYPE = "showType";
	public static final String BEGIN_TIME = "beginTime";
	public static final String END_TIME = "endTime";
	public static final String ROOM = "room";

}

