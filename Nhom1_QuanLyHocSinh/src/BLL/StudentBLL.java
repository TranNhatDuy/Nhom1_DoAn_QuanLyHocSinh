/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.StudentDAL;
import DTO.StudentDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentBLL {
    public static List<StudentDTO> getAll() {
            StudentDAL userDAL = new StudentDAL();
            return userDAL.getAll();
        }      
	public static void insert(StudentDTO user) {
            StudentDAL.insert(user);
        }
        public static void delete(String id) {
             StudentDAL.delete(id);
        }       
        public static void update(StudentDTO user) {          
            StudentDAL.update(user);
        }
        public static List<StudentDTO> findByID(String id) {
            
            return StudentDAL.findByID(id);
        }
        public static List<StudentDTO> hocPhi(String ID){
        	return StudentDAL.getHocPhi(ID);
        }
}
