/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ValhalaCode
 */
public class Tarea implements Serializable, Informe{

    private String nombre;
//    private String tareaPadre;
    public Tarea tareaPadre;
    public ArrayList<Tarea> subTareas;
    private String descripcion;
    private Correccion correccion;
    private Desarrollo desarrollo;

    public Tarea(String nombre, Tarea tareaPadre, String descripcion, Desarrollo desarrollo, Correccion correccion, ArrayList<Tarea> subTareas) {
        this.nombre = nombre;
        this.tareaPadre = tareaPadre;
        this.descripcion = descripcion;
        this.desarrollo = desarrollo;
        this.correccion = correccion;
        this.subTareas = subTareas;
    }
    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desarrollo = new Desarrollo();
        this.correccion = new Correccion();
        this.subTareas = new ArrayList<Tarea>();
    }
    public Tarea(Tarea tarea){
        this.nombre = tarea.getNombre();
        this.tareaPadre = tarea.getTareaPadre();
        this.descripcion = tarea.getDescripcion();
        this.desarrollo = tarea.getDesarrollo();
        this.correccion = tarea.getCorreccion();
        this.subTareas = tarea.getSubTareas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarea getTareaPadre() {
        return tareaPadre;
    }
    public void setTareaPadre(Tarea tareaPadre) {
        this.tareaPadre = tareaPadre;
    }
    public ArrayList<Tarea> getSubTareas(){
        return this.subTareas;
    }
    public void setSubTareas(ArrayList<Tarea> subTareas){
        this.subTareas = subTareas;
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
    public int tiempo(){
        int acum = 0;
        for(Tarea subTarea : subTareas)
            acum += subTarea.getDesarrollo().getTiempo() + subTarea.getCorreccion().getTiempo();
        return acum;
    }
    // Metodo para calcular las lineas totales de la tarea en particular
    public int lineasCodigo(){
        int acum = 0;
        for(Tarea subTarea : subTareas)
            acum += subTarea.getDesarrollo().getLineasCodigo() + (subTarea.getCorreccion().getLineasAgregadas() - subTarea.getCorreccion().getLineasErroneas());
        return acum;
    }

    // Metodos de Informe (Interface)
    @Override
    public int lineasCodigoTotal() {
        return this.lineasCodigo();
    }

    @Override
    public int tiempoTotal() {
        return getDesarrollo().getTiempo() + getCorreccion().getTiempo();
    }

    @Override
    public int tiempoDesarrollo() {
        return getDesarrollo().getTiempo();
    }

    @Override
    public int tiempoCorrecciones() {
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

    @Override
    public String toString() {
        return nombre;
    }
}
