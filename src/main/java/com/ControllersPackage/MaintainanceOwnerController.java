package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.loadDataPackage.LoadData;
import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.User;
import com.example.App;
import com.BussinessLogic.loadDataPackage.LoadComboData;

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

    @SuppressWarnings("unchecked")
    public void initialize() {
        //add the applicants after merged
        changestatuscombobox.getItems().addAll(
            "Completed",
            "Ongoing"
        );

        LoadData util=new LoadData();
        LoadComboData cData = new LoadComboData();        
        maintaincetable=util.loadMaintainanceData(maintaincetable,user.getID());
        selectrentalComboBox = cData.loadRentalDataComboBox(selectrentalComboBox, user.getID());
        selectmaintainanceComboBox = cData.loadMaintainanceComboBox(selectmaintainanceComboBox, user.getID());

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
        App.setRoot("SelectMealsOwner");
    }

    @FXML
    void RegisterNewClicked(ActionEvent event) {
        String selectedData = (String) selectrentalComboBox.getSelectionModel().getSelectedItem();
        String maintainceString = maintainceDescription.getText();
        int rentalId =0;
        Utility util = new Utility();
        String todayDate = util.getTodayDate();
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

        
        if(util.addNewMaintaince(maintainceString, rentalId, todayDate)){
            System.out.println("Hostel Register successful!");
        }
        else {
            
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Maintaince Add failed!");
            throw err;
        }
        util.clearTextFields(mainpane);
        initialize();
    }

    @FXML
    void updateStatusClicked(ActionEvent event) {
        String selectedData = (String) selectmaintainanceComboBox.getSelectionModel().getSelectedItem();
        String changestatus = (String) changestatuscombobox.getSelectionModel().getSelectedItem();
        int maintainceId = 0;
        Utility util = new Utility();
        String todayDate = util.getTodayDate();
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
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Number");
            alert.setContentText("Please enter a valid numeric value in the Price field.");
            alert.showAndWait();
        }
        boolean status=false;
        if(changestatus == "Completed"){
            status = true;
        }
        else if(changestatus == "Ongoing"){
            status = false;
        }


        if(util.UpdateMaintaince(status, maintainceId, todayDate)){
            System.out.println("Hostel Register successful!");
        }
        else {
            
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid username & password.");
            alert.showAndWait();
            Error err=new Error("Hostel Register failed!");
            throw err;
        }
        util.clearTextFields(mainpane);
        initialize();
    }

    @FXML
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("addMenu");
    }
    

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        HomePageController.setSearchData=SearchTextField.getText();
        App.setRoot("HomePage");
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
    void returnButton1Clicked(ActionEvent event) throws IOException {
        App.setRoot("Dashboard");
    }

    @FXML
    void selectmaintainanceComboBoxClicked(ActionEvent event) {

    }

    @FXML
    void selectrentalComboBoxClicked(ActionEvent event) {

    }

}
