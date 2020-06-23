/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.ThoiKhoaBieuDAL;
import DTO.ThoiKhoaBieuDTO;
import java.util.List;

/**
 *
 * @author huynh
 */
public class ThoiKhoaBieuBLL {
    static ThoiKhoaBieuDAL tkbDAL = new ThoiKhoaBieuDAL();
        public static List<ThoiKhoaBieuDTO> getTkbByLop(String lop) {
            return ThoiKhoaBieuDAL.getTkbByLop(lop);
        }
        
        public static void update(ThoiKhoaBieuDTO tkb){
            ThoiKhoaBieuDAL.update(tkb);
        }
}
