/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import java.util.Date;

/**
 *
 * @author ismael
 */
public class Disponibilidad {
    
    private Date comienzo;
    private Date finalPrevisto;
    private String disponibilidad;
    
    public Disponibilidad(Date comienzo, Date finalPrevisto, String disponibilidad){
        
        this.comienzo = comienzo;
        this.finalPrevisto = finalPrevisto;
        this.disponibilidad = disponibilidad;
    }
    
    public String getDisponibilidad(){
        return disponibilidad;
    }
    
    /*public String getNombreDisponibilidad(){
        return disponibilidad.getNombre();
    }*/
    
    /*public int getNumeroDisponibilidad(){
        return disponibilidad.getNumero();
    }*/
    
    public Date getComienzo(){
        return (Date)comienzo.clone();
    }
    
    public Date getFinalPrevisto(){
        return (Date)finalPrevisto.clone();
    }
}
