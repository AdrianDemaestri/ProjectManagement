package project.management;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import vista.*;
import controlador.*;
import modelo.*;

import java.time.LocalTime;

/**
 * @author Valhalla Code
 */
public class ProjectManagement{

    private static Modelo modelo;
    private static ControladorPrincipal controladorPrincipal;
    private static VentanaPrincipal ventanaPrincipal;
    
    public static void main(String[] args) {
        FlatDarkFlatIJTheme.setup();

        modelo = new Modelo("resources/data/datos.pymg");

        ventanaPrincipal = new VentanaPrincipal();
        SwingUtilities.invokeLater(() -> {
            controladorPrincipal = new ControladorPrincipal(modelo,ventanaPrincipal);
        });
        
        
    }
    public static void main2(){
        modelo = new Modelo("resources/data/datos.pymg");

        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setControlador(controladorPrincipal);
        
        SwingUtilities.invokeLater(() -> {
            controladorPrincipal = new ControladorPrincipal(modelo,ventanaPrincipal);
        });
    }
}
