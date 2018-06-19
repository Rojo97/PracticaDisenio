/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistaDeseos;

import Main.Main;
import modelos.Modelo;

/**
 * Implementacion de laclase ControladorVistaDeseos
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaDeseos {
    
    private VistaDeseos vista;
    /**
     * Constructor por defecto
     * @param VistaDeseos vista 
     */
    public ControladorVistaDeseos(VistaDeseos vista){
        this.vista = vista;
    }
    /**
     * Devuelve el modelo que se esta utilizando
     * @return Modelo modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    /**
     * Ejecuta el proceso de reiniciar la busqueda
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
