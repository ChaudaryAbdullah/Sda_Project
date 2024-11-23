package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.classes.User;
import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DashBoardController {

    @FXML
    private TableView<?> DashboardTable;
    
    @FXML
    private ImageView DashbordLogo;

    @FXML
    private ImageView HomeLogo;

    @FXML
    private Hyperlink HomeUrl1;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Button paymentButton;

    @FXML
    private Pane backgroundpane;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink ownedurl;

    @FXML
    private Hyperlink rentedurl;

    @FXML
    private Text dobText;
    
    @FXML
    private Text nameText;
    
    @FXML
    private Text usernameText;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }

    @FXML
    public void initialize() {
        nameText.setText(user.getFirstname()+' '+user.getLastname());
        dobText.setText(user.getDob());
        usernameText.setText(user.getUsername());
    }

     @FXML
    void DashbordLogo_clicked(MouseEvent event) throws IOException {
        App.setRoot("Dashboard");
    }
    
    @FXML
    void DashboardTable_sort(ActionEvent event) {

    }

    @FXML
    void HomeUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) {

    }

    @FXML
    void homeLogo_Clicked(MouseEvent event) throws IOException {
        App.setRoot("HomePage");
    }


    @FXML
    void ownedurl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("owned");
    }

    @FXML
    void rentedurl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("Rented");
    }

}
