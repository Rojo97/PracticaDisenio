/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author rojo
 */
public class Lote {
    private int id;
    private short cantidad;
    private Date fechadeCreacion;
    private short estado;
    private String planta;
    private static String[] estados = {"PendienteDePlantar", "Plantado", "EnProduccion", "FinDeVidaUtil", "Eliminado"};
    
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public Lote(JSONObject jsonLote){
            id =  jsonLote.getInt("ID");
            cantidad = (short) jsonLote.getInt("CANTIDAD");
            try{
                fechadeCreacion = formato.parse(jsonLote.getString("FECHADECREACION"));
            }catch(Exception e){
                System.err.println(e.getStackTrace());
            }
            estado = (short) jsonLote.getInt("ESTADO");
            planta = jsonLote.getString("PLANTA");
        }

    public String getEstado() {
        return estados[estado-1];
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getFecha() {
        return fechadeCreacion.toString();
    }
}
