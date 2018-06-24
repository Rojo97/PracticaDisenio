/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rojo
 */
public class Venta {
    private String dependiente;
    private ArrayList<LineaDeVenta> lineas;
    private int id;;
    
    public Venta(String dependiente, ArrayList<LineaDeVenta> lineas){
        this.dependiente = dependiente;
        this.lineas = lineas;
        id = (int) (Math.random() * (Integer.MAX_VALUE));
    }

    public void guardaVenta() {
        FachadaPersistencia.registraVenta(dependiente, id);
        Iterator it = lineas.iterator();
        while(it.hasNext()){
            LineaDeVenta linea = (LineaDeVenta) it.next();
            linea.guardarLinea(id);
        }
    }
}
