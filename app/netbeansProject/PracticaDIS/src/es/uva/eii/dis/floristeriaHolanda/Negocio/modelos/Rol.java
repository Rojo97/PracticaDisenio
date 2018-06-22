/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import java.util.Date;

/**
 *
 * @author ismael
 */
public class Rol {
    
    private Date comienzoEnRol;
    private String rol;
    
    public Rol(Date comienzoEnRol, String rol){
        
        this.comienzoEnRol = comienzoEnRol;
        this.rol = rol;
    }
    
    public String getRol(){
        return rol;
    }
    
    /*public int getNumeroRol(){
        return rol.getNumero();
    }
    
    public String getNombreRol(){
        return rol.getNombre();
    }*/
    
    public Date getComienzoEnRol(){
        return (Date)comienzoEnRol.clone();
    }
}
