/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleksi
 */
public class KategoriaDao {
    private Database db;
    
    public KategoriaDao(Database db) {
        this.db = db;
    }
    
    public boolean add(Kategoria k) {
        String sql = "INSERT INTO category (name) values (?);";
        List<Object> params = new ArrayList<>();
        params.add(k.getNimi());
        try {
            return db.executeQuery(sql, params);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean clear() {
        String sql = "DELETE FROM category;";
        try {
            return db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Kategoria> findAll() {
        List<Kategoria> result = new ArrayList<>();
        String sql = "SELECT * FROM category;";
        try {
            ResultSet results = db.selectQuery(sql);
            while(results.next()) {
                result.add(new Kategoria(results.getString("name")));
            }
            results.close();
            return result;
        } catch(SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean update(int id,Kategoria k) {
        return false;
    }
    
    
}
