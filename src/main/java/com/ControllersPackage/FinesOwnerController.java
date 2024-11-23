package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.Utility;
import com.BussinessLogic.classes.HostelRental;
import com.BussinessLogic.classes.User;
import com.Factories.NotificationFactory;
import com.HandlersPackage.NotificationHandler;
import com.example.App;
import com.BussinessLogic.DB.LoadComboData;

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

public class FinesOwnerController {

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
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private TextField fineamountfield;

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
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    @FXML
    private ComboBox<String> selectTenant;

    @FXML
    private TableView<String> FinesTable;

    @FXML
    private TextField reasonTextField;

    @FXML
    private Button confirmButton;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
    NotificationHandler notification=new NotificationHandler();

    public void initialize() {
        LoadData util=new LoadData();
        LoadComboData cData = new LoadComboData();        
        FinesTable=util.loadFineOwnerData(FinesTable,user.getID());
        selectTenant = cData.loadTenantDataComboBox(selectTenant, user.getID());
    }

    @FXML
    void confirmButton_Clicked(ActionEvent event) {
        String selectedData = (String) selectTenant.getSelectionModel().getSelectedItem();
        int tenantId=0;
        String fineString = fineamountfield.getText();
        Utility util = new Utility();
        String reasonString = reasonTextField.getText();
        String todayDate = util.getTodayDate();
        if (selectedData != null) {
            try {
                tenantId = Integer.parseInt(selectedData.split(" ")[0]);
                System.out.println("Selected tenant ID: " + tenantId);
            } catch (NumberFormatException e) {
                System.out.println("Error: The selected data does not start with a valid number.");
            }
        } else {
            System.out.println("No tenant selected.");
        }
        int fineAmount = Integer.parseInt(fineString); 
        if(util.addFine(todayDate, reasonString, fineAmount, user.getID(), tenantId)){
            System.out.println("Fine added successful!");
            notification.sendNotificationToTenant("You got a Fine of Rs "+fineString,tenantId);
        }
        else {
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Fine add failed!");
            throw err;
        }
        util.clearTextFields(mainpane);
        initialize();
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
    void MenuUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("addMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) {

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
    void FinesTable_sort(ActionEvent event) {

    }
    
    @FXML
    void fineamountfieldClicked(ActionEvent event) {

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
    void returnButton1Clicked(ActionEvent event) {

    }

    @FXML
    void selectTenant_Clicked(ActionEvent event) {

    }

}
