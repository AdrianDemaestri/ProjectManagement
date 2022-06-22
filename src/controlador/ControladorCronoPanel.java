/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cronometro;
import modelo.MedirTiempo;
import vista.CronoPanel;

/**
 *
 * @author Adrian Demaestri
 */
public final class ControladorCronoPanel implements ActionListener{
    vista.CronoPanel cronoPanel;
    FlatSVGIcon play  = new FlatSVGIcon("imagenes/threadRunning.svg",20,20);;
    FlatSVGIcon pause = new FlatSVGIcon("imagenes/pause.svg",20,20);
    modelo.Cronometro cronometro;
    boolean iniciado = false;
    

    public ControladorCronoPanel() {
        initConponents();
    }

    public ControladorCronoPanel(CronoPanel cronoPanel) {
        setCronoPanel(cronoPanel);
        initConponents();
    }

    public ControladorCronoPanel(CronoPanel cronoPanel, Cronometro cronometro) {
        setCronoPanel(cronoPanel);
        setCronometro(cronometro);
        initConponents();
    }

    public ControladorCronoPanel(Cronometro cronometro) {
        setCronometro(cronometro);
        initConponents();
    }
    
    
    
    
    private void initConponents(){}
    
    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
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
            if (cronometro != null) {
                if (cronoPanel.jButton.getIcon().equals(pause)) {
                    if (!iniciado){
                        System.out.println("iniciar");
                        cronometro.iniciar(new MedirTiempo(), cronoPanel.jTextField1);
                        iniciado = true;
                        
                    }
                    else{
                        System.out.println("play");
                        cronometro.play();
                    }
                        
                }
                else{
                    System.out.println("display");
                    cronometro.display();
                }
                    
            }
            else
                System.out.println("nulo");
            
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
