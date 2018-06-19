/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva;

import Main.Main;
import modelos.Modelo;

/**
 * Implementacion de la clase ControladorVistaReserva
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaReserva {
    
    private VistaReserva vista;
    /**
     * Constructor por defecto de la clase ControladorVistaReserva
     * @param VistaReserva vista 
     */
    public ControladorVistaReserva(VistaReserva vista){
        this.vista = vista;
    }
    /**
     * Devuelve el modelo que se esta usando
     * @return Modelo modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    /**
     * Reinicia el proceso
     */
    public void reiniciar(){
        Main.back();
    }
    /**
     * Vuelve a la ventana anterior
     */
    public void volver(){
        Main.getVistaBusquedaSM().back();
    }
}
