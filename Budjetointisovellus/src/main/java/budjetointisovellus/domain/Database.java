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
            pstmt.setObject(i,params.get(i));
        }
        return pstmt.execute();
    }
    
    public ResultSet selectQuery(String sql,List<Object> params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for(int i = 0;i < params.size();i++) {
            pstmt.setObject(i,params.get(i));
        }
        return pstmt.executeQuery();
    }
    
    public ResultSet selectQuery(String sql) throws SQLException { 
         PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();       
    }
    
    public void init() {
        
    }
    
}
