/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import modelos.Modelo;
import Main.Main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementacion de la clase ControladorVistaRegistro
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class ControladorVistaRegistro {
    
    private VistaRegistro vista;
    /**
     * Constructor por defecto de la clase ControladorVistaRegistro
     * @param VistaRegistro vista 
     */
    public ControladorVistaRegistro(VistaRegistro vista){
        this.vista = vista;
    }
    /**
     * Va a la ventana anterior dependiendo de en que maquina de estados se este en el momento
     */
    public void back(){
        /** Dependiendo de que maquina de estados este, realiza un metodo **/
        if(Main.isPrincipalInUse()){
            Main.getVistaPrincipalSM().backRegistro();
        }else{
            Main.getVistaBusquedaSM().backRegistro();
        }
    }
    
    /**
     * Devuelve el modelo utilizado
     * @return Modelo modelo
     */
    public Modelo getModelo(){
        return Main.getModelo();
    }
    /**
     * Efectua la operacion de registro dependiendo en que maquina de estados estemos en dicho momento
     * y actualiza el usuario
     */
    public void registrado(){
        getModelo().setUsuario(vista.getNombre());
        /** Dependiendo de la maquina realiza una opcion u otra **/
        if(Main.isPrincipalInUse()){
            Main.getVistaPrincipalSM().back();
        }else{
            Main.getVistaBusquedaSM().back();
        }
    }
    /**
     * Comprueba que la fecha elegida es coherente, ya que tiene mas de 18 años
     * @return boolean correcta
     */
    public boolean fechaCorrecta(){
        boolean correcta = true;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "1999-04-23";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if(fecha.before(vista.getFechaNacimiento())){
            correcta = false;
        }
        return correcta;
    }
    /**
     * Resetea los campos de error y comprueba uno a uno si hay algun error para notificarlo
     */
    public void compruebaRegistro(){
        vista.resetErrores();
        
        boolean error = false;
        /** Comprueba el campo del nombre **/
        if(vista.getNombre().isEmpty()){
            vista.errorNombre();
            error = true;
        }
        /** Comprueba el campo de la contraseña **/
        if(vista.getApellidos().isEmpty()){
            vista.errorApellidos();
            error = true;
        }
        /** Comprueba el campo del NIF **/
        if(vista.getNIF().isEmpty()){
            vista.errorNIF();
            error = true;
        }
        /** Comprueba el campo del e-mail **/
        if(vista.getEmail().isEmpty()){
            vista.errorEmail();
            error = true;
        }
        /** Comprueba el campo de la contraseña **/
        if(vista.getContraseña().isEmpty()){
            vista.errorContraseña();
            error = true;
        }
        /** Comprueba el campo de la confirmacion de la contraseña **/
        if(vista.getConfirmacionContraseña().isEmpty()){
            vista.errorContraseña2();
            error = true;
        }
        /** Comprueba que la contraseña y su confirmacion son iguales **/
        if(!vista.getContraseña().isEmpty() && !vista.getConfirmacionContraseña().isEmpty() &&
           !vista.getContraseña().equals(vista.getConfirmacionContraseña())){
            vista.errorContraseñas();
            error = true;
        }
        /** Comprueba que la fecha es correcta **/
        if(!fechaCorrecta()){
            vista.errorFecha();
            error = true;
        }
        /** Si no ha habido ningun error, ejecuta el procedimiento de fin del registro **/
        if(!error){
            registrado();
        }
    }
    /**
     * Hace visibles o no visibles los campos de las contraseñas
     */
    public void verContraseñas(){
        vista.verContraseñas();
    }
}
