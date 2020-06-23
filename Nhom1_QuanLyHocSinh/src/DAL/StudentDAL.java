
package DAL;

import DTO.StudentDTO;
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

public class StudentDAL {
    public static List<StudentDTO> getAll() {
        List<StudentDTO> studentList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "SELECT * FROM `information`, `user` WHERE user.UserID=information.UserID AND user.role='HS'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {                
                StudentDTO std = new StudentDTO(rs.getString("UserID"), 
                        rs.getString("HoTen"), rs.getString("NgaySinh"), 
                        rs.getString("GioiTinh"), rs.getString("DiaChi"),
                        rs.getString("Lop"), rs.getString("NienKhoa"),
                        rs.getString("SoDienThoai"), rs.getString("Email"));                
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return studentList;
    }
    
    public static List<StudentDTO> getDSLop(String Lop) {
        List<StudentDTO> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        //Lop = GUI.Form_GV.txtLop.getText();
        try {
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                      
            String sql = "SELECT * FROM `information`, `user` WHERE information.UserID=user.UserID and information.Lop=? and user.role = 'HS'";
            statement = connection.prepareCall(sql);
            statement.setString(1, Lop);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                StudentDTO std = new StudentDTO(rs.getString("UserID"), 
                        rs.getString("HoTen"), rs.getString("NgaySinh"), 
                        rs.getString("GioiTinh"), rs.getString("DiaChi"),
                        rs.getString("Lop"), rs.getString("NienKhoa"),
                        rs.getString("SoDienThoai"), rs.getString("Email"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }    
    
    public static void insert(StudentDTO std) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                        
            String sql = "insert into information(UserID, HoTen, NgaySinh, GioiTinh, DiaChi, Lop, NienKhoa, SoDienThoai, Email) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getID());
            statement.setString(2, std.getHoten());
            statement.setString(3, std.getNgaysinh());
            statement.setString(4, std.getGioitinh());
            statement.setString(5, std.getDiachi());
            statement.setString(6, std.getLop());
            statement.setString(7, std.getNienKhoa());
            statement.setString(8, std.getSDT());
            statement.setString(9, std.getEmail());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public static void update(StudentDTO std) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                    
            String sql = "update information set HoTen=?, NgaySinh=?, GioiTinh=?, DiaChi=?, Lop=?, NienKhoa=?, SoDienThoai=?, Email=? where UserID = ?";
            statement = connection.prepareCall(sql);       
            
            statement.setString(9, std.getID());
            statement.setString(1, std.getHoten());
            statement.setString(2, std.getNgaysinh());
            statement.setString(3, std.getGioitinh());
            statement.setString(4, std.getDiachi());
            statement.setString(5, std.getLop());
            statement.setString(6, std.getNienKhoa());
            statement.setString(7, std.getSDT());
            statement.setString(8, std.getEmail());
            
             statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public static List<StudentDTO> findByID(String ID) {
        List<StudentDTO> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "SELECT * FROM `information`, `user` WHERE information.UserID=user.UserID and information.UserID=? and user.role = 'HS'";
            statement = connection.prepareCall(sql);
            statement.setString(1, ID);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                StudentDTO std = new StudentDTO(rs.getString("UserID"), 
                        rs.getString("HoTen"), rs.getString("NgaySinh"), 
                        rs.getString("GioiTinh"), rs.getString("DiaChi"),
                        rs.getString("Lop"), rs.getString("NienKhoa"),
                        rs.getString("SoDienThoai"), rs.getString("Email"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    
    public static List<StudentDTO> getHocPhi(String ID) {
        List<StudentDTO> hocPhi = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
		try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "SELECT information.HoTen, information.Lop, malop.HocPhi FROM information, malop WHERE information.Lop=malop.Lop AND information.UserID=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ID);
            
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {                
                StudentDTO std = new StudentDTO(rs.getString("HoTen"), rs.getString("Lop"),rs.getString("HocPhi"));
                hocPhi.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hocPhi;
    }
}
