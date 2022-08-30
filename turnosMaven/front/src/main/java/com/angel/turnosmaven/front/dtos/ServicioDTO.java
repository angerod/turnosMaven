package com.angel.turnosmaven.front.dtos;

/**
 *
 */
public class ServicioDTO {
    
    private Integer idPK;
    private String label;

    public ServicioDTO(Integer idPK, String label) {
        this.idPK = idPK;
        this.label = label;
    }

    public ServicioDTO() {
    }

    
    public Integer getIdPK() {
        return idPK;
    }

    public void setIdPK(Integer idPK) {
        this.idPK = idPK;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
}
