package com.example;

import java.io.IOException;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.Utility;
import com.BussinessLogic.classes.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterHostelController {

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
    private TextField addressTextField;

    @FXML
    private TextField availRoomsTextField;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private TextField facilitiesTxtField;

    @FXML
    private Hyperlink feedbackUrl;

    @FXML
    private Hyperlink finesUrl;

    @FXML
    private Pane headerpane;

    @FXML
    private Pane mainpane;

    @FXML
    private AnchorPane mainscene;

    @FXML
    private Hyperlink maintainanceUrl;

    @FXML
    private Pane menupane;

    @FXML
    private Hyperlink parkingUrl;

    @FXML
    private Button registerHostelbtn;

    @FXML
    private Button registerRoombtn;

    @FXML
    private Hyperlink registerUrl;

    @FXML
    private Button returnButton1;

    @FXML
    private TextField roomDescriptTextField;

    @FXML
    private TextField roomImageTextField;

    @FXML
    private TextField roomPriceTextField;

    @FXML
    private TextField HostelNameTextField;

    @FXML
    private TextField roomTypeTextField;

    @FXML
    private ComboBox<String> selectHostel;

    @FXML
    private TextField totalRoomsTextField;

    public static User user = null;

    public static void setUser(User u){
        user = u;
    }

    public void initialize() {
        //add the hostel of the owners in the combobox
        LoadData util=new LoadData();
        selectHostel = util.loadRentalDataComboBox(selectHostel, user.getID());
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
    void SearchButton_clicked(ActionEvent event) {

    }

    @FXML
    void addressTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void availRoomsTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void evictionUrl_Clicked(ActionEvent event) throws IOException {
        App.setRoot("Eviction");
    }

    @FXML
    void facilitiesTxtFieldclicked(ActionEvent event) {

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
    void returnButton1Clicked(ActionEvent event) {

    }

    @FXML
    void totalRoomsTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void registerHostelBth_Clicked(ActionEvent event) {
        String Address = addressTextField.getText();
        String name = HostelNameTextField.getText();
        String facilities = facilitiesTxtField.getText();
        Utility uti = new Utility();
        int availableRooms = 0;
        int totalRooms =0;
        try {
            availableRooms = Integer.parseInt(availRoomsTextField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Number");
            alert.setContentText("Please enter a valid numeric value in the available rooms field.");
            alert.showAndWait();
        }
        try {
            totalRooms = Integer.parseInt(totalRoomsTextField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Number");
            alert.setContentText("Please enter a valid numeric value in the total rooms field.");
            alert.showAndWait();
        }

        if (Address.isEmpty() || name.isEmpty() || facilities.isEmpty()) {
            System.err.println("All fields are required!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Incomplete Input");
            alert.setContentText("Please dont leave any fields empty.");
            alert.showAndWait();
            return;
        }
        Utility util = new Utility();
        if(util.addRental(name, Address, facilities, totalRooms, availableRooms)){
            System.out.println("Hostel Register successful!");
        }
        else {
            
            uti.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid username & password.");
            alert.showAndWait();
            Error err=new Error("Hostel Register failed!");
            throw err;
        }
        uti.clearTextFields(mainpane);
        
    }

    @FXML
    void registerRoombtn_Clicked(ActionEvent event) {
        String selectedData = (String) selectHostel.getSelectionModel().getSelectedItem();
        String roomType = roomTypeTextField.getText();
        String roomDescrip = roomDescriptTextField.getText();
        int price =0;
        String imgPath = roomImageTextField.getText();
        int hostelId = 0;
        Utility uti = new Utility();

        if (selectedData != null) {
            try {
                hostelId = Integer.parseInt(selectedData.split(" ")[0]);
                System.out.println("Selected Hostel ID: " + hostelId);
            } catch (NumberFormatException e) {
                System.out.println("Error: The selected data does not start with a valid number.");
            }
        } else {
            System.out.println("No hostel selected.");
        }

        try {
            price = Integer.parseInt(roomPriceTextField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Number");
            alert.setContentText("Please enter a valid numeric value in the Price field.");
            alert.showAndWait();
        }
        if (roomType.isEmpty() || roomDescrip.isEmpty() ) {
            System.err.println("All fields are required!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Incomplete Input");
            alert.setContentText("Please dont leave any fields empty.");
            alert.showAndWait();
            return;
        }
        //add to database after merge
        Utility util = new Utility();
        if(util.addRooms(hostelId, roomType, roomDescrip, price, imgPath)){
            System.out.println("Room added successful!");
        }
        else {
            uti.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Room add failed!");
            throw err;
        }
        uti.clearTextFields(mainpane);
    }

    @FXML
    void roomDescriptTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void roomImageTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void HostelNameTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void roomPriceTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void roomTypeTextFieldClicked(ActionEvent event) {

    }

    @FXML
    void selectHostel_Clicked(ActionEvent event) {

    }

}
