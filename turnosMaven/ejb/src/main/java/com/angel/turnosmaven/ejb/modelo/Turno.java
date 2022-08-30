/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angel.turnosmaven.ejb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author anger
 */
@Entity
@Table(name = "turno")
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByIdturnos", query = "SELECT t FROM Turno t WHERE t.idturnos = :idturnos"),
    @NamedQuery(name = "Turno.findMaxId", query = "SELECT MAX(c.idturnos) FROM Turno c"),
    @NamedQuery(name = "Turno.findByFechaRegistro", query = "SELECT t FROM Turno t WHERE t.fechaRegistro = :fechaRegistro")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idturnos")
    private Integer idturnos;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "idcliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicio idservicio;

    public Turno() {
    }

    public Turno(Integer idturnos) {
        this.idturnos = idturnos;
    }

    public Turno(Integer idturnos, Date fechaRegistro) {
        this.idturnos = idturnos;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdturnos() {
        return idturnos;
    }

    public void setIdturnos(Integer idturnos) {
        this.idturnos = idturnos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturnos != null ? idturnos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idturnos == null && other.idturnos != null) || (this.idturnos != null && !this.idturnos.equals(other.idturnos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.angel.turnosmaven.ejb.modelo.Turno[ idturnos=" + idturnos + " ]";
    }
    
}
