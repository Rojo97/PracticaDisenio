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
public enum TipoVinculo {
    CONTRATADO("Contratado", 1),
    DESPEDIDO("Despedido", 2),
    ENERTE("EnERTE", 3);
    
    private String nombre;
    private int vinculo;
    
    private TipoVinculo(String nombre, int vinculo){
        this.nombre = nombre;
        this.vinculo = vinculo;
    }
    
    public int getNumero(){
        return vinculo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public static TipoVinculo getTipoVinculoPorNumero(int vinculo){
        switch(vinculo){
            case(1):
                return TipoVinculo.CONTRATADO;
            case(2):
                return TipoVinculo.DESPEDIDO;
            case(3):
                return TipoVinculo.ENERTE;
        }
        return null;
    }
}
