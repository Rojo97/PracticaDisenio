/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinasEstados;

import busquedaFallida.VistaBusquedaFallida;
import iniciosesion.VistaInicioSesion;
import javax.swing.JFrame;
import modelos.Modelo;
import principal.VistaPrincipal;
import registro.VistaRegistro;

/**
 * Implementacion de la clase VistaPrincipalStateMachine
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class VistaPrincipalStateMachine {
    private JFrame currentState;
    /**
     * Constructor por defecto de la clase VistaPrincipalStateMachine
     */
    public VistaPrincipalStateMachine() {
        start();    
    }
    /**
     * Ejecuta el proceso de inicio abriendo la ventana principal
     */
    void start() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaPrincipal();
                currentState.setVisible(true);
            }
        });}
    /**
     * Ejecuta el proceso de loguearse abriendo la ventana de inicio de sesion
     */
    public void loguin() {
        currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaInicioSesion();
                currentState.setVisible(true);
            }
        });
    }
    /**
     * Inicia el proceso de resgistrarseabriendo la ventana de registro
     */
    public void registrarse() {
        currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaRegistro();
                currentState.setVisible(true);
            }
        });
    }
    /**
     * Ejecuta el proceso de volver a la ventana principal
     */
    public void back() {
       currentState.dispose();   // si se desea destruir
       // Para gestionar los backs podría convenir manejar un atributo que guarde el estado anterior
       // esta opción no hace eso, sería mejorable
       start();
    }
    /**
     * Ejecuta el proceso de volver a la ventana anterior desde el registro
     */
    public void backRegistro(){
        currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaInicioSesion();
                currentState.setVisible(true);
            }
        });
    }
    /**
     * Cierra la ventana actual
     */
    public void close(){
        currentState.dispose();
    }
    /**
     * Ejecuta el proceso de una busqueda fallida abirneod la ventana de busqueda fallida
     */
    public void busFallida(){
       currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaBusquedaFallida();
                currentState.setVisible(true);
            }
        });
    }
   
}
