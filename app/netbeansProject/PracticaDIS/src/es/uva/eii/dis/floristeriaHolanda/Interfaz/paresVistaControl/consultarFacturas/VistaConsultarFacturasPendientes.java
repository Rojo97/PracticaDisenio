package es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.consultarFacturas;

import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.PedidoAProveedor;
import es.uva.eii.dis.floristeriaHolanda.Negocio.modelos.Proveedor;
import es.uva.eii.dis.floristeriaHolanda.Persistencia.CatalogoProveedores;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author super
 */
public class VistaConsultarFacturasPendientes extends javax.swing.JFrame {

    private es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.consultarFacturas.ControladorVistaConsultarFacturasPendientes controlador;
    
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form VistaConsultarFacturasPendientes
     */
    public VistaConsultarFacturasPendientes() {
        initComponents();
        panelProveedor.setVisible(false);
        esconderInforme();
        controlador = new es.uva.eii.dis.floristeriaHolanda.Interfaz.paresVistaControl.consultarFacturas.ControladorVistaConsultarFacturasPendientes(this);
    }
    
    public void esconderInforme(){
        panelInforme.setVisible(false);
        panelDetallePedido.setVisible(false);
    }
    
    public String getFechaInicial(){
        return textFechaInicial.getText();
    }
    
    public String getFechaFinal(){
        return textFechaFinal.getText();
    }
    
    public String getProveedor(){
        return textoProveedor.getText();
    }
    
    public String getPedidoSeleccionado(){
        return comboBoxPedidos.getSelectedItem().toString().split("-->")[1];
    }
    
    public boolean anioActualIsSelected(){
        return checkBoxAnioActual.isSelected();
    }
    
    public void deselectAnioActual(){
        checkBoxAnioActual.setSelected(false);
    }
    
    public void deselectTodasFechas(){
        checkBoxGeneral.setSelected(false);
    }
    
    public boolean todasFechasIsSelected(){
        return checkBoxGeneral.isSelected();
    }
    
    public void esconderProveedores(){
        panelProveedor.setVisible(false);
        esconderInforme();
    }
    
    public void mostrarErrorFechaInicial(){
        textoErrorFechas.setText("La fecha inicial no es valida");
    }
    
    public void mostrarErrorFechaFinal(){
        textoErrorFechas.setText("La fecha final no es valida");
    }
    
    public void mostrarErrorFechasIncompatibles(){
        textoErrorFechas.setText("La fecha inicial debe ser anterior a la final");
    }
    
    public void mostrarNingunPedidoEnIntervalo(){
        textoErrorFechas.setText("No hay ningun pedido en ese intervalo");
    }
    
    public void busquedaCorrecta(){
        textoErrorFechas.setText("");
        panelProveedor.setVisible(true);
    }
    
    public void mostrarErrorProveedor(){
        textoErrorProveedor.setText("El nombre no coincide con ninguún proveedor");
    }
    
    
    
    public void mostrarFacturasProveedorSeleccionado(){
        panelInforme.setVisible(true);
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        Proveedor p = catalogo.getProveedorSeleccionado();
        
        labelNombreProveedorInforme.setText(p.getNombre());
        
        Date fechaIni = catalogo.getFechaInicialCatalogo();
        Date fechaFin = catalogo.getFechaFinalCatalogo();
        labelFechaInicioInforme.setText(formato.format(fechaIni));
        labelFechaFinalInforme.setText(formato.format(fechaFin));
        
        
        ArrayList<PedidoAProveedor> pedidos = p.getListaPedidosPendientes();
        
        Iterator it = pedidos.iterator();
        
        comboBoxPedidos.removeAllItems();
        
        while (it.hasNext()) {
            PedidoAProveedor pp = (PedidoAProveedor)it.next();
            String pedido = p.getNombre() + " - " + p.getCif() + " --> " + pp.getNumeroPedido();
            comboBoxPedidos.addItem(pedido);
        }
    }
    
    public void desactivaIntervalo(){
        System.err.println("Desactiva");
        textFechaInicial.setEditable(false);
        textFechaFinal.setEditable(false);
        botonBuscarProveedor.setEnabled(false);
    }
    
    public void activaIntervalo(){
        textFechaInicial.setEditable(true);
        textFechaFinal.setEditable(true);
        botonBuscarProveedor.setEnabled(true);
    }
    
    public void muestraInforme(){
        panelDetallePedido.setVisible(true);
        CatalogoProveedores catalogo = CatalogoProveedores.getInstancia();
        
        Proveedor p = catalogo.getProveedorSeleccionado();
        
        ArrayList<PedidoAProveedor> listaPedidos = p.getListaPedidosPendientes();
        
        Iterator it = listaPedidos.iterator();
        
        int numElegido = Integer.parseInt(comboBoxPedidos.getSelectedItem().toString().split("--> ")[1]);
        
        PedidoAProveedor pp = new PedidoAProveedor(1, null);
        while (it.hasNext()) {
            pp = (PedidoAProveedor)it.next();
            if(pp.getNumeroPedido()==numElegido){
                break;
            }
        }
        labelNumeroPedido.setText(String.valueOf(numElegido));
        labelNombreProveedor.setText(p.getNombre());
        String fechaFactura = formato.format(pp.getFactura().getFechaEmision());
        labelFechaEmisionFactura.setText(fechaFactura);
        String fechaInforme = formato.format(pp.getFechaRealizacion());
        labelFechaRealizacionPedido.setText(fechaInforme);
        labelImporteFactura.setText(String.valueOf(pp.getFactura().getImporte()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        textFechaInicial = new javax.swing.JTextField();
        textFechaFinal = new javax.swing.JTextField();
        labelFechaIni = new javax.swing.JLabel();
        labelFechaFin = new javax.swing.JLabel();
        botonBuscarProveedor = new javax.swing.JButton();
        checkBoxAnioActual = new javax.swing.JCheckBox();
        checkBoxGeneral = new javax.swing.JCheckBox();
        labelGuion = new javax.swing.JLabel();
        labelAsteriscoFechaIni = new javax.swing.JLabel();
        labelAsteriscoFechaFin = new javax.swing.JLabel();
        textoErrorFechas = new javax.swing.JLabel();
        panelProveedor = new javax.swing.JPanel();
        textoProveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botonBuscarFacturas = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        textoErrorProveedor = new javax.swing.JLabel();
        panelInforme = new javax.swing.JPanel();
        labelNombreProveedorInforme = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelErrorFacturas = new javax.swing.JLabel();
        labelFechaInicioInforme = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelDetallePedido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelNumeroPedido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelNombreProveedor = new javax.swing.JLabel();
        labelImporteFactura = new javax.swing.JLabel();
        labelFechaRealizacionPedido = new javax.swing.JLabel();
        labelFechaEmisionFactura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelFechaFinalInforme = new javax.swing.JLabel();
        comboBoxPedidos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        botonVerInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        textFechaInicial.setText("aaaa-mm-dd");

        textFechaFinal.setText("aaaa-mm-dd");

        labelFechaIni.setText("Introducir fecha inicial");

        labelFechaFin.setText("Introducir fecha final");

        botonBuscarProveedor.setText("Buscar proveedor");
        botonBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProveedorActionPerformed(evt);
            }
        });

        checkBoxAnioActual.setText("Mostrar facturas pendientes del año actual");
        checkBoxAnioActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAnioActualActionPerformed(evt);
            }
        });

        checkBoxGeneral.setText("Mostrar todas las facturas pendientes");
        checkBoxGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxGeneralActionPerformed(evt);
            }
        });

        labelGuion.setText("-");

        labelAsteriscoFechaIni.setText("*");

        labelAsteriscoFechaFin.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(botonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonBuscarProveedor))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkBoxAnioActual)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoErrorFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelAsteriscoFechaIni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelFechaIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(labelGuion)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelAsteriscoFechaFin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxGeneral)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFechaFin)
                    .addComponent(labelFechaIni)
                    .addComponent(labelAsteriscoFechaIni)
                    .addComponent(labelAsteriscoFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGuion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoErrorFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkBoxAnioActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(checkBoxGeneral)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonBuscarProveedor)))
        );

        panelProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        textoProveedor.setText("Cif proveedor");

        jLabel4.setText("Introducir nombre del proveedor");

        botonBuscarFacturas.setText("Buscar facturas");
        botonBuscarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFacturasActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Mostrar todos los proveedores");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel10.setText("*");

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonBuscarFacturas))
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(textoErrorProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProveedorLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(textoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                        .addGap(7, 7, 7))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(jCheckBox4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(textoErrorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(botonBuscarFacturas))
        );

        panelInforme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));

        labelNombreProveedorInforme.setText("Nombre proveedor/ Todos los proveedores");

        jLabel13.setText("Proveedor:");

        labelErrorFacturas.setText("* No se han encontrado facturas pendientes *");

        labelFechaInicioInforme.setText("Fecha inicio");

        jLabel9.setText("Fechas:");

        panelDetallePedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel3.setText("Numero de pedido:");

        labelNumeroPedido.setText("Numero");

        jLabel6.setText("Nombre proveedor:");

        jLabel7.setText("Importe factura:");

        jLabel8.setText("Fecha realizacion pedido:");

        jLabel11.setText("Fecha emision factura:");

        labelNombreProveedor.setText("Nombre");

        labelImporteFactura.setText("Importe");

        labelFechaRealizacionPedido.setText("Fecha");

        labelFechaEmisionFactura.setText("Fecha");

        javax.swing.GroupLayout panelDetallePedidoLayout = new javax.swing.GroupLayout(panelDetallePedido);
        panelDetallePedido.setLayout(panelDetallePedidoLayout);
        panelDetallePedidoLayout.setHorizontalGroup(
            panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallePedidoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDetallePedidoLayout.createSequentialGroup()
                        .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(58, 58, 58)
                        .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNumeroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(labelNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelImporteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelDetallePedidoLayout.createSequentialGroup()
                        .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFechaRealizacionPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFechaEmisionFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelDetallePedidoLayout.setVerticalGroup(
            panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallePedidoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelNumeroPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelNombreProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelImporteFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelFechaRealizacionPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelFechaEmisionFactura))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel1.setText("-");

        labelFechaFinalInforme.setText("FechaFinal");

        comboBoxPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Pedido");

        botonVerInforme.setText("Ver informe");
        botonVerInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInformeLayout = new javax.swing.GroupLayout(panelInforme);
        panelInforme.setLayout(panelInformeLayout);
        panelInformeLayout.setHorizontalGroup(
            panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformeLayout.createSequentialGroup()
                .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformeLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(32, 32, 32)
                                .addComponent(labelFechaInicioInforme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelFechaFinalInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInformeLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelNombreProveedorInforme))))
                    .addComponent(panelDetallePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInformeLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labelErrorFacturas))
                    .addGroup(panelInformeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonVerInforme)
                            .addComponent(comboBoxPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelInformeLayout.setVerticalGroup(
            panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelFechaInicioInforme)
                    .addComponent(jLabel1)
                    .addComponent(labelFechaFinalInforme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelNombreProveedorInforme))
                .addGap(18, 18, 18)
                .addComponent(labelErrorFacturas)
                .addGap(18, 18, 18)
                .addGroup(panelInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(botonVerInforme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDetallePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.procesaCancelarOperacion();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void botonBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProveedorActionPerformed
        controlador.procesaEventoRangoFechas();
    }//GEN-LAST:event_botonBuscarProveedorActionPerformed

    private void checkBoxAnioActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAnioActualActionPerformed
        controlador.procesaEventoAñoActual();
    }//GEN-LAST:event_checkBoxAnioActualActionPerformed

    private void checkBoxGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxGeneralActionPerformed
        controlador.procesaEventoTodasLasFechas();
    }//GEN-LAST:event_checkBoxGeneralActionPerformed

    private void botonBuscarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFacturasActionPerformed
        controlador.procesaEventoProveedorIntroducido();
    }//GEN-LAST:event_botonBuscarFacturasActionPerformed

    private void botonVerInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerInformeActionPerformed
        controlador.procesaPedidoElegido();
    }//GEN-LAST:event_botonVerInformeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarFacturasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarFacturasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarFacturasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarFacturasPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultarFacturasPendientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarFacturas;
    private javax.swing.JButton botonBuscarProveedor;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonVerInforme;
    private javax.swing.JCheckBox checkBoxAnioActual;
    private javax.swing.JCheckBox checkBoxGeneral;
    private javax.swing.JComboBox<String> comboBoxPedidos;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAsteriscoFechaFin;
    private javax.swing.JLabel labelAsteriscoFechaIni;
    private javax.swing.JLabel labelErrorFacturas;
    private javax.swing.JLabel labelFechaEmisionFactura;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JLabel labelFechaFinalInforme;
    private javax.swing.JLabel labelFechaIni;
    private javax.swing.JLabel labelFechaInicioInforme;
    private javax.swing.JLabel labelFechaRealizacionPedido;
    private javax.swing.JLabel labelGuion;
    private javax.swing.JLabel labelImporteFactura;
    private javax.swing.JLabel labelNombreProveedor;
    private javax.swing.JLabel labelNombreProveedorInforme;
    private javax.swing.JLabel labelNumeroPedido;
    private javax.swing.JPanel panelDetallePedido;
    private javax.swing.JPanel panelInforme;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JTextField textFechaFinal;
    private javax.swing.JTextField textFechaInicial;
    private javax.swing.JLabel textoErrorFechas;
    private javax.swing.JLabel textoErrorProveedor;
    private javax.swing.JTextField textoProveedor;
    // End of variables declaration//GEN-END:variables
}
