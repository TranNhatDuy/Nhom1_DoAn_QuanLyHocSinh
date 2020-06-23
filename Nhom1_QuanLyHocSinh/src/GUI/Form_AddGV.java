/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.TeacherBLL;
import DTO.TeacherDTO;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import static java.util.Collections.list;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Admin
 */
public class Form_AddGV extends javax.swing.JFrame {
    
    DefaultTableModel dtm;
    
    List<TeacherDTO> studentList = new ArrayList<>();
    /**
     * Creates new form Form_GV
     */
    public Form_AddGV() {
        initComponents();
        
        dtm = (DefaultTableModel) tblStudent.getModel();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    
    private void showTeacher() {
        studentList =  TeacherBLL.getAll();
        
        dtm.setRowCount(0);
        
        studentList.forEach((TeacherDTO) -> {
            dtm.addRow(new Object[] {TeacherDTO.getID(), TeacherDTO.getHoten(), 
                TeacherDTO.getNgaysinh(), TeacherDTO.getGioitinh(),TeacherDTO.getDiaChi(),
                TeacherDTO.getLop(), TeacherDTO.getNienKhoa(), TeacherDTO.getSDT(), 
                TeacherDTO.getEmail()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtID.setEditable(false);
        txtID.setForeground(Color.RED);
        jLabel2 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgaysinh = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        cbGioitinh = new javax.swing.JComboBox<>();
        cbLop = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNienKhoa = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FORM_QLGV");

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        txtID.setFont(new Font("Tahoma", Font.ITALIC, 14)); // NOI18N
        txtID.setName(""); // NOI18N
        txtID.setText(Form_QLTK.UserID);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên:");

        txtHoten.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHotenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sinh:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        txtNgaysinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiachiActionPerformed(evt);
            }
        });

        cbGioitinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGioitinhActionPerformed(evt);
            }
        });
        

        btnReset.setBackground(new java.awt.Color(0, 153, 0));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconreset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Lớp", "Niên khóa", "Số điện thoại", "Email"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        btnThem.setBackground(new java.awt.Color(0, 153, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconadd.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXem.setBackground(new java.awt.Color(0, 153, 0));
        btnXem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXem.setForeground(new java.awt.Color(255, 255, 255));
        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconlist.png"))); // NOI18N
        btnXem.setText("Xem danh sách");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("QUẢN LÝ GIÁO VIÊN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Niên khóa:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Lớp chủ nhiệm:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Số điện thoại:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Email:");

        txtNienKhoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNienKhoa.setName(""); // NOI18N
        txtNienKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNienKhoaActionPerformed(evt);
            }
        });

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSDT.setName(""); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setName(""); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        
        cbLop.setModel(new DefaultComboBoxModel(new String[] {"1A", "2A", "3A", "4A", "5A"}));
        cbLop.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2)
        						.addComponent(jLabel3)
        						.addComponent(jLabel4)
        						.addComponent(jLabel5))
        					.addGap(24)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        							.addGap(27)
        							.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtHoten, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtNgaysinh, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbGioitinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(27)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel9))))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(txtNienKhoa, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        							.addComponent(txtSDT, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        							.addComponent(txtEmail, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        			.addGap(10))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(210)
        			.addComponent(btnXem, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        			.addGap(259)
        			.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(262, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(441, Short.MAX_VALUE)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        			.addGap(424))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(37)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8)
        				.addComponent(cbLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtHoten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel7)
        				.addComponent(txtNienKhoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtNgaysinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9)
        				.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(cbGioitinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel10)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(21)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnXem, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
        			.addGap(26)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        					.addGap(52))
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiachiActionPerformed

    private void cbGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGioitinhActionPerformed

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLopActionPerformed
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtID.setText(Form_QLTK.UserID);
        txtHoten.setText("");
        txtNgaysinh.setText("");
        cbGioitinh.setSelectedIndex(0);     
        txtDiachi.setText("");
        cbLop.setSelectedIndex(0);
        txtNienKhoa.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed
 
    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblStudent.getSelectedRow();
        TeacherDTO std = studentList.get(selectedIndex); 
        txtID.setText(GUI.Form_QLTK.txtId.getText());
        txtHoten.setText(std.getHoten());
        txtNgaysinh.setText(std.getNgaysinh());
        cbGioitinh.setSelectedItem(std.getGioitinh());
        txtDiachi.setText(std.getDiaChi());   
        cbLop.setSelectedItem(std.getLop());
        txtNienKhoa.setText(std.getNienKhoa());
        txtSDT.setText(std.getSDT());
        txtEmail.setText(std.getEmail());
            
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        showTeacher();
    }//GEN-LAST:event_btnXemActionPerformed

    private void txtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenActionPerformed

    private void txtNienKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNienKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNienKhoaActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    	String rghoten = "(" + "\\p{Upper}(\\p{Lower}+\\s?)" + "){2,}";
        String rgsdt = "\\d{10}";
        String rgemail = "^[A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String rgdate = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        
        String ID = txtID.getText();
        String Hoten = txtHoten.getText();
        String Ngaysinh = txtNgaysinh.getText();
        String Gioitinh = cbGioitinh.getSelectedItem().toString();
        String Diachi = txtDiachi.getText();
        String Lop = cbLop.getSelectedItem().toString();
        String NienKhoa = txtNienKhoa.getText();
        String SDT = txtSDT.getText();
        String Email = txtEmail.getText();

        if(ID.length() == 0 || Hoten.length() == 0 || Ngaysinh.length() == 0 || Gioitinh.length() == 0 || Diachi.length() == 0 || Lop.length() == 0 || NienKhoa.length() == 0 || SDT.length() == 0 || Email.length() == 0){
            JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin", "Thông báo",1);
        }
        else {
        	if (!Hoten.matches(rghoten)) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng (VD: Nguyen Van An)");
              }
              if(!Ngaysinh.matches(rgdate)) {
                  JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng ngày sinh (yyyy-mm-dd)");
              }
              if(!SDT.matches(rgsdt)) {
                  JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số điện thoại (10 số)");
              }
              if(!Email.matches(rgemail)) {
                  JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng email");
              }           
              if(Hoten.matches(rghoten) && Ngaysinh.matches(rgdate) && SDT.matches(rgsdt) && Email.matches(rgemail)) {
                  TeacherDTO std = new TeacherDTO(ID, Hoten, Ngaysinh, Gioitinh, Diachi, Lop, NienKhoa, SDT, Email);       
                  TeacherBLL.insert(std);
                  JOptionPane.showMessageDialog(this, "Thêm thành công");
                  showTeacher();  
                  setVisible(false);
                  Form_QLGV qlgv = new Form_QLGV();
                  qlgv.setVisible(true);
              }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox<String> cbGioitinh;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtNienKhoa;
    private javax.swing.JTextField txtSDT;
}
