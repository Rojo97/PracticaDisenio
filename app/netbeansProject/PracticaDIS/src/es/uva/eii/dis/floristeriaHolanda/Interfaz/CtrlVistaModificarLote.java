/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz;

import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUModificarLote;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author super
 */
public class CtrlVistaModificarLote {
    private VistaModificarLote vista;
    private ControladorCUModificarLote controladorCU;
    
    public CtrlVistaModificarLote(VistaModificarLote vista){
        this.vista = vista;
        controladorCU = new ControladorCUModificarLote();
    }
    
    public void procesaEventoPlanta(){
        String p = vista.getPlanta();
        if(!p.isEmpty()){
            try{
            controladorCU.buscaPlanta(p);
            int existencias = controladorCU.getExistencias();
            boolean hayLote = controladorCU.compruebaLotes();
            if(existencias == 0 || hayLote == false){
                vista.mostrarErrorPlanta();
            } else {
                ArrayList<String[]> lotes = controladorCU.getLotes();
                String[] lote;
                Iterator it = lotes.iterator();
                while(it.hasNext()){
                    lote = (String[]) it.next();
                    vista.addLote(lote);
                }
                vista.muestraLotes();
            }
            } catch(PlantNotFoundException exception){
               vista.mostrarErrorPlanta();
        }
        }
        
    }
}
