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
    
    //Hiển thị danh sách nhân viên
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

    //Thêm nhân viên
    public void AddNV(Nhanvien n){
        String sql="INSERT INTO tbinhnhanvien ([Mã nhân viên], [Name], [Chức vụ], [Ngày sinh], [Giới tính], [Địa chỉ], [Số điện thoại], [Lương])VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";       
        
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,n.getManv());
            ps.setString(2,n.getTennv());
            ps.setString(3,n.getChucvu());
            ps.setString(4,n.getDate());
            ps.setString(5,n.getGt());
            ps.setString(6,n.getDiachi());
            ps.setString(7,n.getSDT());
            ps.setInt(8,n.getLuong());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        }

    //KIểm tra mã nhân viên đã tồn tại hay chưa
    public boolean isMaNVExist(String maNV) {
        try {
            String query = "SELECT COUNT(*) FROM tbinhnhanvien WHERE [Mã nhân viên] like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maNV);
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
    
    //Xóa nhân viên
    public void DeleteNV(int id){
        String sql="DELETE FROM tbinhnhanvien WHERE Id=?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //Tìm nhân viên theo tên
    public ArrayList<Nhanvien> findbyName( String Name){
        ArrayList<Nhanvien> list= new ArrayList<>();
        String sql="SELECT * FROM tbinhnhanvien WHERE Name like ? ";
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,"%"+Name+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
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
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    //Tìm nhân viên theo mã sinh viên
    public ArrayList<Nhanvien> findbyManv( String Manv){
        ArrayList<Nhanvien> list= new ArrayList<>();
        String sql="SELECT * FROM tbinhnhanvien WHERE [Mã nhân viên] like ? ";
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,"%"+Manv+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
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
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        new DAOnv();
    }
    

}
