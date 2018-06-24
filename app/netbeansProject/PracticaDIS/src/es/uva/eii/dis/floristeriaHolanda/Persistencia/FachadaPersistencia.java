/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FlorNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FloresEnLoteNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.UserNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PasswordIncorrectException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import java.util.Date;

/**
 *
 * @author super
 */
public class FachadaPersistencia {
    
    public static String getEmpleadoPorDNIyPass(String d, String p) throws UserNotFoundException, PasswordIncorrectException{
        return EmpleadoDB.getEmpleadoPorDNIyPass(d, p);
    }
    
    public static String getProveedoresConFacturasEnIntervalo(Date fechaInicial, Date fechaFinal){
        return ProveedorDB.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
    }

    public static String getProductoPorCodigo(String codigo) throws ProductoNotFoundException {
        return ProductoDB.getProductoPorCodigo(codigo);
    }
    
    public static String getPlantaPorNombre(String nombre) throws PlantNotFoundException{
        return ProductoDB.getPlantaPorNombre(nombre);
    }

    public static void actualizarLote(int id, String estado) {
        LoteDB.actualizar(id, estado);
    }

    public static String getFlorPorPlanta(String planta) throws FlorNotFoundException {
        return ProductoDB.getFlorPorPlanta(planta);
    }

    public static String getFloresEnLote(int lote, String codigo) throws FloresEnLoteNotFoundException{
        return FloresEnLoteDB.getFloresEnLote(lote, codigo);
    }

    public static void actualizaEstimacion(int cantidad, String flor, int lote, boolean nuevo) {
        FloresEnLoteDB.guardar(cantidad, flor, lote, nuevo);
    }

    public static void actualizaProducto(String codigo, short existencias) {
        ProductoDB.actualizaProducto(codigo, existencias);
    }

    public static void registraVenta(String dependiente, int id) {
        VentaDB.guarda(dependiente, id);
    }

    public static void registraVenta(int id, short cantidad, String producto) {
        LineaDeVentaDB.guarda(id, cantidad, producto);
    }
}
