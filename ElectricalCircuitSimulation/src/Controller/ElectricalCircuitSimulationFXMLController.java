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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
    @FXML
    private Slider b1_slider;
    @FXML
    private TextField b1_tf;
    @FXML
    private Slider rs_R1_slider;
    @FXML
    private TextField rs_R1_tf;
    @FXML
    private Label rs_R1_V;
    @FXML
    private Label rs_R1_C;
    @FXML
    private Slider rs_R2_slider;
    @FXML
    private TextField rs_R2_tf;
    @FXML
    private Label rs_R2_V;
    @FXML
    private Label rs_R2_C;
    @FXML
    private Label rs_TotalCurrent;
    @FXML
    private Label rs_EquivResistance;
    @FXML
    private Button rs_calcBtn;
    @FXML
    private Button rs_clearBtn;
    @FXML
    private Slider b2_slider;
    @FXML
    private TextField b2_tf;
    @FXML
    private Slider rp_R1_slider;
    @FXML
    private TextField rp_R1_tf;
    @FXML
    private Label rp_R1_V;
    @FXML
    private Label rp_R1_C;
    @FXML
    private Slider rp_R2_slider;
    @FXML
    private TextField rp_R2_tf;
    @FXML
    private Label rp_R2_V;
    @FXML
    private Label rp_R2_C;
    @FXML
    private Label rp_TotalCurrent;
    @FXML
    private Label rp_EquivResistance;
    @FXML
    private Button rp_calcBtn;
    @FXML
    private Button rp_clearBtn;
    @FXML
    private Slider b3_slider;
    @FXML
    private TextField b3_tf;
    @FXML
    private Slider cs_C1_slider;
    @FXML
    private TextField cs_C1_tf;
    @FXML
    private Label cs_C1_V;
    @FXML
    private Label cs_C1_C;
    @FXML
    private Slider cs_C2_slider;
    @FXML
    private TextField cs_C2_tf;
    @FXML
    private Label cs_C2_V;
    @FXML
    private Label cs_C2_C;
    @FXML
    private Label cs_TotalCharge;
    @FXML
    private Label cs_EquivCapacitance;
    @FXML
    private Button cs_calcBtn;
    @FXML
    private Button cs_clearBtn;
    @FXML
    private Slider b4_slider;
    @FXML
    private TextField b4_tf;
    @FXML
    private Slider cp_C1_slider;
    @FXML
    private TextField cp_C1_tf;
    @FXML
    private Label cp_C1_V;
    @FXML
    private Label cp_C1_C;
    @FXML
    private Slider cp_C2_slider;
    @FXML
    private TextField cp_C2_tf;
    @FXML
    private Label cp_C2_V;
    @FXML
    private Label cp_C2_C;
    @FXML
    private Label cp_TotalCharge;
    @FXML
    private Label cp_EquivCapacitance;
    @FXML
    private Button cp_calcBtn;
    @FXML
    private Button cp_clearBtn;
    @FXML
    private Slider b5_slider;
    @FXML
    private TextField b5_tf;
    @FXML
    private ComboBox<?> rc_comboBox;
    @FXML
    private Button rc_addBtn;
    @FXML
    private Label rc_TotalCurrent;
    @FXML
    private Label rc_EquivResistance;
    @FXML
    private Button rc_calcBtn;
    @FXML
    private Button rc_clearBtn;
    @FXML
    private Slider b6_slider;
    @FXML
    private TextField b6_tf;
    @FXML
    private ComboBox<?> cc_comboBox;
    @FXML
    private Button cc_addBtn;
    @FXML
    private Label cc_TotalCharge;
    @FXML
    private Label cc_EquivCapacitance;
    @FXML
    private Button cc_calcBtn;
    @FXML
    private Button cc_clearBtn;
    @FXML
    private VBox resistorVbox;
    @FXML
    private VBox rcSidebarVbox;
    private int counter;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        counter = 0;
        
        bindSliderToTextField(b1_slider, b1_tf);
        bindSliderToTextField(rs_R1_slider, rs_R1_tf);
        bindSliderToTextField(rs_R2_slider, rs_R2_tf);

        bindSliderToTextField(b2_slider, b2_tf);
        bindSliderToTextField(rp_R1_slider, rp_R1_tf);
        bindSliderToTextField(rp_R2_slider, rp_R2_tf);

        bindSliderToTextField(b3_slider, b3_tf);
        bindSliderToTextField(cs_C1_slider, cs_C1_tf);
        bindSliderToTextField(cs_C2_slider, cs_C2_tf);

        bindSliderToTextField(b4_slider, b4_tf);
        bindSliderToTextField(cp_C1_slider, cp_C1_tf);
        bindSliderToTextField(cp_C2_slider, cp_C2_tf);
        
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

    

    


    @FXML
    private void rsClearBtnPressed(ActionEvent event) {
        b1_slider.setValue(20);
        b1_tf.setText(null);
        rs_R1_slider.setValue(20);
        rs_R1_tf.setText(null);
        rs_R2_slider.setValue(20);
        rs_R2_tf.setText(null);
    }


    

    


    @FXML
    private void rpClearBtnPressed(ActionEvent event) {
        b2_slider.setValue(20);
        b2_tf.setText(null);
        rp_R1_slider.setValue(20);
        rp_R1_tf.setText(null);
        rp_R2_slider.setValue(20);
        rp_R2_tf.setText(null);
    }

    @FXML
    private void rsCalcBtnPreesed(ActionEvent event) {
    }

    @FXML
    private void rpCalcBtnPressed(ActionEvent event) {
    }
    
    @FXML
    private void cpCalcBtnPressed(ActionEvent event) {
    }
    
    @FXML
    private void csCalcBtnPressed(ActionEvent event) {
    }
    
    




    @FXML
    private void csClearBtnPressed(ActionEvent event) {
        b3_slider.setValue(20);
        b3_tf.setText(null);
        cs_C1_slider.setValue(20);
        cs_C1_tf.setText(null);
        cs_C2_slider.setValue(20);
        cs_C2_tf.setText(null);
    }

   

    


    @FXML
    private void cpClearBtnPressed(ActionEvent event) {
        b4_slider.setValue(20);
        b4_tf.setText(null);
        cp_C1_slider.setValue(20);
        cp_C1_tf.setText(null);
        cp_C2_slider.setValue(20);
        cp_C2_tf.setText(null);
    }

    @FXML
    private void rcAddBtnPressed(ActionEvent event) {
        
        VBox testvb = resistorVbox;
        testvb.setVisible(true);
        rcSidebarVbox.getChildren().add(counter, helpText);
        counter++;
        
        
        
    }
    private void bindSliderToTextField(Slider slider, TextField textField) {
         textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
        String ch = event.getCharacter();

        
        if (ch.matches("[0-9]")) return;

       
        if (ch.equals(".") && !textField.getText().contains(".")) return;

       
        if (ch.isEmpty()) return;

        
        event.consume();
    });

   slider.valueProperty().addListener((obs, oldValue, newValue) -> {
        String formatted = String.format("%.2f", newValue.doubleValue());
        if (!textField.getText().equals(formatted)) {
            textField.setText(formatted);
        }
    });
    textField.setOnAction(e -> {
        String text = textField.getText();

        if (text.matches("\\d+(\\.\\d+)?")) {
            double value = Double.parseDouble(text);

            if (value < slider.getMin()) value = slider.getMin();
            if (value > slider.getMax()) value = slider.getMax();

            slider.setValue(value);
        }
    });
}

    

    
    
   
}
