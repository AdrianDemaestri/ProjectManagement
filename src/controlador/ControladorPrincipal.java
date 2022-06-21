/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CronoPanel;
import vista.VentanaPrincipal;


/**
 *
 * @author Adrian Demaestri
 */
public class ControladorPrincipal implements ActionListener{
    
    private vista.VentanaPrincipal ventana;
    CronoPanel cronoPanel;
    ControladorCronoPanel controladorCronoPanel;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jMenuItemNuevaTarea))
            new vista.DialogNuevaTarea(ventana, true).setVisible(true);
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
        inicializarVista();
    }
    
    void inicializarVista(){
        iniciarIconos();
        cronometro();
        ventana.jPanelInfo.add(cronoPanel);
        
        
    }
    
    private void cronometro(){
         cronoPanel = new CronoPanel();
         controladorCronoPanel = new ControladorCronoPanel();
        
        
        cronoPanel.setControlador(controladorCronoPanel);
        controladorCronoPanel.setCronoPanel(cronoPanel);
    }
    
    private void iniciarIconos(){
        ventana.jMenuItemImportar.setIcon(new FlatSVGIcon("imagenes/import.svg"));
        ventana.jMenuItemExportar.setIcon(new FlatSVGIcon("imagenes/export.svg"));
    }
  }
