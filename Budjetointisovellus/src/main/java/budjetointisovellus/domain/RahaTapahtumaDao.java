package budjetointisovellus.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka tietokannan ja rahaTapahtuman yhdistämisestä
 * @author aleksi
 */
public class RahaTapahtumaDao {
    private Database db;
    
    public RahaTapahtumaDao(Database db) {
        this.db = db;
    }
    
    public boolean add(RahaTapahtuma k) {
        String sql = "INSERT INTO moneyevent (name,color) values (?,?);";
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
        String sql = "DELETE FROM moneyevent;";
        try {
            return db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public double getSumByMonth(Date pvm) {
	return 0.00;
    }

    public double getSumByDate(Date pvm) {
	return 0.00;
    }

    public List<RahaTapahtuma> findAllByDate(Date pvm) {
        List<RahaTapahtuma> result = new ArrayList<>();
        String sql = "SELECT * FROM category;";
        try {
            ResultSet results = db.selectQuery(sql);
            while(results.next()) {
                //result.add(new Kategoria(results.getString("name")));
            }
            results.close();
            return result;
        } catch(SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<RahaTapahtuma> findAllByMonth(Date pvm) {
        List<RahaTapahtuma> result = new ArrayList<>();
        String sql = "SELECT * FROM category;";
        try {
            ResultSet results = db.selectQuery(sql);
            while(results.next()) {
                //result.add(new Kategoria(results.getString("name")));
            }
            results.close();
            return result;
        } catch(SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean update(RahaTapahtuma rt) {
        return false;
    }
    
    
}
