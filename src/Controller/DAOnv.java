/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Nhanvien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
/**
 *
 * @author ADMIN
 */

public class DAOnv {
    private DAOnv(){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433; databaseName=nhanvien;encrypt=false;trustServerCertificate=true;";
        String userName= "sa";
        String password="123456";
        
        Connection connection= DriverManager.getConnection(url, userName, password);
        String sql= "select * from tbinhnhanvien";
        Statement statemnet= connection.createStatement();
        ResultSet rs= statemnet.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString("Name"));
        }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    
}
    

    public static void main(String[] args) {
        new DAOnv();
    }
}
