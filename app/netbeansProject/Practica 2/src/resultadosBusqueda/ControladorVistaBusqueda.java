/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultadosBusqueda;

import Main.Main;
import modelos.Modelo;

/**
 * 
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaBusqueda {
    private VistaBusqueda vista;
    
    public ControladorVistaBusqueda(VistaBusqueda vista){
        this.vista = vista;
    }

    void backVentana() {
        Main.back();
    }
    
    public Modelo getModelo(){
        return Main.getModelo();
    }
    
    public void resetUsuario(){
        getModelo().setUsuario(null);
    }
    
    public void loguin() {
        Main.getVistaBusquedaSM().loguin();
    }
    
    public void reservar(String nombre, String precio, String habitaciones){
        if(!getModelo().esRegistrado()){
            loguin();
        }else{
            getModelo().setCasaElegida(nombre);
            getModelo().setPrecioCasa(Integer.parseInt(precio));
            getModelo().setHabitaciones(Integer.parseInt(habitaciones));
            Main.getVistaBusquedaSM().reservar();
        }
    }
    
    public void añadirListaDeseos(String nombre, String precio, String habitaciones){
        if(!getModelo().esRegistrado()){
            loguin();
        }else{
            getModelo().setCasaElegida(nombre);
            getModelo().setPrecioCasa(Integer.parseInt(precio));
            getModelo().setHabitaciones(Integer.parseInt(habitaciones));
            Main.getVistaBusquedaSM().añadirLista();
        }
    }
    
}
