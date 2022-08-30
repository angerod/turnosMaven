
package com.angel.turnosmaven.front;

import com.angel.turnosmaven.ejb.ClienteBean;
import com.angel.turnosmaven.ejb.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author anger
 */
@Named("clienteRegistrar")
@RequestScoped
public class ClienteRegistrar implements Serializable{
    
    private List<String> listaServicios;    
    private String servicioSeleccionado;
    
    private Cliente selected;  
    
    @EJB
    private ClienteBean clienteBean;
    
    @PostConstruct
    public void init(){
        selected = new Cliente();
    }

    
    
    public void registrarCliente(){
        System.out.println("registrando al cliente"+ selected.getNombres() );
        clienteBean.guardar(selected);
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

    public List<String> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<String> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public String getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    public void setServicioSeleccionado(String servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
    }
    
    
    
}
