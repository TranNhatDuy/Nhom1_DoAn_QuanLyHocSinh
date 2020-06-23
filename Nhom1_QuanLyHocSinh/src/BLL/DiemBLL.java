/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DiemDAL;
import DTO.DiemDTO;
import DTO.StudentDTO;

import java.util.List;

/**
 *
 * @author huynh
 */
public class DiemBLL {
    public static List<DiemDTO> getAll() {
        DiemDAL userDAL = new DiemDAL();
        return DiemDAL.getAll();
    } 
    public static void update(DiemDTO diem){
        DiemDAL.update(diem);
    }
    public static List<DiemDTO> diemCaNhan(String id){
    	return DiemDAL.diemCaNhan(id);
    }
    public static int SLHS() {
    	return DiemDAL.SLHS();
    }
    public static String SLHSByHocLuc(String hl) {
    	return DiemDAL.SLHSByHocLuc(hl);
    }
}
