/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;

/**
 *
 * @author rojo
 */
public class LineaDeVenta {
    private short cantidad;
    private int venta;
    private String producto;

    public LineaDeVenta(String codigo, int cantidad) {
        producto = codigo;
        this.cantidad = (short) cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigo() {
        return producto;
    }

    void guardarLinea(int id) {
        FachadaPersistencia.registraVenta(id, cantidad, producto);
    }
    
}
