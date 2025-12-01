/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Battery;
import Model.CircuitElement;
import Model.CircuitSplit;
import Model.Resistor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author merri
 */
public class ElectricalCircuitSimulationFXMLController implements Initializable {

    @FXML
    private Label helpText;

    
    CircuitElement[] circuit1 = {
        new Battery(15), 
        new Resistor(15, 0, 0),
        new Resistor(15, 0, 0)
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
    private Button cp_calcBtn;
    @FXML
    private Button cp_clearBtn;
    @FXML
    private Slider b5_slider;
    @FXML
    private TextField b5_tf;
    @FXML
    private ComboBox<String> rc_comboBox;
    @FXML
    private Button rc_addBtn;
 
    @FXML
    private Button rc_calcBtn;
    @FXML
    private Button rc_clearBtn;
    @FXML
    private Slider b6_slider;
    @FXML
    private TextField b6_tf;
    @FXML
    private ComboBox<String> cc_comboBox;
    @FXML
    private Button cc_addBtn;
    
    @FXML
    private Button cc_calcBtn;
    @FXML
    private Button cc_clearBtn;
    @FXML
    private VBox resistorVbox;
    @FXML
    private VBox rcSidebarVbox;
    private int counter1;
    private int counter2;
    private List<VBox> rcvbs = new ArrayList<>();
    private List<VBox> ccvbs = new ArrayList<>();
    
    @FXML
    private VBox capacitorvb;
    @FXML
    private VBox ccSidebarVbox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        counter1 = 0;
        counter2 = 0;
        cc_comboBox.getItems().addAll(
        "Branch","Capacitor"
    );
        rc_comboBox.getItems().addAll(
        "Branch","Resistor"
    );
        cc_comboBox.setValue("Branch");
        rc_comboBox.setValue("Branch");
        
        
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
        
        bindSliderToTextField(b5_slider, b5_tf);
    }

    /**
     * resets all the variables in tab 1
     * @param event 
     */
    @FXML
    private void rsClearBtnPressed(ActionEvent event) {
        b1_slider.setValue(20);
        b1_tf.setText("10.00");
        rs_R1_slider.setValue(20);
        rs_R1_tf.setText("10.00");
        rs_R2_slider.setValue(20);
        rs_R2_tf.setText("10.00");
        rs_R1_V.setText("Voltage: 0");
        rs_R2_V.setText("Voltage: 0");
        rs_R1_C.setText("Current: 0");
        rs_R2_C.setText("Current: 0");
    }


    

    

     /**
     * resets all the variables in tab 2
     * @param event 
     */
    @FXML
    private void rpClearBtnPressed(ActionEvent event) {
        b2_slider.setValue(20);
        b2_tf.setText("10.00");
        rp_R1_slider.setValue(20);
        rp_R1_tf.setText("10.00");
        rp_R2_slider.setValue(20);
        rp_R2_tf.setText("10.00");
        rp_R1_V.setText("Voltage: 0");
        rp_R2_V.setText("Voltage: 0");
        rp_R1_C.setText("Current: 0");
        rp_R2_C.setText("Current: 0");
    }

    /**
     * enters the calculated voltage and current into tab 1
     * @param event 
     */
    @FXML
    private void rsCalcBtnPreesed(ActionEvent event) {

        CircuitElement[] calcCircuit = {
            new Battery(Double.parseDouble(b1_tf.getText())),
            new Resistor(Double.parseDouble(rs_R1_tf.getText()), 0, 0),
            new Resistor(Double.parseDouble(rs_R2_tf.getText()), 0, 0),
        };
        calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        rs_R1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        rs_R1_C.setText("Current: " + ((Resistor)calcCircuit[1]).getCurrent());
        rs_R2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        rs_R2_C.setText("Current: " + ((Resistor)calcCircuit[2]).getCurrent());
        
    }

    /**
     * enters the calculated voltage and current into tab 2
     * @param event 
     */
    @FXML
    private void rpCalcBtnPressed(ActionEvent event) {
        CircuitElement[] calcCircuit = {
            new Battery(Double.parseDouble(b2_tf.getText())),
            new Resistor(Double.parseDouble(rp_R1_tf.getText()), 0, 0),
            new Resistor(Double.parseDouble(rp_R2_tf.getText()), 0, 0),
        };
        //calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        rp_R1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        rp_R1_C.setText("Current: " + ((Resistor)calcCircuit[1]).getCurrent());
        rp_R2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        rp_R2_C.setText("Current: " + ((Resistor)calcCircuit[2]).getCurrent());
        
    
    }
    
    /**
     * enters the calculated voltage and charge into tab 3
     * @param event 
     */
    @FXML
    private void cpCalcBtnPressed(ActionEvent event) {
        CircuitElement[] calcCircuit = {
            new Battery(Double.parseDouble(b3_tf.getText())),
            new Resistor(Double.parseDouble(cs_C1_tf.getText()), 0, 0),
            new Resistor(Double.parseDouble(cs_C2_tf.getText()), 0, 0),
        };
        //calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        //cs_C1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        //cs_C1_C.setText("Charge: " + ((Capacitor)calcCircuit[1]).getCurrent());
        //cs_C2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        //cs_C2_C.setText("Charge: " + ((Resistor)calcCircuit[2]).getCurrent());
        
    
    }
    
    /**
     * enters the calculated voltage and charge into tab 4
     * @param event 
     */
    @FXML
    private void csCalcBtnPressed(ActionEvent event) {
        CircuitElement[] calcCircuit = {
            new Battery(Double.parseDouble(b4_tf.getText())),
            new Resistor(Double.parseDouble(cp_C1_tf.getText()), 0, 0),
            new Resistor(Double.parseDouble(cp_C2_tf.getText()), 0, 0),
        };
        //calcResistance(calcCircuit, calcCircuit.length, 0, false, 0);
        //cp_C1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        //cp_C1_C.setText("Charge: " + ((Resistor)calcCircuit[1]).getCurrent());
        //cp_C2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        //cp_C2_C.setText("Charge: " + ((Resistor)calcCircuit[2]).getCurrent());
        
    }
    

    




    /**
     * resets all the variables in tab 3
     * @param event 
     */
    @FXML
    private void csClearBtnPressed(ActionEvent event) {
        b3_slider.setValue(20);
        b3_tf.setText("10.00");
        cs_C1_slider.setValue(20);
        cs_C1_tf.setText("10.00");
        cs_C2_slider.setValue(20);
        cs_C2_tf.setText("10.00");
        cs_C1_V.setText("Voltage: 0");
        cs_C2_V.setText("Voltage: 0");
        cs_C1_C.setText("Charge: 0");
        cs_C2_C.setText("Charge: 0");
    }

   

    


    /**
     * resets all the variables in tab 2
     * @param event 
     */
    @FXML
    private void cpClearBtnPressed(ActionEvent event) {
        b4_slider.setValue(20);
        b4_tf.setText("10.00");
        cp_C1_slider.setValue(20);
        cp_C1_tf.setText("10.00");
        cp_C2_slider.setValue(20);
        cp_C2_tf.setText("10.00");
        cp_C1_V.setText("Voltage: 0");
        cp_C2_V.setText("Voltage: 0");
        cp_C1_C.setText("Charge: 0");
        cp_C2_C.setText("Charge: 0");
    }

    /**
     * adds either a branch or a resistor to the circuit
     * @param event 
     */
    @FXML
    private void rcAddBtnPressed(ActionEvent event) {
        
    if(rc_comboBox.getSelectionModel().getSelectedItem().equals("Resistor")) {
    VBox copy = new VBox();
    copy.setSpacing(resistorVbox.getSpacing());
    copy.setAlignment(resistorVbox.getAlignment());

    
    for (Node n : resistorVbox.getChildren()) {

        
            if (n instanceof Label originalLabel) {
            if (originalLabel.getText().equals("Resistor #"+ counter1 + " Values:")) {
                originalLabel.setText("Resistor #" + (counter1 + 1) +" Values:");
            }
            Label lbl = new Label(originalLabel.getText());
            lbl.setFont(originalLabel.getFont());
            lbl.setTextFill(originalLabel.getTextFill());
            lbl.setStyle(originalLabel.getStyle());
            copy.getChildren().add(lbl);
        }
            else if (n instanceof TextField originalTF) {
                TextField tf = new TextField();
                tf.setText(originalTF.getText());
                tf.setPromptText(originalTF.getPromptText());
                tf.setPrefWidth(originalTF.getPrefWidth());
                tf.setStyle(originalTF.getStyle());
                tf.setText("10.00");
                copy.getChildren().add(tf);
            }
            else if (n instanceof Line originalLine) {
                Line line = new Line();

                line.setStartX(originalLine.getStartX());
                line.setStartY(originalLine.getStartY());
                line.setEndX(originalLine.getEndX());
                line.setEndY(originalLine.getEndY());

                line.setStroke(originalLine.getStroke());
                line.setStrokeWidth(originalLine.getStrokeWidth());
                line.setStyle(originalLine.getStyle());

        copy.getChildren().add(line);
            }
        
        
    }

    copy.setVisible(true);

    
    rcSidebarVbox.getChildren().add(10 + counter1, copy);
    rcvbs.add(counter1,copy);

    counter1++;
    }
    }
    
    /**
     * adds either a branch or a capacitor to the circuit
     * @param event 
     */
    @FXML
    private void ccAddBtnPressed(ActionEvent event) {
        if(cc_comboBox.getSelectionModel().getSelectedItem().equals("Capacitor")) {
    VBox copy = new VBox();
    copy.setSpacing(capacitorvb.getSpacing());
    copy.setAlignment(capacitorvb.getAlignment());

    
    for (Node n : capacitorvb.getChildren()) {

        
            if (n instanceof Label originalLabel) {
            if (originalLabel.getText().equals("Capacitor #"+ counter2 + " Values:")) {
                originalLabel.setText("Capacitor #" + (counter2 + 1) +" Values:");
            }
            Label lbl = new Label(originalLabel.getText());
            lbl.setFont(originalLabel.getFont());
            lbl.setTextFill(originalLabel.getTextFill());
            lbl.setStyle(originalLabel.getStyle());
            copy.getChildren().add(lbl);
        }
            else if (n instanceof TextField originalTF) {
                TextField tf = new TextField();
                tf.setText(originalTF.getText());
                tf.setPromptText(originalTF.getPromptText());
                tf.setPrefWidth(originalTF.getPrefWidth());
                tf.setStyle(originalTF.getStyle());
                tf.setText("10.00");
                copy.getChildren().add(tf);
            }
            else if (n instanceof Line originalLine) {
                Line line = new Line();

                line.setStartX(originalLine.getStartX());
                line.setStartY(originalLine.getStartY());
                line.setEndX(originalLine.getEndX());
                line.setEndY(originalLine.getEndY());

                line.setStroke(originalLine.getStroke());
                line.setStrokeWidth(originalLine.getStrokeWidth());
                line.setStyle(originalLine.getStyle());

        copy.getChildren().add(line);
            }
        
        
    }

    copy.setVisible(true);

    
    ccSidebarVbox.getChildren().add(10 + counter2, copy);
    ccvbs.add(counter2,copy);

    counter2++;
    }
        else {
            VBox copy = new VBox();
    copy.setSpacing(capacitorvb.getSpacing());
    copy.setAlignment(capacitorvb.getAlignment());

    
    for (Node n : capacitorvb.getChildren()) {

        
            if (n instanceof Label originalLabel) {
            if (originalLabel.getText().equals("Capacitor #"+ counter2 + " Values:")) {
                originalLabel.setText("Capacitor #" + (counter2 + 1) +" Values:");
            }
            Label lbl = new Label(originalLabel.getText());
            lbl.setFont(originalLabel.getFont());
            lbl.setTextFill(originalLabel.getTextFill());
            lbl.setStyle(originalLabel.getStyle());
            copy.getChildren().add(lbl);
        }
            else if (n instanceof TextField originalTF) {
                TextField tf = new TextField();
                tf.setText(originalTF.getText());
                tf.setPromptText(originalTF.getPromptText());
                tf.setPrefWidth(originalTF.getPrefWidth());
                tf.setStyle(originalTF.getStyle());
                tf.setText("10.00");
                copy.getChildren().add(tf);
            }
            else if (n instanceof Line originalLine) {
                Line line = new Line();

                line.setStartX(originalLine.getStartX());
                line.setStartY(originalLine.getStartY());
                line.setEndX(originalLine.getEndX());
                line.setEndY(originalLine.getEndY());

                line.setStroke(originalLine.getStroke());
                line.setStrokeWidth(originalLine.getStrokeWidth());
                line.setStyle(originalLine.getStyle());

        copy.getChildren().add(line);
            }
        
        
    }

    copy.setVisible(true);

    
    ccSidebarVbox.getChildren().add(10 + counter2, copy);
    ccvbs.add(counter2,copy);

    counter2++;
        }
        
        
    }
    
    /**
     * binds each slider to its corresponding textfield
     * @param slider the slider to be binded
     * @param textField the textfield to be binded
     */
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

    @FXML
    private void rcCalcBtnPressed(ActionEvent event) {
        
        String str = ((TextField)rcvbs.get(0).getChildren().get(2)).getText();
        ((Label)rcvbs.get(0).getChildren().get(3)).setText(str);
    }
    @FXML
    private void rcClearBtnPressed(ActionEvent event) {
        b5_tf.setText("10.00");
        b5_slider.setValue(0);
        for(int i = 0; i < counter1;i++) {
            ((TextField)rcvbs.get(i).getChildren().get(2)).setText("10.00");
        }
        
        
    }

    @FXML
    private void ccCalcBtnPressed(ActionEvent event) {
      
    }

    @FXML
    private void ccClearBtnPrssed(ActionEvent event) {
        b6_tf.setText("10.00");
        b6_slider.setValue(0);
        for(int i = 0; i < counter1;i++) {
            ((TextField)ccvbs.get(i).getChildren().get(2)).setText("10.00");
    }
    }
    
    

/**
     * UPDATE THIS I CAN'T TYPE IT RIGHT NOW IM SO TIRED
     * @param calcCircuit
     * @param circuitSize
     * @param finalResistance 
     */
    public void calcResistance(CircuitElement[] calcCircuit, int circuitSize, double finalResistance, boolean isSplit, double splitResistance, int splitIdx) {
        double store;
        if (circuitSize == 1) {
            
        }
        else if (circuitSize == 2) {
            store = ((Resistor) calcCircuit[circuitSize - 1]).getResistance();
            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(finalResistance);
            ((Resistor)calcCircuit[1]).setCurrent(calcCircuit[0].getVoltage() / ((Resistor) calcCircuit[1]).getResistance());
            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
            ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[1]).getResistance());
        }
        //if next circuitElement is a split
        else if (calcCircuit[circuitSize - 1] instanceof CircuitSplit) {
            //if 2nd to next Circuit element is a resistor and if this is 1st split path
            if (calcCircuit[circuitSize - 2] instanceof Resistor & isSplit == false) {
                store = ((Resistor) calcCircuit[circuitSize - 2]).getResistance();
                //if 3rd to next element is the end of the 1st split
                if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                    double equResistor = ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                    calcResistance(calcCircuit, circuitSize - 2, finalResistance, true, equResistor, circuitSize - 1);
                    ((CircuitSplit) calcCircuit[circuitSize - 3]).setVoltage(calcCircuit[circuitSize - 4].getVoltage());
                    ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit) calcCircuit[circuitSize - 3]).getVoltage());
                }
                //if 3rd to next element is a resistor
                else if (calcCircuit[circuitSize - 3] instanceof Resistor) {
                    double equResistor = ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                    calcResistance(calcCircuit, circuitSize - 2, finalResistance, true, equResistor, circuitSize - 1);
                    ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((Resistor)calcCircuit[circuitSize - 3]).getVoltage());
                }
                else {
                    finalResistance += splitResistance;
                    calcResistance(calcCircuit, circuitSize - 1, finalResistance, false, 0, splitIdx);                    
                    //((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((Battery)calcCircuit[circuitSize - 3]).getVoltage());             
                }
                ((Resistor)calcCircuit[circuitSize - 2]).setResistance(store);
                ((Resistor)calcCircuit[circuitSize - 2]).setCurrent(((Resistor)calcCircuit[circuitSize - 2]).getVoltage() / ((Resistor) calcCircuit[circuitSize - 2]).getResistance());
                
                
            }
            //if 2nd to next element is a resistor and this is the 2nd split path
            else if (calcCircuit[circuitSize - 2] instanceof Resistor){
                store = ((Resistor) calcCircuit[circuitSize - 2]).getResistance();
                //if 3rd to next element is the end of the second split
                if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                    //if 1st split had a resistor
                    if (splitResistance != 0) {
                        //equiResistor here equals to the 1/Req = 1/R1 + 1/R2
                        double equResistor = Math.pow((1/((Resistor)calcCircuit[circuitSize - 2]).getResistance() + 1/splitResistance), -1);
                        finalResistance += equResistor;
                        //if the component after the circuit split is a resistor
                        if (calcCircuit[circuitSize - 4] instanceof Resistor) {
                            finalResistance += ((Resistor) calcCircuit[circuitSize - 4]).getResistance();
                            calcResistance(calcCircuit, circuitSize - 3, finalResistance, false, 0, 0);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((Resistor)calcCircuit[circuitSize - 4]).getCurrent() * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((Resistor)calcCircuit[circuitSize - 4]).getCurrent() * equResistor);
                        }
                        //if the componenent after the circuit split is another circuit split
                        else if (calcCircuit[circuitSize - 4] instanceof CircuitSplit) {
                            calcResistance(calcCircuit, circuitSize - 3, finalResistance, false, 0, 0);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 4]).getVoltage() / ((CircuitSplit)calcCircuit[circuitSize - 4]).getTotal() * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 4]).getVoltage());
                        }
                        //if the component after the circuit split is the battery
                        else {
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 4].getVoltage() / finalResistance * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit)calcCircuit[splitIdx]).getVoltage());
                        }
                        
                    }
                }
                //if 3rd to next element is a resistor
                //else if (calcCircuit[circuitSize - 3] instanceof Resistor) 
                else {
                    double equResistor = ((Resistor)calcCircuit[circuitSize - 2]).getResistance() + ((Resistor)calcCircuit[circuitSize - 3]).getResistance();
                    calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, equResistor, splitIdx);
                }
                ((Resistor)calcCircuit[circuitSize - 2]).setResistance(store);
                ((Resistor) calcCircuit[circuitSize - 2]).setCurrent(((Resistor) calcCircuit[circuitSize - 2]).getVoltage() / ((Resistor) calcCircuit[circuitSize - 2]).getResistance());
            }
            //case for if a circuit's split has no resistors
            else {
                calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, 0, 0);
                if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) { 
                    ((CircuitSplit) calcCircuit[splitIdx]).setTotal(((CircuitSplit)calcCircuit[circuitSize - 3]).getTotal());
                }
                else if (calcCircuit[circuitSize - 3] instanceof Resistor){ 
                    ((CircuitSplit) calcCircuit[splitIdx]).setTotal(((Resistor)calcCircuit[circuitSize - 3]).getResistance());
                }
                ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage());    
            }
        }
        //if the next element is a resistor
        else {
            store = ((Resistor) calcCircuit[circuitSize - 1]).getResistance();
            if (circuitSize == calcCircuit.length) finalResistance = store;
            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(finalResistance);
            //if resistor is part of a circuit split
            if (splitResistance != 0) {
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(splitResistance);
                if(calcCircuit[circuitSize - 2] instanceof Resistor) {
                    splitResistance += ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                    calcResistance(calcCircuit, circuitSize - 1, finalResistance, isSplit, splitResistance, splitIdx);                
                    ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((Resistor)calcCircuit[circuitSize - 2]).getCurrent());
                    ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                    ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
                }
                else {
                    double equResistor = Math.pow((1/((Resistor)calcCircuit[circuitSize - 1]).getResistance() + 1/splitResistance), -1);
                        finalResistance += equResistor;
                        //if the component after the circuit split is a resistor
                        if (calcCircuit[circuitSize - 3] instanceof Resistor) {
                            finalResistance += ((Resistor) calcCircuit[circuitSize - 3]).getResistance();
                            calcResistance(calcCircuit, circuitSize - 1, finalResistance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((Resistor)calcCircuit[circuitSize - 3]).getCurrent() * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 3]).getCurrent() * equResistor);
                        }
                        //if the componenent after the circuit split is another circuit split
                        else if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                            calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 3]).getVoltage() / ((CircuitSplit)calcCircuit[circuitSize - 3]).getTotal() * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 3]).getVoltage());
                        }
                        //if the component after the circuit split is the battery
                        else {
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage() / finalResistance * equResistor);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((CircuitSplit)calcCircuit[splitIdx]).getVoltage());
                        }
                }
            }
            //if the 2nd to next element is a resistor
            else if (calcCircuit[circuitSize - 2] instanceof Resistor) {
                double equResistor = ((Resistor)calcCircuit[circuitSize - 1]).getResistance() + ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                calcResistance(calcCircuit, circuitSize - 1, equResistor, isSplit, splitResistance, splitIdx);
                ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((Resistor)calcCircuit[circuitSize - 2]).getCurrent());
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
            }
            //if the 2nd to next element is a circuitSplit
            else {
                calcResistance(calcCircuit, circuitSize - 1, finalResistance, isSplit, splitResistance, splitIdx);
                ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((CircuitSplit)calcCircuit[circuitSize - 2]).getVoltage() / ((CircuitSplit)calcCircuit[circuitSize - 2]).getTotal());
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
            }
        }
    }   

}
