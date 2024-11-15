package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DashBoardController {

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
    void DashbordLogo_clicked(MouseEvent event) throws IOException {
        App.setRoot("Dashboard");
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
