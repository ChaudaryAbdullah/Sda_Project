package com.example;

import java.io.IOException;
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

    }

    @FXML
    void loginLink_Clicked(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    

}
