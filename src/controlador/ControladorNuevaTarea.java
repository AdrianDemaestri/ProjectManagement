/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.DialogNuevaTarea;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorNuevaTarea implements ActionListener {
    
    vista.DialogNuevaTarea ventana;
    

    public void setVentana(DialogNuevaTarea ventana) {
        this.ventana = ventana;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void setVisible(boolean b){ventana.setVisible(b);}
    
    
    

}
