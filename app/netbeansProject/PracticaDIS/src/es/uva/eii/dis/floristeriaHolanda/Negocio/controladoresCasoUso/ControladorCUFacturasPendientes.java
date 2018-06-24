/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.CatalogoProveedores;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;
import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;
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
    
    public void setListaProveedores(ArrayList<Proveedor> proveedores){
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        catalogo.setProveedores(proveedores);
    }
    
    public void setFechasCatalogo(Date fechaInicial, Date fechaFinal){
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        catalogo.setFechasCatalogo(fechaInicial, fechaFinal);
    }
    
    public void setProveedorSeleccionado(Proveedor proveedorSeleccionado){
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        catalogo.setProveedorSeleccionado(proveedorSeleccionado);
    }
    
    
    public void calcelarOperacion(){
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.volver();
    }
    
    public Proveedor getProveedorPorNif(String nif){
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        return catalogo.getProveedorPorNif(nif);
    }
    
    public boolean hayProveedores(){
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        return catalogo.hayProveedores();
    }
}
