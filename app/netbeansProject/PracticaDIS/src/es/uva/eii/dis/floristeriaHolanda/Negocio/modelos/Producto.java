/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;

import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author super
 */
public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String existencias;
    
    public Producto(String JSONObjectString) {
        
        JSONObject json = new JSONObject(JSONObjectString);
        
        codigo = json.getString("codigo");
        nombre = json.getString("nombre");
        descripcion = json.getString("descripcion");
        existencias = json.getString("existencias");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        codigo = json.getString("codigo");
        
        
    }

    public static Producto getProductoPorCodigo(String codigo) throws ProductoNotFoundException {
       String res = FachadaPersistencia.getProductoPorCodigo(codigo);
        
        Producto producto = new Producto(res);
        System.out.println(res);//quitar cuando este acabado
        return producto;
    }
    
}
