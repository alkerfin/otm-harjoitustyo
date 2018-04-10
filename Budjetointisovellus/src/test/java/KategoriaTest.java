/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aleksi
 */

import budjetointisovellus.domain.Database;
import budjetointisovellus.domain.Kategoria;
import budjetointisovellus.domain.KategoriaDao;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KategoriaTest {
  @Test
  public void testAddingData() throws SQLException {
    
    Database db = new Database("testi.db");
    db.init();
    KategoriaDao kDao = new KategoriaDao(db);
    kDao.clear();
    kDao.add(new Kategoria("testi"));
    kDao.add(new Kategoria("testi2"));
    kDao.add(new Kategoria("testi3"));
    
    assertEquals("3 kpl kategorioita",3,kDao.findAll().size());
    db.close();
  }

  @Test
  public void testFindingData() throws SQLException {
    Database db = new Database("testi.db");
    db.init();
    KategoriaDao kDao = new KategoriaDao(db);
    kDao.clear();
    Kategoria k1 = new Kategoria("kategoria1");
    kDao.add(new Kategoria("testi"));
    kDao.add(k1);
    kDao.add(new Kategoria("testi3"));
    assertEquals("Löytyykö kategoria1",true,kDao.findAll().contains(k1));  
    db.close();
  }
}
