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

public class OwnedControllor {

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
    private Button approveBtn;

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
    private TableView<String> ownedTable;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
    
     @SuppressWarnings("unchecked")
    public void initialize() {
        LoadData util=new LoadData();        
        ownedTable=util.loadOwnerData(ownedTable,user.getID());

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
    void ownedTable_sort(ActionEvent event) {
    
    }
    
    @FXML
    void approveBtn_clicked(ActionEvent event) throws IOException {
        App.setRoot("ApproveApplicants");
    }

    
}
