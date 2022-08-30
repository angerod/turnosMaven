
package com.angel.turnosmaven.ejb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anger
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Cliente.findByBarrio", query = "SELECT c FROM Cliente c WHERE c.barrio = :barrio"),
    @NamedQuery(name = "Cliente.findByCiudad", query = "SELECT c FROM Cliente c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cliente.findByDepartamento", query = "SELECT c FROM Cliente c WHERE c.departamento = :departamento"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByEdad", query = "SELECT c FROM Cliente c WHERE c.edad = :edad"),
    @NamedQuery(name = "Cliente.findMaxId", query = "SELECT MAX(c.id) FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByNumeroIdentificacion", query = "SELECT c FROM Cliente c WHERE c.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "Cliente.findByTipoIdentificacion", query = "SELECT c FROM Cliente c WHERE c.tipoIdentificacion = :tipoIdentificacion")})
public class Cliente implements Serializable {

    
    @OneToMany(mappedBy = "idcliente", fetch = FetchType.EAGER)
    private List<Turno> turnoList;

    private static final long serialVersionUID = 1231243425436L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "edad")
    private String edad;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    @Column(name = "turno_asignado")
    private String turno_asignado;
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTurno_asignado() {
        return turno_asignado;
    }

    public void setTurno_asignado(String turno_asignado) {
        this.turno_asignado = turno_asignado;
    }

   

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", apellidos=" + apellidos + ", barrio=" + barrio + ", ciudad=" + ciudad + ", departamento=" + departamento + ", direccion=" + direccion + ", edad=" + edad + ", nombres=" + nombres + ", numeroIdentificacion=" + numeroIdentificacion + ", turno_asignado=" + turno_asignado + ", tipoIdentificacion=" + tipoIdentificacion + '}';
    }

    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }
    
    
    
    
}
