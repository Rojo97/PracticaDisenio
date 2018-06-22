/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Empleado;

/**
 *
 * @author ismael
 */
public class Sesion {
    
    private static Sesion sesion;
    private static Empleado empleado;
    
    private Sesion(){
        
    }
    
    public static Sesion getInstancia(){
        if(sesion!=null){
            return sesion;
        }else{
            sesion = new Sesion();
            return sesion;
        }
    }
    
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }
    
    public Empleado getEmpleado(){
        return empleado;
    }
}
