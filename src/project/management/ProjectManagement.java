package project.management;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import javax.swing.SwingUtilities;
import vista.VentanaPrincipal;

/**
 * @author Valhalla Code
 */
public class ProjectManagement{
    
    
    public static void main(String[] args) {
        FlatCarbonIJTheme.setup();
        
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
    
    
}
