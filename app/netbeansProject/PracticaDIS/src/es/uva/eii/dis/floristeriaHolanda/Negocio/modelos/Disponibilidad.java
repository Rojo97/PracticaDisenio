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
    private int disponibilidad;
    
    public Disponibilidad(Date comienzo, Date finalPrevisto, int disponibilidad){
        
        this.comienzo = comienzo;
        this.finalPrevisto = finalPrevisto;
        this.disponibilidad = disponibilidad;
    }
    
    public int getDisponibilidad(){
        return disponibilidad;
    }
    
    public Date getComienzo(){
        return (Date)comienzo.clone();
    }
    
    public Date getFinalPrevisto(){
        return (Date)finalPrevisto.clone();
    }
    
    public static String getNombreDisponibilidad(int n){
        
        if(n<0 || n>3){
            throw new IllegalArgumentException();
        }
        
        String disponibilidad = "";
        
        switch(n){
            case(1):
                disponibilidad = "Vacaciones";
                break;
            case(2):
                disponibilidad = "BajaTemporal";
                 break;
            case(3):
                disponibilidad = "Trabajando";
                 break;
        }
        
        return disponibilidad;
    }
}
