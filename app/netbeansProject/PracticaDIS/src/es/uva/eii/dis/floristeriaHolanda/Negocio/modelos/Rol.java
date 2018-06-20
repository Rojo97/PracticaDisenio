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
    private int rol;
    
    public Rol(Date comienzoEnRol, int rol){
        
        this.comienzoEnRol = comienzoEnRol;
        this.rol = rol;
    }
    
    public int getRol(){
        return rol;
    }
    
    public String getNombreRol(){
        return getNombreRolPorNumero(rol);
    }
    
    public Date getComienzoEnRol(){
        return (Date)comienzoEnRol.clone();
    }
    
    public static String getNombreRolPorNumero(int n){
        
        if(n<0 || n>4){
            throw new IllegalArgumentException();
        }
        
        String rol = "";
        
        switch(n){
            case(1):
                rol = "Supervisor";
                break;
            case(2):
                rol = "Administrativo";
                break;
            case(3):
                rol = "Operario";
                break;
            case(4):
                rol = "Dependiente";
                break;
        }
        
        return rol;
    }
}
