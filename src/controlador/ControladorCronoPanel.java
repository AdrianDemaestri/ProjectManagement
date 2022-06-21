/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.CronoPanel;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorCronoPanel implements ActionListener{
    vista.CronoPanel cronoPanel;
    FlatSVGIcon play;
    FlatSVGIcon pause;

    public ControladorCronoPanel() {
        play = new FlatSVGIcon("imagenes/threadRunning.svg",20,20);
        pause = new FlatSVGIcon("imagenes/pause.svg",20,20);
    }
    
    public void setCronoPanel(CronoPanel cronoPanel) {
        this.cronoPanel = cronoPanel;
        instanciarIconos();
        
    }
    
    private void instanciarIconos(){
        cronoPanel.jButton.setIcon(play);
        cronoPanel.jButton.setContentAreaFilled(false);
    }
    
    private void cambiarIcono(){
        if(cronoPanel.jButton.getIcon().equals(play))
            cronoPanel.jButton.setIcon(pause);
        else
            cronoPanel.jButton.setIcon(play);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cronoPanel.jButton)){
            cambiarIcono();
        }
        else if(e.getSource().equals(cronoPanel.jCheckBox)){
            if (cronoPanel.jCheckBox.isSelected()){
                cronoPanel.jLabel.setEnabled(false);
                cronoPanel.jButton.setEnabled(true);
                cronoPanel.jTextField1.setEnabled(false);
            }
            else{
                cronoPanel.jLabel.setEnabled(true);
                cronoPanel.jButton.setEnabled(false);
                cronoPanel.jTextField1.setEnabled(true);
            }
        }
            
    }
    
    
    
    
    
    
    
}
