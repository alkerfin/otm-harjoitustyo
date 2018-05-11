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
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
        	this.db = new Database("budjetointisovellus.db");
		this.db.init();
	} catch(SQLException ex) {
		
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../ui.fxml"));
        loader.setController(new FxController(db));
        Parent root = (Parent)loader.load(loader.getLocation().openStream());
        
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Budjetointisovellus");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();    
    }
}
