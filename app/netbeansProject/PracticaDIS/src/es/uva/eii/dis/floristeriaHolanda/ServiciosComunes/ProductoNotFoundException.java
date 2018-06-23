/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

/**
 *
 * @author super
 */
public class ProductoNotFoundException extends Exception {

    public ProductoNotFoundException() { 
    }
    
    public ProductoNotFoundException(String msg) {
        super(msg);
    }
    
}
