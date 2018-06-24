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
public class FloresEnLoteNotFoundException extends Exception {
        public FloresEnLoteNotFoundException() {
    }

    /**
     * Constructs an instance of <code>FlorEnLoteNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FloresEnLoteNotFoundException(String msg) {
        super(msg);
    }
}
