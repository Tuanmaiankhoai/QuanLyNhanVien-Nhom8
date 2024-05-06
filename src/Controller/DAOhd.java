/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Hoadon;
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
public class DAOhd {
    public Connection connection;
    public DAOhd(){
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
    public ArrayList<Hoadon> getListHD()
    {
        ArrayList<Hoadon> list = new ArrayList<>();
        String sql= "select * from tbhoadon";
        try{
        //Statement statemnet= connection.createStatement();
       // ResultSet rs= statemnet.executeQuery(sql);
        PreparedStatement statemnet= connection.prepareStatement(sql);
        ResultSet rs= statemnet.executeQuery();
        while(rs.next())
        {
            Hoadon n= new Hoadon();
            n.setMaHD(rs.getInt("Mã hóa đơn"));  
            n.setTenKH(rs.getString("Tên khách hàng"));
            n.setDiaChi(rs.getString("Địa chỉ"));
            n.setSDT(rs.getString("Số điện thoại"));
            n.setDateOrder(rs.getString("Ngày đặt"));
            n.setThanhtien(rs.getInt("Thành tiền"));
            list.add(n);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddHD(Hoadon n){
        String sql="INSERT INTO tbhoadon ([Tên khách hàng],[Địa chỉ],[Số điện thoại], [Ngày đặt], [Thành Tiền])VALUES "
                + "(?,?,?,?,?)";       
        
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,n.getTenKH());
            ps.setString(2,n.getDiaChi());
            ps.setString(3, n.getSDT());
            ps.setString(4,n.getDateOrder());
            ps.setInt(5,n.getThanhtien());
            
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    
    public void DeleteHD(int MaHD){
        String sql="DELETE FROM tbHoadon WHERE [Mã hóa đơn]=?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1, MaHD);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DAOhd();
    }
    
}
