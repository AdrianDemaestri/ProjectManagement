/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cronometro;
import modelo.EtapaProyecto;
import modelo.Proyecto;
import vista.DialogNuevoProyecto;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorNuevoProyecto implements ActionListener{

    vista.DialogNuevoProyecto ventana;
    ControladorPrincipal  controladorPrincipal;
    

    public ControladorNuevoProyecto(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }
    public void setVentana(DialogNuevoProyecto ventana) {
        this.ventana = ventana;
        ventana.cronoPanel.setControlador(new ControladorCronoPanel(ventana.cronoPanel,controladorPrincipal.cronometro,new EtapaProyecto()));
    }
    
    public void setVisible(boolean b){ventana.setVisible(b);}

    public void llamar(){
        setVentana(new vista.DialogNuevoProyecto(controladorPrincipal.ventana,this, true));
        setVisible(true);
    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jButtonSiguiente))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "analisis");
        
        else if (e.getSource().equals(ventana.jButtonAtras))
            ((CardLayout)ventana.jPanelContenedor.getLayout()).show(ventana.jPanelContenedor, "nombre");
        
        else if (e.getSource().equals(ventana.jButtonCrear)){
            controladorPrincipal.cronometro.stop();
            controladorPrincipal.model.getProyectos().add(new Proyecto(ventana.jTextFieldNombre.getText(),(EtapaProyecto)controladorPrincipal.cronometro.getObjeto()));
            controladorPrincipal.controladorTree.actualizarTree();
            ventana.dispose();
        }
            
    }
    
    
    
}
