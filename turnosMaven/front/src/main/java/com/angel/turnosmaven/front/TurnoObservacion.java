
package com.angel.turnosmaven.front;

import com.angel.turnosmaven.ejb.ClienteBean;
import com.angel.turnosmaven.ejb.ServicioBean;
import com.angel.turnosmaven.ejb.modelo.Cliente;
import com.angel.turnosmaven.ejb.modelo.Servicio;
import com.angel.turnosmaven.front.dtos.ServicioDTO;
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
@Named("TurnoObservacion")
@RequestScoped
public class TurnoObservacion implements Serializable{
    
    private List<ServicioDTO> listaServiciosDTOs; 
    
    @EJB 
    private ClienteBean clienteBean;
    @EJB 
    private ServicioBean servicioBean;
    
    private List<Cliente> items = null;    
    private Cliente selected;
    private int idServicioSeleccionado;
    
    
    @PostConstruct
    public void init(){
        System.out.println("init");
        
        selected = new Cliente();        
        
        items = clienteBean.listaClientes();        
        List<Servicio> lista = servicioBean.listaServicio();
        listaServiciosDTOs = new ArrayList<>();
        lista.forEach( servicio -> {
            listaServiciosDTOs.add(new ServicioDTO( servicio.getIdservicio(), servicio.getNombre()));
        });
    }
    
    public void agregarObservacion(Cliente cli){
        System.out.println("agregarObservacion");
    }

    public List<ServicioDTO> getListaServiciosDTOs() {
        return listaServiciosDTOs;
    }

    public void setListaServiciosDTOs(List<ServicioDTO> listaServiciosDTOs) {
        this.listaServiciosDTOs = listaServiciosDTOs;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public List<Cliente> getItems() {
        return items;
    }

    public void setItems(List<Cliente> items) {
        this.items = items;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

    public int getIdServicioSeleccionado() {
        return idServicioSeleccionado;
    }

    public void setIdServicioSeleccionado(int idServicioSeleccionado) {
        this.idServicioSeleccionado = idServicioSeleccionado;
    }
    
    
    
}
