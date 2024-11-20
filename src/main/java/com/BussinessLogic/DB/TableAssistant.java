package com.BussinessLogic.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableAssistant {

    TableView createTable(TableView Table, ResultSet rs) throws SQLException{
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                final int colIndex = i - 1;
                TableColumn<ObservableList<Object>, String> column = new TableColumn<>(rs.getMetaData().getColumnName(i));
                column.setCellValueFactory(param -> {
                    Object value = param.getValue().get(colIndex);
                    return new SimpleStringProperty(value != null ? value.toString() : "null");
                });
                Table.getColumns().add(column);
            }
    
            // Add rows dynamically
            ObservableList<ObservableList<Object>> data = FXCollections.observableArrayList();
            while (rs.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            Table.setItems(data);
            return Table;
    }
    
}
