/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author ismael
 */
public class Empleado {
    
    private String nif;
    private String nombre;
    private Date fechaInicioEnEmpresa;
    private ArrayList<Rol> listaRoles;
    private ArrayList<VinculacionConLaEmpresa> listaVinculaciones;
    private ArrayList<Disponibilidad> listaDisponibilidades;
    
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public Empleado(String JSONObjectString){
        
        JSONObject json = new JSONObject(JSONObjectString);
        
        listaRoles = new ArrayList<>();
        listaVinculaciones = new ArrayList<>();
        listaDisponibilidades = new ArrayList<>();
        
        nif = json.getString("NIF");
        nombre = json.getString("NOMBRE");
        
        try{
            fechaInicioEnEmpresa = formato.parse(json.getString("FECHAINICIOENEMPRESA"));
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
        
        JSONArray roles = json.getJSONArray("roles");
        setRoles(roles); 
        
        JSONArray vinculaciones = json.getJSONArray("vinculaciones");
        setVinculaciones(vinculaciones);
        
        JSONArray disponibilidades = json.getJSONArray("disponibilidades");
        setDisponibilidades(disponibilidades);
    }
    
    public String getNif(){
        return nif;
    }
    
    public void setNif(String nif){
        this.nif = nif;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Date getFechaInicioEnEmpresa(){
        return (Date)fechaInicioEnEmpresa.clone();
    }
    
    public void setFechaInicioEnEmpresa(Date fechaInicioEnEmpresa){
        this.fechaInicioEnEmpresa = fechaInicioEnEmpresa;
    }
    
    public ArrayList<Rol> getRoles(){
        return (ArrayList<Rol>)listaRoles.clone();
    }
    
    public Rol getUltimoRol(){
        return listaRoles.get(listaRoles.size()-1);
    }
    
    public void setRoles(JSONArray roles){
        Iterator it = roles.iterator();
        while(it.hasNext()){
            
            JSONObject jsonRol = (JSONObject)it.next();
            
            try{
                int tipo = jsonRol.getInt("ROL");
                Date fecha = formato.parse(jsonRol.getString("COMIENZOENROL"));
                Rol r = new Rol(fecha,tipo);
                
                listaRoles.add(r);
                
            }catch(Exception e){
                System.err.println(e.getStackTrace());
            }
        }
    }
    
    public ArrayList<VinculacionConLaEmpresa> getVinculaciones(){
        return (ArrayList<VinculacionConLaEmpresa>)listaVinculaciones.clone();
    }
    
    public VinculacionConLaEmpresa getUltimaVinculacion(){
        return listaVinculaciones.get(listaVinculaciones.size()-1);
    }
    
    public void setVinculaciones(JSONArray vinculaciones){
        Iterator it = vinculaciones.iterator();
        while(it.hasNext()){
            
            JSONObject jsonVinculacion = (JSONObject)it.next();
            
            try{
                int tipo = jsonVinculacion.getInt("VINCULO");
                Date fecha = formato.parse(jsonVinculacion.getString("INICIO"));
                VinculacionConLaEmpresa v = new VinculacionConLaEmpresa(fecha,tipo);
                
                listaVinculaciones.add(v);
                
            }catch(Exception e){
                System.err.println(e.getStackTrace());
            }
        }
    }
    
    public ArrayList<Disponibilidad> getDisponibilidades(){
        return (ArrayList<Disponibilidad>)listaDisponibilidades.clone();
    }
    
    public Disponibilidad getUltimaDisponibilidad(){
        return listaDisponibilidades.get(listaDisponibilidades.size()-1);
    }
    
    public void setDisponibilidades(JSONArray disponibilidades){
        Iterator it = disponibilidades.iterator();
        while(it.hasNext()){
            
            JSONObject jsonDisponibilidad = (JSONObject)it.next();
            
            try{
                int tipo = jsonDisponibilidad.getInt("DISPONIBILIDAD");
                Date comienzo = formato.parse(jsonDisponibilidad.getString("COMIENZO"));
                Date finalPrevisto = formato.parse(jsonDisponibilidad.getString("FINALPREVISTO"));
                Disponibilidad d = new Disponibilidad(comienzo, finalPrevisto, tipo);
                
                listaDisponibilidades.add(d);
                
            }catch(Exception e){
                System.err.println(e.getStackTrace());
            }
        }
    }
    
    public boolean estaActivo(){
        VinculacionConLaEmpresa v = getUltimaVinculacion();
        if(!v.getVinculo().getNombre().equals("Contratado")){
            return false;
        }
        
        Disponibilidad d = getUltimaDisponibilidad();
        if(!d.getDisponibilidad().getNombre().equals("Trabajando")){
            return false;
        }
        
        return true;
    }
    
    public static Empleado getEmpleadoPorDNIyPass(String d, String p){
        String res = FachadaPersistencia.getEmpleadoPorDNIyPass(d, p);
        Empleado e = null;
        if(res!=null){
            e = new Empleado(res);
            System.out.println(res);
        }
        return e;
    }
    
}
