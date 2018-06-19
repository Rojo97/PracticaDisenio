/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MaquinasEstados.VistaBusquedaStateMachine;
import MaquinasEstados.VistaPrincipalStateMachine;
import modelos.Modelo;
import principal.VistaPrincipal;

/**
 *
 * @author Ismael Perez Martin 
 * @author Victor Rojo Alvarez
 * Dependiendo del argumento del proyecto que pongamos hay tres casos:
 * - Si el argumento es 0, hay alojamientos disponibles en todas las ciudades
 * - Si el argumento es 1, no hay alojamientos disponibles en ninguna ciudad
 * - Si el argumento es 2, hay ciudades disponibles solo en Madrid y Valencia
 */
public class Main {
    private static VistaPrincipalStateMachine principal;
    private static VistaBusquedaStateMachine busqueda;
    private static Modelo modelo;
    private static boolean princ;
    private static int argumento;
    
    public static void main(String args[]) {
        argumento = Integer.parseInt(args[0]);
        principal = new VistaPrincipalStateMachine();
        princ = true;
        modelo = new Modelo();
        
    }
    /**
     * Devuelve la maquina de estado principal
     * @return VistaPrincipalStateMachine principal
     */
    public static VistaPrincipalStateMachine getVistaPrincipalSM(){
        return principal;
    }
    /**
     * Devuelve la maquina de estado de busqueda
     * @return VistaBusquedaStateMachine busqueda
     */
    public static VistaBusquedaStateMachine getVistaBusquedaSM(){
        return busqueda;
    }
    /**
     * Devuelve si esta en uso la maquina principal o no
     * @return boolean principal
     */
    public static boolean isPrincipalInUse(){
        return princ;
    }
    /**
     * Ejecuta un cambio de las maquinas de estado para buscar
     */
    public static void buscar(){
        principal.close();
        busqueda = new VistaBusquedaStateMachine();
        princ = false;
    }
    
    public static void back(){
        busqueda.close();
        principal = new VistaPrincipalStateMachine();
    }
    
    public static Modelo getModelo(){
        return modelo;
    }
    
    public static int getArgumento(){
        return argumento;
    }
}
