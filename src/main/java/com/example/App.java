package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.io.IOException;

/**
 * JavaFX App
 */
//abdullah
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("Dashboard"), 1080, 720);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// String url = "jdbc:mysql://localhost:3306/sda_project";
		// String username = "root";
		// String password = "12345678";
		// System.out.println("Connecting database");
		// Connection connection = null;
		// try  {
		// 	connection = DriverManager.getConnection(url, username, password);
		// 			System.out.println("Database connected!");
		// 			Statement s = connection.createStatement();
					
		// 			ResultSet rs = s.executeQuery("Select * from user");
					
		// 			while(rs.next()) {
		// 				String id = rs.getString(1);
		// 				String name = rs.getString("name");
		// 				System.out.println(id + " " + name);
		// 			}
					
		// 			connection.close();
		// }catch(Exception e) {
		// 	e.printStackTrace();

		// }
	
        launch();
    }

}