/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Lote;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;
import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
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
                array = new String [3];
                array[0] = lote.getId();
                array[1] = lote.getFecha();
                array[2] = estado;
                datosLotes.add(array);
            }
        }
        return datosLotes;
    }

    public boolean compruebaEstado(int id, String estado) {
        boolean posible = false;
        ArrayList<Lote> lotes = planta.getLotes();
        Lote lote = getLote(id, lotes);
        if(lote == null){
            return false;
        }
        posible = lote.compruebaCambio(estado);
        return posible;
    }

    private Lote getLote(int id, ArrayList<Lote> lotes) {
        Iterator it = lotes.iterator();
        boolean encontrado = false;
        Lote lote = null;
        while(it.hasNext() && encontrado == false ){
            lote = (Lote) it.next();
            if(Integer.parseInt(lote.getId()) == id){
                encontrado = true;
            }
        }
        return lote;
    }

    public void guardarCambios(int id, String estado) {
        FachadaPersistencia.actualizarLote(id, estado);
    }

    public void salir() {
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.empleadoIdentificado();
    }

    public String getCodigoPlanta() {
        return planta.getCodigo();
    }

    public void estimar(int lote, String planta) {
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.estimar(lote, planta);
    }
    
}
