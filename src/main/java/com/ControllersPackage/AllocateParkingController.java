package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.User;
import com.HandlersPackage.AllocateParkingHandler;
import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AllocateParkingController {

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
    private Button acceptbtn;

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
    private Button createButton;
    
    @FXML
    private ComboBox<String> rentalCombobox;

    @FXML
    private ComboBox<String> parkingCombobox;

    @FXML
    private Hyperlink maintainanceUrl;

    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private TextField amountTextfeild;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button rejectbtn;

    @FXML
    private TableView<String> parkingtable;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
    AllocateParkingHandler handle=new AllocateParkingHandler();

     @FXML
    public void initialize() {
        handle.addRental(user.getID());
        handle.addParking(user.getID());
        handle.addUser(user.getID());
        handle.HandleRentalComboBox(rentalCombobox, user.getID());
        handle.HandleTable(parkingtable, user.getID());
        handle.HandleParkingComboBox(parkingCombobox, user.getID());
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
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("addmenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        HomePageController.setSearchData=SearchTextField.getText();
        App.setRoot("HomePage");
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
    void parkingUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("AllocateParking");
    }

    @FXML
    void registerUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("RegisterHostel");
    }

    @FXML
    void rejectbtn_clikcked(ActionEvent event) {
        if(parkingCombobox.getSelectionModel().getSelectedItem()==null)
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
        handle.rejectParking(parkingCombobox.getSelectionModel().getSelectedItem());
        handle.HandleTable(parkingtable, user.getID());
    }

    @FXML
    void acceptbtn_clikcked(ActionEvent event) {
        if(parkingCombobox.getSelectionModel().getSelectedItem()==null)
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
        handle.acceptParking(parkingCombobox.getSelectionModel().getSelectedItem());
        handle.HandleTable(parkingtable, user.getID());
    }

    @FXML
    void parkingtable_sort(ActionEvent event) {

    }
    
    @FXML
    void createButton_clicked(ActionEvent event) {
        if(rentalCombobox.getSelectionModel().getSelectedItem()==null||amountTextfeild.getText()==null)
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
        handle.newParking(rentalCombobox.getSelectionModel().getSelectedItem(), Integer.parseInt(amountTextfeild.getText()));
        initialize();
    }

}
