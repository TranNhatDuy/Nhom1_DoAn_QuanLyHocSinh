/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ThoiKhoaBieuDTO;

import java.awt.Window.Type;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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
public class ThoiKhoaBieuDAL {
    public static List<ThoiKhoaBieuDTO> getTkbByLop(String lop) {
        List<ThoiKhoaBieuDTO> tkbList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                       
            String sql = "SELECT T2,T3,T4,T5,T6 FROM tkb WHERE Lop=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, lop);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                ThoiKhoaBieuDTO tkb = new ThoiKhoaBieuDTO(rs.getString("T2"),rs.getString("T3"), 
                        rs.getString("T4"), rs.getString("T5"), rs.getString("T6"));                
                tkbList.add(tkb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThoiKhoaBieuDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThoiKhoaBieuDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThoiKhoaBieuDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return tkbList;
    }
    

    public static void update(ThoiKhoaBieuDTO tkb) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                    
            String sql = "UPDATE `tkb` SET T2=?, T3=?, T4=?, T5=?, T6=? WHERE Lop=? AND Tiet=?";
            statement = connection.prepareCall(sql);       
            
            statement.setString(7, tkb.getTiet());
            statement.setString(6, tkb.getLop());
            statement.setString(1, tkb.getT2());
            statement.setString(2, tkb.getT3());  
            statement.setString(3, tkb.getT4()); 
            statement.setString(4, tkb.getT5()); 
            statement.setString(5, tkb.getT6()); 
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<ThoiKhoaBieuDTO> getTkbByLop(Type String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
