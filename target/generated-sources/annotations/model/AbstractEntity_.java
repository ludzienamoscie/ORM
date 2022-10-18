package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import org.junit.platform.engine.UniqueId;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractEntity.class)
public abstract class AbstractEntity_ {

	public static volatile SingularAttribute<AbstractEntity, Long> version;
	public static volatile SingularAttribute<AbstractEntity, UniqueId> abstractEntityId;

	public static final String VERSION = "version";
	public static final String ABSTRACT_ENTITY_ID = "abstractEntityId";

}

