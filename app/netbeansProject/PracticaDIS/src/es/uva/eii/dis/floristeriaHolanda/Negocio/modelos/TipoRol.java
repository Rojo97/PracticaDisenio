/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

/**
 *
 * @author ismael
 */
public enum TipoRol {
    SUPERVISOR("Supervisor", 1),
    ADMINISTRATIVO("Administrativo", 2),
    OPERARIO("Operario", 3),
    DEPENDIENTE("Dependiente", 4);
    
    private String nombre;
    private int rol;
    
    private TipoRol(String nombre, int rol){
        this.nombre = nombre;
        this.rol = rol;
    }
    
    public int getNumero(){
        return rol;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    /**
     * TODO Lanzar excepcion si el numero no es compatible
     * @param rol
     * @return 
     */
    public static TipoRol getTipoRolPorNumero(int rol){
        switch(rol){
            case(1):
                return TipoRol.SUPERVISOR;
            case(2):
                return TipoRol.ADMINISTRATIVO;
            case(3):
                return TipoRol.OPERARIO;
            case(4):
                return TipoRol.DEPENDIENTE;
        }
        return null;
    }
}
