/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Administrator
 */
public class DB {
    private static ResultSet result;

    public static Connection OpenConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/project?user=root&password=root");
       
        
        return con;
    }
    
    public static ResultSet executeQuery(PreparedStatement preStmt,List<Object> params){
        
        try {
            for(int i=0;i<params.size();i++){
                preStmt.setObject(i+1, params.get(i));
            }
            result=preStmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;        
    }
    
    public static void executeNonQuery(PreparedStatement preStmt,List<Object> params){
        
        try {
            for(int i=0;i<params.size();i++){
                preStmt.setObject(i+1, params.get(i));
            }
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
