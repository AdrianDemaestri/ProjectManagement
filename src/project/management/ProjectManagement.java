package project.management;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import javax.swing.SwingUtilities;
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
        FlatCarbonIJTheme.setup();
        main2();
        
        
    }
    public static void main2(){
        modelo = new Modelo("resources/data/datos.pymg");
        controladorPrincipal = new ControladorPrincipal(modelo);
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setControlador(controladorPrincipal);
        controladorPrincipal.setVentana(ventanaPrincipal);
        SwingUtilities.invokeLater(() -> {
            ventanaPrincipal.setVisible(true);
        });
    }
    public static void prueba(){
        LocalTime tiempo = LocalTime.of(2,43,01);
        int segundos = 9781;
        System.out.println(Tiempo.pasarSegundosATime(segundos));
    }
}
