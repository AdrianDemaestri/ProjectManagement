/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import modelo.Informe;

/**
 *
 * @author Adrian Demaestri
 */
public class ControladorJFXPanel {
    Informe info;
    ControladorPrincipal controladorPrincipal;
    JFXPanel panel;

    public ControladorJFXPanel(ControladorPrincipal controller) {
        controladorPrincipal = controller;
        panel = new JFXPanel();
        controladorPrincipal.ventana.jSplitPaneInfo.setRightComponent(panel);
        Platform.runLater(this::initFX);
    }
    
    private void initFX(){
        
        panel.setOpaque(true);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color:transparent;");
        Scene scene = new Scene(root); //new Group()
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("1", 10),
                new PieChart.Data("2", 10),
                new PieChart.Data("3", 10),
                new PieChart.Data("4", 10),
                new PieChart.Data("5", 10)
        //                new PieChart.Data("6", 10),
        //                new PieChart.Data("7", 10),
        //                new PieChart.Data("8", 10),
        //                new PieChart.Data("9", 10),
        //                new PieChart.Data("10", 10)
            );
        final PieChart chart = new PieChart(pieChartData);
        //chart.setTitle("Prueba Proyencto");
        chart.setLegendSide(Side.RIGHT);
        root.setCenter(chart);
        //((Group) scene.getRoot()).getChildren().add(chart);

        try{    
            scene.getStylesheets().add("css/pieChart.css");
        }
        catch (Exception ex){System.err.println("Cannot acquire stylesheet: " + ex.toString());}
        
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        panel.setScene(scene);
    }
}
