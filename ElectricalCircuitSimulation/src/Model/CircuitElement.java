/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Class CircuitElement to represent a circuit element within a circuit
 * @author Merrick 6237800
 */
public abstract class CircuitElement {
    private double voltage;
    
    public CircuitElement(double voltage) {
        this.voltage = voltage;
    }
    public void setVoltage(double volt) {
       this.voltage = volt;
    }
    public double getVoltage() {
        return voltage;
    }
}
