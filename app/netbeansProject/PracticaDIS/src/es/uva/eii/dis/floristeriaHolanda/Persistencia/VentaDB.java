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
public class VentaDB {
    
    static void guarda(String dependiente, int id) {
        String SQL_Insert_Venta = "INSERT INTO VENTA VALUES ( " + id +", CURRENT_DATE, '" +dependiente+"')";
        ConexionDB conexion = ConexionDB.getInstancia();
        System.out.println(SQL_Insert_Venta);
        conexion.update(SQL_Insert_Venta);
    }
}
