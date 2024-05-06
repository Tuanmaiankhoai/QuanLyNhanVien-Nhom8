/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Sanpham {
    private int Id;
    private String Masp;
    private String Tensp;
    private String loai;
    private int Soluong;
    private int Gia;
    
    public Sanpham(){
        
    }

    public Sanpham(String Masp, String Tensp, String loai, int Soluong, int Gia) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.loai = loai;
        this.Soluong = Soluong;
        this.Gia = Gia;
    }

    public Sanpham(int Id, String Masp, String Tensp, String loai, int Soluong, int Gia) {
        this.Id = Id;
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.loai = loai;
        this.Soluong = Soluong;
        this.Gia = Gia;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
    
}
