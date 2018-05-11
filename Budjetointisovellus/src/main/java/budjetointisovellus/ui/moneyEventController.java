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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.collections.FXCollections;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;
import javafx.fxml.FXML;
/**
 *
 * @author aleksi
 */
public class moneyEventController {
    private RahaTapahtumaDao rtd;
    private boolean minus;

    private Stage dialog;

    //Widgets
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSum;
    @FXML
    private ChoiceBox cbCategory;
    @FXML
    private DatePicker selectDate;


    public moneyEventController(RahaTapahtumaDao rtd,boolean minus) {
        this.rtd = rtd;
	this.minus = minus;
	//Init categories
    }

    public void setDialog(Stage dlg) {
	this.dialog = dlg;
    }

    public void btnSaveClicked(ActionEvent event) {
	double sum = 0.0;
	if(txtName.getText().isEmpty()) {
		return;
	}
	if(txtSum.getText().isEmpty()) {
		return;
	}
	if(selectDate.getValue() == null) {
		return;
	}
	try {
		sum = Double.parseDouble(txtSum.getText());
	} catch(Exception ex) {
		return;	
	}
	
	
	Date d = Date.from(selectDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

	sum = Math.abs(sum);

	if(sum <= 0.0) {
		return;	
	}
	if(minus) {
		sum = -(sum);	
	}	
	RahaTapahtuma rt = new RahaTapahtuma(-1,txtName.getText(),d,sum,new Kategoria("testi"));
	
	this.rtd.add(rt);
	this.dialog.close();
	//stage.close();
    }

    public void btnCloseClicked(ActionEvent event) {
	//stage.close();
	this.dialog.close();
    }


}
