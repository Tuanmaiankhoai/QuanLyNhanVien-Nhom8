/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Hoadon {
    private int MaHD;
    private String TenKH;
    private String DiaChi;
    private String SDT;
    private String DateOrder;
    private int Thanhtien;
    
    
    public Hoadon(){
        
    }

    public Hoadon(String TenKH, String DiaChi, String SDT, String DateOrder, int Thanhtien) {
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.DateOrder = DateOrder;
        this.Thanhtien = Thanhtien;
    }

    public Hoadon(int MaHD, String TenKH, String DiaChi, String SDT, String DateOrder, int Thanhtien) {
        this.MaHD = MaHD;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.DateOrder = DateOrder;
        this.Thanhtien = Thanhtien;
    }

    

    

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String DateOrder) {
        this.DateOrder = DateOrder;
    }

    public int getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(int Thanhtien) {
        this.Thanhtien = Thanhtien;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    
    
}
