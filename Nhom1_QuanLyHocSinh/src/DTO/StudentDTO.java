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
public class StudentDTO {
    
    private String ID;
    private String Hoten;
    private String Gioitinh;
    private String Ngaysinh;
    private String Diachi;
    private String Lop;
    private String NienKhoa;
    private String SDT;
    private String Email;
    private String HocPhi;

    public StudentDTO(String hoten, String lop, String hocPhi) {
		Hoten = hoten;
		Lop = lop;
		HocPhi = hocPhi;
	}

	public StudentDTO(String ID,String Hoten,String Ngaysinh,String Gioitinh,String Diachi, String Lop, String NienKhoa, String SDT, String Email) {				
        this.ID = ID;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.Diachi = Diachi;
        this.Lop = Lop;
        this.NienKhoa = NienKhoa;
        this.SDT = SDT;
        this.Email = Email;
    }
    
    public String toString() {
        return String.format("%s - %s - %s - %s - %s - %s - %s - %s - %s", ID, Hoten, Gioitinh, Ngaysinh, Diachi, Lop, NienKhoa, SDT, Email);
    }
    
    public String getHocPhi() {
		return HocPhi;
	}

	public void setHocPhi(String hocPhi) {
		HocPhi = hocPhi;
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

    public String getDiachi() {
        return Diachi;
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

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    } 
}
