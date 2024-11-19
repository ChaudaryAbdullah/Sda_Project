package com.example;

import java.io.IOException;

import com.classes.Owner;
import com.classes.Utility;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
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
        String address = addressTextField.toString(); 

        // Validation
        if (userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || password.isEmpty() || address.isEmpty()) {
            System.err.println("All fields are required!");
            return;
        }

        Utility util = new Utility();
        if(util.addUser(userName, firstName, lastName, dob, password, address)){
            System.out.println("Sign-up successful!");
        }
        else {
            Error err=new Error("Sign-up failed!");
            throw err;
        }
    
    }

    @FXML
    void loginLink_Clicked(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    

}
