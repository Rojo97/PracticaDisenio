/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Lote;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rojo
 */
public class ControladorCUModificarLote {
    Producto planta;
    
    public ControladorCUModificarLote(){}
    
    public void buscaPlanta(String p) throws PlantNotFoundException{
        planta = Producto.getPlantaPorNombre(p);
    }

    public int getExistencias() {
        return planta.getExistencias();
    }

    public boolean compruebaLotes() {
        boolean hayLote = false;
        Lote lote;
        ArrayList<Lote> lotes = planta.getLotes();
        Iterator i = lotes.iterator();
        while(i.hasNext() && hayLote == false){
            lote = (Lote) i.next();
            String estado = lote.getEstado();
            if(!estado.equals("Eliminado")){
                hayLote = true;
            }
        }
        return hayLote;
    }

    public ArrayList<String[]> getLotes() {
        Lote lote;
        ArrayList<String[]> datosLotes = new ArrayList<>();
        String[] array = new String[3];
        ArrayList<Lote> lotes = planta.getLotes();
        Iterator i2 = lotes.iterator();
        while(i2.hasNext()){
            lote = (Lote) i2.next();
            String estado = lote.getEstado();
            if(!estado.equals("Eliminado")){
                array[0] = lote.getId();
                array[1] = lote.getFecha();
                array[2] = estado;
                datosLotes.add(array);
            }
        }
        return datosLotes;
    }
}
