package com.ControllersPackage;

import com.BussinessLogic.loadDataPackage.LoadData;

import javafx.scene.control.TableView;

public class SearchController {
LoadData load=new LoadData();

    @SuppressWarnings("rawtypes")
    public TableView searchRental(TableView Table,String data){
        return load.loadSearchData(Table,data);
    }
    
}
