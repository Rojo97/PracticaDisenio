/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.FloresEnLote;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FlorNotFoundException;

/**
 *
 * @author rojo
 */
public class ControladorCUEstimarFlores {
    private Producto flor;
    
    public ControladorCUEstimarFlores(){}

    public boolean compruebaFlor(String planta){
        try{
        flor = Producto.buscaFlorPorPlanta(planta);
        return true;
        }catch(FlorNotFoundException excepcion){
            return false;
        }
   }

    public int getEstimacion(int lote) {
        String codigo = flor.getCodigo();
        FloresEnLote nFlores = Producto.getFloresEnLote(lote, codigo);
    }
}
