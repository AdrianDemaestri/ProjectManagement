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
public class Tarea implements Serializable{

    private String nombre;
    private String descripcion;
    private Correccion correccion;
    private Desarrollo desarrollo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Tarea(String nombre) {
        this.nombre = nombre;
    }
}
