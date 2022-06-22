/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cronometro;
import vista.DialogNuevoProyecto;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorNuevoProyecto implements ActionListener{

    vista.DialogNuevoProyecto ventana;
    Cronometro cronometro;

    public ControladorNuevoProyecto(Cronometro cronometro) {
        setCronometro(cronometro);
    }
    
    public void setCronometro(Cronometro cronometro){
        this.cronometro = cronometro;
    }
    

    public void setVentana(DialogNuevoProyecto ventana) {
        this.ventana = ventana;
        ventana.cronoPanel.setControlador(new ControladorCronoPanel(ventana.cronoPanel,cronometro));
    }
    
    public void setVisible(boolean b){ventana.setVisible(b);}
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jButtonSiguiente))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "analisis");
        
        else if (e.getSource().equals(ventana.jButtonAtras))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "nombre");
        else if (e.getSource().equals(ventana.jButtonCrear))
            ventana.dispose();
    }
    
    
    
}
