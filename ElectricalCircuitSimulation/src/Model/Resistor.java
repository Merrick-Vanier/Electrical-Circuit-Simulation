/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author CoolHandLuke
 */
public class Resistor {
    private double resistance;
    private double current;
    
    public Resistor(double resistance, double current) {
        this.resistance = resistance;
        this.current = current;
    }
    public void setResistance(double res) {
        this.resistance = res;
    }
    public void setCurrent(double cur) {
        this.current = cur;
    }
    public double getResistance() {
        return resistance;
    }
    public double getCurrent() {
        return current;
    }
}
