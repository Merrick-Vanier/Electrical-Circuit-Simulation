/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Class Capacitor to represent a capacitor in a circuit
 * @author Merrick 6237800
 */
public class Capacitor extends CircuitElement {
   private double capacitance;
   private double charge;
   
   public Capacitor(double capacitance, double charge, double voltage) {
       super(voltage);
       this.capacitance = capacitance;
       this.charge = charge;
   }
   public void setCharge(double chrg) {
       this.charge = chrg;
       
   }
   public void setCapacitance(double cap) {
       this.capacitance = cap;
       
   }
   public double getCharge() {
       return charge;
   }
   public double getCapacitance() {
       return capacitance;
   }

    
}
