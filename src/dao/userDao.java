/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import model.UserData;
import java.sql.*;

public class userDao {
    MySqlConnection mysql = new MySqlConnection();
   
    public void signUp(UserData user){
        Connection conn = mysql.openConnection();
        String sql = "Insert into users (username, email, password) values (?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.print(e);
        }finally{
            mysql.closeConnection(conn);
        }
    }
    public boolean check(UserData user){
        Connection conn = mysql.openConnection();
        String sql = "Select * From users where username = ? or email = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            ResultSet result = pstm.executeQuery();
            return result.next();
        }catch(SQLException e){
            System.out.print(e);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    
}
