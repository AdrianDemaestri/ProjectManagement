/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.sound.sampled.Line;
import javax.swing.tree.MutableTreeNode;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.time.LocalTime;

/**
 *
 * @author ValhallaCode
 */

public class Proyecto implements Serializable, Informe {
    private String nombre;
    private EtapaProyecto analisis;
    private EtapaProyecto pruebas;
    ArrayList<Tarea> tareas;

    // Metodos getter y setter 


    public Proyecto(String nombre, int tiempoAnalisis, int tiempoPruebas) {
        this.nombre = nombre;
        this.analisis.setTiempo(tiempoAnalisis);
        this.pruebas.setTiempo(tiempoPruebas);
        this.tareas = new ArrayList<Tarea>();
    }
    public Proyecto(Proyecto proyecto) {
        this.nombre = proyecto.getNombre();
        this.analisis = proyecto.getAnalisis();
        this.pruebas = proyecto.getPruebas();
        this.tareas = proyecto.tareas;
    }

    public Proyecto(String nombre, EtapaProyecto analisis) {
        this.nombre = nombre;
        this.analisis = analisis;
        tareas = new ArrayList<Tarea>();
        pruebas = new EtapaProyecto();
    }
    
    

    public Proyecto() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EtapaProyecto getAnalisis() {
        return analisis;
    }
    public void setAnalisis(EtapaProyecto analisis) {
        this.analisis = analisis;
    }

    public EtapaProyecto getPruebas() {
        return pruebas;
    }

    public void setPruebas(EtapaProyecto pruebas) {
        this.pruebas = pruebas;
    }

    public ArrayList<Tarea> getTareas() {
        if( tareas == null);
            tareas = new ArrayList<Tarea>();
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return nombre;
    }

    // Hcaer metodos para calcular el tiempo total de todas las tareas
    // Hacer metodo para calcular la cantidad de lineas totales de todas las tareas


    @Override
    public int lineasCodigoTotal(){
        int acum=0;
        for(Tarea tarea : tareas)
            acum += tarea.lineasCodigo();
        return acum;
    }

    @Override
    public int tiempoTotal(){
        int acum = 0;
        for (Tarea tarea : tareas)
            acum += tarea.tiempo();
        acum += pruebas.getTiempo();
        acum += analisis.getTiempo();
        return acum;
    }
    @Override
    public int tiempoDesarrollo(){
        int resultado = 0;
        for (Tarea tarea : tareas)
            resultado += tarea.getDesarrollo().getTiempo();
        return resultado;
    }
    @Override
    public int tiempoCorrecciones(){
        int resultado = 0;
        for (Tarea tarea : tareas)
            resultado += tarea.getCorreccion().getTiempo();
        return resultado;
    }
    @Override
    public float lineaCodigoTotalPorHora(){
        int nanosegundos = this.tiempoTotal();
        int lineasCodigoTotal = this.lineasCodigoTotal();
        float horas = (float)(nanosegundos / 3600000000000L);
        return lineasCodigoTotal / horas;
    }
    @Override
    public float lineaCodigoErroneasCada100Lineas(){
        float lineasErroneas = 0;
        for(Tarea tarea : tareas)
            lineasErroneas += tarea.getCorreccion().getLineasErroneas();
        lineasErroneas =  (float) (lineasErroneas / (this.lineasCodigoTotal() / 100));
        return lineasErroneas;
    }
    @Override
    public float porcentajeCodigoErroneo(){
        float lineasErroneas = 0;
        for(Tarea tarea : tareas)
            lineasErroneas += tarea.getCorreccion().getLineasErroneas();
        lineasErroneas = lineasErroneas / (float)(this.lineasCodigoTotal() / 100);
        return lineasErroneas;
    }
    public int tiempoAnalisis(){
        return getAnalisis().getTiempo();
    }
    public int tiempoPrueba(){
        return getPruebas().getTiempo();
    }
    
    
    public boolean contiene(Tarea tarea){
        for (Tarea t : tareas)
            if (tarea == t)
                return true;
        return false;
    }

    public ArrayList<Tarea> subTareas(Tarea tarea){
        ArrayList<Tarea> r = new ArrayList<Tarea>();
        for (Tarea t : tareas)
            if (t.getTareaPadre().equals(tarea.getNombre()))
                r.add(tarea);
        return r;
    }

    public Tarea buscarTarea(String nombre){
        for (Tarea tarea : tareas)
            if (tarea.getNombre().equals(nombre))
                return tarea;
        return null;
    }
}
