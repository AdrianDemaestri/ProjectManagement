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
import modelo.Informe;
import modelo.MedirTiempo;
import modelo.Proyecto;
import vista.CronoPanel;
import vista.VentanaPrincipal;

/**
 * @author Valhalla Code
 */
public class ControladorPrincipal implements ActionListener{
    
    public ControladorTree controladorTree;
    public vista.VentanaPrincipal ventana;
    public modelo.Modelo model;
    public modelo.Cronometro cronometro;
    public Informe informeActivo;
    private ControladorCronoPanel controladorCronoPanel;
    private ControladorJFXPanel controladorJFXPanel;
    private ControladorNuevoProyecto controladorNuevoProyecto;
    private ControladorNuevaTarea controladorNuevaTarea;

    public ControladorPrincipal( modelo.Modelo modelo, VentanaPrincipal ventanaPrincipal) {
        model = modelo;
        setVentana(ventanaPrincipal);
        cronometro = new Cronometro();
        iniciar();
    }
    
    private void iniciar(){
        controladorNuevaTarea = new ControladorNuevaTarea(this);
        controladorNuevoProyecto = new ControladorNuevoProyecto(this);
        if (model.getProyectos().size() == 0)
            controladorNuevoProyecto.llamar();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.jMenuItemNuevaTarea)){
            System.out.println(((Proyecto)informeActivo).getTareas());
            controladorNuevaTarea.llamar();
            System.out.println(((Proyecto)informeActivo).getTareas());
        }

        if(e.getSource().equals(ventana.jMenuItemNuevoProyecto))
            controladorNuevoProyecto.llamar();
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
        ventana.setControlador(this);

        inicializarVista();
        controladorTree = new ControladorTree(this);
        controladorJFXPanel = new ControladorJFXPanel(this);
        ventana.setVisible(true);
    }
    
    void inicializarVista(){
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {model.escribir();}
        });
        iniciarIconos();
    }
    
    private void iniciarIconos(){
        ventana.jMenuItemImportar.setIcon(new FlatSVGIcon("imagenes/import.svg"));
        ventana.jMenuItemExportar.setIcon(new FlatSVGIcon("imagenes/export.svg"));
    }
  }
