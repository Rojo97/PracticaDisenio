/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login.VistaIdentificarse;
import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUIdentificarse;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Empleado;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.Sesion;

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
            Empleado e = controladorCU.identificarEmpleado(d, p);
            
            if(e==null){
                vista.mostrarErrorLogin();
            }else{
                
                if(!e.estaActivo()){
                    vista.mostrarErrorActivo();
                }else{
                    Sesion sesion = Sesion.getInstancia();
                    sesion.setEmpleado(e);
                    System.out.println("Acaba");
                }
                
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
