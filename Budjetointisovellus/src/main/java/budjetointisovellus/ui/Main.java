/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.ui;
import budjetointisovellus.domain.*;
import javafx.application.Application;



/**
 *
 * @author aleksi
 */
public class Main {
    
    public static void main(String[] args) {
        Database db = new Database("");
        UserInterface ui = new UserInterface();
        ui.setDb(db);
        Application.launch(UserInterface.class,args);
        
    }
    
}
