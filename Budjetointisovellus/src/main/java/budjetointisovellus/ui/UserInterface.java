/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package budjetointisovellus.ui;

import budjetointisovellus.domain.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author aleksi
 */
public class UserInterface extends Application {
    private Database db;
    
    public void setDb(Database db) {
        this.db = db;
    }
    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Budjetointisovellus");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();    
    }
}
