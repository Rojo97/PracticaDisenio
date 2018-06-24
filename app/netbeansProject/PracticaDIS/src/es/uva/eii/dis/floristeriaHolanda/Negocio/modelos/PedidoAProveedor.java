/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;


import java.util.Date;
/**
 *
 * @author ismael
 */
public class PedidoAProveedor {
    
    private int numeroPedido;
    private Date fechaRealizacion;
    private boolean estaPendiente;
    
    private Factura factura;
    
    public PedidoAProveedor(int numeroPedido, Date fechaRealizacion){
        this.numeroPedido = numeroPedido;
        this.fechaRealizacion = fechaRealizacion;
        estaPendiente = true;
        factura = null;
    }
    
    public void setFactura(Factura factura){
        this.factura = factura;
    }
    
    public int getNumeroPedido(){
        return numeroPedido;
    }
    
    public Date getFechaRealizacion(){
        return fechaRealizacion;
    }
    
    public Factura getFactura(){
        return factura;
    }
}
