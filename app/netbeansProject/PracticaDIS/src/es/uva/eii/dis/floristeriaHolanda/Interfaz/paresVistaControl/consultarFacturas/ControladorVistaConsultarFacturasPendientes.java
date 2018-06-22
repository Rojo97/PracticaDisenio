/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.consultarFacturas;

import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUFacturasPendientes;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author super
 */
public class ControladorVistaConsultarFacturasPendientes {
    
    private VistaConsultarFacturasPendientes vista;
    private ControladorCUFacturasPendientes controladorCU;
    
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public ControladorVistaConsultarFacturasPendientes(VistaConsultarFacturasPendientes vista){
        this.vista = vista;
        controladorCU = new ControladorCUFacturasPendientes();
    }
    
    public void procesaEventoRangoFechas(){
        String fechaIni = vista.getFechaInicial();
        String fechaFin = vista.getFechaFinal();
        
        if(!fechaIni.isEmpty() && !fechaFin.isEmpty()){
            Date fechaInicial = stringTodate(fechaIni);
            if(fechaInicial==null){
                vista.mostrarErrorFechaInicial();
            }else{
                Date fechaFinal = stringTodate(fechaFin);
                if(fechaFinal==null){
                    vista.mostrarErrorFechaFinal();
                }else{
                    if(!compruebaFechasCompatibles(fechaInicial, fechaFinal)){
                        vista.mostrarErrorFechasIncompatibles();
                    }else{
                        ArrayList<Proveedor> listaProveedores = controladorCU.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
                        if(listaProveedores.size()==0){
                            vista.mostrarNingunPedidoEnIntervalo();
                        }else{
                            controladorCU.intervaloSeleccionado();
                        }
                    }
                }
            }
        }
        
        
    }
    
    public boolean compruebaFechasCompatibles(Date inico, Date fin){
        return inico.before(fin);
    }
    
    public Date stringTodate(String fecha){
        try{
            return formato.parse(fecha);
        }catch(ParseException e){
            return null;
        }
    }
   
}
