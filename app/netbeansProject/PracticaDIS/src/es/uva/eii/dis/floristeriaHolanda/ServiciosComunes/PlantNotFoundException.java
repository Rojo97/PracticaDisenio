/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

/**
 *
 * @author rojo
 */
public class PlantNotFoundException extends Exception {
        /**
     * Creates a new instance of <code>PlantNotFoundException</code> without
     * detail message.
     */
    public PlantNotFoundException() {
    }

    /**
     * Constructs an instance of <code>PlantNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PlantNotFoundException(String msg) {
        super(msg);
    }
}
