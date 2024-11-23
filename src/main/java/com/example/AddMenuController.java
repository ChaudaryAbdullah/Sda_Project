package com.example;

import java.io.IOException;

import com.BussinessLogic.classes.User;
import com.HandlersPackage.AddMenuHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class AddMenuController {

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
    private Button addBtn;

    @FXML
    private AnchorPane backgroundpane;

    @FXML
    private ComboBox<String> breakfastTextFeild;

    @FXML
    private TextField descriptionTextFeild;

    @FXML
    private ComboBox<String> dinnerTextFeild;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private Hyperlink finesUrl;

    @FXML
    private Pane headerpane;

    @FXML
    private ComboBox<String> lunchtTextFeild;

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
    private TableView<String> menuTable;

    AddMenuHandler handle=new AddMenuHandler();
    
    public static User user = null;

    public static void setUser(User u){
        user = u;
    }

    @FXML
    public void initialize() {
        handle.HandleTable(menuTable);
        handle.addMeal();
        handle.addMenu();
        handle.HandleComboBox(breakfastTextFeild);
        handle.HandleComboBox(lunchtTextFeild);
        handle.HandleComboBox(dinnerTextFeild);
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
        App.setRoot("addmenu");
    }

    @FXML
    void SearchButton_clicked(ActionEvent event) throws IOException {
        
    }

    @FXML
    void addBtn_clicked(ActionEvent event) throws IOException {
        handle.addNewMenu(breakfastTextFeild.getSelectionModel().getSelectedItem(),lunchtTextFeild.getSelectionModel().getSelectedItem(),dinnerTextFeild.getSelectionModel().getSelectedItem(),descriptionTextFeild.getText(),user.getID());
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
    void menuTable_Sort(ActionEvent event) {

    }

}
