/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author rojo
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private short existencias;
    private float precioVenta;
    private float precioCompra;
    private short diasParaEntregaDelProveedor;
    private String tipoDeProductoAuxiliar;
    private short cantidadNecesaria;
    private String plataDeLaFlor;
    private String subtipo;
    private ArrayList<Lote> lotes;
    
    public Producto(String JSONObjectString){
         JSONObject json = new JSONObject(JSONObjectString);
        
        codigo = json.getString("CODIGO");
        subtipo = json.getString("SUBTIPO");
        nombre = json.getString("NOMBRE");
        descripcion = json.getString("DESCRIPCION");
        existencias = (short) json.getInt("EXISTENCIAS");
        cantidadNecesaria = (short) json.getInt("CANTIDADNECESARIA");
        
        if(subtipo.equals("planta")){
            precioVenta = json.getFloat("precioVenta");
            precioCompra = json.getFloat("precioCompra");
            diasParaEntregaDelProveedor = (short) json.getInt("DIASPARALAENTREGADELPROVEEDOR");
            JSONArray lotesjson = json.getJSONArray("lotes");
            lotes = new ArrayList<>();
            Iterator it = lotesjson.iterator();
            while(it.hasNext()){
            
                JSONObject jsonLote = (JSONObject)it.next();
            
                try{
                    Lote lote = new Lote(jsonLote);
                    lotes.add(lote);
                
                }catch(Exception e){
                    System.err.println(e.getStackTrace());
                }
            }
        }
        
    }
    
    public static Producto getPlantaPorNombre(String nombre) throws PlantNotFoundException{
        String res = FachadaPersistencia.getPlantaPorNombre(nombre);
        Producto planta = new Producto(res);
        System.out.println(res);
        return planta;
    }

    public int getExistencias() {
        return (int) existencias;
    }

    public ArrayList<Lote> getLotes() {
        return (ArrayList<Lote>) lotes.clone();
    }
}
