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
    private TipoVinculo vinculo;
    
    public VinculacionConLaEmpresa(Date inicio, int vinculo){
        this.inicio = inicio;
        this.vinculo = TipoVinculo.getTipoVinculoPorNumero(vinculo);
    }
    
    public TipoVinculo getVinculo(){
        return vinculo;
    }
    
    public String getNombreVinculo(){
        return vinculo.getNombre();
    }
    
    public int getNumeroVinculo(){
        return vinculo.getNumero();
    }
    
    public Date getInicio(){
        return (Date)inicio.clone();
    }
}
