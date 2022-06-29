/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Proyecto;

import jdk.swing.interop.SwingInterOpUtils;
import modelo.Modelo;
import modelo.Tarea;
import vista.DialogNuevaTarea;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorNuevaTarea implements ActionListener {
    
    vista.DialogNuevaTarea ventana;
    ControladorPrincipal controladorPrincipal;
    Proyecto proyectoActivo;

    public ControladorNuevaTarea(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }
    
    public void setVentana(DialogNuevaTarea ventana) {
        this.ventana = ventana;
        ventana.jComboBox.removeAll();
        setProyectoActivo();
        for (Tarea tarea : proyectoActivo.getTareas() )
            ventana.jComboBox.addItem(tarea.getNombre());
    }

    private void setProyectoActivo(){
        if(controladorPrincipal.informeActivo instanceof Proyecto)
            proyectoActivo = (Proyecto) controladorPrincipal.informeActivo;
        else{
            for (Proyecto proyecto : controladorPrincipal.model.getProyectos())
                if (proyecto.contiene((Tarea) controladorPrincipal.informeActivo))
                    proyectoActivo = proyecto;
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jButtonSiguiente))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "tarea padre");
        
        else if(e.getSource().equals(ventana.jButtonAtras))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "nombre");

        else if (e.getSource().equals(ventana.jButtonCrear))
            crear();
    }

    public void llamar(){
        setVentana(new vista.DialogNuevaTarea(controladorPrincipal.ventana,this, true));
        ventana.setVisible(true);
    }

    private void crear(){
        Tarea tarea =new Tarea(ventana.jTextNombre.getText(),ventana.jTextDescripcion.getText());
        if(ventana.jCheckBox.isSelected())
            tarea.setTareaPadre((String) ventana.jComboBox.getSelectedItem());
    }





    
    
    

}
