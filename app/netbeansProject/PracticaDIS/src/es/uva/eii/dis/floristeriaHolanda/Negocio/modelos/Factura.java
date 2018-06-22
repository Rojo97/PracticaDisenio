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
public class Factura {
    
    Date fechaEmision;
    float importe;
    String cuentaBancaria;
    
    public Factura(Date fechaEmision, float importe, String cuentaBancaria){
        this.fechaEmision = fechaEmision;
        this.importe = importe;
        this.cuentaBancaria = cuentaBancaria;
    }
    
}
