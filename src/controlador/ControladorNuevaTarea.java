/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Proyecto;
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
    public void llamar(){
        setVentana(new vista.DialogNuevaTarea(controladorPrincipal.ventana,this, true));
        ventana.setVisible(true);
    }
    
    public void setVentana(DialogNuevaTarea ventana) {
        this.ventana = ventana;
        ventana.jComboBox.removeAllItems();
        setProyectoActivo();
        configurarComboBox();
    }

    //saber que proyecto esta en seleccion
    private void setProyectoActivo(){
        if(controladorPrincipal.informeActivo instanceof Proyecto)
            proyectoActivo = (Proyecto) controladorPrincipal.informeActivo;
        else{
            for (Proyecto proyecto : controladorPrincipal.model.getProyectos())
                if (proyecto.contiene((Tarea) controladorPrincipal.informeActivo))
                    proyectoActivo = proyecto;
        }
    }

    private void configurarComboBox(){
        for (Tarea tarea : proyectoActivo.getTareas() )
            ventana.jComboBox.addItem(tarea.getNombre());

        ventana.jCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ventana.jCheckBox.isSelected())
                    ventana.jComboBox.setEnabled(true);
                else
                    ventana.jComboBox.setEnabled(false);
            }
        });

        if(controladorPrincipal.informeActivo instanceof Proyecto)
            ventana.jCheckBox.setEnabled(true);
        else {
            ventana.jCheckBox.setEnabled(true);
            ventana.jComboBox.setSelectedItem(((Tarea)controladorPrincipal.informeActivo).getNombre());
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



    private void crear(){
        Tarea tarea = new Tarea(ventana.jTextNombre.getText(),ventana.jTextDescripcion.getText());
        System.out.println("tarea creada " + tarea);
        System.out.println("proyecto activo " + proyectoActivo);

        proyectoActivo.addTarea(tarea);
        

        System.out.println("tareas: " + proyectoActivo.getTareas());
        if(ventana.jCheckBox.isSelected()){
            tarea.setTareaPadre(proyectoActivo.buscarTarea((String) ventana.jComboBox.getSelectedItem()));
            tarea.tareaPadre.subTareas.add(tarea);
        }
        controladorPrincipal.controladorTree.actualizarTree();
        ventana.dispose();
    }
}
