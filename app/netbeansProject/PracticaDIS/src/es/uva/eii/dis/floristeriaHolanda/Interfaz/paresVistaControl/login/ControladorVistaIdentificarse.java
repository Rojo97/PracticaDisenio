/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login.VistaIdentificarse;
import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUIdentificarse;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Empleado;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PasswordIncorrectException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.UserNotFoundException;

/**
 *
 * @author super
 */
public class ControladorVistaIdentificarse {
    private VistaIdentificarse vista;
    private ControladorCUIdentificarse controladorCU;
    
    /**
     * Constructor de el controlador.
     * @param vista la vista que debe controlar.
     */
    public ControladorVistaIdentificarse(VistaIdentificarse vista) {
        this.vista = vista;
        controladorCU = new ControladorCUIdentificarse();
    }

    void salir() {
        System.exit(0);
    }
    
    /**
     * Comprueba las credenciales introducidas en la vista para logear el usuario
     */
    public void procesaEventoIdentificarse(){
        String d = vista.getDNI();
        String p = vista.getPassword();
        
        
        if(!d.isEmpty() && !p.isEmpty()){
            try{
                Empleado e = controladorCU.identificarEmpleado(d, p);
                
                boolean activo = controladorCU.compruebaEmpleadoActivo(e);
                if(!activo){
                    vista.mostrarErrorActivo();
                }else{
                    System.out.println("Acaba");
                    controladorCU.empleadoIdentificado();
                }
            }catch(UserNotFoundException exception){
                vista.mostrarErrorLogin();
            }catch(PasswordIncorrectException exception){
                vista.mostrarErrorPassword();
            }
        }
    }
    
    public void setPasswordVisible(){
        if(vista.verPasswordSelected()){
            vista.setPasswordVisible((char)0);
        }else{
            vista.setPasswordVisible('•');
        }
    }
    
    
}
