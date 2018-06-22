/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.Interfaz;

/**
 *
 * @author super
 */
public class VistaModificarLote extends javax.swing.JFrame {
    
    private final CtrlVistaModificarLote controlador;
    /**
     * Creates new form VistaModificarEstadoLote
     */
    public VistaModificarLote() {
        initComponents();
        selectorLotes.hide();
        jLabel2.hide();
        errorPlanta.hide();
        controlador = new CtrlVistaModificarLote(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        planta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        selectorLotes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        errorPlanta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        planta.setText("Nombre Planta");
        planta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantaActionPerformed(evt);
            }
        });

        jLabel1.setText("Introducir nombre de la planta");

        selectorLotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lote 1", "Lote2" }));

        jLabel2.setText("Seleccionar lote a cambiar");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        errorPlanta.setText("No se ha encontrado una planta con el nombre disponible.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(planta)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(selectorLotes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscar)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorPlanta)
                        .addContainerGap(70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectorLotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(errorPlanta)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plantaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        controlador.procesaEventoPlanta();
    }//GEN-LAST:event_buscarActionPerformed

    public String getPlanta(){
        return planta.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JLabel errorPlanta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField planta;
    private javax.swing.JComboBox<String> selectorLotes;
    // End of variables declaration//GEN-END:variables

    void mostrarErrorPlanta() {
        errorPlanta.setVisible(true);
        
    }

    void addLote(String[] lote) {
        String stringLote = "id: "+ lote[0]+ ", fecha: "+lote[1]+ ", estado: " +lote[2];
        selectorLotes.addItem(stringLote);
    }

    void muestraLotes() {
        selectorLotes.setVisible(true);
        buscar.setVisible(false);
    }
}