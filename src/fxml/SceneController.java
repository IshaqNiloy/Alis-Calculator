/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ali's Corporation
 */
public class SceneController implements Initializable {
    String currentOperation;
    private float result;
    private float currentNumber;
    @FXML
    private Label displayField;
    int flag = 0;
    int flag1 = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDigitAction(ActionEvent event) {
        if(flag == 0){
            displayField.setText("");
            flag++;
            String digit = ((Button) event.getSource()).getText();
            String oldText = displayField.getText();
            String newText = oldText + digit;
            displayField.setText(newText);
            flag1 = 0;

        }else{
            String digit = ((Button) event.getSource()).getText();
            String oldText = displayField.getText();
            String newText = oldText + digit;
            displayField.setText(newText);
            flag1 = 0;
        }
    }

    @FXML
    private void handleOperation(ActionEvent event) {
        String currentText = displayField.getText();
        currentNumber = Float.parseFloat(currentText);
        currentOperation = ((Button) event.getSource()).getText();
        displayField.setText("");
        flag1 = 0;
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
        String newText = displayField.getText();
        float newNumber = Float.parseFloat(newText);
        if(currentOperation.equals("+")){
            result = currentNumber + newNumber;
            displayField.setText("" + result);
        }else if(currentOperation.equals("-")){
            result = currentNumber - newNumber;
            displayField.setText("" + result);
        }else if(currentOperation.equals("X")){
            result = currentNumber * newNumber;
            displayField.setText("" + result);
        }else if(currentOperation.equals("/")){
            result = currentNumber / newNumber;
            displayField.setText("" + result);
        }else if(currentOperation.equals("C")){
            displayField.setText("");
        }
        flag = 0;
        flag1 = 1;
    }

    @FXML
    private void handlePlusMinusOperation(ActionEvent event) {
        result = Float.parseFloat(displayField.getText()) * (-1);
            displayField.setText("" + result);
            flag = 0;
    }

    @FXML
    private void handleRootOperation(ActionEvent event) {
        result =(float) Math.pow(Float.parseFloat(displayField.getText()), 0.5);
        displayField.setText ("" + result);
    }

    @FXML
    private void handleDotOperation(ActionEvent event) {
        if(flag1 == 0){
            String digit = ((Button) event.getSource()).getText();
            String oldText = displayField.getText();
            String newText = oldText + digit;
            displayField.setText(newText);
            flag1 = 1 ;
        }
    }
    
}













