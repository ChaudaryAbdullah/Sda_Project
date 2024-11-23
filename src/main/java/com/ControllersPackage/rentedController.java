package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.loadDataPackage.LoadData;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class rentedController {

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
    private AnchorPane backgroundpane;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private Hyperlink finesUrl;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private Hyperlink maintainanceUrl;

    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private TableView<String> rentedTable;

    public static User user = null;

    @FXML
    private Button paymentButton;

    public static void setUser(User u){
        user = u;
    }

    public void initialize() {
        //add the applicants after merged

        LoadData util=new LoadData();        
        rentedTable=util.loadRenterData(rentedTable,user.getID());

    }
    @FXML
    void DashbordLogo_clicked(MouseEvent event) throws IOException {
        App.setRoot("Dashboard");
    }

    @FXML
    void paymentButton_Clicked(ActionEvent event) throws IOException {
        App.setRoot("payment");
    }


    @FXML
    void HomeUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void MealUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("SelectMealsTenant");
    }

    @FXML
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("SelectMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        
    }

    @FXML
    void evictionUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("EvictionTenant");
    }

    @FXML
    void feedbackUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("GiveFeedback");
    }

    @FXML
    void finesUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("FinesTenant");
    }

    @FXML
    void homeLogo_Clicked(MouseEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    void maintainanceUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("MaintainanceTenant");
    }

    @FXML
    void parkingUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("RequestParking");
    }

    @FXML
    void registerUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("ChooseRental");
    }

    @FXML
    void rentedTableSort(ActionEvent event) {

    }

}

