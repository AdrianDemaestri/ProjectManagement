/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ValhallaCode
 */
public class Proyecto implements Serializable {
    private String nombre;
    private EtapaProyecto analisis;
    private EtapaProyecto pruebas;
    ArrayList<Tarea> tareas;

    // Metodos getter y setter 


    public Proyecto() {
        this.tareas = new ArrayList();
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


    // Hcaer metodos para calcular el tiempo total de todas las tareas
    // Hacer metodo para calcular la cantidad de lineas totales de todas las tareas

    // Metodo para calcular el tiempo

    public Long tiempoTotal(){
        Long acum = Integer.toUnsignedLong(0);
        for (Tarea tarea : tareas)
            acum += tarea.tiempo();
        acum += pruebas.getTiempo();
        acum += analisis.getTiempo();
        return acum;
    }
    public Long tiempoDesarrollo(){
        Long resultado = Integer.toUnsignedLong(0);
        for (Tarea tarea : tareas)
            resultado += tarea.getDesarrollo().getTiempo();
        return resultado;
    }
    public int lineasCodigo(ArrayList<Tarea> tareas){
        int acum=0;
        for(Tarea tarea : tareas)
            acum += tarea.lineasCodigo();
        return acum;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + '\n';
    }
}
