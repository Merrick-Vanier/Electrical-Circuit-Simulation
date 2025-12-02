/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Battery;
import Model.Capacitor;
import Model.CircuitElement;
import Model.CircuitSplit;
import Model.Resistor;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane rc_pane;
    @FXML
    private Pane cc_pane;
    
    private ImageView battery;
    private ImageView battery2;
    private ImageView capacitor;
    private ImageView circuitSplit;
    private ImageView circuitSplitEnd;
    private ImageView corner1_series;
    private ImageView corner1_parallel;
    private ImageView corner2_series;
    private ImageView corner2_parallel;
    private ImageView resistor;
    private ImageView wire;
    private boolean split_circuit1;
    private boolean split_circuit2;
    private int btnCount;
    private int btnCount2;
    private CircuitElement[] calcCircuitcustom1;
    private CircuitElement[] calcCircuitcustom2;
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        split_circuit1 = false;
        split_circuit2 = false;
        btnCount = 0;
        counter1 = 0;
        counter2 = 0;
        cc_comboBox.getItems().addAll(
        "Branch","Capacitor", "Wire"
    );
        rc_comboBox.getItems().addAll(
        "Branch","Resistor", "Wire"
    );
        cc_comboBox.setValue("Branch");
        rc_comboBox.setValue("Branch");
        battery = new ImageView("file:src/View/Images/Battery.png");
        battery2 = new ImageView("file:src/View/Images/Battery.png");
        capacitor = new ImageView("file:src/View/Images/Capacitor.png");
        circuitSplit = new ImageView("file:src/View/Images/CircuitSplit.png");
        circuitSplitEnd = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
        corner1_series = new ImageView("file:src/View/Images/Corner1 Series.png");
        corner1_parallel = new ImageView("file:src/View/Images/Corner1 parallel.png");
        corner2_series = new ImageView("file:src/View/Images/Corner2 Series.png");
        corner2_parallel = new ImageView("file:src/View/Images/Corner2 parallel.png");
        resistor = new ImageView("file:src/View/Images/Resistor.png");
        wire = new ImageView("file:src/View/Images/Wire.png");
        
        rc_pane.getChildren().add(battery2);
        cc_pane.getChildren().add(battery);
        calcCircuitcustom1 = new CircuitElement[20];
        calcCircuitcustom2 = new CircuitElement[20];
        
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
        bindSliderToTextField(b6_slider, b6_tf);
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
        calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
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
            new CircuitSplit(0,0),
            new Resistor(Double.parseDouble(rp_R1_tf.getText()), 0, 0),
            new Resistor(Double.parseDouble(rp_R2_tf.getText()), 0, 0),
            new CircuitSplit(0,0),
        };
        calcResistance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
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
            new Capacitor(Double.parseDouble(cs_C1_tf.getText()), 0, 0),
            new Capacitor(Double.parseDouble(cs_C2_tf.getText()), 0, 0),
        };
        calcCapacitance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        cs_C1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        cs_C1_C.setText("Charge: " + ((Capacitor)calcCircuit[1]).getCurrent());
        cs_C2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        cs_C2_C.setText("Charge: " + ((Capacitor)calcCircuit[2]).getCurrent());
        
    
    }
    
    /**
     * enters the calculated voltage and charge into tab 4
     * @param event 
     */
    @FXML
    private void csCalcBtnPressed(ActionEvent event) {
        CircuitElement[] calcCircuit = {
            new Battery(Double.parseDouble(b4_tf.getText())),
            new CircuitSplit(0,0),
            new Capacitor(Double.parseDouble(cp_C1_tf.getText()), 0, 0),
            new Capacitor(Double.parseDouble(cp_C2_tf.getText()), 0, 0),
            new CircuitSplit(0,0),
        };
        calcCapacitance(calcCircuit, calcCircuit.length, 0, false, 0, 0);
        cp_C1_V.setText("Voltage: " + calcCircuit[1].getVoltage());
        cp_C1_C.setText("Charge: " + ((Capacitor)calcCircuit[1]).getCharge());
        cp_C2_V.setText("Voltage: " + calcCircuit[2].getVoltage());
        cp_C2_C.setText("Charge: " + ((Capacitor)calcCircuit[2]).getCharge());
        
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
        if (btnCount < 5) {
        calcCircuitcustom1[counter1] = new Battery(Double.parseDouble(b5_tf.getText()));
        
        if(rc_comboBox.getSelectionModel().getSelectedItem().equals("Resistor")) {
        if (!split_circuit1) {
    VBox copy = new VBox();
    copy.setSpacing(resistorVbox.getSpacing());
    copy.setAlignment(resistorVbox.getAlignment());

    
    for (Node n : resistorVbox.getChildren()) {

        
            if (n instanceof Label originalLabel) {
            if (originalLabel.getText().equals("Resistor #"+ counter1 + " Values:")||originalLabel.getText().equals("Resistor #"+ counter1 + 1 + " Values:")||originalLabel.getText().equals("Resistor #0 Values:")) {
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
    btnCount++;
    ImageView newResistor = new ImageView("file:src/View/Images/Resistor.png");
    ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newcorner1 = new ImageView("file:src/View/Images/Corner1 Series.png");
    ImageView newcorner2 = new ImageView("file:src/View/Images/Corner2 Series.png");
    if (btnCount == 1) {
        
    newResistor.setLayoutX( 150 );  
    newResistor.setLayoutY( -5 ); 
    
    rc_pane.getChildren().addAll(newResistor);
    calcCircuitcustom1[counter1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
    }
    
    else if (btnCount == 2) {
        newResistor.setLayoutX( 350 );  
    newResistor.setLayoutY( -5 );  
    newcorner1.setLayoutX( 550 );  
    newwire1.setLayoutX( 450 ); 
    newwire1.setLayoutY( -5 );
    newwire2.setLayoutX(250);
    newwire2.setLayoutY(-5);
    newcorner1.setLayoutY( 20);
    rc_pane.getChildren().addAll(newResistor, newwire1,newwire2, newcorner1);
    calcCircuitcustom1[counter1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    
    }
    else if (btnCount == 3) {
        newResistor.setRotate(90);
        newwire1.setRotate(90);
        newwire2.setRotate(90);
        newwire1.setLayoutX(525);
        newwire1.setLayoutY(70);
        newResistor.setLayoutX( 525 );  
        newResistor.setLayoutY( 170 );
        newwire2.setLayoutX(525);
        newwire2.setLayoutY(270);
        newcorner2.setLayoutX(552);
        newcorner2.setLayoutY(370);
        rc_pane.getChildren().addAll(newResistor, newwire1, newwire2, newcorner2);
        calcCircuitcustom1[counter1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        
        
    }else if (btnCount == 4) {
        newResistor.setLayoutX(352);
        newResistor.setLayoutY(405);
        newwire1.setLayoutX(451);
        newwire1.setLayoutY(405);
        rc_pane.getChildren().addAll(newResistor, newwire1);
        rc_comboBox.getItems().remove(0);
        calcCircuitcustom1[counter1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        
        
    }
    else if (btnCount == 5) {
        newResistor.setLayoutX(150);
        newResistor.setLayoutY(405);
        newwire1.setLayoutX(251);
        newwire1.setLayoutY(405);
        rc_pane.getChildren().addAll(newResistor, newwire1);
        calcCircuitcustom1[counter1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    }
    }
        else {
            VBox copy1 = new VBox();
    VBox copy2 = new VBox();

    copy1.setSpacing(resistorVbox.getSpacing());
    copy1.setAlignment(resistorVbox.getAlignment());
    copy2.setSpacing(resistorVbox.getSpacing());
    copy2.setAlignment(resistorVbox.getAlignment());

    int number1 = counter1 + 1;
    int number2 = counter1 + 2;

    Label lbl1 = new Label("Resistor #" + number1 + " Values:");
    Label lbl2 = new Label("Resistor #" + number2 + " Values:");

    lbl1.setFont(((Label) resistorVbox.getChildren().get(0)).getFont());
    lbl2.setFont(((Label) resistorVbox.getChildren().get(0)).getFont());

    copy1.getChildren().add(lbl1);
    copy2.getChildren().add(lbl2);

    for (Node n : resistorVbox.getChildren()) {

        if (n instanceof Label original && !original.getText().startsWith("Resistor #")) {
            Label clone1 = new Label(original.getText());
            Label clone2 = new Label(original.getText());

            clone1.setFont(original.getFont());
            clone1.setStyle(original.getStyle());
            clone1.setTextFill(original.getTextFill());

            clone2.setFont(original.getFont());
            clone2.setStyle(original.getStyle());
            clone2.setTextFill(original.getTextFill());

            copy1.getChildren().add(clone1);
            copy2.getChildren().add(clone2);
        }

        else if (n instanceof TextField originalTF) {

            TextField tf1 = new TextField("10.00");
            TextField tf2 = new TextField("10.00");

            tf1.setPromptText(originalTF.getPromptText());
            tf1.setPrefWidth(originalTF.getPrefWidth());
             tf1.setStyle(originalTF.getStyle());

            tf2.setPromptText(originalTF.getPromptText());
            tf2.setPrefWidth(originalTF.getPrefWidth());
            tf2.setStyle(originalTF.getStyle());

            copy1.getChildren().add(tf1);
            copy2.getChildren().add(tf2);
        }

        else if (n instanceof Line originalLine) {

            Line l1 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                               originalLine.getEndX(), originalLine.getEndY());
            Line l2 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                               originalLine.getEndX(), originalLine.getEndY());

            l1.setStroke(originalLine.getStroke());
             l1.setStrokeWidth(originalLine.getStrokeWidth());
            l1.setStyle(originalLine.getStyle());

            l2.setStroke(originalLine.getStroke());
            l2.setStrokeWidth(originalLine.getStrokeWidth());
            l2.setStyle(originalLine.getStyle());

            copy1.getChildren().add(l1);
            copy2.getChildren().add(l2);
        }
    }

    rcSidebarVbox.getChildren().add(10 + counter1, copy1);
    rcSidebarVbox.getChildren().add(10 + counter1 + 1, copy2);

    rcvbs.add(copy1);
    rcvbs.add(copy2);
    btnCount++;
    counter1 += 2;
    ImageView newResistor = new ImageView("file:src/View/Images/Resistor.png");
    ImageView newResistor2 = new ImageView("file:src/View/Images/Resistor.png");
    ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
    ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
    ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
    
    ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newcircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
    if (btnCount == 2) {
    
    newwire3.setLayoutX(300);
    newwire3.setLayoutY( -33);
    newwire4.setLayoutX(300);
    newwire4.setLayoutY( 25);
    newResistor.setLayoutX( 375 );  
    newResistor.setLayoutY( -33); 
    
    newResistor2.setLayoutX( 375 );  
    newResistor2.setLayoutY( 25); 
    
    newcornerp1.setLayoutX(475);
    newcornerp1.setLayoutY(70);
    
    newwire1.setLayoutX(475);
    newwire1.setLayoutY(-33);
    
    newcornerp2.setLayoutX(565);
    newcornerp2.setLayoutY(-8);
    
    newwire2.setLayoutX(540);
    newwire2.setLayoutY(28); 
    newwire2.setRotate(90);
    rc_pane.getChildren().addAll(newResistor, newResistor2, newcornerp1, newwire1, newcornerp2, newwire2, newwire3, newwire4 );
    calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
    calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
    calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    }
    else if (btnCount == 3) {
        newwire1.setRotate(90);
        newwire2.setRotate(90);
        newwire3.setRotate(90);
        newwire4.setRotate(90);
        newResistor.setRotate(90);
        newResistor2.setRotate(90);
        newcornerp1.setRotate(90);
        newcornerp2.setRotate(90);
        newwire1.setLayoutX(475);
        newwire1.setLayoutY(125);
        newwire2.setLayoutX(543);
        newwire2.setLayoutY(125);
        newResistor.setLayoutX(475);
        newResistor.setLayoutY(225);
        newResistor2.setLayoutX(543);
        newResistor2.setLayoutY(225);
        newwire4.setLayoutX(475);
        newwire4.setLayoutY(300);
        newwire3.setLayoutX(543);
        newwire3.setLayoutY(325);
        newcornerp1.setLayoutX(540);
        newcornerp1.setLayoutY(425);
        newcornerp2.setLayoutX(500);
        newcornerp2.setLayoutY(393);
        newwire5.setLayoutX(470);
        newwire5.setLayoutY(428);
       
        calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
       calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
       calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        rc_pane.getChildren().addAll(newwire1, newwire2, newResistor, newResistor2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5);
    }
    else if (btnCount == 4) {
        newResistor.setLayoutX(390);
        newResistor.setLayoutY(428);
        newResistor2.setLayoutX(390);
        newResistor2.setLayoutY(365);
        newwire1.setLayoutX(310);
        newwire1.setLayoutY(428);
        newwire2.setLayoutX(310);
        newwire2.setLayoutY(365);
        calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
    calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
    calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        rc_pane.getChildren().addAll(newResistor, newResistor2, newwire1,newwire2);
    }
    else if (btnCount == 5) {
        newResistor.setLayoutX(210);
        newResistor.setLayoutY(428);
        newResistor2.setLayoutX(210);
        newResistor2.setLayoutY(365);
        newcircuitend.setRotate(180);
        newcircuitend.setLayoutX(110);
        newcircuitend.setLayoutY(397);
        calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
    calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
    calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        rc_pane.getChildren().addAll(newResistor, newResistor2, newcircuitend);
        
    }
        }
    }
    else if (rc_comboBox.getSelectionModel().getSelectedItem().equals("End branch")) {
        ImageView newCircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
        ImageView newwire = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newcorner = new ImageView("file:src/View/Images/Corner1 Series.png");
        btnCount++;
        split_circuit1 = false;
        rc_comboBox.getItems().remove(0);
        rc_comboBox.getItems().add(0, "Branch");
        rc_comboBox.setValue("Resistor");
        
        if (btnCount == 2) {
            newwire2.setLayoutX(300);
            newwire2.setLayoutY(-33);
            newwire3.setLayoutX(300);
            newwire3.setLayoutY(25);
            newCircuitend.setLayoutX(375);
            newCircuitend.setLayoutY(-5);
            newwire.setLayoutX(450);
            newwire.setLayoutY(-5);
            newcorner.setLayoutX(550);
            newcorner.setLayoutY(20);
            rc_pane.getChildren().addAll(newCircuitend, newwire, newcorner, newwire2, newwire3);
            calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
            
        }
        else if (btnCount == 3) {
            newCircuitend.setRotate(90);
            newwire.setRotate(90);
            newwire2.setRotate(90);
            newcorner.setRotate(90);
            newCircuitend.setLayoutX(510);
            newCircuitend.setLayoutY(125);
            newwire.setLayoutX(510);
            newwire.setLayoutY(225);
            newwire2.setLayoutX(510);
            newwire2.setLayoutY(325);
            newcorner.setLayoutX(535);
            newcorner.setLayoutY(425);
            rc_pane.getChildren().addAll(newCircuitend, newwire, newwire2, newcorner);
            calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
        }
        else if (btnCount == 4) {
            newCircuitend.setRotate(180);
            newCircuitend.setLayoutX(390);
            newCircuitend.setLayoutY(395);
            newwire.setLayoutX(295);
            newwire.setLayoutY(400);
            rc_pane.getChildren().addAll(newCircuitend, newwire);
            calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
            rc_comboBox.getItems().remove(0);
        }
        else if (btnCount == 5) {
            newCircuitend.setRotate(180);
            newCircuitend.setLayoutX(250);
            newCircuitend.setLayoutY(398);
            
            newwire2.setLayoutX(150);
            newwire2.setLayoutY(402);
            rc_pane.getChildren().addAll(newCircuitend, newwire2);
            calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
        }
    
        
    }
    else if (rc_comboBox.getSelectionModel().getSelectedItem().equals("Wire")) {
        if (!split_circuit1) {
            btnCount++;
    ImageView newwire = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newcorner1 = new ImageView("file:src/View/Images/Corner1 Series.png");
    ImageView newcorner2 = new ImageView("file:src/View/Images/Corner2 Series.png");
    if (btnCount == 1) {
        
    newwire.setLayoutX( 150 );  
    newwire.setLayoutY( -5 ); 
    
    rc_pane.getChildren().addAll(newwire);
    }
    
    else if (btnCount == 2) {
        newwire.setLayoutX( 350 );  
    newwire.setLayoutY( -5 );  
    newcorner1.setLayoutX( 550 );  
    newwire1.setLayoutX( 450 ); 
    newwire1.setLayoutY( -5 );
    newwire2.setLayoutX(250);
    newwire2.setLayoutY(-5);
    newcorner1.setLayoutY( 20);
    rc_pane.getChildren().addAll(newwire, newwire1,newwire2, newcorner1);
    
    }
    else if (btnCount == 3) {
        newwire.setRotate(90);
        newwire1.setRotate(90);
        newwire2.setRotate(90);
        newwire1.setLayoutX(525);
        newwire1.setLayoutY(70);
        newwire.setLayoutX( 525 );  
        newwire.setLayoutY( 170 );
        newwire2.setLayoutX(525);
        newwire2.setLayoutY(270);
        newcorner2.setLayoutX(552);
        newcorner2.setLayoutY(370);
        rc_pane.getChildren().addAll(newwire, newwire1, newwire2, newcorner2);
        
        
        
    }else if (btnCount == 4) {
        newwire.setLayoutX(352);
        newwire.setLayoutY(405);
        newwire1.setLayoutX(451);
        newwire1.setLayoutY(405);
        rc_pane.getChildren().addAll(newwire, newwire1);
        rc_comboBox.getItems().remove(0);
        
        
        
    }
    else if (btnCount == 5) {
        newwire.setLayoutX(150);
        newwire.setLayoutY(405);
        newwire1.setLayoutX(251);
        newwire1.setLayoutY(405);
        rc_pane.getChildren().addAll(newwire, newwire1);
    }
    }
        else {
            btnCount++;
                ImageView newwires = new ImageView("file:src/View/Images/Wire.png");
                ImageView newwires2 = new ImageView("file:src/View/Images/Wire.png");
                ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
                ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
                ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
                ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
    
                ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
                ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
                ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
                ImageView newcircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
    if (btnCount == 2) {
    
    newwire3.setLayoutX(300);
    newwire3.setLayoutY( -33);
    newwire4.setLayoutX(300);
    newwire4.setLayoutY( 25);
    newwires.setLayoutX( 375 );  
    newwires.setLayoutY( -33); 
    
    newwires2.setLayoutX( 375 );  
    newwires2.setLayoutY( 25); 
    
    newcornerp1.setLayoutX(475);
    newcornerp1.setLayoutY(70);
    
    newwire1.setLayoutX(475);
    newwire1.setLayoutY(-33);
    
    newcornerp2.setLayoutX(565);
    newcornerp2.setLayoutY(-8);
    
    newwire2.setLayoutX(540);
    newwire2.setLayoutY(28); 
    newwire2.setRotate(90);
    rc_pane.getChildren().addAll(newwires, newwires2, newcornerp1, newwire1, newcornerp2, newwire2, newwire3, newwire4 );
    }
    else if (btnCount == 3) {
        newwire1.setRotate(90);
        newwire2.setRotate(90);
        newwire3.setRotate(90);
        newwire4.setRotate(90);
        newwires.setRotate(90);
        newwires2.setRotate(90);
        newcornerp1.setRotate(90);
        newcornerp2.setRotate(90);
        newwire1.setLayoutX(475);
        newwire1.setLayoutY(125);
        newwire2.setLayoutX(543);
        newwire2.setLayoutY(125);
        newwires.setLayoutX(475);
        newwires.setLayoutY(225);
        newwires2.setLayoutX(543);
        newwires2.setLayoutY(225);
        newwire4.setLayoutX(475);
        newwire4.setLayoutY(300);
        newwire3.setLayoutX(543);
        newwire3.setLayoutY(325);
        newcornerp1.setLayoutX(540);
        newcornerp1.setLayoutY(425);
        newcornerp2.setLayoutX(500);
        newcornerp2.setLayoutY(393);
        newwire5.setLayoutX(470);
        newwire5.setLayoutY(428);
       
        rc_pane.getChildren().addAll(newwire1, newwire2, newwires, newwires2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5);
    }
    else if (btnCount == 4) {
        newwires.setLayoutX(390);
        newwires.setLayoutY(428);
        newwires2.setLayoutX(390);
        newwires2.setLayoutY(365);
        newwire1.setLayoutX(310);
        newwire1.setLayoutY(428);
        newwire2.setLayoutX(310);
        newwire2.setLayoutY(365);
        rc_pane.getChildren().addAll(newwires, newwires2, newwire1,newwire2);
    }
    else if (btnCount == 5) {
        newwires.setLayoutX(210);
        newwires.setLayoutY(428);
        newwires2.setLayoutX(210);
        newwires2.setLayoutY(365);
        newcircuitend.setRotate(180);
        newcircuitend.setLayoutX(110);
        newcircuitend.setLayoutY(397);
        
        rc_pane.getChildren().addAll(newwires, newwires2, newcircuitend);
        
    }
        }
        }
    
    else {
    VBox copy1 = new VBox();
    VBox copy2 = new VBox();

    copy1.setSpacing(resistorVbox.getSpacing());
    copy1.setAlignment(resistorVbox.getAlignment());
     copy2.setSpacing(resistorVbox.getSpacing());
    copy2.setAlignment(resistorVbox.getAlignment());

    int number1 = counter1 + 1;
    int number2 = counter1 + 2;

    Label lbl1 = new Label("Resistor #" + number1 + " Values:");
    Label lbl2 = new Label("Resistor #" + number2 + " Values:");

    lbl1.setFont(((Label) resistorVbox.getChildren().get(0)).getFont());
    lbl2.setFont(((Label) resistorVbox.getChildren().get(0)).getFont());

    copy1.getChildren().add(lbl1);
    copy2.getChildren().add(lbl2);

    for (Node n : resistorVbox.getChildren()) {

        if (n instanceof Label original && !original.getText().startsWith("Resistor #")) {
            Label clone1 = new Label(original.getText());
            Label clone2 = new Label(original.getText());

            clone1.setFont(original.getFont());
            clone1.setStyle(original.getStyle());
            clone1.setTextFill(original.getTextFill());

            clone2.setFont(original.getFont());
            clone2.setStyle(original.getStyle());
            clone2.setTextFill(original.getTextFill());

            copy1.getChildren().add(clone1);
            copy2.getChildren().add(clone2);
        }

        else if (n instanceof TextField originalTF) {

            TextField tf1 = new TextField("10.00");
            TextField tf2 = new TextField("10.00");

            tf1.setPromptText(originalTF.getPromptText());
            tf1.setPrefWidth(originalTF.getPrefWidth());
            tf1.setStyle(originalTF.getStyle());

            tf2.setPromptText(originalTF.getPromptText());
            tf2.setPrefWidth(originalTF.getPrefWidth());
            tf2.setStyle(originalTF.getStyle());

            copy1.getChildren().add(tf1);
            copy2.getChildren().add(tf2);
        }

        else if (n instanceof Line originalLine) {

            Line l1 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                               originalLine.getEndX(), originalLine.getEndY());
            Line l2 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                               originalLine.getEndX(), originalLine.getEndY());

            l1.setStroke(originalLine.getStroke());
             l1.setStrokeWidth(originalLine.getStrokeWidth());
            l1.setStyle(originalLine.getStyle());

            l2.setStroke(originalLine.getStroke());
            l2.setStrokeWidth(originalLine.getStrokeWidth());
            l2.setStyle(originalLine.getStyle());

            copy1.getChildren().add(l1);
            copy2.getChildren().add(l2);
        }
    }

    rcSidebarVbox.getChildren().add(10 + counter1, copy1);
    rcSidebarVbox.getChildren().add(10 + counter1 + 1, copy2);

    rcvbs.add(copy1);
    rcvbs.add(copy2);

    counter1 += 2;
    btnCount ++;
    rc_comboBox.getItems().remove(0);
    rc_comboBox.getItems().add(0, "End branch");
    split_circuit1 = true;
    rc_comboBox.setValue("Resistor");
    ImageView newcircuitSplit = new ImageView("file:src/View/Images/CircuitSplit.png");
    ImageView newResistor = new ImageView("file:src/View/Images/Resistor.png");
    ImageView newResistor2 = new ImageView("file:src/View/Images/Resistor.png");
    ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
    ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
    ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire6 = new ImageView("file:src/View/Images/Wire.png");
    ImageView newwire7 = new ImageView("file:src/View/Images/Wire.png");
    
    if (btnCount == 1) {
    newcircuitSplit.setLayoutX( 125 );  
    newcircuitSplit.setLayoutY( -5 ); 
    
    newResistor.setLayoutX( 225 );  
    newResistor.setLayoutY( -33); 
    
    newResistor2.setLayoutX( 225 );  
    newResistor2.setLayoutY( 25); 
    rc_pane.getChildren().addAll(newcircuitSplit, newResistor, newResistor2);
    calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
       calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
       calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    }
    else if (btnCount == 2) {
        newwire3.setLayoutX(220);
        newwire3.setLayoutY(-5);
        
        newcircuitSplit.setLayoutX(285);
        newcircuitSplit.setLayoutY(-5);
        newResistor.setLayoutX( 385 );  
        newResistor.setLayoutY( -33); 
        
    
        newResistor2.setLayoutX( 385 );  
        newResistor2.setLayoutY( 25);
        newcornerp1.setLayoutX(475);
        newcornerp1.setLayoutY(70);
    
        newwire1.setLayoutX(485);
        newwire1.setLayoutY(-33);
     
        newcornerp2.setLayoutX(570);
        newcornerp2.setLayoutY(-8);
    
        newwire2.setLayoutX(545);
        newwire2.setLayoutY(28); 
        newwire2.setRotate(90);
        rc_pane.getChildren().addAll(newwire3, newcircuitSplit, newResistor, newResistor2, newwire1, newwire2, newcornerp1, newcornerp2);
        calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
       calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
       calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    
    }
    else if (btnCount == 3) {
        newcircuitSplit.setRotate(90);
        newcircuitSplit.setLayoutX(525);
        newcircuitSplit.setLayoutY(65);
        newwire1.setRotate(90);
        newwire2.setRotate(90);
        newwire3.setRotate(90);
        newwire4.setRotate(90);
        newResistor.setRotate(90);
        newResistor2.setRotate(90);
        newcornerp1.setRotate(90);
        newcornerp2.setRotate(90);
        newwire1.setLayoutX(495);
        newwire1.setLayoutY(125);
        newwire2.setLayoutX(553);
        newwire2.setLayoutY(125);
        newResistor.setLayoutX(495);
        newResistor.setLayoutY(225);
        newResistor2.setLayoutX(553);
        newResistor2.setLayoutY(225);
        newwire4.setLayoutX(495);
        newwire4.setLayoutY(300);
        newwire3.setLayoutX(553);
        newwire3.setLayoutY(325);
        newcornerp1.setLayoutX(550);
        newcornerp1.setLayoutY(425);
        newcornerp2.setLayoutX(520);
        newcornerp2.setLayoutY(393);
        newwire5.setLayoutX(508);
        newwire5.setLayoutY(428);
        newwire6.setLayoutX(480);
        newwire6.setLayoutY(428);
        newwire7.setLayoutX(450);
        newwire7.setLayoutY(368);
        
       
        rc_pane.getChildren().addAll(newcircuitSplit, newwire1, newwire2, newResistor, newResistor2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5, newwire6, newwire7);
        calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
       calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
       calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

    }
    else if (btnCount == 4) {
        newcircuitSplit.setRotate(180);
        newcircuitSplit.setLayoutX(453);
        newcircuitSplit.setLayoutY(405);
        newResistor.setLayoutX(353);
        newResistor.setLayoutY(375);
        newResistor2.setLayoutX(353);
        newResistor2.setLayoutY(433);
        newwire1.setLayoutX(280);
        newwire1.setLayoutY(370);
        newwire2.setLayoutX(280);
        newwire2.setLayoutY(430);
        rc_pane.getChildren().addAll(newcircuitSplit, newResistor, newResistor2, newwire1, newwire2);
       calcCircuitcustom1[counter1] = new CircuitSplit(0,0);
      
    
       calcCircuitcustom1[counter1 + 1] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
 
       calcCircuitcustom1[counter1 + 2] = new Resistor(Double.parseDouble(((TextField)rcvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        
    }
    
    
    }
    
   }
        else {
             Label lbl = new Label("Unable to add anymore components");
            rcSidebarVbox.getChildren().add(9, lbl);
        }
   }
    /**
     * adds either a branch or a capacitor to the circuit
     * @param event 
     */
    @FXML
    private void ccAddBtnPressed(ActionEvent event) {
        if(btnCount2 < 5) { 
    if (cc_comboBox.getSelectionModel().getSelectedItem().equals("Capacitor")) {
        if (!split_circuit2) {
            VBox copy = new VBox();
            copy.setSpacing(capacitorvb.getSpacing());
            copy.setAlignment(capacitorvb.getAlignment());

            for (Node n : capacitorvb.getChildren()) {

                if (n instanceof Label originalLabel) {
                    if (originalLabel.getText().equals("Capacitor #"+ counter2 + " Values:")||originalLabel.getText().equals("Capacitor #"+ counter2 + 1 + " Values:")||originalLabel.getText().equals("Capacitor #0 Values:")) {
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
            btnCount2++;
            ImageView newCapacitor = new ImageView("file:src/View/Images/Capacitor.png");
            ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcorner1 = new ImageView("file:src/View/Images/Corner1 Series.png");
            ImageView newcorner2 = new ImageView("file:src/View/Images/Corner2 Series.png");
            if (btnCount2 == 1) {
                newCapacitor.setLayoutX( 150 );
                newCapacitor.setLayoutY( -5 );
                cc_pane.getChildren().addAll(newCapacitor);
         
       calcCircuitcustom2[counter2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }

            else if (btnCount2 == 2) {
                newCapacitor.setLayoutX( 350 );
                newCapacitor.setLayoutY( -5 );
                newcorner1.setLayoutX( 550 );
                newwire1.setLayoutX( 450 );
                newwire1.setLayoutY( -5 );
                newwire2.setLayoutX(250);
                newwire2.setLayoutY(-5);
                newcorner1.setLayoutY( 20);
                cc_pane.getChildren().addAll(newCapacitor, newwire1,newwire2, newcorner1);
                       calcCircuitcustom2[counter2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);


            }
            else if (btnCount2 == 3) {
                newCapacitor.setRotate(90);
                newwire1.setRotate(90);
                newwire2.setRotate(90);
                newwire1.setLayoutX(525);
                newwire1.setLayoutY(70);
                newCapacitor.setLayoutX( 525 );
                newCapacitor.setLayoutY( 170 );
                newwire2.setLayoutX(525);
                newwire2.setLayoutY(270);
                newcorner2.setLayoutX(552);
                newcorner2.setLayoutY(370);
                cc_pane.getChildren().addAll(newCapacitor, newwire1, newwire2, newcorner2);
                       calcCircuitcustom2[counter2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }else if (btnCount2 == 4) {
                newCapacitor.setLayoutX(352);
                newCapacitor.setLayoutY(405);
                newwire1.setLayoutX(451);
                newwire1.setLayoutY(405);
                cc_pane.getChildren().addAll(newCapacitor, newwire1);
                       calcCircuitcustom2[counter2 ] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

                cc_comboBox.getItems().remove(0);
            }
            else if (btnCount2 == 5) {
                newCapacitor.setLayoutX(150);
                newCapacitor.setLayoutY(405);
                newwire1.setLayoutX(251);
                newwire1.setLayoutY(405);
                cc_pane.getChildren().addAll(newCapacitor, newwire1);
                       calcCircuitcustom2[counter2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }
        }
        else {
            VBox copy1 = new VBox();
            VBox copy2 = new VBox();

            copy1.setSpacing(capacitorvb.getSpacing());
            copy1.setAlignment(capacitorvb.getAlignment());
            copy2.setSpacing(capacitorvb.getSpacing());
            copy2.setAlignment(capacitorvb.getAlignment());

            int number1 = counter2 + 1;
            int number2 = counter2 + 2;

            Label lbl1 = new Label("Capacitor #" + number1 + " Values:");
            Label lbl2 = new Label("Capacitor #" + number2 + " Values:");

            lbl1.setFont(((Label) capacitorvb.getChildren().get(0)).getFont());
            lbl2.setFont(((Label) capacitorvb.getChildren().get(0)).getFont());

            copy1.getChildren().add(lbl1);
            copy2.getChildren().add(lbl2);

            for (Node n : capacitorvb.getChildren()) {
                if (n instanceof Label original && !original.getText().startsWith("Capacitor #")) {
                    Label clone1 = new Label(original.getText());
                    Label clone2 = new Label(original.getText());

                    clone1.setFont(original.getFont());
                    clone1.setStyle(original.getStyle());
                    clone1.setTextFill(original.getTextFill());

                    clone2.setFont(original.getFont());
                    clone2.setStyle(original.getStyle());
                    clone2.setTextFill(original.getTextFill());

                    copy1.getChildren().add(clone1);
                    copy2.getChildren().add(clone2);
                }
                else if (n instanceof TextField originalTF) {
                    TextField tf1 = new TextField("10.00");
                    TextField tf2 = new TextField("10.00");

                    tf1.setPromptText(originalTF.getPromptText());
                    tf1.setPrefWidth(originalTF.getPrefWidth());
                    tf1.setStyle(originalTF.getStyle());

                    tf2.setPromptText(originalTF.getPromptText());
                    tf2.setPrefWidth(originalTF.getPrefWidth());
                    tf2.setStyle(originalTF.getStyle());

                    copy1.getChildren().add(tf1);
                    copy2.getChildren().add(tf2);
                }
                else if (n instanceof Line originalLine) {
                    Line l1 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                            originalLine.getEndX(), originalLine.getEndY());
                    Line l2 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                            originalLine.getEndX(), originalLine.getEndY());

                    l1.setStroke(originalLine.getStroke());
                    l1.setStrokeWidth(originalLine.getStrokeWidth());
                    l1.setStyle(originalLine.getStyle());

                    l2.setStroke(originalLine.getStroke());
                    l2.setStrokeWidth(originalLine.getStrokeWidth());
                    l2.setStyle(originalLine.getStyle());

                    copy1.getChildren().add(l1);
                    copy2.getChildren().add(l2);
                }
            }

            ccSidebarVbox.getChildren().add(10 + counter2, copy1);
            ccSidebarVbox.getChildren().add(10 + counter2 + 1, copy2);

            ccvbs.add(copy1);
            ccvbs.add(copy2);
            btnCount2++;
            counter2 += 2;
            ImageView newCapacitor = new ImageView("file:src/View/Images/Capacitor.png");
            ImageView newCapacitor2 = new ImageView("file:src/View/Images/Capacitor.png");
            ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
            ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
            ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");

            ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
            if (btnCount2 == 2) {
                newwire3.setLayoutX(300);
                newwire3.setLayoutY( -33);
                newwire4.setLayoutX(300);
                newwire4.setLayoutY( 25);
                newCapacitor.setLayoutX( 375 );
                newCapacitor.setLayoutY( -33 );

                newCapacitor2.setLayoutX( 375 );
                newCapacitor2.setLayoutY( 25 );

                newcornerp1.setLayoutX(475);
                newcornerp1.setLayoutY(70);

                newwire1.setLayoutX(475);
                newwire1.setLayoutY(-33);

                newcornerp2.setLayoutX(565);
                newcornerp2.setLayoutY(-8);

                newwire2.setLayoutX(540);
                newwire2.setLayoutY(28);

                newwire2.setRotate(90);
                cc_pane.getChildren().addAll(newCapacitor, newCapacitor2, newcornerp1, newwire1, newcornerp2, newwire2, newwire3, newwire4 );
                
                calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }
            else if (btnCount2 == 3) {
                newwire1.setRotate(90);
                newwire2.setRotate(90);
                newwire3.setRotate(90);
                newwire4.setRotate(90);
                newCapacitor.setRotate(90);
                newCapacitor2.setRotate(90);
                newcornerp1.setRotate(90);
                newcornerp2.setRotate(90);
                newwire1.setLayoutX(475);
                newwire1.setLayoutY(125);
                newwire2.setLayoutX(543);
                newwire2.setLayoutY(125);
                newCapacitor.setLayoutX(475);
                newCapacitor.setLayoutY(225);
                newCapacitor2.setLayoutX(543);
                newCapacitor2.setLayoutY(225);
                newwire4.setLayoutX(475);
                newwire4.setLayoutY(300);
                newwire3.setLayoutX(543);
                newwire3.setLayoutY(325);
                newcornerp1.setLayoutX(540);
                newcornerp1.setLayoutY(425);
                newcornerp2.setLayoutX(500);
                newcornerp2.setLayoutY(393);
                newwire5.setLayoutX(470);
                newwire5.setLayoutY(428);
                cc_pane.getChildren().addAll(newwire1, newwire2, newCapacitor, newCapacitor2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }
            else if (btnCount2 == 4) {
                newCapacitor.setLayoutX(390);
                newCapacitor.setLayoutY(428);
                newCapacitor2.setLayoutX(390);
                newCapacitor2.setLayoutY(365);
                newwire1.setLayoutX(310);
                newwire1.setLayoutY(428);
                newwire2.setLayoutX(310);
                newwire2.setLayoutY(365);
                cc_pane.getChildren().addAll(newCapacitor, newCapacitor2, newwire1,newwire2);
                calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }
            else if (btnCount2 == 5) {
                newCapacitor.setLayoutX(210);
                newCapacitor.setLayoutY(428);
                newCapacitor2.setLayoutX(210);
                newCapacitor2.setLayoutY(365);
                newcircuitend.setRotate(180);
                newcircuitend.setLayoutX(110);
                newcircuitend.setLayoutY(397);

                cc_pane.getChildren().addAll(newCapacitor, newCapacitor2, newcircuitend);
                calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

            }
        }
    }
    else if (cc_comboBox.getSelectionModel().getSelectedItem().equals("End branch")) {
        ImageView newCircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
        ImageView newwire = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newcorner = new ImageView("file:src/View/Images/Corner1 Series.png");
        btnCount2++;
        split_circuit2 = false;
        cc_comboBox.getItems().remove(0);
        cc_comboBox.getItems().add(0, "Branch");
        cc_comboBox.setValue("Capacitor");

        if (btnCount2 == 2) {
            newwire2.setLayoutX(300);
            newwire2.setLayoutY(-33);
            newwire3.setLayoutX(300);
            newwire3.setLayoutY(25);
            newCircuitend.setLayoutX(375);
            newCircuitend.setLayoutY(-5);
            newwire.setLayoutX(450);
            newwire.setLayoutY(-5);
            newcorner.setLayoutX(550);
            newcorner.setLayoutY(20);
            cc_pane.getChildren().addAll(newCircuitend, newwire, newcorner, newwire2, newwire3);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                

        }
        else if (btnCount2 == 3) {
            newCircuitend.setRotate(90);
            newwire.setRotate(90);
            newwire2.setRotate(90);
            newcorner.setRotate(90);
            newCircuitend.setLayoutX(510);
            newCircuitend.setLayoutY(125);
            newwire.setLayoutX(510);
            newwire.setLayoutY(225);
            newwire2.setLayoutX(510);
            newwire2.setLayoutY(325);
            newcorner.setLayoutX(535);
            newcorner.setLayoutY(425);
            cc_pane.getChildren().addAll(newCircuitend, newwire, newwire2, newcorner);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                
        }
        else if (btnCount2 == 4) {
            newCircuitend.setRotate(180);
            newCircuitend.setLayoutX(390);
            newCircuitend.setLayoutY(395);
            newwire.setLayoutX(295);
            newwire.setLayoutY(400);
            cc_pane.getChildren().addAll(newCircuitend, newwire);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
            
            cc_comboBox.getItems().remove(0);
        }
        else if (btnCount2 == 5) {
            newCircuitend.setRotate(180);
            newCircuitend.setLayoutX(250);
            newCircuitend.setLayoutY(398);

            newwire2.setLayoutX(150);
            newwire2.setLayoutY(402);
            cc_pane.getChildren().addAll(newCircuitend, newwire2);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                
        }

    }
    else if (cc_comboBox.getSelectionModel().getSelectedItem().equals("Wire")) {
        if (!split_circuit2) {
            btnCount2++;
            ImageView newwire = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcorner1 = new ImageView("file:src/View/Images/Corner1 Series.png");
            ImageView newcorner2 = new ImageView("file:src/View/Images/Corner2 Series.png");
            if (btnCount2 == 1) {
                newwire.setLayoutX( 150 );
                newwire.setLayoutY( -5 );
                cc_pane.getChildren().addAll(newwire);
            }

            else if (btnCount2 == 2) {
                newwire.setLayoutX( 350 );
                newwire.setLayoutY( -5 );
                newcorner1.setLayoutX( 550 );
                newwire1.setLayoutX( 450 );
                newwire1.setLayoutY( -5 );
                newwire2.setLayoutX(250);
                newwire2.setLayoutY(-5);
                newcorner1.setLayoutY( 20);
                cc_pane.getChildren().addAll(newwire, newwire1,newwire2, newcorner1);

            }
            else if (btnCount2 == 3) {
                newwire.setRotate(90);
                newwire1.setRotate(90);
                newwire2.setRotate(90);
                newwire1.setLayoutX(525);
                newwire1.setLayoutY(70);
                newwire.setLayoutX( 525 );
                newwire.setLayoutY( 170 );
                newwire2.setLayoutX(525);
                newwire2.setLayoutY(270);
                newcorner2.setLayoutX(552);
                newcorner2.setLayoutY(370);
                cc_pane.getChildren().addAll(newwire, newwire1, newwire2, newcorner2);
            }else if (btnCount2 == 4) {
                newwire.setLayoutX(352);
                newwire.setLayoutY(405);
                newwire1.setLayoutX(451);
                newwire1.setLayoutY(405);
                cc_pane.getChildren().addAll(newwire, newwire1);
                cc_comboBox.getItems().remove(0);
            }
            else if (btnCount2 == 5) {
                newwire.setLayoutX(150);
                newwire.setLayoutY(405);
                newwire1.setLayoutX(251);
                newwire1.setLayoutY(405);
                cc_pane.getChildren().addAll(newwire, newwire1);
            }
        }
        else {
            btnCount2++;
            ImageView newwires = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwires2 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
            ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
            ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");

            ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
            ImageView newcircuitend = new ImageView("file:src/View/Images/CircuitSplitEnd.png");
            if (btnCount2 == 2) {
                newwire3.setLayoutX(300);
                newwire3.setLayoutY( -33);
                newwire4.setLayoutX(300);
                newwire4.setLayoutY( 25);
                newwires.setLayoutX( 375 );
                newwires.setLayoutY( -33 );

                newwires2.setLayoutX( 375 );
                newwires2.setLayoutY( 25 );

                newcornerp1.setLayoutX(475);
                newcornerp1.setLayoutY(70);

                newwire1.setLayoutX(475);
                newwire1.setLayoutY(-33);

                newcornerp2.setLayoutX(565);
                newcornerp2.setLayoutY(-8);

                newwire2.setLayoutX(540);
                newwire2.setLayoutY(28);

                newwire2.setRotate(90);
                cc_pane.getChildren().addAll(newwires, newwires2, newcornerp1, newwire1, newcornerp2, newwire2, newwire3, newwire4 );
            }
            else if (btnCount2 == 3) {
                newwire1.setRotate(90);
                newwire2.setRotate(90);
                newwire3.setRotate(90);
                newwire4.setRotate(90);
                newwires.setRotate(90);
                newwires2.setRotate(90);
                newcornerp1.setRotate(90);
                newcornerp2.setRotate(90);
                newwire1.setLayoutX(475);
                newwire1.setLayoutY(125);
                newwire2.setLayoutX(543);
                newwire2.setLayoutY(125);
                newwires.setLayoutX(475);
                newwires.setLayoutY(225);
                newwires2.setLayoutX(543);
                newwires2.setLayoutY(225);
                newwire4.setLayoutX(475);
                newwire4.setLayoutY(300);
                newwire3.setLayoutX(543);
                newwire3.setLayoutY(325);
                newcornerp1.setLayoutX(540);
                newcornerp1.setLayoutY(425);
                newcornerp2.setLayoutX(500);
                newcornerp2.setLayoutY(393);
                newwire5.setLayoutX(470);
                newwire5.setLayoutY(428);
                cc_pane.getChildren().addAll(newwire1, newwire2, newwires, newwires2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5);
            }
            else if (btnCount2 == 4) {
                newwires.setLayoutX(390);
                newwires.setLayoutY(428);
                newwires2.setLayoutX(390);
                newwires2.setLayoutY(365);
                newwire1.setLayoutX(310);
                newwire1.setLayoutY(428);
                newwire2.setLayoutX(310);
                newwire2.setLayoutY(365);
                cc_pane.getChildren().addAll(newwires, newwires2, newwire1,newwire2);
            }
            else if (btnCount2 == 5) {
                newwires.setLayoutX(210);
                newwires.setLayoutY(428);
                newwires2.setLayoutX(210);
                newwires2.setLayoutY(365);
                newcircuitend.setRotate(180);
                newcircuitend.setLayoutX(110);
                newcircuitend.setLayoutY(397);

                cc_pane.getChildren().addAll(newwires, newwires2, newcircuitend);
            }
        }
    }

    else {
        VBox copy1 = new VBox();
        VBox copy2 = new VBox();

        copy1.setSpacing(capacitorvb.getSpacing());
        copy1.setAlignment(capacitorvb.getAlignment());

        copy2.setSpacing(capacitorvb.getSpacing());
        copy2.setAlignment(capacitorvb.getAlignment());

        int number1 = counter2 + 1;
        int number2 = counter2 + 2;

        Label lbl1 = new Label("Capacitor #" + number1 + " Values:");
        Label lbl2 = new Label("Capacitor #" + number2 + " Values:");

        lbl1.setFont(((Label) capacitorvb.getChildren().get(0)).getFont());
        lbl2.setFont(((Label) capacitorvb.getChildren().get(0)).getFont());

        copy1.getChildren().add(lbl1);
        copy2.getChildren().add(lbl2);

        for (Node n : capacitorvb.getChildren()) {
            if (n instanceof Label original && !original.getText().startsWith("Capacitor #")) {
                Label clone1 = new Label(original.getText());
                Label clone2 = new Label(original.getText());

                clone1.setFont(original.getFont());
                clone1.setStyle(original.getStyle());
                clone1.setTextFill(original.getTextFill());

                clone2.setFont(original.getFont());
                clone2.setStyle(original.getStyle());
                clone2.setTextFill(original.getTextFill());

                copy1.getChildren().add(clone1);
                copy2.getChildren().add(clone2);
            }
            else if (n instanceof TextField originalTF) {
                TextField tf1 = new TextField("10.00");
                TextField tf2 = new TextField("10.00");

                tf1.setPromptText(originalTF.getPromptText());
                tf1.setPrefWidth(originalTF.getPrefWidth());
                tf1.setStyle(originalTF.getStyle());

                tf2.setPromptText(originalTF.getPromptText());
                tf2.setPrefWidth(originalTF.getPrefWidth());
                tf2.setStyle(originalTF.getStyle());

                copy1.getChildren().add(tf1);
                copy2.getChildren().add(tf2);
            }
            else if (n instanceof Line originalLine) {
                Line l1 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                        originalLine.getEndX(), originalLine.getEndY());
                Line l2 = new Line(originalLine.getStartX(), originalLine.getStartY(),
                        originalLine.getEndX(), originalLine.getEndY());

                l1.setStroke(originalLine.getStroke());
                l1.setStrokeWidth(originalLine.getStrokeWidth());
                l1.setStyle(originalLine.getStyle());

                l2.setStroke(originalLine.getStroke());
                l2.setStrokeWidth(originalLine.getStrokeWidth());
                l2.setStyle(originalLine.getStyle());

                copy1.getChildren().add(l1);
                copy2.getChildren().add(l2);
            }
        }

        ccSidebarVbox.getChildren().add(10 + counter2, copy1);
        ccSidebarVbox.getChildren().add(10 + counter2 + 1, copy2);

        ccvbs.add(copy1);
        ccvbs.add(copy2);

        counter2 += 2;
        btnCount2++;
        cc_comboBox.getItems().remove(0);
        cc_comboBox.getItems().add(0, "End branch");
        split_circuit2 = true;
        cc_comboBox.setValue("Capacitor");
        ImageView newcircuitSplit = new ImageView("file:src/View/Images/CircuitSplit.png");
        ImageView newCapacitor = new ImageView("file:src/View/Images/Capacitor.png");
        ImageView newCapacitor2 = new ImageView("file:src/View/Images/Capacitor.png");
        ImageView newwire1 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newcornerp1 = new ImageView("file:src/View/Images/Corner1 parallel.png");
        ImageView newcornerp2 = new ImageView("file:src/View/Images/Corner1 Series.png");
        ImageView newwire2 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire3 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire4 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire5 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire6 = new ImageView("file:src/View/Images/Wire.png");
        ImageView newwire7 = new ImageView("file:src/View/Images/Wire.png");

        if (btnCount2 == 1) {
            newcircuitSplit.setLayoutX( 125 );
            newcircuitSplit.setLayoutY( -5 );
            newCapacitor.setLayoutX( 225 );
            newCapacitor.setLayoutY( -33);
            newCapacitor2.setLayoutX( 225 );
            newCapacitor2.setLayoutY( 25);
            cc_pane.getChildren().addAll(newcircuitSplit, newCapacitor, newCapacitor2);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        }
        else if (btnCount2 == 2) {
            newwire3.setLayoutX(220);
            newwire3.setLayoutY(-5);

            newcircuitSplit.setLayoutX(285);
            newcircuitSplit.setLayoutY(-5);
            newCapacitor.setLayoutX( 385 );
            newCapacitor.setLayoutY( -33);

            newCapacitor2.setLayoutX( 385 );
            newCapacitor2.setLayoutY( 25);
            newcornerp1.setLayoutX(475);
            newcornerp1.setLayoutY(70);

            newwire1.setLayoutX(485);
            newwire1.setLayoutY(-33);

            newcornerp2.setLayoutX(570);
            newcornerp2.setLayoutY(-8);

            newwire2.setLayoutX(545);
            newwire2.setLayoutY(28);

            newwire2.setRotate(90);
            cc_pane.getChildren().addAll(newwire3, newcircuitSplit, newCapacitor, newCapacitor2, newwire1, newwire2, newcornerp1, newcornerp2);
            calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        }
        else if (btnCount2 == 3) {
            newcircuitSplit.setRotate(90);
            newcircuitSplit.setLayoutX(525);
            newcircuitSplit.setLayoutY(65);
            newwire1.setRotate(90);
            newwire2.setRotate(90);
            newwire3.setRotate(90);
            newwire4.setRotate(90);
            newCapacitor.setRotate(90);
            newCapacitor2.setRotate(90);
            newcornerp1.setRotate(90);
            newcornerp2.setRotate(90);
            newwire1.setLayoutX(495);
            newwire1.setLayoutY(125);
            newwire2.setLayoutX(553);
            newwire2.setLayoutY(125);
            newCapacitor.setLayoutX(495);
            newCapacitor.setLayoutY(225);
            newCapacitor2.setLayoutX(553);
            newCapacitor2.setLayoutY(225);
            newwire4.setLayoutX(495);
            newwire4.setLayoutY(300);
            newwire3.setLayoutX(553);
            newwire3.setLayoutY(325);
            newcornerp1.setLayoutX(550);
            newcornerp1.setLayoutY(425);
            newcornerp2.setLayoutX(520);
            newcornerp2.setLayoutY(393);
            newwire5.setLayoutX(508);
            newwire5.setLayoutY(428);
            newwire6.setLayoutX(480);
            newwire6.setLayoutY(428);
            newwire7.setLayoutX(450);
            newwire7.setLayoutY(368);

            cc_pane.getChildren().addAll(newcircuitSplit, newwire1, newwire2, newCapacitor, newCapacitor2,  newwire3, newwire4, newcornerp1, newcornerp2, newwire5, newwire6, newwire7);
        calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        
        }
        else if (btnCount2 == 4) {
            newcircuitSplit.setRotate(180);
            newcircuitSplit.setLayoutX(453);
            newcircuitSplit.setLayoutY(405);
            newCapacitor.setLayoutX(353);
            newCapacitor.setLayoutY(375);
            newCapacitor2.setLayoutX(353);
            newCapacitor2.setLayoutY(433);
            newwire1.setLayoutX(280);
            newwire1.setLayoutY(370);
            newwire2.setLayoutX(280);
            newwire2.setLayoutY(430);
            cc_pane.getChildren().addAll(newcircuitSplit, newCapacitor, newCapacitor2, newwire1, newwire2);
       calcCircuitcustom2[counter2] = new CircuitSplit(0,0);
                calcCircuitcustom2[counter2+1] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);
                calcCircuitcustom2[counter2+2] = new Capacitor(Double.parseDouble(((TextField)ccvbs.get(counter1-1).getChildren().get(2)).getText()), 0, 0);

        }

    }
}
        else {
            Label lbl = new Label("unable to add anymore components");
            ccSidebarVbox.getChildren().add(9, lbl);
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
        calcResistance(calcCircuitcustom1, calcCircuitcustom1.length, 0, false, 0, 0);
        for(int i = 0; i < counter1;i++) {
          if (calcCircuitcustom1[i] instanceof Resistor) {
            ((Label)rcvbs.get(i).getChildren().get(3)).setText("Voltage: " + calcCircuitcustom1[i].getVoltage());
            ((Label)rcvbs.get(i).getChildren().get(4)).setText("Current: " + ((Resistor)calcCircuitcustom1[i]).getCurrent());
        }  
        }
        
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
        calcCapacitance(calcCircuitcustom2, calcCircuitcustom1.length, 0, false, 0, 0);
      for(int i = 0; i < counter2;i++) {
          if (calcCircuitcustom2[i] instanceof Capacitor) {
            ((Label)ccvbs.get(i).getChildren().get(3)).setText("Voltage: " + calcCircuitcustom2[i].getVoltage());
            ((Label)ccvbs.get(i).getChildren().get(4)).setText("Charge: " + ((Capacitor)calcCircuitcustom2[i]).getCharge());
        }  
        }
    }

    @FXML
    private void ccClearBtnPrssed(ActionEvent event) {
        b6_tf.setText("10.00");
        b6_slider.setValue(0);
        for(int i = 0; i < counter2;i++) {
            ((TextField)ccvbs.get(i).getChildren().get(2)).setText("10.00");
    }
    }
    
    

/**
     * Calculates the resistance of a circuit with resistors
     * @param calcCircuit the array of the CircuitElement objects
     * @param circuitSize the length of the calcCircuit array that is being looked at (should be calcCircuit.length on call)
     * @param finalResistance the final resistance of all previous circuit elements (set to 0 on call)
     * @param isSplit which path of a split the method is looking at (set to false on call)
     * @param splitResistance the resistance of a split path (set to 0 on call)
     * @param splitIdx the index at which a split ends (set to 0 on call)
     */
    public void calcResistance(CircuitElement[] calcCircuit, int circuitSize, double finalResistance, boolean isSplit, double splitResistance, int splitIdx) {
        double store;
        if (calcCircuit[circuitSize - 1] == null) {
            calcResistance(calcCircuit, circuitSize - 1, finalResistance, isSplit, splitResistance, splitIdx);
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
                    ((CircuitSplit) calcCircuit[circuitSize - 3]).setVoltage(calcCircuit[circuitSize - 1].getVoltage());
                    ((Resistor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit) calcCircuit[circuitSize - 3]).getVoltage());
                }
                //if 3rd to next element is a resistor
                else if (calcCircuit[circuitSize - 3] instanceof Resistor) {
                    double equResistor = ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                    calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, equResistor, circuitSize - 1);
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
                    //equiResistor here equals to the 1/Req = 1/R1 + 1/R2
                    double equResistor;
                    if (splitResistance != 0) {
                        equResistor = Math.pow((1/((Resistor)calcCircuit[circuitSize - 2]).getResistance() + 1/splitResistance), -1);
                        finalResistance += equResistor;
                    }
                    else {
                        equResistor = Math.pow((1/((Resistor)calcCircuit[circuitSize - 2]).getResistance() + 1/((CircuitSplit)calcCircuit[splitIdx]).getTotal()), -1);
                        finalResistance += equResistor;
                    }
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
                ((Resistor)calcCircuit[circuitSize - 2]).setResistance(store);
                ((Resistor) calcCircuit[circuitSize - 2]).setCurrent(((Resistor) calcCircuit[circuitSize - 2]).getVoltage() / ((Resistor) calcCircuit[circuitSize - 2]).getResistance());
            }
        }
        //if the next element is a resistor
        else {
            store = ((Resistor) calcCircuit[circuitSize - 1]).getResistance();
            if (circuitSize == calcCircuit.length) finalResistance = store;
            //if resistor is part of a circuit split
            if (splitResistance != 0 || isSplit == true) {
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(splitResistance + store);
                //if there is another resistor in the split
                if(calcCircuit[circuitSize - 2] instanceof Resistor) {
                    splitResistance += store;
                    
                    calcResistance(calcCircuit, circuitSize - 1, finalResistance, isSplit, splitResistance, splitIdx);                
                    ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((Resistor)calcCircuit[circuitSize - 2]).getCurrent());
                    ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                    ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
                }
                //if this is part of the first split
                else if (isSplit == false) {
                    splitResistance += store;
                    ((CircuitSplit)calcCircuit[splitIdx]).setTotal(splitResistance);
                    calcResistance(calcCircuit, circuitSize - 2, finalResistance, true, 0, splitIdx);
                    ((CircuitSplit)calcCircuit[circuitSize - 2]).setVoltage(calcCircuit[splitIdx].getVoltage());
                    ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((CircuitSplit) calcCircuit[circuitSize - 2]).getVoltage() / splitResistance);
                    ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                    ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor)calcCircuit[circuitSize - 1]).getResistance());
                    
                }
                //if this resistor is part of the 2nd split
                else {
                    splitResistance += store;
                    double equResistor = Math.pow((1/((CircuitSplit)calcCircuit[splitIdx]).getTotal() + 1/splitResistance), -1);
                        finalResistance += equResistor;
                        //if the component after the circuit split is a resistor
                        if (calcCircuit[circuitSize - 3] instanceof Resistor) {
                            finalResistance += ((Resistor) calcCircuit[circuitSize - 3]).getResistance();
                            calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage() / finalResistance * equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(calcCircuit[splitIdx].getVoltage() / splitResistance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor)calcCircuit[circuitSize - 1]).getResistance());
                        }
                        //if the componenent after the circuit split is another circuit split
                        else if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                            calcResistance(calcCircuit, circuitSize - 2, finalResistance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage() / finalResistance * equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(calcCircuit[splitIdx].getVoltage() / splitResistance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor)calcCircuit[circuitSize - 1]).getResistance());
                        }
                        //if the component after the circuit split is the battery
                        else {
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[0].getVoltage() / finalResistance * equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(calcCircuit[splitIdx].getVoltage() / splitResistance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equResistor);
                            ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                            ((Resistor) calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor)calcCircuit[circuitSize - 1]).getResistance());
                        }
                }
            }
            //if the 2nd to next element is a resistor
            else if (calcCircuit[circuitSize - 2] instanceof Resistor) {
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(finalResistance);
                double equResistor = ((Resistor)calcCircuit[circuitSize - 1]).getResistance() + ((Resistor)calcCircuit[circuitSize - 2]).getResistance();
                calcResistance(calcCircuit, circuitSize - 1, equResistor, isSplit, splitResistance, splitIdx);
                ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((Resistor)calcCircuit[circuitSize - 2]).getCurrent());
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
            }
            //if the 2nd to next element is a circuitSplit
            else {
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(finalResistance);
                calcResistance(calcCircuit, circuitSize - 1, finalResistance, isSplit, splitResistance, splitIdx);
                ((Resistor)calcCircuit[circuitSize - 1]).setCurrent(((CircuitSplit)calcCircuit[circuitSize - 2]).getVoltage() / ((CircuitSplit)calcCircuit[circuitSize - 2]).getTotal());
                ((Resistor)calcCircuit[circuitSize - 1]).setResistance(store);
                ((Resistor)calcCircuit[circuitSize - 1]).setVoltage(((Resistor)calcCircuit[circuitSize - 1]).getCurrent() * ((Resistor) calcCircuit[circuitSize - 1]).getResistance());
            }
        }
    }   



/**
     * Calculates the capacitance and charge of each element in a circuit of capacitors
     * @param calcCircuit the array of the CircuitElement objects
     * @param circuitSize the length of the calcCircuit array that is being looked at (should be calcCircuit.length on call)
     * @param finalCapacitance the final capacitance of all previous circuit elements (set to 0 on call)
     * @param isSplit which path of a split the method is looking at (set to false on call)
     * @param splitCapacitance the capacitance of a split path (set to 0 on call)
     * @param splitIdx the index at which a split ends (set to 0 on call)
     */
    public void calcCapacitance(CircuitElement[] calcCircuit, int circuitSize, double finalCapacitance, boolean isSplit, double splitCapacitance, int splitIdx) {
        double store;
        if (circuitSize == 2) {
            store = ((Capacitor) calcCircuit[circuitSize - 1]).getCapacitance();
            ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(finalCapacitance);
            ((Capacitor)calcCircuit[1]).setCharge(calcCircuit[0].getVoltage() * ((Capacitor) calcCircuit[1]).getCapacitance());
            ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
            ((Capacitor)calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor) calcCircuit[1]).getCapacitance());
        }
        //if next circuitElement is a split
        else if (calcCircuit[circuitSize - 1] instanceof CircuitSplit) {
            //if 2nd to next Circuit element is a capacitor and if this is 1st split path
            if (calcCircuit[circuitSize - 2] instanceof Capacitor & isSplit == false) {
                store = ((Capacitor) calcCircuit[circuitSize - 2]).getCapacitance();
                //if 3rd to next element is the end of the 1st split
                if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                    double equCapacitor = ((Capacitor)calcCircuit[circuitSize - 2]).getCapacitance();
                    calcCapacitance(calcCircuit, circuitSize - 2, finalCapacitance, true, equCapacitor, circuitSize - 1);
                    ((CircuitSplit) calcCircuit[circuitSize - 3]).setVoltage(calcCircuit[circuitSize - 1].getVoltage());
                    ((Capacitor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit) calcCircuit[circuitSize - 3]).getVoltage());
                }
                //if 3rd to next element is a capacitor
                else if (calcCircuit[circuitSize - 3] instanceof Capacitor) {
                    double equCapacitor = ((Capacitor)calcCircuit[circuitSize - 2]).getCapacitance();
                    calcCapacitance(calcCircuit, circuitSize - 2, finalCapacitance, false, equCapacitor, circuitSize - 1);
                    ((Capacitor) calcCircuit[circuitSize - 2]).setVoltage(((Capacitor)calcCircuit[circuitSize - 3]).getVoltage());
                }
                else {
                    finalCapacitance = Math.pow(1/finalCapacitance + 1/splitCapacitance, -1);
                    calcCapacitance(calcCircuit, circuitSize - 1, finalCapacitance, false, 0, splitIdx);                                 
                }
                ((Capacitor)calcCircuit[circuitSize - 2]).setCapacitance(store);
                ((Capacitor)calcCircuit[circuitSize - 2]).setCharge(((Capacitor)calcCircuit[circuitSize - 2]).getVoltage() * ((Capacitor) calcCircuit[circuitSize - 2]).getCapacitance());
                
                
            }
            //if 2nd to next element is a capacitor and this is the 2nd split path
            else if (calcCircuit[circuitSize - 2] instanceof Capacitor){
                store = ((Capacitor) calcCircuit[circuitSize - 2]).getCapacitance();
                //if 3rd to next element is the end of the second split
                if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                    double equCapacitor;
                        equCapacitor = (((Capacitor)calcCircuit[circuitSize - 2]).getCapacitance() + splitCapacitance);
                        finalCapacitance += equCapacitor;
                    //if the component after the circuit split is a capacitor
                    if (calcCircuit[circuitSize - 4] instanceof Capacitor) {
                        finalCapacitance = Math.pow(1/finalCapacitance + 1/((Capacitor) calcCircuit[circuitSize - 4]).getCapacitance(), -1);
                        calcCapacitance(calcCircuit, circuitSize - 3, finalCapacitance, false, 0, 0);
                        ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                        ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((Capacitor)calcCircuit[circuitSize - 4]).getCharge() / equCapacitor);
                        ((Capacitor) calcCircuit[circuitSize - 2]).setVoltage(((Capacitor)calcCircuit[circuitSize - 4]).getCharge() / equCapacitor);
                    }
                    //if the componenent after the circuit split is another circuit split
                    else if (calcCircuit[circuitSize - 4] instanceof CircuitSplit) {
                        calcCapacitance(calcCircuit, circuitSize - 3, finalCapacitance, false, 0, 0);
                        ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                        ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 4]).getVoltage() * ((CircuitSplit)calcCircuit[circuitSize - 4]).getTotal() / equCapacitor);
                        ((Capacitor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit)calcCircuit[circuitSize - 4]).getVoltage());
                    }
                    //if the component after the circuit split is the battery
                    else {
                        ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                        ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 4].getVoltage() * finalCapacitance / equCapacitor);
                        ((Capacitor) calcCircuit[circuitSize - 2]).setVoltage(((CircuitSplit)calcCircuit[splitIdx]).getVoltage());
                    }
                        
                    
                }
                
                ((Capacitor)calcCircuit[circuitSize - 2]).setCapacitance(store);
                ((Capacitor) calcCircuit[circuitSize - 2]).setCharge(((Capacitor) calcCircuit[circuitSize - 2]).getVoltage() * ((Capacitor) calcCircuit[circuitSize - 2]).getCapacitance());
            }
        }
        //if the next element is a Capacitor
        else {
            store = ((Capacitor) calcCircuit[circuitSize - 1]).getCapacitance();
            if (circuitSize == calcCircuit.length) finalCapacitance = store;
            //if Capacitor is part of a circuit split
            if (splitCapacitance != 0 || isSplit == true) {
                ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(Math.pow(1/splitCapacitance + 1/store, -1));
                //if there is another Capacitor in the split
                if(calcCircuit[circuitSize - 2] instanceof Capacitor) {
                    splitCapacitance = Math.pow(1/splitCapacitance + 1/store, -1);
                    
                    calcCapacitance(calcCircuit, circuitSize - 1, finalCapacitance, isSplit, splitCapacitance, splitIdx);                
                    ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(((Capacitor)calcCircuit[circuitSize - 2]).getCharge());
                    ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                    ((Capacitor)calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor) calcCircuit[circuitSize - 1]).getCapacitance());
                }
                //if this is part of the first split
                else if (isSplit == false) {
                    splitCapacitance = Math.pow(1/splitCapacitance + 1/store, -1);
                    ((CircuitSplit)calcCircuit[splitIdx]).setTotal(splitCapacitance);
                    calcCapacitance(calcCircuit, circuitSize - 2, finalCapacitance, true, 0, splitIdx);
                    ((CircuitSplit)calcCircuit[circuitSize - 2]).setVoltage(calcCircuit[splitIdx].getVoltage());
                    ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(((CircuitSplit) calcCircuit[circuitSize - 2]).getVoltage() * splitCapacitance);
                    ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                    ((Capacitor)calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor)calcCircuit[circuitSize - 1]).getCapacitance());
                    
                }
                //if this Capacitor is part of the 2nd split
                else {
                    splitCapacitance = Math.pow(1/splitCapacitance + 1/store, -1);
                    double equCapacitor = ((CircuitSplit)calcCircuit[splitIdx]).getTotal() + splitCapacitance;
                        finalCapacitance = Math.pow(1/ finalCapacitance + 1/equCapacitor, -1);
                        //if the component after the circuit split is a Capacitor
                        if (calcCircuit[circuitSize - 3] instanceof Capacitor) {
                            finalCapacitance = Math.pow(1/finalCapacitance + 1/((Capacitor) calcCircuit[circuitSize - 3]).getCapacitance(), -1);
                            calcCapacitance(calcCircuit, circuitSize - 2, finalCapacitance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage() * finalCapacitance / equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(calcCircuit[splitIdx].getVoltage() * splitCapacitance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                            ((Capacitor) calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor)calcCircuit[circuitSize - 1]).getCapacitance());
                        }
                        //if the componenent after the circuit split is another circuit split
                        else if (calcCircuit[circuitSize - 3] instanceof CircuitSplit) {
                            calcCapacitance(calcCircuit, circuitSize - 2, finalCapacitance, false, 0, splitIdx);
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[circuitSize - 3].getVoltage() * finalCapacitance / equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(calcCircuit[splitIdx].getVoltage() * splitCapacitance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                            ((Capacitor) calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor)calcCircuit[circuitSize - 1]).getCapacitance());
                        }
                        //if the component after the circuit split is the battery
                        else {
                            ((CircuitSplit) calcCircuit[splitIdx]).setVoltage(calcCircuit[0].getVoltage() * finalCapacitance / equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(calcCircuit[splitIdx].getVoltage() * splitCapacitance);
                            ((CircuitSplit) calcCircuit[splitIdx]).setTotal(equCapacitor);
                            ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                            ((Capacitor) calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor)calcCircuit[circuitSize - 1]).getCapacitance());
                        }
                }
            }
            //if the 2nd to next element is a Capacitor
            else if (calcCircuit[circuitSize - 2] instanceof Capacitor) {
                ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(finalCapacitance);
                double equCapacitor = Math.pow(1/((Capacitor)calcCircuit[circuitSize - 1]).getCapacitance() + 1/((Capacitor)calcCircuit[circuitSize - 2]).getCapacitance(), -1);
                calcCapacitance(calcCircuit, circuitSize - 1, equCapacitor, isSplit, splitCapacitance, splitIdx);
                ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(((Capacitor)calcCircuit[circuitSize - 2]).getCharge());
                ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                ((Capacitor)calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor) calcCircuit[circuitSize - 1]).getCapacitance());
            }
            //if the 2nd to next element is a circuitSplit
            else {
                ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(finalCapacitance);
                calcCapacitance(calcCircuit, circuitSize - 1, finalCapacitance, isSplit, splitCapacitance, splitIdx);
                ((Capacitor)calcCircuit[circuitSize - 1]).setCharge(((CircuitSplit)calcCircuit[circuitSize - 2]).getVoltage() * ((CircuitSplit)calcCircuit[circuitSize - 2]).getTotal());
                ((Capacitor)calcCircuit[circuitSize - 1]).setCapacitance(store);
                ((Capacitor)calcCircuit[circuitSize - 1]).setVoltage(((Capacitor)calcCircuit[circuitSize - 1]).getCharge() / ((Capacitor) calcCircuit[circuitSize - 1]).getCapacitance());
            }
        }
    }  
    
}
