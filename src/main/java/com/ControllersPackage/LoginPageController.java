package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.*;
import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;



public class LoginPageController {

    @FXML
    private CheckBox RememberMeButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Hyperlink signUpUrl;

    @FXML
    private TextField userNameTextField;

    @FXML
    public AnchorPane backgroundpane;
    
    @FXML
    private Rectangle mainPane;

    @FXML
    void RememberMeButton_Clicked(ActionEvent event) {

    }

    @FXML
    void loginButton_Clicked(ActionEvent event) throws IOException {
        Utility util=new Utility();
        User state=util.getUser(userNameTextField.getText(),passwordTextField.getText());
        HomePageController.setUser(state);
        if(state!=null){
            App.setRoot("HomePage");
        }
        else{
            Utility uti = new Utility();
            uti.clearTextFields(backgroundpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid username & password.");
            alert.showAndWait();
        }
        
      
           
      
    }

    @FXML
    void signUpUrl_Clicked(ActionEvent event) {
        try {
            App.setRoot("SignUp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
