/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login.VistaIdentificarse;
import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.opciones.VistaOpcionesAdministrativo;
import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.opciones.VistaOpcionesDependiente;
import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.opciones.VistaOpcionesOperario;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.Sesion;
import javax.swing.JFrame;

/**
 *
 * @author super
 */
public class GestorDeInterfazDeUsuario {

    private JFrame currentState;
    private JFrame lastState = null;

    /**
     * Constructor de la máquina de estados.
     */
    public GestorDeInterfazDeUsuario() {
        start();
    }

    /**
     * Método que inicia la ventana de la cartelera "HomeWindow".
     */
    public void start() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                currentState = new VistaIdentificarse();
                currentState.setVisible(true);
            }
        });
    }
    
    /**
     * Método que cierra la ventana actual y abre la anterior.
     */
    void close() {
        if (lastState != null) {
            currentState.dispose();   // si se desea destruir
            currentState = lastState;
            currentState.setVisible(true);
            lastState = null;
        } else {
            currentState.dispose();
        }
    }
        /**
     * Método que oculta el estado recibido.
     * @param state ventana a ocultar.
     */
    void hide(JFrame state) {
        state.setVisible(false);
    }
    /**
     * Método que destruye el estado actual.
     */
    void dispose(){
        currentState.dispose();
    }
    
    /**
     * Método que cierra la ventana actual y abre la anterior.
     */
    public void empleadoIdentificado() {
        Sesion sesion = Sesion.getInstancia();
        
        String rol = sesion.getEmpleado().getUltimoRol().getRol();
        System.out.println("Rol: " + rol);
                
        currentState.dispose();
        
        switch(rol){
            case "Administrativo":
                currentState = new VistaOpcionesAdministrativo();
                break;
            case "Dependiente":
                currentState = new VistaOpcionesDependiente();
                break;
            case "Operario":
                currentState = new VistaOpcionesOperario();
                break;
        }
        
        currentState.setVisible(true);
    }
    
    public void modificarLote(){
        currentState.dispose();
        
        currentState = new VistaModificarLote();
        currentState.setVisible(true); 
    }
    
    public void cerrarSesion() {
                
        currentState.dispose();
        
        currentState = new VistaIdentificarse();
        currentState.setVisible(true);
    }

    public void estimar(int lote, String planta) {
        currentState.hide();
        lastState = currentState;
        
        currentState = new VistaEstimarFlores(lote, planta);
        currentState.setVisible(true);
    }

    public void volver() {
        currentState.dispose();
        currentState = lastState;
        lastState = null;
        currentState.setVisible(true);
    }
}
