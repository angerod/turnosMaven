
package com.angel.turnosmaven.ejb;

import com.angel.turnosmaven.ejb.modelo.Cliente;
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
public class ClienteBean {
    
    @PersistenceContext(unitName = "BD_Mysql")
    private EntityManager em;
    
    public List<Cliente> listaClientes(){
        //Query q = em.createNamedQuery("Cliente.findAll",Cliente.class);
        TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findAll",Cliente.class);
        return q.getResultList();
    }
    
    public List<Cliente> listaClientesxIdentificacion(String identificacion){
        //Query q = em.createNamedQuery("Cliente.findAll",Cliente.class);
        
        TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByNumeroIdentificacion",Cliente.class);
        q.setParameter("numeroIdentificacion", identificacion);
        return q.getResultList();
    }
    
    public Cliente guardar(Cliente cli){
        TypedQuery<Integer> q = em.createNamedQuery("Cliente.findMaxId",Integer.class);
        Integer indice = q.getSingleResult();
        if(indice == null){
            indice = 1;
        }else{
            indice +=1;
        }
        cli.setId(indice);
        cli.setTurno_asignado("N");
        em.persist(cli);
        return cli;
    }
    
    public Cliente actualizar(Cliente cli){
        em.merge(cli);
        return cli;
    }
    
    
    
}
