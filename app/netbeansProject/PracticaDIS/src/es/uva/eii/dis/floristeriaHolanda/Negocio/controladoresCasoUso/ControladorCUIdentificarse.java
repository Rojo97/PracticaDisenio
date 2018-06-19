/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Empleado;

/**
 *
 * @author ismael
 */
public class ControladorCUIdentificarse {
    
    public ControladorCUIdentificarse(){       
    }
    
    public Empleado identificarEmpleado(String d, String p){
        return Empleado.getEmpleadoPorDNIyPass(d, p);
    }
}
