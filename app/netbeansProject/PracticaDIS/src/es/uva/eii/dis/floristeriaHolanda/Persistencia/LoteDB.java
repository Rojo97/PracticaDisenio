/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

/**
 *
 * @author rojo
 */
public class LoteDB {
     private static String[] estados = {"PendienteDePlantar", "Plantado", "EnProduccion", "FinDeVidaUtil", "Eliminado"};

    public static void actualizar(int id, String estado) {
        int estadoN = 0;
        for(int i= 0; i<estados.length; i++){
            if(estados[i].toLowerCase().equals(estado.toLowerCase())){
                estadoN = i;
            }
        }
        estadoN++;
        String SQL_Update_Lote = "UPDATE LOTE L SET ESTADO = " + estadoN + " WHERE ID = " + id;
        System.out.println(SQL_Update_Lote);
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        conexion.update(SQL_Update_Lote);
    }
}
