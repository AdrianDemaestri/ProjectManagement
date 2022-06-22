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
    ControladorCronoPanel controladorCronoPanel;
    modelo.Cronometro cronometro;
    modelo.Modelo modelo;

    public ControladorPrincipal( modelo.Modelo modelo) {
        this.modelo = modelo;
        cronometro = new Cronometro(new MedirTiempo());
    }

    public ControladorPrincipal() {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jMenuItemNuevaTarea))
            llamarNuevaTarea();
        
        if(e.getSource().equals(ventana.jMenuItemNuevoProyecto))
            llamarNuevoProyecto();
        
    }
    
    private void llamarNuevaTarea(){
        ControladorNuevaTarea c = new ControladorNuevaTarea();
        c.setVentana(new vista.DialogNuevaTarea(ventana,c, true));
        c.setVisible(true);
    }
    
    private void llamarNuevoProyecto(){
        ControladorNuevoProyecto c = new ControladorNuevoProyecto(cronometro);
        c.setVentana(new vista.DialogNuevoProyecto(ventana,c, true));
        c.setVisible(true);
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
        inicializarVista();
    }
    
    void inicializarVista(){
        iniciarIconos();
    }
    
    private void iniciarIconos(){
        ventana.jMenuItemImportar.setIcon(new FlatSVGIcon("imagenes/import.svg"));
        ventana.jMenuItemExportar.setIcon(new FlatSVGIcon("imagenes/export.svg"));
    }
  }
