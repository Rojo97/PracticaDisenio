/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinasEstados;

import Main.Main;
import iniciosesion.VistaInicioSesion;
import javax.swing.JFrame;
import llistaDeseos.VistaDeseos;
import registro.VistaRegistro;
import reserva.VistaReserva;
import resultadosBusqueda.VistaBusqueda;

/**
 * Implementacion de la clase VistaBusquedaStateMachine
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class VistaBusquedaStateMachine {
    private JFrame currentState;
    /**
     * Constructor por defecto de la clase VistaBusquedaStateMachine
     */
    public VistaBusquedaStateMachine() {
        start();    
    }
    /**
     * Comienza el proceso de la maquina de estados inciando la ventana de busqueda
     */
    void start() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaBusqueda();
                currentState.setVisible(true);
            }
        });}
    /**
     * Inicia el proceso de registrarse abriendo la ventana de registro
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
     * Ejecuta el proceso de volver a la anterior ventana despues de loguearse
     */
    public void backLoguin() {
       currentState.dispose();   // si se desea destruir
       // Para gestionar los backs podría convenir manejar un atributo que guarde el estado anterior
       // esta opción no hace eso, sería mejorable
       start();
    }
    /**
     * Ejecuta el proceso de volver despues de registrarse
     */
    public void backRegistro(){
        currentState.dispose();
        
        currentState = new VistaInicioSesion();
        currentState.setVisible(true);
    }
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
    
    public void reservar() {
        currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaReserva();
                currentState.setVisible(true);
            }
        });
    }
    
    public void añadirLista() {
        currentState.dispose(); 
       //transición
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentState = new VistaDeseos();
                currentState.setVisible(true);
            }
        });
    }
    
    public void back() {
       currentState.dispose();   // si se desea destruir
       // Para gestionar los backs podría convenir manejar un atributo que guarde el estado anterior
       // esta opción no hace eso, sería mejorable
       start();
    }
    
    public void close(){
        currentState.dispose();
    }
}
