/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.RegistrarVentaDirecta;

import es.uva.eii.dis.floristeriaHolanda.Interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.ModeloRegistrarVentaDirecta;
import es.uva.eii.dis.floristeriaHolanda.Main.Main;
import es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso.ControladorCURegistrarVentaDirecta;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;

/**
 *
 * @author super
 */
public class ControladorVistaRegistrarVentaDirecta {
    private VistaRegistrarVentaDirecta vista;
    private ControladorCURegistrarVentaDirecta controladorCU;
    
    /**
     * Constructor de el controlador.
     * @param vista la vista que debe controlar.
     */
    public ControladorVistaRegistrarVentaDirecta(VistaRegistrarVentaDirecta vista) {
        this.vista = vista;
        controladorCU = new ControladorCURegistrarVentaDirecta();
    }

    void procesaEventoIntroducirProducto() {
        String codigo = vista.getCodigo();
        String cant = vista.getCantidad();
        try{
            int cantidad = Integer.parseInt(cant);
            
            if(codigo.equals("")||codigo.equals("Código del producto")){
                vista.muestraMensajeError("ERROR_PRODUCTONOENCONTRADO");
            }else{
                Producto producto = controladorCU.buscaProducto(codigo);
            }
            
            
            
        }catch(NumberFormatException e){
            vista.muestraMensajeError("ERROR_CANTIDADINCORRECTA");
        }
        
    }

    void registraVenta() {
        
    }

    void cancela() {
        GestorDeInterfazDeUsuario stateMachine = Main.getStateMachineLogin();
        stateMachine.empleadoIdentificado();
    }
    
    
    
    
}
