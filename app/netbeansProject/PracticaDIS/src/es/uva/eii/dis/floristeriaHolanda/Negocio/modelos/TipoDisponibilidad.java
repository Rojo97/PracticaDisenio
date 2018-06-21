/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

/**
 *
 * @author ismael
 */
public enum TipoDisponibilidad {
    VACACIONES("Vacaciones", 1),
    BAJATEMPORAL("BajaTemporal",2),
    TRABAJANDO("Trabajando",3);
    
    private String nombre;
    private int disponibilidad;
    
    private TipoDisponibilidad(String nombre, int disponibilidad){
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getNumero(){
        return disponibilidad;
    }
    
    public static TipoDisponibilidad getTipoDisponibilidadPorNumero(int disponibilidad){
        switch(disponibilidad){
            case(1):
                return TipoDisponibilidad.VACACIONES;
            case(2):
                return TipoDisponibilidad.BAJATEMPORAL;
            case(3):
                return TipoDisponibilidad.TRABAJANDO;
        }
        return null;
    }
}
