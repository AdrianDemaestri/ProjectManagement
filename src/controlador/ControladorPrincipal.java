/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        cronometro = new Cronometro();
        iniciar();
    }
    
    public ControladorPrincipal( modelo.Modelo modelo, Cronometro cronometro) {
        this.modelo = modelo;
        this.cronometro = cronometro;
        iniciar();
    }
    
    private void iniciar(){
        if (modelo.getProyectos().size() == 0)
            llamarNuevoProyecto();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jMenuItemNuevaTarea))
            llamarNuevaTarea();
        
        if(e.getSource().equals(ventana.jMenuItemNuevoProyecto))
            llamarNuevoProyecto();
    }
    
    private void llamarNuevaTarea(){
        ControladorNuevaTarea c = new ControladorNuevaTarea(modelo);
        c.setVentana(new vista.DialogNuevaTarea(ventana,c, true));
        c.setVisible(true);
    }
    
    private void llamarNuevoProyecto(){
        ControladorNuevoProyecto c = new ControladorNuevoProyecto(modelo,cronometro);
        c.setVentana(new vista.DialogNuevoProyecto(ventana,c, true));
        c.setVisible(true);
        System.out.println(modelo.getProyectos());
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
        inicializarVista();
    }
    
    void inicializarVista(){
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {modelo.escribir();}
            
        });
        iniciarIconos();
    }
    
    private void iniciarIconos(){
        ventana.jMenuItemImportar.setIcon(new FlatSVGIcon("imagenes/import.svg"));
        ventana.jMenuItemExportar.setIcon(new FlatSVGIcon("imagenes/export.svg"));
    }
  }
