/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.PedidoAProveedor;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ismael
 */
public class CatalogoProveedores {
    
    private static CatalogoProveedores catalogo;
    private static ArrayList<Proveedor> listaProveedores;
    private static Proveedor proveedorSeleccionado;
    private static PedidoAProveedor pedidoSeleccionado;
    private static Date fechaInicialCatalogo;
    private static Date fechaFinalCatalogo;
    
    private CatalogoProveedores(){
        
    }
    
    public static CatalogoProveedores getInstancia(){
        if(catalogo==null){
            catalogo= new CatalogoProveedores();
        }
        
        return catalogo;
    }
    
    public void setFechasCatalogo(Date fechaInicialcatalogo, Date fechaFinalCatalogo){
        this.fechaInicialCatalogo = fechaInicialcatalogo;
        this.fechaFinalCatalogo = fechaFinalCatalogo;
    }
    
    public Date getFechaInicialCatalogo(){
        return fechaInicialCatalogo;
    }
    
    public Date getFechaFinalCatalogo(){
        return fechaFinalCatalogo;
    }
    
    public void setProveedores(ArrayList<Proveedor> listaProveedores){
        this.listaProveedores = listaProveedores;
    }
    
    public ArrayList<Proveedor> getProveedores(){
        return (ArrayList<Proveedor>)listaProveedores.clone();
    }
    
    public Proveedor getProveedorPorNif(String nif){
        for(int i=0; i<listaProveedores.size(); i++){
            Proveedor p = listaProveedores.get(i);
            if(p.getCif().equals(nif)){
                return p;
            }
        }
        
        return null;
    }
    
    public boolean hayProveedores(){
        if(listaProveedores==null || listaProveedores.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    public void setProveedorSeleccionado(Proveedor proveedorSeleccionado){
        this.proveedorSeleccionado = proveedorSeleccionado;
    }
    
    public Proveedor getProveedorSeleccionado(){
        return proveedorSeleccionado;
    }
    
    public void setPedidoSeleccionado(PedidoAProveedor pedidoSeleccionado){
        this.pedidoSeleccionado = pedidoSeleccionado;
    }
    
    public PedidoAProveedor getPedidoSeleccionado(){
        return pedidoSeleccionado;
    }
    
}
