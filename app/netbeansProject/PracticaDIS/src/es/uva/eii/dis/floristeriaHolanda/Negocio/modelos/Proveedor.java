/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Negocio.modelos;

import es.uva.eii.dis.floristeriaHolanda.Persistencia.FachadaPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ismael
 */
public class Proveedor {
    
    private String cif;
    private String nombre;
    private String telefono;
    private String email;
    
    private ArrayList<PedidoAProveedor> listaPedidos;
    
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public Proveedor(String cif, String nombre, String telefono, String email){
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        
        listaPedidos = new ArrayList<>();
    }
    
    public static ArrayList<Proveedor> getProveedoresConFacturasEnIntervalo(Date fechaInicial, Date fechaFinal){
        String JSONArrayString = FachadaPersistencia.getProveedoresConFacturasEnIntervalo(fechaInicial, fechaFinal);
        
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        JSONArray proveedores = new JSONArray(JSONArrayString);
        
        Iterator it = proveedores.iterator();
        
        while (it.hasNext()) {            
            JSONObject jsonProveedor = (JSONObject)it.next();
            
            String cif = jsonProveedor.getString("CIF");
            String nombre = jsonProveedor.getString("NOMBRE");
            String telefono = jsonProveedor.getString("TELEFONO");
            String email = jsonProveedor.getString("EMAIL");
            
            Proveedor p = new Proveedor(cif, nombre, telefono, email);
            
            JSONArray pedidos = jsonProveedor.getJSONArray("pedidos");
            
            Iterator itP = pedidos.iterator();
            
            ArrayList<PedidoAProveedor> listaPedidos = new ArrayList<>();
            
            while (itP.hasNext()) {
                JSONObject jsonPedido = (JSONObject)itP.next();
                
                int numeroDePedido = jsonPedido.getInt("NUMERODEPEDIDO");
                String fechaDeRealizacionDePedido = jsonPedido.getString("FECHADEREALIZACION");
                String fechaDeEmisionFactura = jsonPedido.getString("FECHAEMISIONFACTURA");
                float importe = jsonPedido.getFloat("IMPORTEFACTURA");
                String cuentaBancaria = jsonPedido.getString("CUENTABANCARIAFACTURA");
                
                Date fechaRealizacion = null;
                try{
                   fechaRealizacion = formato.parse(fechaDeRealizacionDePedido); 
                }catch(ParseException e){
                    System.err.println(e.getStackTrace());
                }
                 
                PedidoAProveedor pp = new PedidoAProveedor(numeroDePedido, fechaRealizacion);
                
                Date fechaEmision = null;
                try{
                   fechaEmision = formato.parse(fechaDeRealizacionDePedido); 
                }catch(ParseException e){
                    System.err.println(e.getStackTrace());
                }
                
                Factura f = new Factura(fechaEmision, importe, cuentaBancaria);
                
                pp.setFactura(f);
                
                listaPedidos.add(pp);
            }
            p.addPedidosProveedor(listaPedidos);
            
            listaProveedores.add(p);
        }
        
        return listaProveedores;
    }
    
    public void addPedidosProveedor(ArrayList<PedidoAProveedor> listaPedidos){
        this.listaPedidos.addAll(listaPedidos);
    }
}
