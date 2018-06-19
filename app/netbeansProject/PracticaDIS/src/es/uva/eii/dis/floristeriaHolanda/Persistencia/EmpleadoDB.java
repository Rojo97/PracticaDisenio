/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import com.google.gson.*;

/**
 *
 * @author ismael
 */
public class EmpleadoDB {
    
    public static String getEmpleadoPorDNIyPass(String d, String p){
        
        String SQL_Query_Empleado = "SELECT * FROM Empleado E WHERE E.Nif = '" + d + "' and E.Password = '" + p + "'";    
        String SQL_Query_Roles = "SELECT * FROM RolesEnEmpresa R WHERE R.Empleado = '" + d + "' ORDER BY R.ComienzoEnRol";
        String SQL_Query_Vinculaciones = "SELECT * FROM VinculacionConLaEmpresa V WHERE V.Empleado = '" + d + "' ORDER BY V.inicio";
        String SQL_Query_Disponibilidades = "SELECT * FROM DisponibilidadEmpleado D WHERE D.Empleado = '" + d + "' ORDER BY D.Comienzo";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        JsonArray jsonArray = getJsonArrayConsulta(SQL_Query_Empleado, conexion);
        
        if(jsonArray.size()==0){
            return null;
        }
        
        JsonObject jsonE = jsonArray.get(0).getAsJsonObject();
        
        jsonE.add("roles", getJsonArrayConsulta(SQL_Query_Roles, conexion));    
        jsonE.add("vinculaciones", getJsonArrayConsulta(SQL_Query_Vinculaciones, conexion));
        jsonE.add("disponibilidades", getJsonArrayConsulta(SQL_Query_Disponibilidades, conexion));
        
        return jsonE.toString();
    }
    
    public static JsonArray getJsonArrayConsulta(String SQL_Query, ConexionDB conexion){  
        
        String consulta = conexion.consulta(SQL_Query);
        
        if(consulta==null){
            return new JsonArray();
        }
        
        /* Pasar el string JsonArray a JsonArray */
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(consulta);
        return tradeElement.getAsJsonArray();
    }
}
