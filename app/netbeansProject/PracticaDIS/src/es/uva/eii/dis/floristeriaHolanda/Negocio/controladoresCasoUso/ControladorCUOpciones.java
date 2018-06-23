/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;

/**
 *
 * @author ismael
 */
public class ControladorCUOpciones {
    
    public ControladorCUOpciones(){
        
    }
    
    public void modificarLote(){
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.modificarLote();
    }
    
    public void cerrarSesion(){
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.cerrarSesion();
    }

    public void registrarVentaDirecta() {
       GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
       stateMachine.registrarVentaDirecta();
    }
}
