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
public class LineaDeVentaDB {

    static void guarda(int id, short cantidad, String producto) {
        String SQL_Insert_LineaDeVenta = "INSERT INTO LINEADEVENTA VALUES ( " + cantidad +", "+ id+", '" +producto+"')";
        ConexionDB conexion = ConexionDB.getInstancia();
        System.out.println(SQL_Insert_LineaDeVenta);
        conexion.update(SQL_Insert_LineaDeVenta);
    }
}
