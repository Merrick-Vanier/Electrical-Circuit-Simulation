/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electricalcircuitsimulation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 6237800
 */
public class ElectricalCircuitSimulation extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ElectricalcircuitSimulationFXML.fxml"));
            Scene s = new Scene(root);
            primaryStage.setScene(s);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ElectricalCircuitSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
