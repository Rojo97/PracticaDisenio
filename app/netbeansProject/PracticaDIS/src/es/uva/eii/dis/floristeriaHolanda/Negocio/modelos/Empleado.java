/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import java.util.Date;
import java.util.ArrayList;
import org.json;

/**
 *
 * @author ismael
 */
public class Empleado {
    
    private String nif;
    private String nombre;
    private Date fechaIni;
    private ArrayList<Rol> listaRoles;
    private ArrayList<VinculacionConLaEmpresa> listaVinculaciones;
    private ArrayList<Disponibilidad> listaDisponibilidades;
    
    public Empleado(String res){
        /* Pasar el string JsonArray a JsonArray */
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(res);
        JsonObject json = tradeElement.getAsJsonObject();
        
        
        
        nif = json.get("NIF").toString();
    }
    
    public String getNif(){
        return nif;
    }
    
    public static Empleado getEmpleadoPorDNIyPass(String d, String p){
        String res = FachadaPersistencia.getEmpleadoPorDNIyPass(d, p);
        Empleado e = null;
        if(res!=null){
            e = new Empleado(res);
            String prueba = "aaaaa";
            System.out.println(e.getNif());
            System.out.println(prueba);
        }
        return e;
    }
    
}
