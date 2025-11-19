/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author merri
 */
public class Battery {
    private double voltage;
    
    public Battery(double voltage) {
        this.voltage = voltage;
    }
    public void setVoltage(double volt) {
       this.voltage = volt;
    }
    public double getVoltage() {
        return voltage;
    }
}
