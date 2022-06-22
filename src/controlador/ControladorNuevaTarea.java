/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.DialogNuevaTarea;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorNuevaTarea implements ActionListener {
    
    vista.DialogNuevaTarea ventana;
    modelo.Modelo model;

    public ControladorNuevaTarea(Modelo modelo) {
        this.model = modelo;
    }
    
    public ControladorNuevaTarea(DialogNuevaTarea ventana, Modelo modelo) {
        this.model = modelo;
        setVentana(ventana);
    }
    
    public void setVentana(DialogNuevaTarea ventana) {
        this.ventana = ventana;
        ventana.jComboBox.removeAll();
        for (modelo.Proyecto proyecto : model.getProyectos())
            ventana.jComboBox.addItem(proyecto.getNombre());
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jButtonSiguiente))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "tarea padre");
        
        else if(e.getSource().equals(ventana.jButtonAtras))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "nombre");
    }
    
    
    public void setVisible(boolean b){ventana.setVisible(b);}
    
    
    

}
