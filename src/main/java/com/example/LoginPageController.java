package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class LoginPageController {

    @FXML
    private CheckBox RememberMeButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Hyperlink signUpUrl;

    @FXML
    private TextField userNameTextField;

    @FXML
    void RememberMeButton_Clicked(ActionEvent event) {

    }

    @FXML
    void loginButton_Clicked(ActionEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void signUpUrl_Clicked(ActionEvent event) {
        try {
            App.setRoot("SignUp");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
