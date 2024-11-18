package com.example;

import java.io.IOException;

import com.classes.Owner;
import com.classes.Utility;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private Button SignUpButton;

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
    private TextField phoneNoTextField;

    @FXML
    void SignUpButton_Clicked(ActionEvent event) {
        // Collect data from text fields
        String userName = phoneNoTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String dob = dobTextField.getText();
        String password = passwordTextField.getText();
        String address = "Sample Address"; // You can add another text field for the address

        // Validation
        if (userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        // Create Owner object
        // Owner owner = new Owner();
        // owner.setUserName(userName);
        // owner.setFirstName(firstName);
        // owner.setLastName(lastName);
        // owner.setDob(dob);
        // owner.setPassword(password);
        // owner.setAddress(address);

        // Pass Owner object to DAO for insertion
        Utility util = new Utility();
        boolean isInserted = util.addUser(userName, firstName, lastName, dob, password, address);

        if (isInserted) {
            System.out.println("Sign-up successful!");
        } else {
            System.out.println("Sign-up failed!");
        }
    
    }

    @FXML
    void loginLink_Clicked(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    

}
