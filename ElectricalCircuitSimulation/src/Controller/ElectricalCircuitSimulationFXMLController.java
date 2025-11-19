/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Battery;
import Model.CircuitElement;
import Model.Resistor;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author merri
 */
public class ElectricalCircuitSimulationFXMLController implements Initializable {

    @FXML
    private Label helpText;

    
    CircuitElement[] circuit1 = {
        new Battery(0), 
        new Resistor(0, 0, 0),
        new Resistor(0, 0, 0)
    };
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * 
     * @param calcCircuit
     * @return 
     */
    public double calcResistance(CircuitElement[] calcCircuit) {
        if (calcCircuit.length == 2) {
            return calcCircuit[0].getVoltage()/((Resistor) calcCircuit[1]).getResistance(); 
        }
        else {
            CircuitElement[] equivalentCircuit = Arrays.copyOf(calcCircuit, calcCircuit.length - 1);
            ((Resistor)equivalentCircuit[equivalentCircuit.length - 1]).setResistance(
                    ((Resistor)calcCircuit[calcCircuit.length - 1]).getResistance() 
                            + ((Resistor)calcCircuit[calcCircuit.length - 2]).getResistance());
            ((Resistor)calcCircuit[calcCircuit.length - 1]).setCurrent(calcResistance(equivalentCircuit));
        }
        return 0;
    }
    
}
