package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.loadDataPackage.LoadData;
import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.HostelRental;
import com.BussinessLogic.classes.User;
import com.HandlersPackage.NotificationHandler;
import com.example.App;
import com.BussinessLogic.loadDataPackage.LoadComboData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class EvictionController {

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
    private Button evictiButton;

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
    private TableView<String> evictionTable;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    public static User user = null;

    @FXML
    private DatePicker selectDate;

    @FXML
    private ComboBox<String> selectTenantCombobox;

    
    @FXML
    private TextField reasonTextField;

    public static void setUser(User u){
        user = u;
    }

    @SuppressWarnings("unchecked")
    public void initialize() {

        LoadData util=new LoadData();
        LoadComboData cData = new LoadComboData();        
        evictionTable=util.loadEvictionOwnerData(evictionTable,user.getID());
        selectTenantCombobox = cData.loadTenantDataComboBox(selectTenantCombobox, user.getID());        
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
        App.setRoot("addMenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        HomePageController.setSearchData=SearchTextField.getText();
        App.setRoot("HomePage");
    }

    @FXML
    void evictionTable_sort(ActionEvent event) {

    }

    @FXML
    void evictiButton_Clicked(ActionEvent event) {
        String selectedData = (String) selectTenantCombobox.getSelectionModel().getSelectedItem();
        int tenantId=0;
        String evictionDate;
        String reason = reasonTextField.getText();
        Utility util = new Utility();
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
        evictionDate = util.getFormattedDateForMySQL(selectDate);

        HostelRental host = util.getRentalfromTenant(tenantId);

        String rentalIDString = host.getPropertyID();
        int rentalid = Integer.parseInt(rentalIDString); 


        if(util.addEviction(todayDate, evictionDate, tenantId, user.getID(), rentalid, reason)){
            System.out.println("Room added successful!");
            NotificationHandler notification=new NotificationHandler();
            notification.sendNotificationToTenant("You got evicted.  ",tenantId);
        }
        else {
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Room add failed!");
            throw err;
        }
        util.clearTextFields(mainpane);
        initialize();

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
    void returnButton1Clicked(ActionEvent event) throws IOException {
        App.setRoot("owned");
    }

    @FXML
    void reasonTextField_Clicked(ActionEvent event) {

    }

    @FXML
    void selectDate_Clicked(ActionEvent event) {

    }

    @FXML
    void selectTenantCombobox_Clicked(ActionEvent event) {

    }

}
