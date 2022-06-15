/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.sound.sampled.Line;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalTime;

/**
 *
 * @author ValhallaCode
 */

public class Proyecto implements Serializable, Informe{
    private String nombre;
    private EtapaProyecto analisis;
    private EtapaProyecto pruebas;
    ArrayList<Tarea> tareas;

    // Metodos getter y setter 


    public Proyecto(String nombre, Long tiempoAnalisis, Long tiempoPruebas) {
        this.nombre = nombre;
        this.analisis.setTiempo(tiempoAnalisis);
        this.pruebas.setTiempo(tiempoPruebas);
        this.tareas = new ArrayList<Tarea>();
    }
    public Proyecto(Proyecto proyecto) {
        this.nombre = proyecto.getNombre();
        this.analisis = proyecto.getAnalisis();
        this.pruebas = proyecto.getPruebas();
        this.tareas = new ArrayList<Tarea>();
    }

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
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + '\n';
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
    public Long tiempoTotal(){
        Long acum = Integer.toUnsignedLong(0);
        for (Tarea tarea : tareas)
            acum += tarea.tiempo();
        acum += pruebas.getTiempo();
        acum += analisis.getTiempo();
        return acum;
    }
    @Override
    public Long tiempoDesarrollo(){
        Long resultado = Integer.toUnsignedLong(0);
        for (Tarea tarea : tareas)
            resultado += tarea.getDesarrollo().getTiempo();
        return resultado;
    }
    @Override
    public Long tiempoCorrecciones(){
        Long resultado = Integer.toUnsignedLong(0);
        for (Tarea tarea : tareas)
            resultado += tarea.getCorreccion().getTiempo();
        return resultado;
    }
    @Override
    public float lineaCodigoTotalPorHora(){
        Long nanosegundos = this.tiempoTotal();
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
    public Long tiempoAnalisis(){
        return getAnalisis().getTiempo();
    }
    public Long tiempoPrueba(){
        return getPruebas().getTiempo();
    }
}
