package BLL;
import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;

import DAL.TeacherDAL;
import DAL.UserDAL;
import DTO.StudentDTO;
import DTO.TeacherDTO;
import DTO.UserDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBLL {
		TeacherDAL teacherDAL = new TeacherDAL();
        static UserDAL userDAL = new UserDAL();
        public static List<UserDTO> getAll() {
            return userDAL.getAll();
        }      
        public static void insert(UserDTO user) {
            UserDAL.insert(user);
        }
        public static void delete(String id) {
             UserDAL.delete(id);
        }       
        public static void update(UserDTO user) {          
            UserDAL.update(user);
        }
        public static List<UserDTO> findByID(String Id) {
            
            return UserDAL.findByUserID(Id);
        }
        public static List<UserDTO> findByRole(String userRole){
        	return userDAL.findByRole(userRole);
        }
        public static String getUserByNameAndPass() {
        	return userDAL.getUserByNameNPASS();
        }
        public static String getInfoByUserID(String thuoctinh, String bang, String info) {
        	return userDAL.getInfoByUserID(thuoctinh, bang, info);
        }
        public String getRoleToLogin(String role) {
        	return userDAL.getRoleUser(role);
        }
        public int changePass(String NewPassWord) {
        	return userDAL.changePassword(NewPassWord);
        }
        public void updateEmailAndPhoneGV(TeacherDTO teacher) {
        	userDAL.updateInforEmailNPhoneNumberGV(teacher);
        }
        public void updateEmailAndPhoneHS(StudentDTO student) {
        	userDAL.updateInforEmailNPhoneNumberHS(student);
        }
        public int getUserByRoleHS(int dem_HS) {
        	return userDAL.getUserByRoleHS(dem_HS);
        }
        public int getUserByRoleGV(int dem_GV) {
        	return userDAL.getUserByRoleGV(dem_GV);
        }
        public int getUserByRoleAD(int dem_AD) {
        	return userDAL.getUserByRoleAD(dem_AD);
        }
        public String getGVCN(String Lop) {
        	return userDAL.getGVCN(Lop);
        }
        public boolean checkExistUserName(String userName) {
        	return userDAL.checkExistUserName(userName);
        }
        public boolean checkExistID(String ID) {
        	return userDAL.checkExistID(ID);
        }
}
