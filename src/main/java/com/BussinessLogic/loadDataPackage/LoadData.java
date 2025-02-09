package com.BussinessLogic.loadDataPackage;

import com.BussinessLogic.DB.TableAssistant;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoadData {
    @SuppressWarnings("rawtypes")
    public TableView loadHomeData(TableView Table) {
        String query = "SELECT r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities, " +
                       "CONCAT(o.firstName, ' ', o.lastName) AS ownerName " +
                       "FROM rental r " +
                       "JOIN owns own ON r.rentalId = own.rentalId " +
                       "JOIN owner o ON own.ownerId = o.ownerId";
    
                       TableAssistant table= new TableAssistant();
                       return table.runZeroParameterquery(query, Table);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadSearchData(TableView Table,String data) {
        String query = "SELECT r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities, CONCAT(o.firstName, ' ', o.lastName) AS ownerName FROM rental r\n" + //
                        "JOIN owns own ON r.rentalId = own.rentalId\n" + //
                        "JOIN owner o ON own.ownerId = o.ownerId\n" + //
                        "WHERE r.address LIKE CONCAT('%', ? , '%');";
    
                       TableAssistant table= new TableAssistant();
                       return table.runOneParameterquery(query, Table, data);
    }

   @SuppressWarnings({ "unchecked", "rawtypes" })
public TableView loadHomeNotificationData(TableView Table, int ID) {
    String query1 = "select n.dateTime, n.description from notification n \n" +
                    "join sendnotificationowner o on o.notificationId = n.id\n" +
                    "where o.OwnerId = ?";
    String query2 = "select n.dateTime, n.description from notification n \n" +
                    "join sendnotificationtenant t on t.notificationId = n.id\n" +
                    "where t.tenantId = ?";

    TableAssistant tableAssistant = new TableAssistant();

    // Get results from both queries
    ObservableList<ObservableList<Object>> data1 = tableAssistant.runOneParameterquery(query1, ID);
    ObservableList<ObservableList<Object>> data2 = tableAssistant.runOneParameterquery(query2, ID);

    // Combine data
    ObservableList<ObservableList<Object>> combinedData = FXCollections.observableArrayList();
    combinedData.addAll(data1);
    combinedData.addAll(data2);

    // Create table columns (if not already created)
    if (Table.getColumns().isEmpty()) {
        TableColumn<ObservableList<Object>, String> dateTimeColumn = new TableColumn<>("DateTime");
        dateTimeColumn.setCellValueFactory(param -> 
            new SimpleStringProperty(param.getValue().get(0).toString()));

        TableColumn<ObservableList<Object>, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(param -> 
            new SimpleStringProperty(param.getValue().get(1).toString()));

        Table.getColumns().addAll(dateTimeColumn, descriptionColumn);
    }

    // Set the combined data into the table
    Table.setItems(combinedData);

    return Table;
}


    @SuppressWarnings("rawtypes")
    public TableView loadApproveApplicantData(TableView Table,int ID) {
        
        String query = "select a.userName, a.firstName, a.lastName, a.address, a.dob from applyRental rent \n" + //
                        "join applicant a on rent.applicantid=a.applicantId\n" + //
                        "join owns o on o.rentalId=rent.rentalId where o.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }
    
    @SuppressWarnings("rawtypes")
    public TableView loadOwnerData(TableView Table,int ID) {
        String query = "select r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join owns on r.rentalId=owns.rentalId \n" + //
                        "where owns.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadRenterData(TableView Table,int ID) {
        String query = "select room.rtype, room.descript,room.price, r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join rent on r.rentalId=rent.rentalId \n" + //
                        "join room on r.rentalId=room.rentalId \n" + //
                        "where rent.tenantId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }
    
    @SuppressWarnings("rawtypes")
    public TableView loadMaintainanceData(TableView Table,int ID) {
        String query = "select m.description, r.rentalName,r.address,r.facilities from maintainance m\n" + //
                        "join rental r on m.rentalId=r.rentalId \n" + //
                        "join owns on owns.rentalId=m.rentalId\n" + //
                        "where m.status=0 and owns.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadMaintainanceTenantData(TableView Table,int ID) {
        String query = "select m.description, r.rentalName,r.address,r.facilities from maintainance m\n" + //
                        "join rental r on m.rentalId=r.rentalId\n" + //
                        "join rent on rent.rentalId=m.rentalId\n" + //
                        "where m.status=0 and rent.tenantId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadEvictionOwnerData(TableView Table,int ID) {
        String query = "select e.issueDate, e.evictionDate, e.reason,t.userName,concat(t.firstname,' ',lastname) as fullname from eviction e\n" + //
                        "join tenant t on e.tenantId=t.tenantId \n" + //
                        "where ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadEvictionTenantData(TableView Table,int ID) {
        String query = "select e.issueDate, e.evictionDate, e.reason from eviction e where e.tenantId=?";
        
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadFineOwnerData(TableView Table,int ID) {
        String query = "select t.username,t.firstname,t.lastName,t.dob, re.rentalName, room.rtype,f.amount from tenant t\n" + //
                        "join rent r on r.tenantId=t.tenantId\n" + //
                        "join room on r.roomId=room.roomId\n" + //
                        "join rental re on re.rentalId=r.rentalId\n" + //
                        "join owns on re.rentalId=owns.rentalId\n" + //
                        "join fine f on f.tenantId=t.tenantId\n" + //
                        "where owns.ownerId=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadReviewFeedbackData(TableView Table,int ID) {
        String query = "select f.rating, f.description, r.rentalName, r.address, r.facilities from feedback f \n" + //
                        "inner join rental r on r.rentalId=f.rentalId\n" + //
                        "inner join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadAllocateParkingData(TableView Table,int ID) {
        String query = "select pr.slotId, t.firstName, t.lastName, t.username, r.rentalName,r.address from parkingrequest pr \n" + //
                        "join tenant t on pr.tenantId=t.tenantId\n" + //
                        "join parkingslot p on p.slotId=pr.slotId\n" + //
                        "join rental r on r.rentalId=p.rentalId\n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
                        
        TableAssistant table= new TableAssistant();
        return table.runOneParameterquery(query, Table, ID);   
    }

    @SuppressWarnings("rawtypes")
    public TableView loadRequestParkingData(TableView Table,int ID) {
        String query = "select p.slotId, r.rentalName,r.address from parkingslot p \n" + //
                        "inner join rental r on r.rentalId=p.rentalId\n" + //
                        "inner join rent re on re.rentalId=r.rentalId\n" + //
                        "where re.tenantId=? and p.is_occupied=0;";
                        
        TableAssistant table= new TableAssistant();
        return table.runOneParameterquery(query, Table, ID);
        
    }

    @SuppressWarnings("rawtypes")
    public TableView loadAddMenuData(TableView Table) {
        String query = "SELECT menu.menuId, breakfast.name as BreakFastName,\n" + //
                        "lunch.name as LunchName,dinner.name as DinnerName,menu.description FROM menu \n" + //
                        "JOIN meals AS breakfast ON menu.breakfast = breakfast.mealId \n" + //
                        "JOIN meals AS lunch ON menu.lunch = lunch.mealId \n" + //
                        "JOIN meals AS dinner ON menu.dinner = dinner.mealId;";
                        
        TableAssistant table= new TableAssistant();
        return table.runZeroParameterquery(query, Table);
        
    }

    @SuppressWarnings("rawtypes")
    public TableView loadChoseRentalData(TableView Table,int ID) {
        String query = "select room.roomid,room.rtype, room.descript,room.price, r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join rent on r.rentalId=rent.rentalId \n" + //
                        "join room on r.rentalId=room.rentalId \n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerid!=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadFineTenantData(TableView Table,int ID) {
        String query = "select issueDate, reason,amount from fine where tenantId=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    @SuppressWarnings("rawtypes")
    public TableView loadMealData(TableView Table) {
        String query = "select * from Meals";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runZeroParameterquery(query, Table);
    }
}
