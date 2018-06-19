/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

/**
 *
 * @author super
 */
public class FachadaPersistencia {
    
    public static String getEmpleadoPorDNIyPass(String d, String p){
        return EmpleadoDB.getEmpleadoPorDNIyPass(d, p);
    }
}
