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
import vista.VentanaPrincipal;


/**
 *
 * @author Adrian Demaestri
 */
public class ControladorPrincipal implements ActionListener{
    
    private vista.VentanaPrincipal ventana;
    CronoPanel cronoPanel;
    ControladorCronoPanel controladorCronoPanel;
    modelo.Cronometro cronometro;
    modelo.Modelo modelo;

    public ControladorPrincipal( modelo.Modelo modelo) {
        this.modelo = modelo;
        
    }

    public ControladorPrincipal() {}
    
    
    
    
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
        setCronometro(new Cronometro(new MedirTiempo()));
        cronometroPanel();
        ventana.jPanelInfo.add(cronoPanel);
    }
    
    private void cronometroPanel(){
        cronoPanel = new CronoPanel();
        if (controladorCronoPanel == null)
            controladorCronoPanel = new ControladorCronoPanel(cronoPanel,cronometro);
        else
            controladorCronoPanel.setCronoPanel(cronoPanel);
       
        cronoPanel.setControlador(controladorCronoPanel);
    }

    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
        if (controladorCronoPanel == null)
            controladorCronoPanel = new ControladorCronoPanel(cronometro);
        else
            controladorCronoPanel.setCronometro(cronometro);
    }
    
    
    
    private void iniciarIconos(){
        ventana.jMenuItemImportar.setIcon(new FlatSVGIcon("imagenes/import.svg"));
        ventana.jMenuItemExportar.setIcon(new FlatSVGIcon("imagenes/export.svg"));
    }
  }
