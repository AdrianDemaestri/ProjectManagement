/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;
import java.util.ArrayList;
import modelo.Proyecto;

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
            else{
                leer();
            }
                
        }catch (IOException e) {}
    }

    public void escribir(){
        try {
            archivo.createNewFile();
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(this.archivo));
            for (Proyecto proyecto : proyectos)
                escritor.writeObject(proyecto);
        }catch(IOException e){}
        
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
                System.out.println(proyectos);
                
                
                System.out.println("aca");
                proyectos.add((modelo.Proyecto)lector.readObject());
            }
        } catch (IOException e) { System.out.println("a");
        } catch (ClassNotFoundException e) {System.out.println("b");}
    }
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
}


