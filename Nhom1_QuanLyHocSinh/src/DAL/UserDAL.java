
package DAL;

import DTO.StudentDTO;
import DTO.TeacherDTO;
import DTO.UserDTO;
import GUI.Form_QLTK;
import GUI.Login;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;


import UTILS.*;

public class UserDAL {
	ResultSet rs = null;
	Connection conn = null;
	
	PreparedStatement ps = null;
	
    public static List<UserDTO> getAll() {
        List<UserDTO> userList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                       
            String sql = "select * from user";
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                UserDTO user = new UserDTO(rs.getString("UserID"),rs.getString("userName"), 
                        rs.getString("password"), rs.getString("role"));                
                userList.add(user);
            }
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
        return userList;
    }
    
    public static void insert(UserDTO user) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                        
            String sql = "insert into user(UserID, userName, password, role) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, user.getUserID());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());         
            statement.execute();
            if(user.getRole().equals("HS")) {
            	String sql1 = "insert into diem(UserID, TiengViet, Toan, LSvaDL, AmNhac, MyThuat, TheDuc, DaoDuc) values(?,?,?,?,?,?,?,?)";
            	statement = connection.prepareCall(sql1);
            	statement.setString(1, user.getUserID());
            	statement.setInt(2, 0);
            	statement.setInt(3, 0);
            	statement.setInt(4, 0);
            	statement.setInt(5, 0);
            	statement.setInt(6, 0);
            	statement.setInt(7, 0);
            	statement.setInt(8, 0);
            	statement.execute();
            }
           
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
    
    public static void update(UserDTO user) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                    
            String sql = "update user set userName=? , password=?, role=? where UserID = ?";
            statement = connection.prepareCall(sql);       
            
            statement.setString(4, user.getUserID());
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());           
            
            
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
    
    public static void delete(String UserID) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            
            String sql = "DELETE FROM `user` WHERE user.UserID=?";
            String sql1 = "DELETE FROM `information` WHERE information.UserID=?";
            String sql2 = "DELETE FROM `diem` WHERE diem.UserID=?";
            statement = connection.prepareCall(sql);
            statement1 = connection.prepareCall(sql1);
            statement2 = connection.prepareCall(sql2);
            statement.setString(1, UserID);
            statement1.setString(1, UserID);
            statement2.setString(1, UserID);
            
            statement1.execute();
            statement2.execute();
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
    
    public static List<UserDTO> findByUserID(String UserID) {
        List<UserDTO> userList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            String sql = "select * from user where UserID = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, UserID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                UserDTO user = new UserDTO(rs.getString("UserID"),rs.getString("userName"), 
                        rs.getString("password"), rs.getString("role"));                
                userList.add(user);
            }
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
        return userList;
    }
    public static List<UserDTO> findByRole(String userRole) {
        List<UserDTO> userList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                      
            String sql = "select * from user where Role = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, userRole);
         //   statement.setString(2, Role);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                UserDTO user = new UserDTO(rs.getString("UserID"),rs.getString("userName"), 
                        rs.getString("password"), rs.getString("role"));                
                userList.add(user);
            }
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
        return userList;
    }
    public String getRoleUser(String userRole) {
    	userRole = "";
		ResultSet result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
	                      
	            String sql = "select * from user where userName= ? AND password = ?";
	            statement = connection.prepareCall(sql);
	            statement.setString(1, GUI.Login.txtUserName.getText());
	            statement.setString(2, GUI.Login.getPass());
	            result = statement.executeQuery();
	            if (result.next()) {
	            	userRole = result.getString("role");
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRole;
    }
    
    public int getUserByRoleHS(int dem_HS) {
    	String userRole = "";
    	ResultSet result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
	            String sql = "select Role from user";
	            statement = connection.prepareCall(sql);
	            result = statement.executeQuery();
	           
	            while (result.next()) {
	            	userRole = result.getString("Role");
	            	if(userRole.equals("HS")) {
	            		dem_HS = dem_HS + 1;
	            	}
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem_HS;
    }
    public int getUserByRoleGV(int dem_GV) {
    	String userRole = "";
    	ResultSet result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
	            String sql = "select * from user";
	            statement = connection.prepareCall(sql);
	            result = statement.executeQuery();
	           
	            while (result.next()) {
	            	userRole = result.getString("Role");
	            	if(userRole.equals("GV")) {
	            		dem_GV = dem_GV + 1;
	            	}
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem_GV;
    }
    public int getUserByRoleAD(int dem_AD) {
    	String userRole = "";
    	ResultSet result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
	            String sql = "select * from user";
	            statement = connection.prepareCall(sql);
	            result = statement.executeQuery();
	           
	            while (result.next()) {
	            	userRole = result.getString("Role");
	            	if(userRole.equals("AD")) {
	            		dem_AD = dem_AD + 1;
	            	}
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem_AD;
    }
    public String getUserByNameNPASS() {
    	ResultSet result = null;
    	Connection connection = null;
    	PreparedStatement statement = null;
    	String id = "";
    	try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                      
            String sql = "select * from user where userName= ? AND password = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, GUI.Login.txtUserName.getText());
            statement.setString(2, GUI.Login.getPass());
            
            result = statement.executeQuery();
            
            if (result.next()) {
            	id = result.getString("UserID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    	return id;
    }
    public String getInfoByUserID(String thuoctinh, String bang, String info) {
        	info = "";
        	String UserID = getUserByNameNPASS();
        	try {
        			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
                
    	            String sql = "select " + thuoctinh + " from " + bang + " where UserID=?";
    	            ps = conn.prepareCall(sql);
    	            ps.setString(1, UserID);
    	            rs = ps.executeQuery();
    	            if(rs.next()) {
    	            	info = rs.getString(1) + "/" +  rs.getString(2) + "/" + rs.getString(3) +
    	            			"/" + rs.getString(4) + "/" + rs.getString(5) + "/" + rs.getString(6) + "/" + rs.getString(7) + "/" + rs.getString(8) + 
    	            			"/" + rs.getString(9);
    	            }
    	            info.trim();
        	} catch (Exception e) {
    			// TODO: handle exception
    		}
    		return info;
        	
        }
    public int changePassword(String NewPassWord) {
    	int x = 0;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs","root","");
    		ps = conn.prepareStatement("UPDATE user SET password=? WHERE userName=?");
    		ps.setString(1, NewPassWord);
    		ps.setString(2, GUI.Login.txtUserName.getText());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return x;
    }
    public void updateInforEmailNPhoneNumberGV(TeacherDTO teacher) {
    	Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            if(GUI.Form_GV.Email.equals(GUI.Form_GV.txtEmail.getText()) && GUI.Form_GV.SDT.equals(GUI.Form_GV.txtSDT.getText())) {
            	JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ hoặc chỉnh sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else {
	            if(GUI.Form_GV.txtEmail.getText().isEmpty() || GUI.Form_GV.txtSDT.getText().isEmpty() || GUI.Form_GV.txtEmail.getText().equals(" ") || GUI.Form_GV.txtSDT.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ hoặc chỉnh sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
	            else {
	            	String sql = "update information set Email=?, SoDienThoai=? where UserID = ?";
		            statement = connection.prepareCall(sql);       
		            statement.setString(1, teacher.getEmail());
		            statement.setString(2, teacher.getSDT());
		            statement.setString(3, teacher.getID());
		            statement.execute();
	            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                	JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
    public void updateInforEmailNPhoneNumberHS(StudentDTO student) {
    	Connection connection = null;
        PreparedStatement statement = null;
        
        try {
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            if(GUI.ThongTin_HS.Email.equals(GUI.ThongTin_HS.txtEmail.getText()) && GUI.ThongTin_HS.SDT.equals(GUI.ThongTin_HS.txtSDT.getText())) {
            	JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ hoặc chỉnh sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else {
	            if(GUI.ThongTin_HS.txtEmail.getText().isEmpty() || GUI.ThongTin_HS.txtSDT.getText().isEmpty() || GUI.ThongTin_HS.txtEmail.getText().equals(" ") || GUI.ThongTin_HS.txtSDT.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ hoặc chỉnh sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
	            else {
	            	String sql = "update information set Email=?, SoDienThoai=? where UserID = ?";
		            statement = connection.prepareCall(sql);       
		            statement.setString(1, student.getEmail());
		            statement.setString(2, student.getSDT());
		            statement.setString(3, student.getID());
		            statement.execute();
	            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                	JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
    public String getGVCN(String Lop) {
    	String GVCN = "";
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
    		String sql = "SELECT * FROM `information`, `user` WHERE information.UserID=user.UserID and user.role ='GV' and information.Lop=?";
            ps = conn.prepareCall(sql);
            ps.setString(1, Lop);
            rs = ps.executeQuery();
            if (rs.next()) {
            	GVCN = rs.getString("HoTen") +"/"+ rs.getString("SoDienThoai") +"/"+ rs.getString("Email");
            	
            }
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return GVCN;
    }
    public boolean checkExistUserName(String userName)  {
        boolean check = false;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
            
            userName = GUI.Form_QLTK.txtUsername.getText();
            String sql = "SELECT * FROM user WHERE userName='" + userName +  "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            if(rs.next()) {
                check = false;
            }
            else {
                check = true;
            }
        } catch(Exception e) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return check;     
    }
    public boolean checkExistID(String ID)  {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhs", "root", "");
         
          //  ID = GUI.Form_QLTK.UserID;
            String sql = "SELECT * FROM user WHERE UserID='" + ID +  "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            if(rs.next()) {
            	return false;
            }
            
        } catch(Exception e) {
            Logger.getLogger(UserDAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;     
    }
}
