/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.registrarVentaDirecta;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;
import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCURegistrarVentaDirecta;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;


/**
 *
 * @author super
 */
public class ControladorVistaRegistrarVentaDirecta {
    private VistaRegistrarVentaDirecta vista;
    private ControladorCURegistrarVentaDirecta controladorCU;
    private float subtotal;
    private float total;
    /**
     * Constructor de el controlador.
     * @param vista la vista que debe controlar.
     */
    public ControladorVistaRegistrarVentaDirecta(VistaRegistrarVentaDirecta vista) {
        this.vista = vista;
        controladorCU = new ControladorCURegistrarVentaDirecta();
        subtotal = 0;
        total = 0;
    }

    void procesaEventoIntroducirProducto() {
        String codigo = vista.getCodigo();
        try{
            int cantidad = vista.getCantidad();
            if(codigo.isEmpty()){
                vista.errorCodigo();
            }else{
                try{
                    controladorCU.buscaProducto(codigo);
                    int existencias = controladorCU.getExistencias();
                    System.out.println(existencias +" "+ cantidad);
                    if(existencias == 0){
                        vista.noHayExistencias();
                    }else if(existencias < cantidad){
                        vista.errorCantidadMayor();
                    }else if(cantidad < 1 ){
                        vista.errorCantidadIncorrecta();
                    }else if(cantidad <= existencias){
                        controladorCU.nuevaLinea(codigo, cantidad);
                        String nombre = controladorCU.getNombre();
                        float precio = controladorCU.getPrecio();
                        subtotal = precio * cantidad;
                        total += subtotal;
                        vista.muestraNombre(nombre);
                        vista.muestraPrecio(precio);
                        vista.muestraSubtotal(subtotal);
                        vista.muestraFinalizarVenta();
                    }
                }catch(ProductoNotFoundException e){
                    vista.errorCodigo();
                }
            }      
        }catch(NumberFormatException e){
            vista.errorCantidadIncorrecta();
        }
        
    }
    
    public void cancela() {
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.empleadoIdentificado();
    }

    public void finaliza() {
        vista.muestraTotal(total);
    }

    public void completar() {
        controladorCU.registrarVenta();
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.empleadoIdentificado();
    }
   
}
