/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FlorNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FloresEnLoteNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author rojo
 */
public class Producto {

    public static Producto getPlantaPorNombre(String nombre) throws PlantNotFoundException{
        String res = FachadaPersistencia.getPlantaPorNombre(nombre);
        Producto planta = new Producto(res);
        return planta;
    }
        
    public static Producto buscaFlorPorPlanta(String planta) throws FlorNotFoundException {
        String res = FachadaPersistencia.getFlorPorPlanta(planta);
        Producto flor = new Producto(res);
        return flor;
    }

    public static FloresEnLote getFloresEnLote(int lote, String codigo) {
        FloresEnLote flores;
        try{
            String res = FachadaPersistencia.getFloresEnLote(lote, codigo);
            flores = new FloresEnLote(res);
            System.out.println(res);
        }catch(FloresEnLoteNotFoundException exception){
            flores = new FloresEnLote(lote, codigo);
        }
        return flores;
        
    }

    public static Producto getProductoPorCodigo(String codigo) throws ProductoNotFoundException{
        String res = FachadaPersistencia.getProductoPorCodigo(codigo);
        Producto producto = new Producto(res);
        return producto;
    }
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private short existencias;
    private float precioDeVenta;
    private float precioCompra;
    private short diasParaEntregaDelProveedor;
    private String tipoDeProductoAuxiliar;
    private short cantidadNecesaria;
    private String plataDeLaFlor;
    private String subtipo;
    private ArrayList<Lote> lotes;
    private float getPrecioVenta;
    
    public Producto(String JSONObjectString){
         JSONObject json = new JSONObject(JSONObjectString);
        
        codigo = json.getString("CODIGO");
        subtipo = json.getString("SUBTIPO");
        nombre = json.getString("NOMBRE");
        descripcion = json.getString("DESCRIPCION");
        existencias = (short) json.getInt("EXISTENCIAS");
        cantidadNecesaria = (short) json.getInt("CANTIDADNECESARIA");
        
        if(subtipo.equals("planta")){
            precioDeVenta = json.getFloat("PRECIODEVENTA");
            precioCompra = json.getFloat("PRECIOCOMPRA");
            diasParaEntregaDelProveedor = (short) json.getInt("DIASPARAENTREGADELPROVEEDOR");
            try{
            JSONArray lotesjson = json.getJSONArray("lotes");
            lotes = new ArrayList<>();
            Iterator it = lotesjson.iterator();
            while(it.hasNext()){
            
                JSONObject jsonLote = (JSONObject) it.next();
            
                try{
                    Lote lote = new Lote(jsonLote);
                    lotes.add(lote);
                
                }catch(Exception e){
                    System.out.println(e.getStackTrace());
                }
            }
            }catch(JSONException e){
        }
        } 
    }
    

    public int getExistencias() {
        return (int) existencias;
    }

    public ArrayList<Lote> getLotes() {
        return (ArrayList<Lote>) lotes.clone();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioVenta() {
        return precioDeVenta;
    }

    public void restaCantidad(int cantidad) {
        this.existencias -= cantidad;
    }

    public void guardaCantidad() {
        FachadaPersistencia.actualizaProducto(codigo, existencias);
    }
}
