/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author ismael
 */
public class ProveedorDB {
    
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public static String getProveedoresConFacturasEnIntervalo(Date fechaInicial, Date fechaFinal){
        
        String fechaIni = formato.format(fechaInicial);
        String fechaFin = formato.format(fechaFinal);
        
        String SQL_Query_Proveedores_Con_Facturas_Pendientes_Intervalo = "SELECT * FROM PROVEEDOR P WHERE EXISTS (SELECT * FROM PEDIDOAPROVEEDOR PP WHERE PP.PROVEEDOR=P.CIF AND PP.ESTAPENDIENTE='y'" +
                " AND PP.FECHADEREALIZACION>='"+ fechaIni + "' AND PP.FECHADEREALIZACION<='"+fechaFin+"')";
        
        ConexionDB conexion = ConexionDB.getInstancia();
        
        String consulta = conexion.consulta(SQL_Query_Proveedores_Con_Facturas_Pendientes_Intervalo);
        
        if(consulta!=null){
            JSONArray proveedores = new JSONArray(consulta);
            
            Iterator it = proveedores.iterator();
            while (it.hasNext()) {
                JSONObject jsonProveedor = (JSONObject)it.next();
                
                String cif = jsonProveedor.getString("CIF");
                
                String SQL_Query_Facturas_Proveedor_Pendientes_Intervalo = "SELECT PP.NUMERODEPEDIDO, PP.FECHADEREALIZACION,  F.FECHADEEMISION AS FECHAEMISIONFACTURA, F.IMPORTE AS IMPORTEFACTURA, F.CUENTABANCARIA AS CUENTABANCARIAFACTURA" +
                        " FROM PEDIDOAPROVEEDOR PP, FACTURA F WHERE PP.PROVEEDOR = '"+ cif +"' AND PP.ESTAPENDIENTE='y' AND PP.FECHADEREALIZACION>='"+fechaIni+"'" +
                        " AND PP.FECHADEREALIZACION<='"+fechaFin+"' AND F.PEDIDO = PP.NUMERODEPEDIDO AND F.ENTRANSFERENCIA IS NULL";
                
                consulta = conexion.consulta(SQL_Query_Facturas_Proveedor_Pendientes_Intervalo);
                
                JSONArray pedidos = new JSONArray(consulta);
                
                jsonProveedor.put("pedidos", pedidos);
            }
            
            System.out.println("Proveedores: "+ proveedores.toString());
            return proveedores.toString();
        }
        
        return null;
    }
}
