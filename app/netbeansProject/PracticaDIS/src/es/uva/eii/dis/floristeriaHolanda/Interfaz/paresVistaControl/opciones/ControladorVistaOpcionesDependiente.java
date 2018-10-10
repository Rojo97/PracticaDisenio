/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.opciones;

import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUOpciones;

/**
 *
 * @author super
 */
public class ControladorVistaOpcionesDependiente {
    private VistaOpcionesDependiente vista;
    private ControladorCUOpciones controladorCU;
    
    public ControladorVistaOpcionesDependiente(VistaOpcionesDependiente vista){
        this.vista = vista;
        controladorCU = new ControladorCUOpciones();
    }
    
    public void procesaCerrarSesion(){
        controladorCU.cerrarSesion();
    }

    void procesaRegistrarVentaDirecta() {
        controladorCU.registrarVentaDirecta();
    }
}
