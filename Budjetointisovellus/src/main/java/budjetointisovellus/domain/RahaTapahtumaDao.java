package budjetointisovellus.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.lang.*;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;

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
        String sql = "INSERT INTO moneyevent (name,amount,cat_id,eventDate) values (?,?,-1,?);";
        List<Object> params = new ArrayList<>();
        params.add(k.getNimi());
	params.add(k.getSumma());
	params.add((long)k.getPaiva().getTime()/1000);
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

        String sql = "SELECT sum(amount) as summa FROM moneyevent WHERE strftime('%m',datetime(eventDate,'unixepoch')) = ? AND strftime('%Y',datetime(eventDate,'unixepoch')) = ?;";
	List<Object> params = new ArrayList<>();
	params.add(new SimpleDateFormat("MM").format(pvm));
	params.add(new SimpleDateFormat("yyyy").format(pvm));
	try {
		ResultSet results = this.db.selectQuery(sql,params);
		if(results.next()) {
			System.out.println(results.getDouble("summa"));
			return results.getDouble("summa");
		} else {
			return 0.00;
		}
	} catch(SQLException ex) {
		return 0.00;	
	}
    }

    public double getSumByDate(Date pvm) {

        String sql = "SELECT sum(amount) as summa FROM moneyevent WHERE date(datetime(eventDate,'unixepoch')) = ?;";
	List<Object> params = new ArrayList<>();//%Y-%m-%d
	params.add(new SimpleDateFormat("yyyy-MM-dd").format(pvm));
	try {
		ResultSet results = this.db.selectQuery(sql,params);
		
		if(results.next()) {
			System.out.println(results.getDouble("summa"));
			return results.getDouble("summa");
		} else {
			return 0.00;
		}
	} catch(SQLException ex) {
		return 0.00;	
	}
    }

    public List<RahaTapahtuma> findAllByDate(Date pvm) {
        List<RahaTapahtuma> result = new ArrayList<>();
        String sql = "SELECT * FROM moneyevent WHERE date(datetime(eventDate,'unixepoch')) = ?;";
	List<Object> params = new ArrayList<>();//%Y-%m-%d
	params.add(new SimpleDateFormat("yyyy-MM-dd").format(pvm));
	if(this.db == null) {
		//Logger.getLogger(RahaTapahtumaDao.class.getName()).log(Level.SEVERE,"DB null",null);
		System.out.println("DB NULL");
	}
        try {
            ResultSet results = this.db.selectQuery(sql,params);
            while(results.next()) {
		//new RahaTapahtuma(-1,txtName.getText(),d,sum,new Kategoria("testi"))
                result.add(new RahaTapahtuma(results.getInt("id"),results.getString("name"),pvm,results.getDouble("amount"),new Kategoria("null")));
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

        String sql = "SELECT * FROM moneyevent WHERE strftime('%m',datetime(eventDate,'unixepoch')) = ? AND strftime('%Y',datetime(eventDate,'unixepoch')) = ?;";
	List<Object> params = new ArrayList<>();
	params.add(new SimpleDateFormat("MM").format(pvm));
	params.add(new SimpleDateFormat("yyyy").format(pvm));

	if(this.db == null) {
		//Logger.getLogger(RahaTapahtumaDao.class.getName()).log(Level.SEVERE,"DB null",null);
		System.out.println("DB NULL");
	}
        try {
            ResultSet results = db.selectQuery(sql,params);
            while(results.next()) {
		
                result.add(new RahaTapahtuma(results.getInt("id"),results.getString("name"),pvm,results.getDouble("amount"),new Kategoria("null")));
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
