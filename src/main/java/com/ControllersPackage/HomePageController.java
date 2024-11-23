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
import javafx.scene.layout.Pane;

public class HomePageController {

    @FXML
    private ImageView DashbordLogo;

    @FXML
    private ImageView HomeLogo;

    @FXML
    public TableView<String> HomeTable;

    @FXML
    private TableView<String> NotificationTable;
    
    @FXML
    private Hyperlink HomeUrl1;

    @FXML
    private Button SearchButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private Pane mappane;
    public static User user = null;

    public static void setUser(User u){
        user = u;
        AddMenuController.setUser(u);
        AllocateParkingController.setUser(u);
        ApproveApplicantsController.setUser(u);
        ChooseRentalController.setUser(u);
        DashBoardController.setUser(u);
        EvictionController.setUser(u);
        FinesOwnerController.setUser(u);
        GiveFeedbackController.setUser(u);
        MaintainanceOwnerController.setUser(u);
        OwnedControllor.setUser(u);
        RegisterHostelController.setUser(u);
        rentedController.setUser(u);
        RequestParkingController.setUser(u);
        ReviewFeedbackController.setUser(u);
        selectMenuController.setUser(u);
        MaintainanceTenantController.setUser(u);
        EvictionTenantController.setUser(u);
        FinesTenantController.setUser(u);
        PaymentController.setUser(u);
        
       
    }

    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        LoadData util=new LoadData();        
        HomeTable=util.loadHomeData(HomeTable);
        NotificationTable=util.loadHomeNotificationData(NotificationTable,user.getID());
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
    void SearchButton_clicked(ActionEvent event) {

    }

    @FXML
    void NotificationTable_sort(ActionEvent event) {

    }

    @FXML
    void homeLogo_Clicked(MouseEvent event) throws IOException {
        App.setRoot("HomePage");
    }

    
    @FXML
    void logOutButton_clicked(ActionEvent event) {

    }

}
