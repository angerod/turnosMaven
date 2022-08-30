/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angel.turnosmaven.front;

import com.angel.turnosmaven.ejb.ClienteBean;
import com.angel.turnosmaven.ejb.ServicioBean;
import com.angel.turnosmaven.ejb.TurnoBean;
import com.angel.turnosmaven.ejb.modelo.Cliente;
import com.angel.turnosmaven.ejb.modelo.Servicio;
import com.angel.turnosmaven.ejb.modelo.Turno;
import com.angel.turnosmaven.front.dtos.ServicioDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author anger
 */
@Named("ClienteAsignarTurno")
@RequestScoped
public class ClienteAsignarTurno implements Serializable{
    
    private List<ServicioDTO> listaServiciosDTOs; 
    
    @EJB 
    private ClienteBean clienteBean;
    @EJB 
    private TurnoBean turnoBean;
    @EJB 
    private ServicioBean servicioBean;
    private List<Cliente> items = null;    
    private Cliente selected;
    private Turno asignarTurno;
    private int idServicioSeleccionado;

    private String clienteBuscar;
    
    private boolean mostrarObservacion = false;
    private boolean mostrarTurno = false;
    private boolean mostrarBuscar = true;
    
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
        this.selected = cli;
        System.out.println("agregarObservacion");
        mostrarObservacion = true;
        mostrarTurno = false;
    }
    
   
    public void agregarTurno(Cliente cli){
        //this.selected = cli;
        System.out.println("agregarTurno");
        System.out.println("servicioSeleccionado"+idServicioSeleccionado);
         asignarTurno = new Turno();
         asignarTurno.setIdcliente(cli);
         
         Servicio servicioModel = new Servicio();
         servicioModel.setIdservicio( idServicioSeleccionado );
         
         asignarTurno.setIdservicio( servicioModel );
         asignarTurno.setFechaRegistro(new Date());
         
         turnoBean.guardar(asignarTurno);
         
         //Actualizar turno en registro cliente
         cli.setTurno_asignado("S");         
         clienteBean.actualizar(cli);
         
         mostrarObservacion = false;
         mostrarTurno = false;
         
         //selected = new Cliente();
         
         items = clienteBean.listaClientes();
    }
    
    public void recargarTabla(){
        System.out.println("recargarTabla");
         items = clienteBean.listaClientes();
         System.out.println("cantidad registros"+items.size());
    }
    
    public void filtrarTablaxCliente(){
        System.out.println("filtrarTablaxCliente");
        items = clienteBean.listaClientesxIdentificacion(clienteBuscar);
        if (items.size()>=1){
            mostrarTurno = true;
        }
        clienteBuscar = "";
        mostrarBuscar = false;
    }
    

    public List<Cliente> getItems() {
        return items;
    }

    public void setItems(List<Cliente> items) {
        this.items = items;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }


    public boolean isMostrarObservacion() {
        return mostrarObservacion;
    }

    public void setMostrarObservacion(boolean mostrarObservacion) {
        this.mostrarObservacion = mostrarObservacion;
    }

   

    public boolean isMostrarTurno() {
        return mostrarTurno;
    }

    public void setMostrarTurno(boolean mostrarTurno) {
        this.mostrarTurno = mostrarTurno;
    }

    public List<ServicioDTO> getListaServiciosDTOs() {
        return listaServiciosDTOs;
    }

    public void setListaServiciosDTOs(List<ServicioDTO> listaServiciosDTOs) {
        this.listaServiciosDTOs = listaServiciosDTOs;
    }

    public int getIdServicioSeleccionado() {
        return idServicioSeleccionado;
    }

    public void setIdServicioSeleccionado(int idServicioSeleccionado) {
        this.idServicioSeleccionado = idServicioSeleccionado;
    }

    

    

    
    public String getClienteBuscar() {
        return clienteBuscar;
    }

    public void setClienteBuscar(String clienteBuscar) {
        this.clienteBuscar = clienteBuscar;
    }

    public boolean isMostrarBuscar() {
        return mostrarBuscar;
    }

    public void setMostrarBuscar(boolean mostrarBuscar) {
        this.mostrarBuscar = mostrarBuscar;
    }
    
    
    
}
