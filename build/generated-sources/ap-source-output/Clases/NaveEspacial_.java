package Clases;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NaveEspacial.class)
public abstract class NaveEspacial_ {

	public static volatile SingularAttribute<NaveEspacial, Integer> peso;
	public static volatile SingularAttribute<NaveEspacial, Float> empuje;
	public static volatile SingularAttribute<NaveEspacial, byte[]> imagen;
	public static volatile SingularAttribute<NaveEspacial, Date> finActividad;
	public static volatile SingularAttribute<NaveEspacial, Long> id;
	public static volatile SingularAttribute<NaveEspacial, Origen> origen;
	public static volatile SingularAttribute<NaveEspacial, String> nombre;
	public static volatile SingularAttribute<NaveEspacial, Date> inicioActividad;
	public static volatile SingularAttribute<NaveEspacial, String> combustible;

}

