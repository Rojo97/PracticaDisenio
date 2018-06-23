/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FlorNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author rojo
 */
public class ProductoDB {
    public static String getPlantaPorNombre(String nombre) throws PlantNotFoundException{
        
        String res = null;
        
        String SQL_Query_Planta = "SELECT * FROM PRODUCTO P WHERE P.NOMBRE = '" + nombre + "' AND P.SUBTIPO = 'planta'";
        String SQL_Query_Lotes = "SELECT * FROM LOTE L INNER JOIN PRODUCTO P ON (L.PLANTA = P.CODIGO) WHERE P.NOMBRE = '" + nombre + "' AND P.SUBTIPO = 'planta'";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        String consulta = conexion.consulta(SQL_Query_Planta);
        
        if(consulta==null){
            throw new PlantNotFoundException("No hay ninguna Planta con ese Nombre");
        }
                  
        JSONArray jsonArray = new JSONArray(consulta);
            
        JSONObject json = jsonArray.getJSONObject(0);
            
        consulta = conexion.consulta(SQL_Query_Lotes);
        JSONArray lotes = new JSONArray(consulta);
        json.put("lotes", lotes);
        res = json.toString();
        System.out.println(res);
        return res;
    }

    static String getFlorPorPlanta(String planta) throws FlorNotFoundException {
        String res = null;
        
        String SQL_Query_Flor = "SELECT * FROM PRODUCTO P WHERE P.PLANTADELAFLOR = '" + planta + "' AND P.SUBTIPO = 'flor'";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        String consulta = conexion.consulta(SQL_Query_Flor);
        
        if(consulta==null){
            throw new FlorNotFoundException("No hay ninguna Flor de esa planta");
        }
                  
        JSONArray jsonArray = new JSONArray(consulta);
            
        JSONObject json = jsonArray.getJSONObject(0);
        res = json.toString();
        System.out.println(res);
        return res;
    }

    static String getProductoPorCodigo(String codigo) throws ProductoNotFoundException {
        String res = null;
        String SQL_Query_Producto = "SELECT * FROM PRODUCTO P WHERE P.CODIGO = '" + codigo + "'";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        String consulta = conexion.consulta(SQL_Query_Producto);
        
        if(consulta==null){
            throw new ProductoNotFoundException("No hay ningun producto con ese codigo");
        }
                  
        JSONArray jsonArray = new JSONArray(consulta);
            
        JSONObject json = jsonArray.getJSONObject(0);
            
        res = json.toString();
        System.out.println(res);
        return res;
    }

    static void actualizaProducto(String codigo, short existencias) {
        String SQL_Update_Producto = "UPDATE PRODUCTO P SET EXISTENCIAS = " + existencias + " WHERE CODIGO = '" + codigo + "'";
        //System.out.println(SQL_Update_Producto);
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        conexion.update(SQL_Update_Producto);
    }
}
