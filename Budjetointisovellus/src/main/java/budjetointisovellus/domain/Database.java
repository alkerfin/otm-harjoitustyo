/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tietokannan hallintaan tarkoitettu luokka. 
 * Käytä vain yhtä instanssia tästä luokasta.
 * @author aleksi
 */
public class Database {

    private Connection conn;
    
    /**
    * Constructori, joka luo tietokanta yhteyden
    * @param String db Tietokanta tiedoston sijainti
    */    
    public Database(String db) throws SQLException {
       this.conn = DriverManager.getConnection("jdbc:sqlite:"+db);
    }
    /**
    * SQL-lauseen suorittaminen ilman tietojen palautusta, käytä Insert,Update,Delete-lauseille
    * @throws SQLException jos tietokanta-yhteys ei toimi tai muu virhe
    * @param String sql Suoritettava sql-lause
    * @return boolean arvo sql-lauseen suorittamisen onnistumisesta
    */
    public boolean executeQuery(String sql) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.execute();
    }
    
    /**
    * SQL-lauseen suorittaminen parametri listalla ilman tietojen palautusta, käytä Insert,Update,Delete-lauseille
    * @throws SQLException jos tietokanta-yhteys ei toimi tai muu virhe
    * @param String sql Suoritettava sql-lause
    * @param List<Object> params SQL-lauseen parametrit
    * @return boolean arvo sql-lauseen suorittamisen onnistumisesta
    */
    public boolean executeQuery(String sql,List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i = 0;i < params.size();i++) {
            pstmt.setObject(i+1,params.get(i));
        }
        return pstmt.execute();
    }
    /**
    * Suorittaa SQL-lauseen ja palauttaa arvot, käytä SELECT-lauseille
    * @throws SQLException jos tietokanta-yhteys ei toimi tai muu virhe
    * @param String sql Suoritettava SQL-lause
    * @param List<Object> params SQL-lauseen parametrit
    * @return ResultSet SQL-lauseen kysymät arvot
    */
    public ResultSet selectQuery(String sql,List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i = 0;i < params.size();i++) {
            pstmt.setObject(i+1,params.get(i));
        }
        return pstmt.executeQuery();
    }
    /**
    * Suorittaa SQL-lauseen ja palauttaa arvot, käytä SELECT-lauseille
    * @throws SQLException jos tietokanta-yhteys ei toimi tai muu virhe
    * @param String sql Suoritettava SQL-lause
    * @return ResultSet SQL-lauseen kysymät arvot
    */
    
    public ResultSet selectQuery(String sql) throws SQLException { 
         PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();       
    }
    /**
    * Sulkee tietokanta-yhteyden
    * @throws SQLException jos tietokanta-yhteys ei toimi tai muu tietokanta-virhe
    */
    public void close() throws SQLException {
        this.conn.close();
    }
    /**
    * Luo tietokanta-taulut ohjelmalle
    */
    public void init() {
        String sql = "CREATE TABLE IF NOT EXISTS category ("
                + " id INTEGER  NOT NULL PRIMARY KEY,"
                + " name VARCHAR(40));";

        try {
            this.executeQuery(sql);
		sql = "CREATE TABLE IF NOT EXISTS moneyevent("
		+ " id INTEGER NOT NULL PRIMARY KEY,"
		+ " name VARCHAR(40),"
		+ " amount double,"
		+ " cat_id int,"
		+ " eventDate INTEGER,"
		+ " FOREIGN KEY (cat_id) REFERENCES category(id));";
	     this.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
