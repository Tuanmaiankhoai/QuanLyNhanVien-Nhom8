/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Sanpham;
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
public class DAOsp {
    public Connection connection;
    public DAOsp(){
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
    public ArrayList<Sanpham> getListSP()
    {
        ArrayList<Sanpham> list = new ArrayList<>();
        String sql= "select * from tbsanpham";
        try{
        //Statement statemnet= connection.createStatement();
       // ResultSet rs= statemnet.executeQuery(sql);
        PreparedStatement statemnet= connection.prepareStatement(sql);
        ResultSet rs= statemnet.executeQuery();
        while(rs.next())
        {
            Sanpham n= new Sanpham();
            n.setId(rs.getInt("Id"));           
            n.setMasp(rs.getString("Mã sản phẩm"));
            n.setTensp(rs.getString("Tên sản phẩm"));
            n.setLoai(rs.getString("Loại"));
            n.setSoluong(rs.getInt("Số lượng"));
            n.setGia(rs.getInt("Giá"));
            list.add(n);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddSP(Sanpham n){
        String sql="INSERT INTO tbsanpham ( [Mã sản phẩm], [Tên sản phẩm],[Loại],[Số lượng], [Giá])VALUES "
                + "(?, ?,?,?,?)";       
        
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,n.getMasp());
            ps.setString(2,n.getTensp());
            ps.setString(3,n.getLoai());
            ps.setInt(4, n.getSoluong());
            ps.setInt(5,n.getGia());
            
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    //KIểm tra mã san pham đã tồn tại hay chưa
    public boolean isMaNVExist(String maSP) {
        try {
            String query = "SELECT COUNT(*) FROM tbsanpham WHERE [Mã sản phẩm] like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maSP);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void DeleteSP(int Masp){
        String sql="DELETE FROM tbsanpham WHERE [Id]=?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1, Masp);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DAOsp();
    }
}
