package com.example;

import java.io.IOException;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.LoadComboData;
import com.BussinessLogic.DB.Utility;
import com.BussinessLogic.classes.User;

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

public class ApproveApplicantsController {

    @FXML
    private ComboBox<String> AllocateRoomcombobox;

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
    private ComboBox<String> approveComboBox;

    @FXML
    private Hyperlink evictionUrl;

    @FXML
    private Hyperlink feedbackUrl;

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
    private Button confirmbtn;

    @FXML
    private Button returnButton1;

    @FXML
    private ComboBox<String> selectapplicantComboBox;

    @FXML
    private TableView<String> viewApllicantsTable;

    @FXML
    private ComboBox<String> selectapplicantRoomComboBox1;

    @FXML
    private Button confirmbtnRoom;

    public int RentalID;
    
    public static User user = null;

    public static void setUser(User u){
        user = u;
    }

    public void initialize() {
        //add the applicants after merged
        approveComboBox.getItems().addAll(
            "Approve",
            "Reject"
        );
        LoadData util=new LoadData();
        LoadComboData cData = new LoadComboData();        
        viewApllicantsTable=util.loadApproveApplicantData(viewApllicantsTable,user.getID());
        selectapplicantComboBox = cData.loadApplicantsComboBox(selectapplicantComboBox, user.getID());
        selectapplicantRoomComboBox1 = cData.loadNULLRents(selectapplicantRoomComboBox1, user.getID());

    }
    

    @FXML
    void AllocateRoomcombobox(ActionEvent event) {

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
    void approveComboBoxClicked(ActionEvent event) {

    }

    @FXML
    void confirmbtnClicked(ActionEvent event) {
        String selectedData = (String) selectapplicantComboBox.getSelectionModel().getSelectedItem();
        String approveString = (String) approveComboBox.getSelectionModel().getSelectedItem();
        int applicantId = 0;
        int rentalId = 0;
        int roomId=0;
        Utility util = new Utility();

        if (selectedData != null) {
            try {
                // Split the string by space to extract individual parts
                String[] parts = selectedData.split(" ");
                
                applicantId = Integer.parseInt(parts[0]);
                rentalId = Integer.parseInt(parts[3]);
                roomId = Integer.parseInt(parts[4]);
                
                System.out.println("Selected applicant ID: " + applicantId);
                System.out.println("Selected tenant ID: " + rentalId);
                System.out.println("Selected room ID: " + roomId);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Unable to parse the selected data. Please ensure the format is correct.");
            }
        } else {
            System.out.println("No item selected.");
        }
        LoadComboData cData = new LoadComboData();
        int price = cData.getRoomPrice(roomId);
        
        if("approve".equalsIgnoreCase(approveString)) {
            //execute approve query
            
            if(util.addTenantRental(applicantId, rentalId, roomId, price)){
                System.out.println("Room added successful!");
                util.deleteRent(applicantId);
            }
            else {
                util.clearTextFields(mainpane);
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Error: Invalid Input");
                alert.setContentText("Please enter a valid information.");
                alert.showAndWait();
                Error err=new Error("Rent add failed!");
                throw err;
            }
            util.clearTextFields(mainpane);

        }
        else if("reject".equalsIgnoreCase(approveString)) {
            //execute Reject Query
            util.deleteRent(applicantId);
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Option");
            alert.setHeaderText("Error: Invalid Option");
            alert.setContentText("Please enter a valid option.");
            alert.showAndWait();
        }

    }

    @FXML
    void confirmbtnRoomClicked(ActionEvent event) {
        String selectedData = (String) selectapplicantRoomComboBox1.getSelectionModel().getSelectedItem();
        String room = (String) AllocateRoomcombobox.getSelectionModel().getSelectedItem();
        int tenantId = 0;
        int rentalId = 0;
        Utility util = new Utility();

        if (selectedData != null) {
            try {
                // Split the string by space to extract individual parts
                String[] parts = selectedData.split(" ");
                
                tenantId = Integer.parseInt(parts[0]);
                rentalId = Integer.parseInt(parts[1]);
                
                System.out.println("Selected applicant ID: " + tenantId);
                System.out.println("Selected tenant ID: " + rentalId);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Unable to parse the selected data. Please ensure the format is correct.");
            }
        } else {
            System.out.println("No item selected.");
        }
        int roomId=0;
        int price=0;
        if (room != null) {
            try {
                // Split the string by space to extract individual parts
                String[] parts = room.split(" ");
                
                roomId = Integer.parseInt(parts[0]);
                price = Integer.parseInt(parts[1]);
                
                System.out.println("Selected room ID: " + roomId);
                System.out.println("Selected price ID: " + price);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Unable to parse the selected data. Please ensure the format is correct.");
            }
        } else {
            System.out.println("No item selected.");
        }
        if(util.UpdateTenantRental(tenantId, roomId, price)){
            System.out.println("Room Allocation successful!");
        }
        else {
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Room Alocation failed!");
            throw err;
        }
        if(util.UpdateRoomStatus(roomId)){
            System.out.println("Room Status Updated successful!");
        }
        else {
            util.clearTextFields(mainpane);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Error: Invalid Input");
            alert.setContentText("Please enter a valid information.");
            alert.showAndWait();
            Error err=new Error("Room Update failed!");
            throw err;
        }
        util.clearTextFields(mainpane);

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
    void selectapplicantComboBoxClicked(ActionEvent event) {
        
    }

    @FXML
    void selectapplicantRoomComboBoxClicked(ActionEvent event) {
        String selectedData = (String) selectapplicantRoomComboBox1.getSelectionModel().getSelectedItem();
        int tenantId=0;
        int rentalId=0;
        if (selectedData != null) {
            try {
                // Split the string by space to extract individual parts
                String[] parts = selectedData.split(" ");
                
                tenantId = Integer.parseInt(parts[0]);
                rentalId = Integer.parseInt(parts[1]);
                
                System.out.println("Selected applicant ID: " + tenantId);
                System.out.println("Selected tenant ID: " + rentalId);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Unable to parse the selected data. Please ensure the format is correct.");
            }
        } else {
            System.out.println("No item selected.");
        }
        RentalID = rentalId;
        LoadComboData cData = new LoadComboData();
        AllocateRoomcombobox = cData.loadRoomsData(AllocateRoomcombobox, RentalID);
    }

    @FXML
    void viewApllicantsTableSort(ActionEvent event) {

    }

}
