/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import vista.CronoPanel;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorCronoPanel {
    vista.CronoPanel cronoPanel;
    FlatSVGIcon play;
    FlatSVGIcon pause;

    public ControladorCronoPanel() {
        play = new FlatSVGIcon("imagenes/threadRunning.svg",24,24);
    }
    
    public void setCronoPanel(CronoPanel cronoPanel) {
        this.cronoPanel = cronoPanel;
        instanciarIconos();
        
    }
    
    private void instanciarIconos(){
        cronoPanel.jLabel2.setIcon(play);
    }
    
    
    
}
