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
import java.util.HashSet;
import java.util.List;
/**
 *
 * @author ADMIN
 */

public class DAOnv {
    public Connection connection;
    public DAOnv(){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433; databaseName=nhanvien;encrypt=false;trustServerCertificate=true;";
        String userName= "sa";
        String password="123456";
        
        connection= DriverManager.getConnection(url, userName, password);
        
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    
    }
    
    public ArrayList<Nhanvien> getListNv()
    {
        ArrayList<Nhanvien> list = new ArrayList<>();
        String sql= "select * from tbinhnhanvien";
        try{
        //Statement statemnet= connection.createStatement();
       // ResultSet rs= statemnet.executeQuery(sql);
        PreparedStatement statemnet= connection.prepareStatement(sql);
        ResultSet rs= statemnet.executeQuery();
        while(rs.next())
        {
            Nhanvien n= new Nhanvien();
            n.setId(rs.getInt("ID"));           
            n.setManv(rs.getString("Mã nhân viên"));
            n.setTennv(rs.getString("Name"));
            n.setChucvu(rs.getString("Chức vụ"));
            n.setDate(rs.getString("Ngày sinh"));
            n.setGt(rs.getString("Giới tính"));
            n.setDiachi(rs.getString("Địa chỉ"));
            n.setSDT(rs.getString("Số điện thoại"));
            //n.getGmail(rs.getString("Gmail"));
            n.setLuong(rs.getInt("Lương"));
            list.add(n);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        new DAOnv();
    }
    

}
