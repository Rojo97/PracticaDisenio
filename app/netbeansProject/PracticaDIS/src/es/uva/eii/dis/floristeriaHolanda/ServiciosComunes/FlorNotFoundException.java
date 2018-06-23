/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

/**
 *
 * @author victo
 */
public class FlorNotFoundException extends Exception {
    public FlorNotFoundException() {
    }

    /**
     * Constructs an instance of <code>FlorNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FlorNotFoundException(String msg) {
        super(msg);
    }
}
