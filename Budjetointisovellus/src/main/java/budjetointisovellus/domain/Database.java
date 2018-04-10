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
 *
 * @author aleksi
 */
public class Database {
    private Connection conn;
    
    
    public Database(String db) throws SQLException {
       this.conn = DriverManager.getConnection("jdbc:sqlite:"+db);
    }
    
    public boolean executeQuery(String sql) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.execute();
    }
    
    public boolean executeQuery(String sql,List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i = 0;i < params.size();i++) {
            pstmt.setObject(i+1,params.get(i));
        }
        return pstmt.execute();
    }
    
    public ResultSet selectQuery(String sql,List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i = 0;i < params.size();i++) {
            pstmt.setObject(i+1,params.get(i));
        }
        return pstmt.executeQuery();
    }
    
    public ResultSet selectQuery(String sql) throws SQLException { 
         PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();       
    }
    
    public void close() throws SQLException {
        this.conn.close();
    }
    
    public void init() {
        String sql = "CREATE TABLE IF NOT EXISTS category ("
                + " id INTEGER  NOT NULL PRIMARY KEY,"
                + " name VARCHAR(40));";
        try {
            this.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
