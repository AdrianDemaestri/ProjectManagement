/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ValhallaCode
 */
public class Modelo {
     private File archivo;
     private String extencion;
     ArrayList<Proyecto> proyectos;

    public Modelo(String ubicacion){
        proyectos = new ArrayList<>();
        archivo = new File(ubicacion);
        try {
            if(!archivo.exists())
                archivo.createNewFile();
            else
                leer();
        }catch (IOException e) {}
    }

    public void escribir() throws IOException {
        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo));
        escritor.writeObject(proyectos);
    }

    public void escribir(ArrayList<Proyecto> proyectos){
        try {
            archivo.createNewFile();
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(this.archivo));
            for (Proyecto proyecto : proyectos)
                escritor.writeObject(proyecto);
        }catch(IOException e){}
    }

    public void leer(){
        proyectos.clear();
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(this.archivo));
            while (true){
                Proyecto p = (Proyecto)lector.readObject();
                proyectos.add(p);
            }
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {}
    }
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
}


