/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.UserNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PasswordIncorrectException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.PlantNotFoundException;

/**
 *
 * @author super
 */
public class FachadaPersistencia {
    
    public static String getEmpleadoPorDNIyPass(String d, String p) throws UserNotFoundException, PasswordIncorrectException{
        return EmpleadoDB.getEmpleadoPorDNIyPass(d, p);
    }
    
    public static String getPlantaPorNombre(String nombre) throws PlantNotFoundException{
        return ProductoDB.getPlantaPorNombre(nombre);
    }
}
