/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SanphamCT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DAOspct {
    public Connection connection;
    public DAOspct(){
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
    public ArrayList<SanphamCT> getListSPCT()
    {
        ArrayList<SanphamCT> list = new ArrayList<>();
        String sql= "select * from tbsanphamct";
        try{
        //Statement statemnet= connection.createStatement();
       // ResultSet rs= statemnet.executeQuery(sql);
        PreparedStatement statemnet= connection.prepareStatement(sql);
        ResultSet rs= statemnet.executeQuery();
        while(rs.next())
        {
            SanphamCT n= new SanphamCT();
            n.setId(rs.getInt("Id"));           
            n.setMasp(rs.getString("Mã sản phẩm"));
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
    
    public void AddSPCT(SanphamCT n){
        String sql="INSERT INTO tbsanphamct([Mã sản phẩm], [Số lượng], [Giá]) VALUES "
                + "(?, ?, ?)";       
        
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,n.getMasp());
            ps.setInt(2,n.getSoluong());
            ps.setInt(3,n.getGia());

            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    public void DeleteSPCT(int id){
        String sql="DELETE FROM tbsanphamct WHERE Id=?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DAOspct();
    }
}
