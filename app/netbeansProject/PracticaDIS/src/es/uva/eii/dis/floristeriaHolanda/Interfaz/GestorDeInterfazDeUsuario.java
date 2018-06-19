/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.login.VistaLogin;
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
                currentState = new VistaLogin();
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
}
