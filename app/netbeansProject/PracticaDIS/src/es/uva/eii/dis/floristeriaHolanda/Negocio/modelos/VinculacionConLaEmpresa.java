/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import java.util.Date;
import java.lang.IllegalArgumentException;

/**
 *
 * @author ismael
 */
public class VinculacionConLaEmpresa {
    
    private Date inicio;
    private int vinculo;
    
    public VinculacionConLaEmpresa(Date inicio, int vinculo){
        this.inicio = inicio;
        this.vinculo = vinculo;
    }
    
    public int getVinculo(){
        return vinculo;
    }
    
    public Date getInicio(){
        return (Date)inicio.clone();
    }
    
    

    public static String getNombreVinculacion(int n){
        
        if(n<0 || n>3){
            throw new IllegalArgumentException();
        }
        
        String vinculacion = "";
        
        switch(n){
            case(1):
                vinculacion = "Contratado";
                break;
            case(2):
                vinculacion = "Despedido";
                 break;
            case(3):
                vinculacion = "EnERTE";
                 break;
        }
        
        return vinculacion;
    }
}
