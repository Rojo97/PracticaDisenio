/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Main.Main;
import modelos.Modelo;

/**
 * Implementacion de la clase ControladorVistaPrincipal
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaPrincipal {
    private VistaPrincipal vista;
    /**
     * Constructor por defecto de la clase ControladorVistaPrincipal
     * @param vista 
     */
    public ControladorVistaPrincipal(VistaPrincipal vista){
        this.vista = vista;
    }
    /**
     * Ejecuta el procedimiento para loquearse y almacena los datos de la vista en el modelo
     */
    public void loguin() {
        actualizaModelo();
        Main.getVistaPrincipalSM().loguin();
    }
    /**
     * Ejecuta el procedimiento para buscar con los parámetros introducidos
     * Dependiendo del argumento del proyecto, ejecuta una accion u otra
     */
    public void buscar(){
        actualizaModelo();
        switch(Main.getArgumento()){
            case 0:     /** Se ejecuta con casas siempre fisponibles **/
                Main.buscar();
                break;
            
            case 1:     /** Se ejecuta sin casas disponibles **/
                Main.getVistaPrincipalSM().busFallida();
                break;
                
            case 2:     /** Se ejecuta con casas disponibles solo en algunas ciudades **/
                String ciudad = getModelo().getCiudad();
                if(ciudad == "Madrid" || ciudad == "Valencia"){
                    Main.buscar();
                    break;
                }else{
                    Main.getVistaPrincipalSM().busFallida();
                    break;
                }
        }
    }
    /**
     * Devuelve el modelo de nuestro sistema
     * @return modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    /**
     * Actualiza la informacion del modelo con la nueva informacion de la ventana
     */
    public void actualizaModelo(){
        getModelo().setCiudad(vista.getCiudad());
        getModelo().setFechaInicio(vista.getFechaEntrada());
        getModelo().setFechaFinal(vista.getFechaSalida());
        getModelo().setHuespedes(vista.getHuespedes());
        getModelo().setTipoCasa(vista.getTipoCasa());
        /**Comprueba que hay precios introducidos para almacenarlos en el modelo **/
        if(!vista.getPrecioMin().isEmpty()){    
            getModelo().setPrecioMin(Integer.parseInt(vista.getPrecioMin()));
        }
        if(!vista.getPrecioMax().isEmpty()){
            getModelo().setPrecioMax(Integer.parseInt(vista.getPrecioMax()));
        }
        getModelo().setInmediato(vista.getInmediato());
    }
    
    /**
     * Pone null el usuario
     */
    public void resetUsuario(){
        getModelo().setUsuario(null);
    }
    /**
     * Devuelve si las fechas introducidas son coherentes (fechaEntrada<=fechaSalida)
     * @return boolean fechaCorrecta
     */
    public boolean compruebaFechas(){
        boolean bien = true;
        if((vista.getFechaSalida().compareTo(vista.getFechaEntrada()))<0){
            bien = false;
        }
        return bien;
    }
    
    /**
     * Comprueba si hay algun error en los datos introducidos para la busqueda
     * en concreto, comprueba lo siguiente:
     * - Hay fechas introducidas
     * - Las fechas son coherentes
     * - Los precios introducidos son validos
     * Si hay algun error, lo notifica en la vista
     */
    public void comprobacionBack(){
        vista.resetErrores();
        /** Almacenamos en un boolean siha habido algun error para interrumpir la busqueda **/
        boolean error = false;
        /** Comprobamos que hay fecha de entrada introducida **/
        if(vista.getFechaEntrada() == null){
            getModelo().setErrorFE("Introduzca una fecha de entrada");
            vista.errorFechaEntrada();
            error = true;
        }
        /** Comprobamos que hay fecha de salida introducida **/
        if(vista.getFechaSalida() == null){
            getModelo().setErrorFS("Introduzca una fecha de salida");
            vista.errorFechaSalida();
            error = true;
        }
        /** Comprueba si las fechas introducidas con coherentes **/
        if((vista.getFechaEntrada() != null) && (vista.getFechaSalida() != null) && !compruebaFechas()){
            getModelo().setErrorFE("La fecha de entrada debe ser");
            vista.errorFechaEntrada();
            getModelo().setErrorFS("anterior a la fecha de salida");
            vista.errorFechaSalida();
            error = true;
        }
        /** Comienza la comprobaicon de los precios **/
        try{
            boolean enteroMin = false;
            boolean enteroMax = false;
            /** Primero comprueba si los dos campos estan vacios **/
            if(!(vista.getPrecioMin().isEmpty() && vista.getPrecioMax().isEmpty())){
                /** Si no estan vacios, comprueba uno a uno que estan correctos **/
                if(!vista.getPrecioMin().isEmpty()){
                    Integer.parseInt(vista.getPrecioMin());
                    enteroMin = true;
                }
                if(!vista.getPrecioMax().isEmpty()){
                    Integer.parseInt(vista.getPrecioMax());
                    enteroMax = true;
                }
                
            }
            /** Comprueba si no ha habido ningun error que los precios introducidos son coherentes **/
            if(enteroMin && enteroMax){
                if(Integer.parseInt(vista.getPrecioMin()) > Integer.parseInt(vista.getPrecioMax())){
                    vista.errorPrecio();
                    error = true;
                }
            }
        /** Capturamos la excepcion si los precios no son datos validos **/
        }catch(NumberFormatException e){
            vista.errorPrecio2();
            error = true;
        }
        /** Si no ha ocurrido ningun error, se ejecuta normalmente la busqueda **/
        if(!error){
            buscar();
        }
    }
    
}
