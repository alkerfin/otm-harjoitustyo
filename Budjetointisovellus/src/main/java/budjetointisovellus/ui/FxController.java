/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.ui;

import budjetointisovellus.domain.Database;
import budjetointisovellus.domain.Kategoria;
import budjetointisovellus.domain.KategoriaDao;
import budjetointisovellus.domain.RahaTapahtuma;
import budjetointisovellus.domain.RahaTapahtumaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
/**
 *
 * @author aleksi
 */
public class FxController {
    private Database db;
    public FxController(Database db) {
        this.db = db;
    }
    public void addCategory(ActionEvent event) throws Exception {
        KategoriaDao kDao = new KategoriaDao(db);
 	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addCategoryModal.fxml"));
        //loader.setController(new FxController(db));
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);
	stage.show();
    }

    public void dateSelected(ActionEvent event) {
	

    }

    public void addPlusMoney(ActionEvent event) throws Exception {
	RahaTapahtumaDao rtDao = new RahaTapahtumaDao(db);
  	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addMoneyEvent.fxml"));
        //loader.setController(new FxController(db));
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);
	stage.show();       
    }

    public void addMinusMoney(ActionEvent event) throws Exception {
	RahaTapahtumaDao rtDao = new RahaTapahtumaDao(db);        
  	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addMoneyEvent.fxml"));
        //loader.setController(new FxController(db));
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);
	stage.show();       
    }
}
