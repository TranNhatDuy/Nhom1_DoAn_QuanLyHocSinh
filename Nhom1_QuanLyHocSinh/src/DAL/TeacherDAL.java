
package DAL;

import DTO.TeacherDTO;
import UTILS.ConnectionUtils;

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

public class TeacherDAL {
	ResultSet rs = null;
	ConnectionUtils conn = null;
	PreparedStatement ps = null;
	UserDAL userDAL = new UserDAL();
    public static List<TeacherDTO> getAll() {
        List<TeacherDTO> teacherList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                       
            String sql = "SELECT * FROM `information`, `user` WHERE user.UserID=information.UserID AND user.role='GV'";
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                TeacherDTO tea = new TeacherDTO(rs.getString("UserID"), 
                        rs.getString("HoTen"), rs.getString("NgaySinh"), 
                        rs.getString("GioiTinh"), rs.getString("DiaChi"),
                        rs.getString("Lop"), rs.getString("NienKhoa"),
                        rs.getString("SoDienThoai"), rs.getString("Email"));                
                teacherList.add(tea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return teacherList;
    }
    
    public static void insert(TeacherDTO tea) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                        
            String sql = "insert into information(UserID, HoTen, NgaySinh, GioiTinh, DiaChi, Lop, NienKhoa, SoDienThoai, Email) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, tea.getID());
            statement.setString(2, tea.getHoten());
            statement.setString(3, tea.getNgaysinh());
            statement.setString(4, tea.getGioitinh());
            statement.setString(5, tea.getDiaChi());
            statement.setString(6, tea.getLop());
            statement.setString(7, tea.getNienKhoa());
            statement.setString(8, tea.getSDT());
            statement.setString(9, tea.getEmail());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(TeacherDTO tea) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "update information set HoTen=?, NgaySinh=?, GioiTinh=?, DiaChi=?, Lop=?, NienKhoa=?, SoDienThoai=?, Email=? where UserID = ?";
            statement = connection.prepareCall(sql);  
            statement.setString(9, tea.getID());
            statement.setString(1, tea.getHoten());
            statement.setString(2, tea.getNgaysinh());
            statement.setString(3, tea.getGioitinh());
            statement.setString(4, tea.getDiaChi());
            statement.setString(5, tea.getLop());
            statement.setString(6, tea.getNienKhoa());
            statement.setString(7, tea.getSDT());
            statement.setString(8, tea.getEmail());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(String ID) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            
            
            String sql = "delete from `information`, `user` where user.UserID=information.UserID and user.UserID = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, ID);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<TeacherDTO> findByID(String ID) {
        List<TeacherDTO> teacherList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                      
            String sql = "SELECT * FROM `information`, `user` WHERE information.UserID=user.UserID and information.UserID=? and user.role = 'GV'";
            statement = connection.prepareCall(sql);
            statement.setString(1, ID);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                TeacherDTO tea = new TeacherDTO(rs.getString("UserID"), 
                        rs.getString("HoTen"), rs.getString("NgaySinh"), 
                        rs.getString("GioiTinh"), rs.getString("DiaChi"),
                        rs.getString("Lop"), rs.getString("NienKhoa"),
                        rs.getString("SoDienThoai"), rs.getString("Email"));               
                teacherList.add(tea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return teacherList;
    }
}
