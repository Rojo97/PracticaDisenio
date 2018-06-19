/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Clase con los metodos necesarios para añadir imagenes a los objetos de la
 * vista
 *
 * @see #paint(java.awt.Graphics)
 * @author rojo
 */
public class Imagen extends javax.swing.JPanel {

    private String localizacion;

    public Imagen(String localizacion, Dimension dimension) {
        this.setSize(dimension.width,dimension.height);
        this.localizacion = localizacion;
    }

    @Override
    public void paint(Graphics grafico) {
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon(getClass().getResource(localizacion));
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
}
