package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.TableView;

public class LoadData {
    public TableView loadHomeData(TableView HomeTable) {
        jdbc javaJdbc=new jdbc();
        String query = "SELECT r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities, " +
                       "CONCAT(o.firstName, ' ', o.lastName) AS ownerName " +
                       "FROM rental r " +
                       "JOIN owns own ON r.rentalId = own.rentalId " +
                       "JOIN owner o ON own.ownerId = o.ownerId";
    
        try (Connection conn = javaJdbc.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery(query)) {
    
            TableAssistant table=new TableAssistant();
            table.createTable(HomeTable, rs);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
                return HomeTable;
    }

    public TableView loadApproveApplicantData(TableView Table,int ID) {
        jdbc javaJdbc=new jdbc();
        String query = "select a.userName, a.firstName, a.lastName, a.address, a.dob from applyRental rent \n" + //
                        "join applicant a on rent.applicantid=a.applicantId\n" + //
                        "join owns o on o.rentalId=rent.rentalId where o.ownerId=?";
    
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            TableAssistant table=new TableAssistant();
            table.createTable(Table, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
                return Table;
    }
    
    public TableView loadOwnerData(TableView Table,int ID) {
        jdbc javaJdbc=new jdbc();
        String query = "select r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join owns on r.rentalId=owns.rentalId \n" + //
                        "where owns.ownerId=?";
    
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            TableAssistant table=new TableAssistant();
            table.createTable(Table, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
                return Table;
    }

    public TableView loadRenterData(TableView Table,int ID) {
        jdbc javaJdbc=new jdbc();
        String query = "select room.rtype, room.descript,room.price, r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join rent on r.rentalId=rent.rentalId \n" + //
                        "join room on r.rentalId=room.rentalId \n" + //
                        "where rent.tenantId=?";
    
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            TableAssistant table=new TableAssistant();
            table.createTable(Table, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
                return Table;
    }
    
    public TableView loadMaintainanceData(TableView Table,int ID) {
        jdbc javaJdbc=new jdbc();
        String query = "select m.description, r.rentalName,r.address,r.facilities from maintainance m\n" + //
                        "join rental r on m.rentalId=r.rentalId \n" + //
                        "join owns on owns.rentalId=m.rentalId\n" + //
                        "where m.status=0 and owns.ownerId=?";
    
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            TableAssistant table=new TableAssistant();
            table.createTable(Table, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
                return Table;
    }

    public TableView loadEvictionData(TableView Table,int ID) {
        jdbc javaJdbc=new jdbc();
        String query = "select e.issueDate, e.evictionDate, e.reason, t.username, concat(t.firstname,' ',t.lastname)as FullName from eviction e \n" + //
                        "join tenant t on e.tenantId=t.tenantId \n" + //
                        "where ownerId=?";
    
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            TableAssistant table=new TableAssistant();
            table.createTable(Table, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
                return Table;
    }
}
