/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import Model.Battery;
import Model.CircuitElement;
import Model.*;
import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author merri
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
     * Test of calcResistance method, of class ElectricalCircuitSimulationFXMLController.
     */
    @Test
     public void testCalcResistance1() {
        System.out.println("calcResistance");
        CircuitElement[] calcCircuit = {
            new Battery(15),
            new Resistor(10, 0, 0),
            new Resistor(10, 0, 0),
            new Resistor(10, 0, 0)
        };
        double expResult = 0.5;
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        assertEquals(expResult, ((Resistor)calcCircuit[1]).getCurrent(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[2]).getCurrent(), 0);
        assertEquals(10, ((Resistor)calcCircuit[1]).getResistance(), 0);
        assertEquals(10, ((Resistor)calcCircuit[2]).getResistance(), 0);
        assertEquals(10, ((Resistor)calcCircuit[3]).getResistance(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[3]).getCurrent(), 0);
    }
    /**
     * Test of initialize method, of class ElectricalCircuitSimulationFXMLController.
     */
    @Test
     public void testCalcResistance2() {
        System.out.println("calcResistance");
        CircuitElement[] calcCircuit = {
            new Battery(15),
            new Resistor(10, 0, 0),
            new CircuitSplit(0),
            new Resistor(10, 0, 0),
            new CircuitSplit(0)
        };
        double expResult = 0.5;
        ElectricalCircuitSimulationFXMLController instance = new ElectricalCircuitSimulationFXMLController();
        instance.calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        assertEquals(expResult, ((Resistor)calcCircuit[1]).getCurrent(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[2]).getCurrent(), 0);
        assertEquals(10, ((Resistor)calcCircuit[1]).getResistance(), 0);
        assertEquals(10, ((Resistor)calcCircuit[2]).getResistance(), 0);
        assertEquals(10, ((Resistor)calcCircuit[3]).getResistance(), 0);
        assertEquals(expResult, ((Resistor)calcCircuit[3]).getCurrent(), 0);
    }
    
    
    
}
