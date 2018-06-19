/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ConexionDB {
    private static ConexionDB conexion;
    private static Connection conn;
    
    private ConexionDB(){
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Derby driver not found.");
        }
        try{
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/invernadero","root","root");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    
    }
    
    public static ConexionDB getInstancia(){
        if(conexion!=null){
            return conexion;
        }else{
            return new ConexionDB();
        }
    }
    
    private static Connection getConnection(){
        return conn;
    }
    
    public String consulta(String SQL_Query){
        String res = null;
        
        try{          
            Statement consulta = conn.createStatement();
            boolean execute = consulta.execute(SQL_Query);
            if(execute){
                ResultSet result = consulta.getResultSet();
                
                res = toStringJson(result);
                
            }                     
        }catch(SQLException e){            
            System.err.println("thats bad: "+e.getMessage());           
        }
        
        return res;       
    }
        
    
    public PreparedStatement getPreparedStatement(String s){
        PreparedStatement ps = null;
        try{
            ps = getConnection().prepareStatement(s);
        }catch(SQLException e){ 
            
            System.err.println(e.getMessage());
            
        }
        return ps;
    }
    
    private String toStringJson(ResultSet r){
        JSONArray json = new JSONArray();
        try{
            ResultSetMetaData rsmd = r.getMetaData();
            while(r.next()) {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i=1; i<=numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, r.getObject(column_name));
                }
                json.add(obj);
            }
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        
        if(json.size()>0){
            return json.toJSONString();
        }
       
        return null;
    }
   
}