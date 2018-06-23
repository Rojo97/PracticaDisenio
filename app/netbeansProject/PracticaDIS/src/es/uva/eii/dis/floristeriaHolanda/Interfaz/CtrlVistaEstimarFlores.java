/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz;

import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUEstimarFlores;

/**
 *
 * @author victo
 */
public class CtrlVistaEstimarFlores {
    private VistaEstimarFlores vista;
    private ControladorCUEstimarFlores controladorCU;
    
    public CtrlVistaEstimarFlores(VistaEstimarFlores vista){
        this.vista = vista;
        controladorCU = new ControladorCUEstimarFlores();
    }

    void procesaEventoInicio(int lote, String planta) {
        boolean correcto = controladorCU.compruebaFlor(planta);
        if(correcto == false){
           // vista.errorNoHayFlor();
        }else{
            int estim = controladorCU.getEstimacion(lote);
        }
    }
}
