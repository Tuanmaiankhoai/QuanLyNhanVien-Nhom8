/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class SanphamCT {
    private int id;
    private String Masp;
    private int Soluong;
    private int Gia;
    
    public SanphamCT(){
        
    }

    public SanphamCT(String Masp, int Soluong, int Gia) {
        this.Masp = Masp;
        this.Soluong = Soluong;
        this.Gia = Gia;
    }

    public SanphamCT(int id, String Masp, int Soluong, int Gia) {
        this.id = id;
        this.Masp = Masp;
        this.Soluong = Soluong;
        this.Gia = Gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
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
