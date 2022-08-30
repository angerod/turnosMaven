
package com.angel.turnosmaven.ejb;

import com.angel.turnosmaven.ejb.modelo.Servicio;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author anger
 */
@Stateless
@LocalBean
public class ServicioBean {
    
    @PersistenceContext(unitName = "BD_Mysql")
    private EntityManager em;
    
    public List<Servicio> listaServicio(){
        //Query q = em.createNamedQuery("Cliente.findAll",Cliente.class);
        TypedQuery<Servicio> q = em.createNamedQuery("Servicio.findAll",Servicio.class);
        return q.getResultList();
    }
    

}
