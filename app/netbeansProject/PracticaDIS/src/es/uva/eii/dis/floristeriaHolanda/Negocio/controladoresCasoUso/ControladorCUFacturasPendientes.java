/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ismael
 */
public class ControladorCUFacturasPendientes {
    
    public ControladorCUFacturasPendientes(){
        
    }
    
    public ArrayList<Proveedor> getProveedoresConFacturasEnIntervalo(Date fechaInicial, Date fechaFinal){
        return Proveedor.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
    }
    
    public void intervaloSeleccionado(){
        
    }
}
