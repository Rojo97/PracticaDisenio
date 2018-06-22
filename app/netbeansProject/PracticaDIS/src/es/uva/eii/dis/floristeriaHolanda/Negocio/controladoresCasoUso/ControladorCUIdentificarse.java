/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Empleado;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PasswordIncorrectException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.Sesion;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.UserNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;
import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;

/**
 *
 * @author ismael
 */
public class ControladorCUIdentificarse {
    
    public ControladorCUIdentificarse(){       
    }
    
    public Empleado identificarEmpleado(String d, String p) throws UserNotFoundException, PasswordIncorrectException{
        return Empleado.getEmpleadoPorDNIyPass(d, p);
    }
    
    public boolean compruebaEmpleadoActivo(Empleado e){
        if(!e.estaActivo()){
            return false;
        }
        
        setEmpleadoEnSesion(e);
        return true;
    }
    
    public void setEmpleadoEnSesion(Empleado e){
        Sesion sesion = Sesion.getInstancia();
        sesion.setEmpleado(e);
    }
    
    public void empleadoIdentificado(){
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.empleadoIdentificado();
    }
}
