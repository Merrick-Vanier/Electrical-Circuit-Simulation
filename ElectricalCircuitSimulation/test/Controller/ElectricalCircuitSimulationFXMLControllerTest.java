/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import Model.Battery;
import Model.Capacitor;
import Model.CircuitElement;
import Model.CircuitSplit;
import Model.Resistor;
import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for calcResistance and calcCapacitance methods in ElectricalCircuitSimulationFXMLController
 * @author Merrick 6237800
 */
public class ElectricalCircuitSimulationFXMLControllerTest {
    
    public ElectricalCircuitSimulationFXMLControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testing of calcResistance method with only resistors
     */
    @Test
     public void testCalcResistance1() {
        System.out.println("Test1");
        CircuitElement[] calcCircuit = {
            new Battery(15),
            new Resistor(10, 0, 0),
            new Resistor(10, 0, 0),
            new Resistor(10, 0, 0)
        };
        double expResult = 0.5;
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(expResult, ((Resistor)calcCircuit[1]).getCurrent(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[2]).getCurrent(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[3]).getCurrent(), 0);
        assertEquals(5, ((Resistor)calcCircuit[1]).getVoltage(), 0);
        assertEquals(5, ((Resistor)calcCircuit[2]).getVoltage(), 0);
        assertEquals(5, ((Resistor)calcCircuit[3]).getVoltage(), 0);
     }
     
    /**
     * Testing of calcResistance method with a resistor and a circuit split
     */
    @Test
     public void testCalcResistance2() {
        System.out.println("Test2");
        CircuitElement[] calcCircuit = {
            new Battery(15),
            new Resistor(10, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(10, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(5, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(1.12, ((Resistor)calcCircuit[1]).getCurrent(), 0.01);
        assertEquals(10, ((Resistor)calcCircuit[1]).getResistance(), 0.01);
        assertEquals(11.25, ((Resistor)calcCircuit[1]).getVoltage(), 0.01);
        assertEquals(0.37, ((Resistor)calcCircuit[3]).getCurrent(), 0.01);
        assertEquals(10, ((Resistor)calcCircuit[3]).getResistance(), 0.01);
        assertEquals(3.75, ((Resistor)calcCircuit[3]).getVoltage(), 0.01);
        assertEquals(0.75, ((Resistor)calcCircuit[5]).getCurrent(), 0.01);
        assertEquals(5, ((Resistor)calcCircuit[5]).getResistance(), 0.01);
        assertEquals(3.75, ((Resistor)calcCircuit[5]).getVoltage(), 0.01);
        
    }
    /**
     * Testing of calcResistance method with a resistor and a circuit split followed by the same pattern
     */
    @Test
     public void testCalcResistance3() {
        System.out.println("Test3");
        CircuitElement[] calcCircuit = {
            new Battery(15),
            new Resistor(10, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(10, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(5, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(30, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(15, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(22, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(0.29, ((Resistor)calcCircuit[1]).getCurrent(), 0.01);
        assertEquals(10, ((Resistor)calcCircuit[1]).getResistance(), 0.01);
        assertEquals(2.87, ((Resistor)calcCircuit[1]).getVoltage(), 0.01);
        assertEquals(0.1, ((Resistor)calcCircuit[3]).getCurrent(), 0.01);
        assertEquals(10, ((Resistor)calcCircuit[3]).getResistance(), 0.01);
        assertEquals(0.96, ((Resistor)calcCircuit[3]).getVoltage(), 0.01);
        assertEquals(0.19, ((Resistor)calcCircuit[5]).getCurrent(), 0.01);
        assertEquals(5, ((Resistor)calcCircuit[5]).getResistance(), 0.01);
        assertEquals(0.96, ((Resistor)calcCircuit[5]).getVoltage(), 0.01);
        assertEquals(0.29, ((Resistor)calcCircuit[7]).getCurrent(), 0.01);
        assertEquals(30, ((Resistor)calcCircuit[7]).getResistance(), 0.01);
        assertEquals(8.61, ((Resistor)calcCircuit[7]).getVoltage(), 0.01);
        assertEquals(0.17, ((Resistor)calcCircuit[9]).getCurrent(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[9]).getResistance(), 0.01);
        assertEquals(2.56, ((Resistor)calcCircuit[9]).getVoltage(), 0.01);
        assertEquals(0.12, ((Resistor)calcCircuit[11]).getCurrent(), 0.01);
        assertEquals(22, ((Resistor)calcCircuit[11]).getResistance(), 0.01);
        assertEquals(2.56, ((Resistor)calcCircuit[11]).getVoltage(), 0.01);
        
    }
     
    /**
     * Testing of calcResistance method with a circuit split
     */
    @Test
     public void testCalcResistance4() {
        System.out.println("Test4");
        CircuitElement[] calcCircuit = {
            new Battery(30),
            new CircuitSplit(0, 0),
            new Resistor(12, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(8, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(2.50, ((Resistor)calcCircuit[2]).getCurrent(), 0.01);
        assertEquals(12, ((Resistor)calcCircuit[2]).getResistance(), 0.01);
        assertEquals(30, ((Resistor)calcCircuit[2]).getVoltage(), 0.01);
        assertEquals(3.75, ((Resistor)calcCircuit[4]).getCurrent(), 0.01);
        assertEquals(8, ((Resistor)calcCircuit[4]).getResistance(), 0.01);
        assertEquals(30, ((Resistor)calcCircuit[4]).getVoltage(), 0.01);
        
    }
     
    /**
     * Testing of calcResistance method with a circuit split followed by a circuit split
     */
    @Test
     public void testCalcResistance5() {
        System.out.println("Test5");
        CircuitElement[] calcCircuit = {
            new Battery(30),
            new CircuitSplit(0, 0),
            new Resistor(12, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(8, 0, 0),
            new CircuitSplit(0, 0),
            new CircuitSplit(0, 0),
            new Resistor(12, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(8, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(1.25, ((Resistor)calcCircuit[2]).getCurrent(), 0.01);
        assertEquals(12, ((Resistor)calcCircuit[2]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[2]).getVoltage(), 0.01);
        assertEquals(1.87, ((Resistor)calcCircuit[4]).getCurrent(), 0.01);
        assertEquals(8, ((Resistor)calcCircuit[4]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[4]).getVoltage(), 0.01);
        assertEquals(1.25, ((Resistor)calcCircuit[7]).getCurrent(), 0.01);
        assertEquals(12, ((Resistor)calcCircuit[7]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[7]).getVoltage(), 0.01);
        assertEquals(1.87, ((Resistor)calcCircuit[9]).getCurrent(), 0.01);
        assertEquals(8, ((Resistor)calcCircuit[9]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[9]).getVoltage(), 0.01);
        
    }
    
     /**
     * Testing of calcResistance method with a circuit split with splits that have multiple resistors
     */
    @Test
     public void testCalcResistance6() {
        System.out.println("Test6");
        CircuitElement[] calcCircuit = {
            new Battery(30),
            new CircuitSplit(0, 0),
            new Resistor(8, 0, 0),
            new Resistor(4, 0, 0),
            new CircuitSplit(0, 0),
            new Resistor(4, 0, 0),
            new Resistor(4, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(2.50, ((Resistor)calcCircuit[2]).getCurrent(), 0.01);
        assertEquals(8, ((Resistor)calcCircuit[2]).getResistance(), 0.01);
        assertEquals(20, ((Resistor)calcCircuit[2]).getVoltage(), 0.01);
        assertEquals(2.50, ((Resistor)calcCircuit[3]).getCurrent(), 0.01);
        assertEquals(4, ((Resistor)calcCircuit[3]).getResistance(), 0.01);
        assertEquals(10, ((Resistor)calcCircuit[3]).getVoltage(), 0.01);
        assertEquals(3.75, ((Resistor)calcCircuit[5]).getCurrent(), 0.01);
        assertEquals(4, ((Resistor)calcCircuit[5]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[5]).getVoltage(), 0.01);
        assertEquals(3.75, ((Resistor)calcCircuit[6]).getCurrent(), 0.01);
        assertEquals(4, ((Resistor)calcCircuit[6]).getResistance(), 0.01);
        assertEquals(15, ((Resistor)calcCircuit[6]).getVoltage(), 0.01);
        
    }
     
     /**
     * Testing of calcCapacitance method with a circuit split
     */
    @Test
     public void testCalcCapacitance1() {
        System.out.println("Test1");
        CircuitElement[] calcCircuit = {
            new Battery(30),
            new CircuitSplit(0, 0),
            new Capacitor(12, 0, 0),
            new CircuitSplit(0, 0),
            new Capacitor(8, 0, 0),
            new CircuitSplit(0, 0)
        };
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcCapacitance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        assertEquals(360, ((Capacitor)calcCircuit[2]).getCharge(), 1);
        assertEquals(12, ((Capacitor)calcCircuit[2]).getCapacitance(), 1);
        assertEquals(30, ((Capacitor)calcCircuit[2]).getVoltage(), 1);
        assertEquals(240, ((Capacitor)calcCircuit[4]).getCharge(), 1);
        assertEquals(8, ((Capacitor)calcCircuit[4]).getCapacitance(), 1);
        assertEquals(30, ((Capacitor)calcCircuit[4]).getVoltage(), 1);
        
    }
}
