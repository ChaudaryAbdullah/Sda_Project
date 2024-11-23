package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.DB.Utility;
import com.BussinessLogic.classes.Owner;
import com.example.App;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpController {

      @FXML
    private Button SignUpButton;

    @FXML
    private TextField addressTextField;

    @FXML
    private AnchorPane backgroundpane;

    @FXML
    private TextField dobTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField userNameTextField;

    @FXML
    void SignUpButton_Clicked(ActionEvent event) {
        // Collect data from text fields
        String userName = userNameTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String dob = dobTextField.getText();
        String password = passwordTextField.getText();
        String address = addressTextField.getText(); 

        // Validation
        if (userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || password.isEmpty() || address.isEmpty()) {
            System.err.println("All fields are required!");
            Utility uti = new Utility();
            uti.clearTextFields(backgroundpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid input.");
            alert.showAndWait();
            return;
        }

        Utility util = new Utility();
        if(util.addUser(userName, firstName, lastName, dob, password, address)){
            System.out.println("Sign-up successful!");
        }
        else {
            Utility uti = new Utility();
            uti.clearTextFields(backgroundpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid username & password.");
            alert.showAndWait();
            Error err=new Error("Sign-up failed!");
            throw err;
        }
    
    }

    @FXML
    void loginLink_Clicked(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    

}
