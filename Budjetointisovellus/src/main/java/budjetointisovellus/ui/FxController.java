/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.ui;

import budjetointisovellus.domain.Database;
import budjetointisovellus.domain.Kategoria;
import budjetointisovellus.domain.KategoriaDao;
import javafx.event.ActionEvent;

/**
 *
 * @author aleksi
 */
public class FxController {
    private Database db;
    public FxController(Database db) {
        this.db = db;
    }
    public void addCategory(ActionEvent event) {
        KategoriaDao kDao = new KategoriaDao(db);
        kDao.add(new Kategoria("Lisätty"));
    }
    public void addPlusMoney(ActionEvent event) {
        
    }
    public void addMinusMoney(ActionEvent event) {
        
    }
    public void dateKeyTyped(ActionEvent event) {
        
    }
}
