/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Persistencia;

import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import es.uva.eii.dis.floristeriaHolanda.ServiciosComunes.ProductoNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author super
 */
public class ProductoDB {

    static String getProductoPorCodigo(String codigo) throws ProductoNotFoundException{
        String producto = null;
     
        String SQL_Query_Producto_Con_Codigo = "SELECT * FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Nombre = "SELECT P.NOMBRE FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Descripcion = "SELECT P.DESCRIPCION FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Existencias = "SELECT P.EXISTENCIAS FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Cantidad_Necesaria = "SELECT P.CANTIDADNECESARIA FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Precio_De_Venta = "SELECT P.PRECIODEVENTA FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Precio_Compra = "SELECT P.PRECIOCOMPRA FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Dias_Para_Entrega_Del_Proveedor = "SELECT P.DIASPARAENTREGADELPROVEEDOR FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Tipo_De_Producto_Auxiliar = "SELECT P.TIPODEPRODUCTOAUXILIAR FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Subtipo = "SELECT P.SUBTIPO FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        String SQL_Query_Planta_De_La_Flor = "SELECT P.PLANTADELAFLOR FROM Producto P WHERE P.CODIGO = '" + codigo + "'";
        
        
        ConexionDB conexion = ConexionDB.getInstancia(); 
        
        String consulta = conexion.consulta(SQL_Query_Producto_Con_Codigo);
        
        if(consulta==null){
            throw new ProductoNotFoundException("No hay ningun producto con ese codigo");
        }
        
        JSONArray jsonArray = new JSONArray(consulta);
            
        JSONObject jsonE = jsonArray.getJSONObject(0);
        
        jsonE.put("codigo", codigo);
            
        consulta = conexion.consulta(SQL_Query_Nombre);
        jsonE.put("nombre", consulta);
            
        consulta = conexion.consulta(SQL_Query_Descripcion);
        jsonE.put("descripcion", consulta);
        
        consulta = conexion.consulta(SQL_Query_Existencias);
        jsonE.put("existencias", consulta);
        
        consulta = conexion.consulta(SQL_Query_Cantidad_Necesaria);
        jsonE.put("cantidadNecesaria", consulta);
        
        consulta = conexion.consulta(SQL_Query_Precio_De_Venta);
        jsonE.put("precioDeVenta", consulta);
        
        consulta = conexion.consulta(SQL_Query_Precio_Compra);
        jsonE.put("precioCompra", consulta);
        
        consulta = conexion.consulta(SQL_Query_Dias_Para_Entrega_Del_Proveedor);
        jsonE.put("diasParaEntregaDelProveedor", consulta);
        
        consulta = conexion.consulta(SQL_Query_Tipo_De_Producto_Auxiliar);
        jsonE.put("tipoDeProductoAuxiliar", consulta);
        
        consulta = conexion.consulta(SQL_Query_Subtipo);
        jsonE.put("subtipo", consulta);
        
        consulta = conexion.consulta(SQL_Query_Planta_De_La_Flor);
        jsonE.put("plantaDeLaFlor", consulta);
        
        producto = jsonE.toString();
        
        return producto;
    }
    
}
