/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Class CircuitSplit to represent a circuitSplit in a circuit
 * @author Merrick 6237800
 */
public class CircuitSplit extends CircuitElement {
    double total;
    
    public CircuitSplit(double voltage, double total) {
        super(voltage);
        this.total = total;
    }
    
    public void copy(CircuitSplit cs) {
        this.setVoltage(cs.getVoltage());
        this.setTotal(cs.getTotal());
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
