/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelos.Modelo;

/**
 * Implementacion de la clase VistaRegistro
 * @author Ismael Perez Martin  
 * @author Victor Rojo Alvarez
 */
public class VistaRegistro extends javax.swing.JFrame {

    private ControladorVistaRegistro controlador;
    /**
     * Constructor por defecto de la clase VistaRegistro
     */
    public VistaRegistro() {
        initComponents();
        controlador = new ControladorVistaRegistro(this);
        /** Ponemos una fecha predefinida **/
        fechaPredefinida();
    }
    /**
     * Devuelve el nombre introducido
     * @return String nombre
     */
    public String getNombre(){
        return campoNombre.getText();
    }
    /**
     * Devuelve los apellidos introducidos
     * @return String apellidos
     */
    public String getApellidos(){
        return campoApellidos.getText();
    }
    /**
     * Devuelve el NIF introducido
     * @return String NIF
     */
    public String getNIF(){
        return campoNIF.getText();
    }
    /**
     * Devuelve el e-mail introducido
     * @return String email
     */
    public String getEmail(){
        return campoEmail.getText();
    }
    /**
     * Devuelve la contraseña introducida
     * @return String contraseña
     */
    public String getContraseña(){
        return String.valueOf(campoContraseña.getPassword());
    }
    /**
     * Devuelve la confirmacion de la contraseña introducida
     * @return String confirmacionContraseña
     */
    public String getConfirmacionContraseña(){
        return String.valueOf(campoContraseña2.getPassword());
    }
    /**
     * Devuelve la fecha elegida
     * @return Date fechaNacimiento
     */
    public Date getFechaNacimiento(){
        return fechaNacimiento.getDate();
    }
    /**
     * Devuelve el sexo elegido
     * @return String sexo
     */
    public String getSexo(){
        return String.valueOf(sexo.getSelectedItem());
    }
    /**
     * Notifica en la vista si hay algun error con el nombre introducido
     */
    public void errorNombre(){
        errorNombre.setText("Introduzca su nombre por favor");
    }
    /**
     * Notifica en la vista si hay algun error con los apellidos introducidos
     */
    public void errorApellidos(){
        errorApellidos.setText("Introduzca sus apellidos por favor");
    }
    /**
     * Notifica en la vista si hay algun error con el NIF introducido
     */
    public void errorNIF(){
        errorNIF.setText("Introduzca su NIF por favor");
    }
    /**
     * Notifica en la vista si hay algun error con el e-mail introducido
     */
    public void errorEmail(){
        errorEmail.setText("Introduzca un e-mail valido por favor");
    }
    /**
     * Notifica en la vista si hay algun error con la contraseña introducida
     */
    public void errorContraseña(){
        errorContraseña.setText("Introduzca una contraseña por favor");
    }
    /**
     * Notifica en la vista si hay algun error con la confirmacion de la contraseña introducida
     */
    public void errorContraseña2(){
        errorContraseña2.setText("Introduzca una contraseña por favor");
    }
    /**
     * Notifica en la vista si hay algun error con la concordancia de la contraseña
     * y su confirmacion
     */
    public void errorContraseñas(){
        errorContraseña2.setText("Las contraseñas no coinciden");
    }
    /**
     * Notifica en la vista si hay algun error con la fecha introducida
     * ya que es necesario tener 18 años para registrarse
     */
    public void errorFecha(){
        errorFecha.setText("Debe ser mayor de 18 años");
    }
    /**
     * Resetea los campos de los errores
     */
    public void resetErrores(){
        errorNombre.setText(null);
        errorApellidos.setText(null);
        errorNIF.setText(null);
        errorEmail.setText(null);
        errorContraseña.setText(null);
        errorContraseña2.setText(null);
        errorFecha.setText(null);
    }
    /**
     * Pone la fecha de 23/04/1997 como predefinida para seleccionar
     */
    public void fechaPredefinida(){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "1999-04-23";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        fechaNacimiento.setDate(fecha);
    }
    /**
     * Hace visible o invisible el contenido de las contraseñas
     */
    public void verContraseñas(){
        if(verContraseña.isSelected()){
            campoContraseña.setEchoChar((char)0);
            campoContraseña2.setEchoChar((char)0);
        }else{
            campoContraseña.setEchoChar('•');
            campoContraseña2.setEchoChar('•');
        }
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
        nombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        apellidos = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        NIF = new javax.swing.JLabel();
        campoNIF = new javax.swing.JTextField();
        fechaText = new javax.swing.JLabel();
        sexoText = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox();
        botonRegistrarse = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        campoEmail = new javax.swing.JTextField();
        emailText = new javax.swing.JLabel();
        errorNombre = new javax.swing.JLabel();
        errorApellidos = new javax.swing.JLabel();
        errorNIF = new javax.swing.JLabel();
        errorEmail = new javax.swing.JLabel();
        errorFecha = new javax.swing.JLabel();
        contraseña = new javax.swing.JLabel();
        errorContraseña = new javax.swing.JLabel();
        repetirContraseña = new javax.swing.JLabel();
        campoContraseña = new javax.swing.JPasswordField();
        campoContraseña2 = new javax.swing.JPasswordField();
        verContraseña = new javax.swing.JRadioButton();
        errorContraseña2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        nombre.setText("Nombre: *");

        apellidos.setText("Apellidos: *");

        NIF.setText("NIF: *");

        fechaText.setText("Fecha de nacimiento(Dia-Mes-Año):");

        sexoText.setText("Sexo:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mujer", "Hombre", "No especificar" }));

        botonRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarse.png"))); // NOI18N
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        emailText.setText("e-mail *");

        errorNombre.setForeground(new java.awt.Color(255, 0, 0));

        errorApellidos.setForeground(new java.awt.Color(255, 0, 0));

        errorNIF.setForeground(new java.awt.Color(255, 0, 0));

        errorEmail.setForeground(new java.awt.Color(255, 0, 0));

        errorFecha.setForeground(new java.awt.Color(255, 0, 0));

        contraseña.setText("Contraseña *");

        errorContraseña.setForeground(new java.awt.Color(255, 0, 0));

        repetirContraseña.setText("Repetir contraseña *");

        verContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verContraseña.setText("Ver contraseña");
        verContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verContraseñaActionPerformed(evt);
            }
        });

        errorContraseña2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verContraseña)
                        .addGap(18, 18, 18)
                        .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonVolver)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addComponent(apellidos)
                            .addComponent(NIF)
                            .addComponent(emailText)
                            .addComponent(contraseña)
                            .addComponent(repetirContraseña))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(errorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                    .addComponent(campoApellidos)
                                    .addComponent(campoNIF)
                                    .addComponent(errorApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(errorNIF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(errorContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(errorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(fechaText)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sexoText)
                                            .addGap(73, 73, 73))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(42, 42, 42))
                                        .addComponent(campoContraseña2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                        .addComponent(campoContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre))
                .addGap(3, 3, 3)
                .addComponent(errorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidos)
                    .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(errorApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NIF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseña)
                    .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repetirContraseña)
                    .addComponent(campoContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorContraseña2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaText)
                            .addComponent(sexoText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        controlador.back();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        controlador.compruebaRegistro();
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    private void verContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verContraseñaActionPerformed
        controlador.verContraseñas();
    }//GEN-LAST:event_verContraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NIF;
    private javax.swing.JLabel apellidos;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JPasswordField campoContraseña2;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNIF;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel emailText;
    private javax.swing.JLabel errorApellidos;
    private javax.swing.JLabel errorContraseña;
    private javax.swing.JLabel errorContraseña2;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorFecha;
    private javax.swing.JLabel errorNIF;
    private javax.swing.JLabel errorNombre;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
    private javax.swing.JLabel fechaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel repetirContraseña;
    private javax.swing.JComboBox sexo;
    private javax.swing.JLabel sexoText;
    private javax.swing.JRadioButton verContraseña;
    // End of variables declaration//GEN-END:variables
}
