package com.angel.turnosmaven.ejb.modelo;

import com.angel.turnosmaven.ejb.modelo.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-29T16:30:55")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> apellidos;
    public static volatile SingularAttribute<Cliente, String> barrio;
    public static volatile SingularAttribute<Cliente, String> turno_asignado;
    public static volatile SingularAttribute<Cliente, String> numeroIdentificacion;
    public static volatile SingularAttribute<Cliente, String> tipoIdentificacion;
    public static volatile SingularAttribute<Cliente, String> ciudad;
    public static volatile ListAttribute<Cliente, Turno> turnoList;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, String> departamento;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> edad;
    public static volatile SingularAttribute<Cliente, String> nombres;

}