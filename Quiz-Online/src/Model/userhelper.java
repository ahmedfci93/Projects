/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class userhelper {
    static Connection connection;
    static PreparedStatement prestmt;
    static ResultSet result;

    public void insertuser(userbean user) throws ClassNotFoundException, SQLException{
        connection = DB.OpenConnection();
        prestmt = connection.prepareStatement("insert into users(username,password,name,email,usertype) values(?,?,?,?,?)");
         ArrayList<Object> parameters=new ArrayList<Object>();
         parameters.add(user.getUsername());
         parameters.add(user.getPassword());
         parameters.add(user.getName());
         parameters.add(user.getEmail());
         parameters.add(user.getUsertype());
         DB.executeNonQuery(prestmt, parameters);
    }
    
    public ArrayList<userbean> selectall() throws ClassNotFoundException, SQLException{
        ArrayList<userbean> users=new ArrayList<userbean>();
        
        connection = DB.OpenConnection();
        prestmt = connection.prepareStatement("select * from users");
        result = prestmt.executeQuery();
        while(result.next()){
            userbean user=new userbean();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setEmail(result.getString("email"));
            user.setUsertype(result.getInt("usertype"));
            users.add(user);
        }
        
        
        return users;
    }
    
    public void deleteuser(int id) throws ClassNotFoundException, SQLException{
        connection = DB.OpenConnection();
        prestmt = connection.prepareStatement("delete from users where id=?");
        ArrayList<Object> parameters=new ArrayList<Object>();
        parameters.add(id);
        DB.executeNonQuery(prestmt, parameters);
     
    }
    
    public void updateuser(userbean user) throws ClassNotFoundException, SQLException{
        connection = DB.OpenConnection();
        prestmt = connection.prepareStatement("update users set username=?, password=?, name=?, email=?,usertype=? where id=?");
        ArrayList<Object> parameters=new ArrayList<Object>();
         parameters.add(user.getUsername());
         parameters.add(user.getPassword());
         parameters.add(user.getName());
         parameters.add(user.getEmail());
         parameters.add(user.getUsertype());
         parameters.add(user.getId());
         
        DB.executeNonQuery(prestmt, parameters);
     
    }
    
    public userbean getuserbyid(int id) throws ClassNotFoundException, SQLException{
        userbean user =null;
        connection = DB.OpenConnection();
        prestmt = connection.prepareStatement("select * from users where id=?");
        ArrayList<Object> parameters=new ArrayList<Object>();
        parameters.add(id);
        result=DB.executeQuery(prestmt, parameters);
        
        if(result.next()){
            user = new userbean();
            user.setId(id);
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setUsername(result.getString("username"));
        }
        return user;
    }
    
        public static userbean isExist(String username,String password) throws ClassNotFoundException{
        userbean u=null;
        
        
        try {
        	connection = DB.OpenConnection();
			prestmt=connection.prepareStatement("select * from users where username=? and password=?");
			ArrayList<Object> paramertes=new ArrayList<Object>();
			paramertes.add(username);
            paramertes.add(password);
            result = DB.executeQuery(prestmt, paramertes);
            if(result.next()){
                u=new userbean();
                u.setId(result.getInt("id"));
                u.setName(result.getString("name"));
                u.setUsername(result.getString("username"));
                u.setPassword(result.getString("password"));
                u.setEmail(result.getString("email"));
                u.setUsertype(result.getInt("usertype"));
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
     return u;   
    }
}
