/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.controladoresCasoUso;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Venta;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.LineaDeVenta;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Producto;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.Sesion;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author super
 */
public class ControladorCURegistrarVentaDirecta {
    private Producto producto;
    private LineaDeVenta linea;
    private ArrayList<LineaDeVenta> lineas;
    private Venta venta;
    
    public ControladorCURegistrarVentaDirecta(){
        lineas = new ArrayList<>();
    }

    public void buscaProducto(String codigo) throws ProductoNotFoundException {
        producto = Producto.getProductoPorCodigo(codigo);
    }

    public int getExistencias() {
        return producto.getExistencias();
    }

    public void nuevaLinea(String codigo, int cantidad) {
        linea = new LineaDeVenta(codigo, cantidad);
        lineas.add(linea);
    }

    public String getNombre() {
        return producto.getNombre();
    }

    public float getPrecio() {
        return producto.getPrecioVenta();
    }

    public void registrarVenta() {
        Sesion sesion = Sesion.getInstancia();
        String dependiente = sesion.getEmpleadoNIF();
        venta = new Venta(dependiente, lineas);
        Iterator it = lineas.iterator();
        while(it.hasNext()){
            linea = (LineaDeVenta) it.next();
            int cantidad = linea.getCantidad();
            String codigo = linea.getCodigo();
            try{
                buscaProducto(codigo);
                producto.restaCantidad(cantidad);
                producto.guardaCantidad();
            }catch(ProductoNotFoundException e){
                System.out.println("No he encontrado un producto que ya habia encontrado");
            }
        }
        venta.guardaVenta();
    }
    
}
