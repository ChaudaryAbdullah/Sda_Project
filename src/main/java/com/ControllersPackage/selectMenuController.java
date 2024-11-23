package com.ControllersPackage;

import java.io.IOException;
import java.util.logging.Handler;

import com.BussinessLogic.classes.User;
import com.HandlersPackage.SelectMenuHandler;
import com.example.App;

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

public class selectMenuController {

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
    private ComboBox<String> menuComboBox;

    @FXML
    private TableView<String> menuTable;
    
    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button selectbtn;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }
    
    SelectMenuHandler handle=new SelectMenuHandler();

    public void initialize() {
        handle.tableHandler(menuTable);
        handle.addMenu();
        handle.HandleComboBox(menuComboBox);
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
    void selectbtn_clicked(ActionEvent event) {
        handle.ChooseMenu(menuComboBox.getSelectionModel().getSelectedItem(), user.getID());
        initialize();
    }

    @FXML
    void table_sort(ActionEvent event) {

    }

}
