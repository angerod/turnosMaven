package com.angel.turnosmaven.ejb.modelo;

import com.angel.turnosmaven.ejb.modelo.Cliente;
import com.angel.turnosmaven.ejb.modelo.Servicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-29T16:30:55")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> fechaRegistro;
    public static volatile SingularAttribute<Turno, Cliente> idcliente;
    public static volatile SingularAttribute<Turno, Integer> idturnos;
    public static volatile SingularAttribute<Turno, Servicio> idservicio;

}