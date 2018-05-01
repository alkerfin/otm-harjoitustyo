
package budjetointisovellus.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka tietokannan ja Kategorian yhdistämisestä.
 * @author aleksi
 */
public class KategoriaDao {
/**
* Tietokanta-luokka tietokanta yhteydelle
*/
    private Database db;
    
    public KategoriaDao(Database db) {
        this.db = db;
    }

    /**
    * Lisää Kategoria objekti tietokantaan
    * @param Kategoria k Tietokantaan lisättävä Kategoria-objekti
    * @return boolean arvo tietokantaan lisäämisen onnistumisesta
    */
    public boolean add(Kategoria k) {
        String sql = "INSERT INTO category (name,color) values (?,?);";
        List<Object> params = new ArrayList<>();
        params.add(k.getNimi());
        try {
            return db.executeQuery(sql, params);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /**
    * Tyhjentää kaikki kategoriat tietokannasta
    * @return boolean arvo tietokannan tyhjennyksen onnistumisesta
    */
    public boolean clear() {
        String sql = "DELETE FROM category;";
        try {
            return db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /**
    * Etsi yksi kategoria tietokannasta Id:n perusteella
    * @param int id Tietokanta-objektin id
    * @return Kategoria objekti tai epäonnistuessaan null
    */
    public Kategoria findOneById(int id) {
   	String sql = "SELECT * FROM category WHERE id = ? LIMIT 1";
	List<Object> params = new ArrayList<>();
	params.add(id);
	try {
		ResultSet results = db.selectQuery(sql,params);	
		if(results.next()) {
			Kategoria k = new Kategoria(results.getInt("id"),results.getString("name"));
			return k;
		} else {
			return null;		
		}
	} catch(SQLException ex) {
		Logger.getLogger(KategoriaDao.class.getName()).log(Level.SEVERE,null,ex);
		return null;	
	}
    }
    /**
    * Etsi kaikki kategoriat tietokannasta
    * @return List<Kategoria> Lista kategorioista
    */
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
