/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author ismael
 */
public class ProveedorDB {
    
    public String getProveedoresConFacturasEnIntervalo(Date fechaInicial, Date fechaFinal){
        // Pasar las fechas al formato yyyy-mm-dd
        String SQL_Query_Proveedores_Con_Facturas_Pendientes_Intervalo = "SELECT * FROM PROVEEDOR P WHERE EXISTS (SELECT * FROM PEDIDOAPROVEEDOR PP WHERE PP.PROVEEDOR=P.CIF AND PP.ESTAPENDIENTE='y'" +
                " AND PP.FECHADEREALIZACION>='2018-12-25' AND PP.FECHADEREALIZACION<='2018-12-30');";
        ConexionDB conexion = ConexionDB.getInstancia();
        
        return "Falta implementar";
    }
}
