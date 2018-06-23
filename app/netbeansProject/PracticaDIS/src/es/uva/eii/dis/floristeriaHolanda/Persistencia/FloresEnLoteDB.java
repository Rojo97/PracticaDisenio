/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FloresEnLoteNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.FlorNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author victo
 */
class FloresEnLoteDB {
    
    static String getFloresEnLote(int lote, String codigo) throws FloresEnLoteNotFoundException {
        String res = null;
        
        String SQL_Query_Flores_En_Lote = "SELECT * FROM FLORESENLOTE F WHERE F.FLOR = '" + codigo + "' AND F.LOTE = '" + lote + "'";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        String consulta = conexion.consulta(SQL_Query_Flores_En_Lote);
        
        if(consulta==null){
            throw new FloresEnLoteNotFoundException("No hay estimaciones de flores");
        }
                  
        JSONArray jsonArray = new JSONArray(consulta);
            
        JSONObject json = jsonArray.getJSONObject(0);
        res = json.toString();
        //System.out.println(res);
        return res;
    }
}
