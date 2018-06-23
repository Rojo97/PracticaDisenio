/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import org.json.JSONObject;

/**
 *
 * @author victo
 */
public class FloresEnLote {
    private int cantidad;
    private int lote;
    private String flor;
    private boolean nuevo;

    FloresEnLote(String res) {
        JSONObject json = new JSONObject(res);
        
        flor = json.getString("FLOR");
        lote = json.getInt("LOTE");
        cantidad = json.getInt("CANTIDAD");
        nuevo = false;
    }

    FloresEnLote(int lote, String codigo) {
        cantidad = 0;
        this.lote = lote;
        flor = codigo;
        nuevo = true;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFlor() {
        return flor;
    }

    public int getLote() {
        return lote;
    }
    
    public boolean getNuevo(){
        return nuevo;
    }
    
}
