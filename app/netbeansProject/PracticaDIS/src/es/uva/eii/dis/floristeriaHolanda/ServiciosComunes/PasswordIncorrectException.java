/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.dis.floristeriaHolanda.ServiciosComunes;

/**
 *
 * @author ismael
 */
public class PasswordIncorrectException extends Exception {

    /**
     * Creates a new instance of <code>PasswordIncorrectException</code> without
     * detail message.
     */
    public PasswordIncorrectException() {
    }

    /**
     * Constructs an instance of <code>PasswordIncorrectException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordIncorrectException(String msg) {
        super(msg);
    }
}
