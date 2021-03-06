/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.UserNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PasswordIncorrectException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ismael
 */
public class EmpleadoDB {
    
    public static String getEmpleadoPorDNIyPass(String d, String p) throws UserNotFoundException, PasswordIncorrectException{
        
        String e = null;
     
        String SQL_Query_Empleado_Sin_Pass = "SELECT * FROM Empleado E WHERE E.Nif = '" + d + "'";
        String SQL_Query_Empleado = "SELECT * FROM Empleado E WHERE E.Nif = '" + d + "' and E.Password = '" + p + "'";
        String SQL_Query_Roles = "SELECT R.COMIENZOENROL, T1.NOMBRETIPO AS ROL FROM ROLESENEMPRESA R INNER JOIN TIPODEROL T1 ON (R.ROL = T1.IDTIPO) WHERE R.EMPLEADO = '" + d + "' ORDER BY R.COMIENZOENROL";
        String SQL_Query_Vinculaciones = "SELECT V.INICIO, T1.NOMBRETIPO AS VINCULO FROM VINCULACIONCONLAEMPRESA V INNER JOIN TIPODEVINCULACION T1 ON (V.VINCULO = T1.IDTIPO) WHERE V.EMPLEADO = '" + d + "' ORDER BY V.INICIO";
        String SQL_Query_Disponibilidades = "SELECT D.COMIENZO, D.FINALPREVISTO, T1.NOMBRETIPO AS DISPONIBILIDAD FROM DISPONIBILIDADEMPLEADO D INNER JOIN TIPODEDISPONIBILIDAD T1 ON (D.DISPONIBILIDAD = T1.IDTIPO) WHERE D.EMPLEADO = '" + d + "' ORDER BY D.COMIENZO";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        String consulta = conexion.consulta(SQL_Query_Empleado_Sin_Pass);
        
        if(consulta==null){
            throw new UserNotFoundException("No hay ningun usuario con ese Nif");
        }
        
        consulta = conexion.consulta(SQL_Query_Empleado);
        
        if(consulta==null){
            throw new PasswordIncorrectException("La contraseña es incorrecta");
        }
        
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
        
        return e;
    }
    
    public static String getRolesEmpleadoPorDNI(String d){
        String SQL_Query_Roles = "SELECT R.COMIENZOENROL, T1.NOMBRETIPO AS ROL FROM ROLESENEMPRESA R INNER JOIN TIPODEROL T1 ON (R.ROL = T1.IDTIPO) WHERE R.EMPLEADO = '" + d + "' ORDER BY R.COMIENZOENROL";
        //String SQL_Query_Roles = "SELECT * FROM RolesEnEmpresa R WHERE R.Empleado = '" + d + "' ORDER BY R.ComienzoEnRol";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Roles);
    }
    
    public static String getVinculacionesEmpleadoPorDNI(String d){
        String SQL_Query_Vinculaciones = "SELECT V.INICIO, T1.NOMBRETIPO AS VINCULO FROM VINCULACIONCONLAEMPRESA V INNER JOIN TIPODEVINCULACION T1 ON (V.VINCULO = T1.IDTIPO) WHERE V.EMPLEADO = '" + "' ORDER BY V.INICIO";
        //String SQL_Query_Vinculaciones = "SELECT * FROM VinculacionConLaEmpresa V WHERE V.Empleado = '" + d + "' ORDER BY V.inicio";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Vinculaciones);
    }
    
    public static String getDisponibilidadesEmpleadoPorDNI(String d){ 
        String SQL_Query_Disponibilidades = "SELECT D.COMIENZO, D.FINALPREVISTO, T1.NOMBRETIPO AS DISPONIBILIDAD FROM DISPONIBILIDADEMPLEADO D INNER JOIN TIPODEDISPONIBILIDAD T1 ON (D.DISPONIBILIDAD = T1.IDTIPO) WHERE D.EMPLEADO = '" + d + "' ORDER BY D.COMIENZO";
        //String SQL_Query_Disponibilidades = "SELECT * FROM DisponibilidadEmpleado D WHERE D.Empleado = '" + d + "' ORDER BY D.Comienzo";
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        return conexion.consulta(SQL_Query_Disponibilidades);
    }
}
