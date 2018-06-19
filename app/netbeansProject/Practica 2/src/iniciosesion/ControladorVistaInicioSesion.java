/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import modelos.Modelo;
import Main.Main;

/**
 * Implementacion de la clase ControladorVistaInicioSesion
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaInicioSesion {
    private VistaInicioSesion vista;
    /**
     * Constructor por defecto de la clase ControladorVistaInicioSesion
     * @param VistaInicioSesion vista
     */
    public ControladorVistaInicioSesion(VistaInicioSesion vista){
        this.vista = vista;
    }
    /**
     * Retrocede a la ventana anterior
     */
    public void atras() {
        /** Dependiendo desde  que maquina de estados este usandose retrocede acorde a ello **/
        if(Main.isPrincipalInUse()){
            Main.getVistaPrincipalSM().back();
        }else{
            Main.getVistaBusquedaSM().back();
        }
    }
    /**
     * Comienza el procedimiento de registro 
     */
    public void registrar() {
        /** Dependiendo desde  que maquina de estados este usandose retrocede acorde a ello **/
        if(Main.isPrincipalInUse()){
            Main.getVistaPrincipalSM().registrarse();
        }else{
            Main.getVistaBusquedaSM().registrarse();
        }
    }
    /**
     * Vuelve atras con el usuario logueado
     */
    void atrasLogueado(){
        String usuario = vista.getUsuario();
        getModelo().setUsuario(usuario);
        atras();
    }
    /**
     * Vuelve atras logueandose con facebook o twitter
     */
    void atrasLogueado2(){
        getModelo().setUsuario("IlitriFC");
        atras();
    }
    /**
     * Devuelve el modelo que se esta usando
     * @return Modelo modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    /**
     * Comprueba uno por uno los datos introducidos para inicar la sesion
     */
    public void compruebaSesion(){
        vista.resetError();
        if(vista.getUsuario().isEmpty() || vista.getContraseña().isEmpty()){
            vista.errorSesion();
        }else{
            atrasLogueado();
        }
    }
    /**
     * Hace que las contraseñas sean visibles
     */
    public void verContraseñas(){
        vista.verContraseñas();
    }
    
}
