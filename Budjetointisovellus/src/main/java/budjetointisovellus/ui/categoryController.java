package budjetointisovellus.ui;

import budjetointisovellus.domain.Kategoria;
import budjetointisovellus.domain.KategoriaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import java.util.List;
/**
 *
 * @author aleksi
 */
public class categoryController {
    private KategoriaDao kd;

    //Widgets
    private TextField txtName;
    private ColorPicker clrCategory;

    public categoryController(KategoriaDao kd) {
        this.kd = kd;
    }


    private void btnSaveClicked(ActionEvent event) {
    }

    private void btnCloseClicked(ActionEvent event) {
    }

}
