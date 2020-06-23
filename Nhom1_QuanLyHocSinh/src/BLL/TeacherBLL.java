/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TeacherDAL;
import DTO.TeacherDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TeacherBLL {
    public static List<TeacherDTO> getAll() {
            TeacherDAL userDAL = new TeacherDAL();
            return userDAL.getAll();
        }      
	public static void insert(TeacherDTO user) {
            TeacherDAL.insert(user);
        }
        public static void delete(String id) {
             TeacherDAL.delete(id);
        }       
        public static void update(TeacherDTO user) {          
            TeacherDAL.update(user);
        }
        public static List<TeacherDTO> findByID(String id) {
            
            return TeacherDAL.findByID(id);
        }
}
