/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.consultarFacturas;

import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCUFacturasPendientes;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import java.util.Date;
import java.util.Calendar;
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
        reseteaProveedores();
        
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
                        compruebaCantidadProveedores(listaProveedores, fechaInicial, fechaFinal);
                    }
                }
            }
        }
        
        
    }
    
    public void compruebaCantidadProveedores(ArrayList<Proveedor> listaProveedores, Date fechaIni, Date fechaFin){
        
        if(listaProveedores.isEmpty()){
            vista.mostrarNingunPedidoEnIntervalo();
        }else{
            controladorCU.setListaProveedores(listaProveedores);
            controladorCU.setFechasCatalogo(fechaIni, fechaFin);
            vista.busquedaCorrecta();
        }
    }
    
    public void posibleIntervalo(){
        if(vista.todasFechasIsSelected() || vista.anioActualIsSelected()){
                vista.desactivaIntervalo();
        }else{
            vista.activaIntervalo();
        }
    }
    
    public void procesaEventoAñoActual(){
        reseteaProveedores();
        
        boolean seleccionada = vista.anioActualIsSelected();
        
        if(seleccionada){
            Calendar calendar = Calendar.getInstance();
        
            int year = calendar.get(calendar.YEAR);
        
            String fIni = year + "-01-01";
            String fFin = year + "-12-31";
        
            Date fechaInicial = stringTodate(fIni);
                
            Date fechaFinal = stringTodate(fFin);
        
            ArrayList<Proveedor> listaProveedores = controladorCU.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
        
            compruebaCantidadProveedores(listaProveedores, fechaInicial, fechaFinal);
            
            vista.deselectTodasFechas();
        }else if(!controladorCU.hayProveedores()){
            vista.esconderProveedores();
        }
        
        posibleIntervalo();
    }
    
    public void procesaEventoTodasLasFechas(){
        
        reseteaProveedores();
        
        boolean seleccionada = vista.todasFechasIsSelected();
        
        System.out.println(seleccionada);
        
        if(seleccionada){
            
            String fIni = "0000-01-01";
            String fFin = "2999-12-31";
        
            Date fechaInicial = stringTodate(fIni);
                
            Date fechaFinal = stringTodate(fFin);
        
            ArrayList<Proveedor> listaProveedores = controladorCU.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
        
            compruebaCantidadProveedores(listaProveedores, fechaInicial, fechaFinal);
            
            vista.deselectAnioActual();
        }else if(!controladorCU.hayProveedores()){
            vista.esconderProveedores();
        }
        
        posibleIntervalo();
    }
    
    public void reseteaProveedores(){
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        
        controladorCU.setListaProveedores(listaProveedores);
    }
    
    public void procesaCancelarOperacion(){
        controladorCU.calcelarOperacion();
    }
    
    public boolean compruebaFechasCompatibles(Date inico, Date fin){
        return inico.before(fin);
    }
    
    public void procesaEventoProveedorIntroducido(){
        String cif = vista.getProveedor();
        
        Proveedor p = controladorCU.getProveedorPorNif(cif);
        if(p == null){
            vista.mostrarErrorProveedor();
            vista.esconderInforme();
        }else{
            controladorCU.setProveedorSeleccionado(p);
            
            vista.mostrarFacturasProveedorSeleccionado();
            System.out.println("Crea informe");
        }
    }
    
    public void rellenaCatalogo(ArrayList<Proveedor> listaProveedores, Date fechaInicial, Date fechaFinal){
        controladorCU.setListaProveedores(listaProveedores);
        controladorCU.setFechasCatalogo(fechaInicial, fechaFinal);
    }
    
    public Date stringTodate(String fecha){
        int[] dias={30,28,31,30,31,30,31,31,30,31,30,31};
        if(fecha.length()!=10){
            return null;
        }
        
        int año = Integer.parseInt(fecha.substring(0, 4));
        
        if(año<0){
            return null;
        }
        
        int mes = Integer.parseInt(fecha.substring(5, 7));
        
        if(mes<0||mes>12){
            return null;
        }
        
        int dia = Integer.parseInt(fecha.substring(8, 10));
        
        if(dia<0 || dia>dias[mes-1]){
            return null;
        }
        
        try{
            return formato.parse(fecha);
        }catch(ParseException e){
            return null;
        }
    }
    
    public void procesaPedidoElegido(){
        vista.muestraInforme();
        System.out.println(vista.getPedidoSeleccionado());
    }
   
}
