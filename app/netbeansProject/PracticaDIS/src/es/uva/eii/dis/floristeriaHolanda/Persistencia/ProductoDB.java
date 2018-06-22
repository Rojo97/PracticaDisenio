/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;
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
        //System.out.println(res);
        return res;
    }
}
