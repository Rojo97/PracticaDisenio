/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 * Implementacion de la clase modelo
 * @author Ismael Perez Martin
 * @author Victor Rojo Alvarez
 */
public class Modelo {
    
    private String usuario, ciudad, tipoCasa, casaElegida, errorFE, erroFS;
    private Date fechaInicio, fechaFinal;
    private boolean inmediato;
    private int huespedes, precioMin, precioMax, precioCasa, habitaciones;
    
    /**
     * Constructor por defecto de la clase Modelo
     */
    public Modelo(){
        fechaInicio = new Date();
        fechaFinal = new Date();
        inmediato = false;
    }
    
    public boolean esRegistrado(){
        return(getUsuario()!=null);
    }
    
    public String getUsuario(){
        return usuario; 
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getCiudad(){
        return ciudad; 
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public String getTipoCasa(){
        return tipoCasa; 
    }
    public void setTipoCasa(String tipoCasa){
        this.tipoCasa = tipoCasa;
    }
    public Date getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(Date fecha){
        fechaInicio = fecha;
    }
    public Date getFechaFinal(){
        return fechaFinal;
    }
    public void setFechaFinal(Date fecha){
        fechaFinal = fecha;
    }
    public boolean getInmediato(){
        return inmediato;
    }
    public void setInmediato(boolean bool){
        inmediato = bool;
    }
    public int getHuespedes(){
        return huespedes;
    }
    public void setHuespedes(int huespedes){
        this.huespedes = huespedes;
    }
    public int getPrecioMin(){
        return precioMin;
    }
    public void setPrecioMin(int precio){
        precioMin = precio;
    }
    public int getPrecioMax(){
        return precioMax;
    }
    public void setPrecioMax(int precio){
        precioMax = precio;
    }
    public String getCasaElegida(){
        return casaElegida;
    }
    public void setCasaElegida(String casa){
        casaElegida = casa;
    }
    public void setErrorFE(String error){
        errorFE = error;
    }
    public String getErrorFE(){
        return errorFE;
    }
    public void setErrorFS(String error){
        errorFE = error;
    }
    public String getErrorFS(){
        return errorFE;
    }
    public void setPrecioCasa(int precio){
        precioCasa = precio;
    }
    public int getPrecioCasa(){
        return precioCasa;
    }
    public void setHabitaciones(int habitac){
        habitaciones = habitac;
    }
    public int getHabitaciones(){
        return habitaciones;
    }
    
    
}
