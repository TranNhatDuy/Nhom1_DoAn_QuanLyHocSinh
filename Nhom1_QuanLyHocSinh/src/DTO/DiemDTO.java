/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author huynh
 */
public class DiemDTO {
    private String ID;
    private String hoTen;
    private String lop;
    private String tiengViet;
    private String toan;
    private String LSDL;
    private String amNhac;
    private String myThuat;
    private String theDuc;
    private String daoDuc;
    private float DTB;
    private String hocLuc;

    public DiemDTO(String hoTen, String lop, String tiengViet, String toan, String LSDL, String amNhac, String myThuat, String theDuc, String daoDuc) {
        this.hoTen = hoTen;
        this.lop = lop;
        this.tiengViet = tiengViet;
        this.toan = toan;
        this.LSDL = LSDL;
        this.amNhac = amNhac;
        this.myThuat = myThuat;
        this.theDuc = theDuc;
        this.daoDuc = daoDuc;
    }
    public DiemDTO(String ID, String hoTen, String lop, String tiengViet, String toan, String LSDL, String amNhac, String myThuat, String theDuc, String daoDuc) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.lop = lop;
        this.tiengViet = tiengViet;
        this.toan = toan;
        this.LSDL = LSDL;
        this.amNhac = amNhac;
        this.myThuat = myThuat;
        this.theDuc = theDuc;
        this.daoDuc = daoDuc;
    }
    public DiemDTO(String ID, String tiengViet, String toan, String LSDL, String amNhac, String myThuat, String theDuc, String daoDuc) {
        this.ID = ID;
        this.tiengViet = tiengViet;
        this.toan = toan;
        this.LSDL = LSDL;
        this.amNhac = amNhac;
        this.myThuat = myThuat;
        this.theDuc = theDuc;
        this.daoDuc = daoDuc;
    }
    
    public float diemTB(){
        int TV = Integer.valueOf(this.tiengViet);
        int T = Integer.valueOf(this.toan);
        int LSDL = Integer.valueOf(this.LSDL);
        int AN = Integer.valueOf(this.amNhac);
        int MT = Integer.valueOf(this.myThuat);
        int TD = Integer.valueOf(this.theDuc);
        int DD = Integer.valueOf(this.daoDuc);
        float dtb = (float) ((TV + T + LSDL + AN + MT + TD + DD)*1.0/7);
        return (float) Math.round(dtb * 10) / 10;
    }
    
    public String hocLuc(){
        if(getDTB() >= 8)   
            return "HSG";
        else if(getDTB() >=7)
            return "HSK";
        else if(getDTB() >=5)
            return "HSTB";
        else
            return "HSY";
        
    }

    public String getHocLuc() {
        return hocLuc();
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }
    
    public float getDTB() {
        return diemTB();
    }

    public void setDTB(float DTB) {
        this.DTB = DTB;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTiengViet() {
        return tiengViet;
    }

    public void setTiengViet(String tiengViet) {
        this.tiengViet = tiengViet;
    }

    public String getToan() {
        return toan;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public String getLSDL() {
        return LSDL;
    }

    public void setLSDL(String LSDL) {
        this.LSDL = LSDL;
    }

    public String getAmNhac() {
        return amNhac;
    }

    public void setAmNhac(String amNhac) {
        this.amNhac = amNhac;
    }

    public String getMyThuat() {
        return myThuat;
    }

    public void setMyThuat(String myThuat) {
        this.myThuat = myThuat;
    }

    public String getTheDuc() {
        return theDuc;
    }

    public void setTheDuc(String theDuc) {
        this.theDuc = theDuc;
    }

    public String getDaoDuc() {
        return daoDuc;
    }

    public void setDaoDuc(String daoDuc) {
        this.daoDuc = daoDuc;
    }
    
}
