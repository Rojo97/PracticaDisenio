/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;

/**
 *
 * @author super
 */
public class ControladorCURegistrarVentaDirecta {

    public Producto buscaProducto(String codigo) throws ProductoNotFoundException {
        return Producto.getProductoPorCodigo(codigo);
    }
    
}
