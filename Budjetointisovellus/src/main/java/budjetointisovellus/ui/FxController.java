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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.collections.FXCollections;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
/**
 *
 * @author aleksi
 */
public class FxController {
    private Database db;

    //Widgetit
    @FXML
    private ListView lstItems;
    @FXML
    private DatePicker selectDate;
    @FXML
    private Label lblSum;

    public FxController(Database db) {
        this.db = db;
    }
    public void addCategory(ActionEvent event) throws Exception {
        KategoriaDao kDao = new KategoriaDao(db);
 	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../addCategoryModal.fxml"));
        //loader.setController(new FxController(db));
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);
	stage.show();
    }

    public void dateSelected(ActionEvent event) {
	if(this.db == null) {
		System.out.println("DB IS ALREADY NULL");
		return;	
	}
	RahaTapahtumaDao rtDao = new RahaTapahtumaDao(db);
	Date d = Date.from(selectDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()); //PROBLEM HERE

	Double summa = rtDao.getSumByMonth(d);
 	List<RahaTapahtuma> tapahtumat = rtDao.findAllByMonth(d);
	
	lstItems.setItems(FXCollections.observableList(tapahtumat));
	

	//Label summa oikeaksi
	lblSum.setText(summa.toString()+" €");
    }

    public void addPlusMoney(ActionEvent event) throws Exception {
	RahaTapahtumaDao rtDao = new RahaTapahtumaDao(db);
  	FXMLLoader loader = new FXMLLoader();
	moneyEventController ctrl = new moneyEventController(rtDao,false);
        loader.setLocation(getClass().getResource("../../addMoneyEvent.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);
	ctrl.setDialog(stage);
	stage.show();       
    }

    public void addMinusMoney(ActionEvent event) throws Exception {
	RahaTapahtumaDao rtDao = new RahaTapahtumaDao(db);
	moneyEventController ctrl = new moneyEventController(rtDao,true);        
  	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../addMoneyEvent.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.initModality(Modality.WINDOW_MODAL);

	ctrl.setDialog(stage);

	stage.show();       
    }
}
