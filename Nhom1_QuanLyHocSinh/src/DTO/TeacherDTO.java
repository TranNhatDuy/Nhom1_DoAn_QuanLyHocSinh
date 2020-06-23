/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class TeacherDTO {
    private String ID;
    private String Hoten;
    private String Gioitinh;
    private String Ngaysinh;
    private String DiaChi;
    private String Lop;
    private String NienKhoa;
    private String SDT;
    private String Email;
    
    public TeacherDTO(String ID,String Hoten,String Ngaysinh,String Gioitinh,String Diachi, String Lop, String NienKhoa, String SDT, String Email) {				
        this.ID = ID;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.DiaChi = Diachi;
        this.Lop = Lop;
        this.NienKhoa = NienKhoa;
        this.SDT = SDT;
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public String getNienKhoa() {
        return NienKhoa;
    }

    public void setNienKhoa(String NienKhoa) {
        this.NienKhoa = NienKhoa;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public TeacherDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID() {
        return ID;  
    }

    public String getHoten() {
        return Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
}
