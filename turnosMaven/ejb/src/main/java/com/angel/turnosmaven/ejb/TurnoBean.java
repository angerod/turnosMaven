
package com.angel.turnosmaven.ejb;

import com.angel.turnosmaven.ejb.modelo.Turno;
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
public class TurnoBean {
    
    @PersistenceContext(unitName = "BD_Mysql")
    private EntityManager em;
    
        
    public Turno guardar(Turno t){
        TypedQuery<Integer> q = em.createNamedQuery("Turno.findMaxId",Integer.class);
        Integer indice = q.getSingleResult();
        if(indice == null){
            indice = 1;
        }else{
            indice +=1;
        }
        t.setIdturnos(indice);
        em.persist(t);
        return t;
    }
    
    public Turno actualizar(Turno t){
        em.merge(t);
        return t;
    }
    
    
}
