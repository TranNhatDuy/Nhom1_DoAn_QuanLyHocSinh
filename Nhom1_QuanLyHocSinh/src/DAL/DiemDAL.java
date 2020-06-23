/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DiemDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynh
 */
public class DiemDAL {
    public static List<DiemDTO> getAll() {
        List<DiemDTO> diemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "SELECT diem.UserID, information.HoTen, information.Lop, diem.TiengViet, diem.Toan, diem.LSvaDL, diem.AmNhac, diem.MyThuat, diem.TheDuc, diem.DaoDuc FROM `user`, `information`, `diem` WHERE diem.UserID=user.UserID AND user.UserID=information.UserID AND information.Lop=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, GUI.Form_GV.txtLop.getText());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                DiemDTO diem = new DiemDTO(rs.getString("UserID"), rs.getString("HoTen"), 
                        rs.getString("Lop"), rs.getString("TiengViet"), 
                        rs.getString("Toan"), rs.getString("LSvaDL"),
                        rs.getString("AmNhac"), rs.getString("MyThuat"),
                        rs.getString("TheDuc"), rs.getString("DaoDuc"));                
                diemList.add(diem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return diemList;
    }
    public static void update(DiemDTO diem){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "UPDATE diem SET TiengViet=?, Toan=?, LSvaDL=?, AmNhac=?, MyThuat=?, TheDuc=?, DaoDuc=? WHERE UserID=?";
            statement = connection.prepareCall(sql);
            
            statement.setString(8, diem.getID());
            statement.setString(1, diem.getTiengViet());
            statement.setString(2, diem.getToan());
            statement.setString(3, diem.getLSDL());
            statement.setString(4, diem.getAmNhac());
            statement.setString(5, diem.getMyThuat());
            statement.setString(6, diem.getTheDuc());
            statement.setString(7, diem.getDaoDuc());

            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    public static List<DiemDTO> diemCaNhan(String id) {
        List<DiemDTO> diemList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                       
            String sql = "SELECT information.HoTen, information.Lop, diem.TiengViet, diem.Toan, diem.LSvaDL, diem.AmNhac, diem.MyThuat, diem.TheDuc, diem.DaoDuc FROM `user`, `information`, `diem` WHERE diem.UserID=user.UserID AND user.UserID=information.UserID AND user.role='HS' AND user.UserID=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {                
                DiemDTO diem = new DiemDTO(rs.getString("HoTen"), 
                        rs.getString("Lop"), rs.getString("TiengViet"), 
                        rs.getString("Toan"), rs.getString("LSvaDL"),
                        rs.getString("AmNhac"), rs.getString("MyThuat"),
                        rs.getString("TheDuc"), rs.getString("DaoDuc"));                
                diemList.add(diem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return diemList;
    }
    
    public static int SLHS(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "SELECT COUNT(diem.UserID) AS SLHS FROM diem, information, user WHERE user.UserID=information.UserID AND user.UserID = diem.UserID AND information.Lop=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, GUI.Form_GV.txtLop.getText());
            rs = statement.executeQuery();
            if(rs.next()){
                a = rs.getInt("SLHS"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public static String SLHSByHocLuc(String hl){
        List<DiemDTO> diemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        int count = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                       
            String sql = "SELECT information.HoTen, information.Lop, diem.TiengViet, diem.Toan, diem.LSvaDL, diem.AmNhac, diem.MyThuat, diem.TheDuc, diem.DaoDuc FROM `user`, `information`, `diem` WHERE diem.UserID=user.UserID AND user.UserID=information.UserID AND user.role='HS' AND information.Lop=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, GUI.Form_GV.txtLop.getText());
            ResultSet rs = statement.executeQuery();
            
            String HocLuc;
            while (rs.next()) {                
                DiemDTO diem = new DiemDTO(rs.getString("HoTen"), 
                        rs.getString("Lop"), rs.getString("TiengViet"), 
                        rs.getString("Toan"), rs.getString("LSvaDL"),
                        rs.getString("AmNhac"), rs.getString("MyThuat"),
                        rs.getString("TheDuc"), rs.getString("DaoDuc"));  
                HocLuc = diem.hocLuc();
                diemList.add(diem);
                if(HocLuc.equals(hl)){
                    count++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiemDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
        float PT = count*100/SLHS();
        return count+" ( "+PT+"% )";
    }
}
