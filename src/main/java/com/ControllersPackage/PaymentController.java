package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.User;
import com.HandlersPackage.PaymentHandler;
import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PaymentController {

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
    private Label amountHere;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Label evictionlabel;

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
    private ComboBox<String> methodComboBox;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Button payButton;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
    int amount;

    public void initialize() {
        //add the applicants after merged
        PaymentHandler pay = new PaymentHandler();
        methodComboBox.getItems().addAll(
            "Cash",
            "Credit",
            "Debit"
        );
        amount = pay.calculateRent(user.getID());
        String numberString = String.valueOf(amount);
        amountHere.setText(numberString);

    }

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
        App.setRoot("SelectMealsTenant");
    }

    @FXML
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("SelectMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        HomePageController.setSearchData=SearchTextField.getText();
        App.setRoot("HomePage");

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
    void methodComboBox_Clicked(ActionEvent event) {

    }

    @FXML
    void parkingUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("RequestParking");
    }

    @FXML
    void payButton_Clicked(ActionEvent event) {
        if(methodComboBox.getSelectionModel().getSelectedItem()==null)
        {   
            System.err.println("All fields are required!");
            Utility uti = new Utility();
            uti.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid input.");
            alert.showAndWait();
            return;
        }
        
        int total = amount;
        String method = (String) methodComboBox.getSelectionModel().getSelectedItem();
        PaymentHandler pay = new PaymentHandler();
        pay.processPayment(user.getID(), method, total);
    }

    @FXML
    void registerUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("ChooseRental");
    }

    @FXML
    void returnButton1Clicked(ActionEvent event) throws IOException {
        App.setRoot("Rented");
    }

}
