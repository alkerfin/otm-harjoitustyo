/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.ui;
import budjetointisovellus.domain.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;



/**
 *
 * @author aleksi
 */
public class Main {
    
    public static void main(String[] args) {
        Database db;
        try {
            db = new Database("budjetointisovellus.db");
            UserInterface ui = new UserInterface();
            ui.setDb(db);
            Application.launch(UserInterface.class,args);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
