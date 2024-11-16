package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterHostelController {

    @FXML
    private ImageView DashbordLogo;

    @FXML
    private ImageView HomeLogo;

    @FXML
    private Hyperlink HomeUrl1;

    @FXML
    private Hyperlink MealUrl_Clicked;

    @FXML
    private Hyperlink MenuUrl;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField availRoomsTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private TextField facilitiesTxtField;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private Hyperlink finesUrl;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private AnchorPane mainscene;

    @FXML
    private Hyperlink maintainanceUrl;

    @FXML
    private Pane menupane;

    @FXML
    private MenuButton parkingAvailableMenu;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    @FXML
    private TextField totalRoomsTextField;

     @FXML
    void DashbordLogo_clicked(MouseEvent event) throws IOException {
        App.setRoot("Dashboard");
    }

    @FXML
    void HomeUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void MealUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("");
    }

    @FXML
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("addMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) {

    }

    @FXML
    void addressTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void availRoomsTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void cityTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void evictionUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("Eviction");
    }

    @FXML
    void facilitiesTxtFieldclicked(ActionEvent event) {

    }

    @FXML
    void feedbackUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("ReviewFeedback");
    }

    @FXML
    void finesUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("FinesOwner");
    }

    @FXML
    void homeLogo_Clicked(MouseEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void maintainanceUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("MaintainanceOwner");
    }

    @FXML
    void parkingAvailableMenuClicked(ActionEvent event) {

    }

    @FXML
    void parkingUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("AllocateParking");
    }

    @FXML
    void registerUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("RegisterHostel");
    }

    @FXML
    void returnButton1Clicked(ActionEvent event) {

    }

    @FXML
    void totalRoomsTextFieldClicked(ActionEvent event) {

    }

}
