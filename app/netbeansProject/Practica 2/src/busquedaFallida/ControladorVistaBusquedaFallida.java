/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaFallida;

import Main.Main;
import modelos.Modelo;

/**
 * Implementacion de la clase ControladorVistaBusquedaFallida
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaBusquedaFallida {
    
    private VistaBusquedaFallida vista;
    /**
     * Constructor por defecto de la clase ControladorVistaBusquedaFallida
     * @param VistaBusquedaFallida vista
     */
    public ControladorVistaBusquedaFallida(VistaBusquedaFallida vista){
        this.vista = vista;
    }
    /**
     * Ejecuta la accion para volver a la ventana anterior
     */
    public void volver(){
        Main.getVistaPrincipalSM().back();
    }
    /**
     * Devuelve el modelo que se esta usando
     * @return Modelo modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    
}
