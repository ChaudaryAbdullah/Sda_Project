package com.ControllersPackage;

import java.io.IOException;

import com.BussinessLogic.FacadePackage.Utility;
import com.BussinessLogic.classes.User;
import com.HandlersPackage.AddMealHandler;
import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SelectMealsTenant {

    @FXML
    private ImageView DashbordLogo;

    @FXML
    private TextField DescriptionTextFeild;

    @FXML
    private ImageView HomeLogo;

    @FXML
    private Hyperlink HomeUrl1;

    @FXML
    private Hyperlink MealUrl_Clicked;

    @FXML
    private Hyperlink MenuUrl;

    @FXML
    private TextField NameTextFeild;

    @FXML
    private TextField PriceTextFeild;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Button addbtn;

    @FXML
    private AnchorPane backgroundpane;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private TableView<String> MealTable;

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

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
   
    public void initialize() {
        handle.tableHandler(MealTable);
    }
   
    AddMealHandler handle=new AddMealHandler();

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
    void parkingUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("RequestParking");
    }

    @FXML
    void registerUrl_Clicked(ActionEvent event) throws IOException {
    App.setRoot("ChooseRental");
    }

    @FXML
    void addbuttonbtn_clicked(ActionEvent event) throws IOException {
        if(NameTextFeild.getText()==""||PriceTextFeild.getText()==""||DescriptionTextFeild.getText()=="")
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
     handle.addNewMeal(NameTextFeild.getText(),DescriptionTextFeild.getText(),Integer.parseInt(PriceTextFeild.getText())); 
     handle.tableHandler(MealTable);
    }
}
