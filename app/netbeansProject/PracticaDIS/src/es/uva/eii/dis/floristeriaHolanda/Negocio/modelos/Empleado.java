/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;

/**
 *
 * @author ismael
 */
public class Empleado {
    
    public Empleado(){
        
    }
    
    public static Empleado getEmpleadoPorDNIyPass(String d, String p){
        String h = FachadaPersistencia.getEmpleadoPorDNIyPass(d, p);
        Empleado e = null;
        if(h!=null){
            e = new Empleado();
            System.out.println(h);
        }
        return e;
    }
    
}
