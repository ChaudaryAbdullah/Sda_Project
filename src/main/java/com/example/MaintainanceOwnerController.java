package com.example;

import java.io.IOException;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.classes.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MaintainanceOwnerController {

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
    private ComboBox<String> changestatuscombobox;

    @FXML
    private TextField costfield;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private TextField maintainceDescription;

    @FXML
    private Hyperlink finesUrl;

    @FXML
    private Label fineslabel;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private Hyperlink maintainanceUrl;

    @FXML
    private TableView<String> maintaincetable;

    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    @FXML
    private ComboBox<String> selectmaintainanceComboBox;

    @FXML
    private ComboBox<String> selectrentalComboBox;

    @FXML
    private Button RegisterNew;

    @FXML
    private Button updateStatus;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }

    public void initialize() {
        //add the applicants after merged
        changestatuscombobox.getItems().addAll(
            "Completed",
            "Ongoing"
        );

        LoadData util=new LoadData();        
        maintaincetable=util.loadMaintainanceData(maintaincetable,user.getID());

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
        App.setRoot("");
    }

    @FXML
    void RegisterNewClicked(ActionEvent event) {
        String selectedData = (String) selectmaintainanceComboBox.getSelectionModel().getSelectedItem();
        String maintainceString = maintainceDescription.getText();
        int rentalId =0;
        if (selectedData != null) {
            try {
                rentalId = Integer.parseInt(selectedData.split(" ")[0]);
                System.out.println("Selected Hostel ID: " + rentalId);
            } catch (NumberFormatException e) {
                System.out.println("Error: The selected data does not start with a valid number.");
            }
        } 
        else{
            System.out.println("No hostel selected.");
        }

        if (maintainceString.isEmpty()) {
            System.err.println("All fields are required!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Incomplete Input");
            alert.setContentText("Please dont leave any fields empty.");
            alert.showAndWait();
            return;
        }

    }

    @FXML
    void updateStatusClicked(ActionEvent event) {
        String selectedData = (String) selectmaintainanceComboBox.getSelectionModel().getSelectedItem();
        String maintainceString = maintainceDescription.getText();
        int maintainceId = 0;
        int amount = 0;
        if (selectedData != null) {
            try {
                maintainceId = Integer.parseInt(selectedData.split(" ")[0]);
                System.out.println("Selected Hostel ID: " + maintainceId);
            } catch (NumberFormatException e) {
                System.out.println("Error: The selected data does not start with a valid number.");
            }
        } 
        else{
            System.out.println("No hostel selected.");
        }
        try {
            amount = Integer.parseInt(costfield.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Number");
            alert.setContentText("Please enter a valid numeric value in the Price field.");
            alert.showAndWait();
        }

        if (maintainceString.isEmpty()) {
            System.err.println("All fields are required!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Incomplete Input");
            alert.setContentText("Please dont leave any fields empty.");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("addMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) {

    }

    @FXML
    void changestatuscombobox(ActionEvent event) {

    }

    @FXML
    void costfieldclicked(ActionEvent event) {

    }

    @FXML
    void evictionUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("Eviction");
    }

    @FXML
    void feedbackUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("ReviewFeedback");
    }

    @FXML
    void maintainceDescriptionClicked(ActionEvent event) {

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
    void maintaincetableSort(ActionEvent event) {

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
    void selectmaintainanceComboBoxClicked(ActionEvent event) {

    }

    @FXML
    void selectrentalComboBoxClicked(ActionEvent event) {

    }

}
