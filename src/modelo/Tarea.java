/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author ValhalaCode
 */
public class Tarea implements Serializable, Informe{

    private String nombre;
    private String tareaPadre;
    private String descripcion;
    private Correccion correccion;
    private Desarrollo desarrollo;

    public Tarea(String nombre, String tareaPadre, String descripcion, Desarrollo desarrollo, Correccion correccion) {
        this.nombre = nombre;
        this.tareaPadre = tareaPadre;
        this.descripcion = descripcion;
        this.desarrollo = desarrollo;
        this.correccion = correccion;
    }
    public Tarea(Tarea tarea){
        this.nombre = tarea.getNombre();
        this.tareaPadre = tarea.getTareaPadre();
        this.descripcion = tarea.getDescripcion();
        this.desarrollo = tarea.getDesarrollo();
        this.correccion = tarea.getCorreccion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTareaPadre() {
        return tareaPadre;
    }

    public void setTareaPadre(String nombre) {
        this.tareaPadre = tareaPadre;
    }

    public Correccion getCorreccion() {
        return correccion;
    }

    public void setCorreccion(Correccion correccion) {
        this.correccion = correccion;
    }

    public Desarrollo getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(Desarrollo desarrollo) {
        this.desarrollo = desarrollo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Metodo para calcular el tiempo total del desarrollo
    public Long tiempo(){
        return correccion.getTiempo() + desarrollo.getTiempo();
    }
    // Metodo para calcular las lineas totales de la tarea en particular
    public int lineasCodigo(){
        return  desarrollo.getLineasCodigo() + correccion.LineasCodigo();
    }

    // Metodos de Informe (Interface)
    @Override
    public int lineasCodigoTotal() {
        return getDesarrollo().getLineasCodigo() + getCorreccion().LineasCodigo();
    }

    @Override
    public Long tiempoTotal() {
        return getDesarrollo().getTiempo() + getCorreccion().getTiempo();
    }

    @Override
    public Long tiempoDesarrollo() {
        return getDesarrollo().getTiempo();
    }

    @Override
    public Long tiempoCorrecciones() {
        return getCorreccion().getTiempo();
    }
    @Override
    public float lineaCodigoTotalPorHora() {
        return 0;
    }

    @Override
    public float lineaCodigoErroneasCada100Lineas() {
        return (float)getCorreccion().getLineasErroneas() / (float) (lineasCodigoTotal() / 100);
    }

    @Override
    public float porcentajeCodigoErroneo() {
        return (float)getCorreccion().getLineasErroneas() * 100 / (float) (lineasCodigoTotal());
    }
}
