/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ismael
 */
public class EmpleadoDB {
    
    public static String getEmpleadoPorDNIyPass(String d, String p){
        
        String e = null;
        
        String SQL_Query_Empleado = "SELECT * FROM Empleado E WHERE E.Nif = '" + d + "' and E.Password = '" + p + "'";
        String SQL_Query_Roles = "SELECT * FROM RolesEnEmpresa R WHERE R.Empleado = '" + d + "' ORDER BY R.ComienzoEnRol";
        String SQL_Query_Vinculaciones = "SELECT * FROM VinculacionConLaEmpresa V WHERE V.Empleado = '" + d + "' ORDER BY V.inicio";
        String SQL_Query_Disponibilidades = "SELECT * FROM DisponibilidadEmpleado D WHERE D.Empleado = '" + d + "' ORDER BY D.Comienzo";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        String consulta = conexion.consulta(SQL_Query_Empleado);
        
        if(consulta!=null){
            JSONArray jsonArray = new JSONArray(consulta);
            
            JSONObject jsonE = jsonArray.getJSONObject(0);
            
            consulta = conexion.consulta(SQL_Query_Roles);
            JSONArray roles = new JSONArray(consulta);
            jsonE.put("roles", roles);
            
            consulta = conexion.consulta(SQL_Query_Vinculaciones);
            JSONArray vinculaciones = new JSONArray(consulta);
            jsonE.put("vinculaciones", vinculaciones);
            
            consulta = conexion.consulta(SQL_Query_Disponibilidades);
            JSONArray disponibilidades = new JSONArray(consulta);
            jsonE.put("disponibilidades", disponibilidades);
            
            e = jsonE.toString();
        }
        
        return e;
    }
    
    public static String getRolesEmpleadoPorDNI(String d){
        String SQL_Query_Roles = "SELECT * FROM RolesEnEmpresa R WHERE R.Empleado = '" + d + "' ORDER BY R.ComienzoEnRol";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Roles);
    }
    
    public static String getVinculacionesEmpleadoPorDNI(String d){
        String SQL_Query_Vinculaciones = "SELECT * FROM VinculacionConLaEmpresa V WHERE V.Empleado = '" + d + "' ORDER BY V.inicio";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Vinculaciones);
    }
    
    public static String getDisponibilidadesEmpleadoPorDNI(String d){     
        String SQL_Query_Disponibilidades = "SELECT * FROM DisponibilidadEmpleado D WHERE D.Empleado = '" + d + "' ORDER BY D.Comienzo";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Disponibilidades);
    }
}
