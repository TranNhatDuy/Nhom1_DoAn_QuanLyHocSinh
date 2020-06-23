package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import BLL.ThoiKhoaBieuBLL;
import BLL.UserBLL;
import DAL.StudentDAL;
import DTO.StudentDTO;
import DTO.TeacherDTO;
import DTO.ThoiKhoaBieuDTO;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.sl.draw.geom.Guide;

import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class Form_GV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaGV;
	private JTextField txtHoTen;
	private JTextField txtGioiTinh;
	public static JTextField txtLop;
	public static JTextField txtEmail;
	public static JTextField txtSDT;
	public static String Email;
	public static String SDT;
	
	private JPasswordField txtMKHT;
	private JPasswordField txtMKMoi;
	private JPasswordField txtNhapLai;
	private JPanel panel_1;
	
	UserBLL userBLL = new UserBLL();
	DefaultTableModel dtm;
    List<StudentDTO> studentList = new ArrayList<>();
	private javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
	private JTable tblTKB;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Form_GV() {
		super("Giáo viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 870, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 286, 864, 35);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnXemTkb = new JButton("Xem TKB");
		btnXemTkb.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/icon_formGV- Copy.png")));
		btnXemTkb.setBackground(new Color(0, 153, 0));
		btnXemTkb.setForeground(Color.WHITE);
		btnXemTkb.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnXemTkb);
		btnXemTkb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jScrollPane2.setViewportView(tblTKB);
				showTKB();
			}
		});
		
		JButton btnMatKhau = new JButton("Đổi mật khẩu");
		btnMatKhau.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/iconkey.png")));
		btnMatKhau.setForeground(Color.WHITE);
		btnMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMatKhau.setBackground(new Color(0, 153, 0));
		btnMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMatKhau) {
					setSize(870, 487);
				}
			}
		});
		panel.add(btnMatKhau);
		
		JButton btnDSHS = new JButton("Xem danh sách");
		btnDSHS.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/iconlist_formGV.png")));
		btnDSHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDSHS.setBackground(new Color(0, 153, 0));
		btnDSHS.setForeground(Color.WHITE);
		panel.add(btnDSHS);
		btnDSHS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		        jScrollPane2.setViewportView(table);
				showStudent();
		        
			}
		});
		
		JButton btnQLDiem = new JButton("Quản lý điểm");
		btnQLDiem.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/icongrades.png")));
		btnQLDiem.setBackground(new Color(0, 153, 0));
		btnQLDiem.setForeground(Color.WHITE);
		btnQLDiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnQLDiem);
		btnQLDiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Form_QLDiem diem = new Form_QLDiem();
				diem.setVisible(true);
			}
		});
		
		JButton btndangXuat = new JButton("Đăng xuất");
		btndangXuat.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/iconlogout.png")));
		btndangXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndangXuat.setBackground(new Color(0, 153, 0));
		btndangXuat.setForeground(Color.WHITE);
		panel.add(btndangXuat);
		btndangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login lg = new Login();
				lg.setVisible(true);
			}
		});
		panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(0, 0, 864, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMGioVin = new JLabel("Mã giáo viên :");
		lblMGioVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMGioVin.setBounds(10, 38, 88, 22);
		panel_1.add(lblMGioVin);
		
		JLabel lblHoTen = new JLabel("Họ tên :");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoTen.setBounds(10, 71, 88, 22);
		panel_1.add(lblHoTen);
		
		JLabel lblGioiTinh = new JLabel("Giới tính :");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(10, 104, 88, 22);
		panel_1.add(lblGioiTinh);
		
		JLabel lblLopCN = new JLabel("Lớp chủ nhiệm :");
		lblLopCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLopCN.setBounds(10, 137, 107, 22);
		panel_1.add(lblLopCN);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 203, 88, 22);
		panel_1.add(lblEmail);
		
		JLabel lblSdt = new JLabel("Số điện thoại :");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSdt.setBounds(10, 170, 107, 22);
		panel_1.add(lblSdt);
		
		txtMaGV = new JTextField();
		txtMaGV.setEditable(false);
		txtMaGV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaGV.setBounds(120, 38, 146, 22);
		panel_1.add(txtMaGV);
		txtMaGV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(120, 71, 146, 22);
		panel_1.add(txtHoTen);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(120, 104, 146, 22);
		panel_1.add(txtGioiTinh);
		
		txtLop = new JTextField();
		txtLop.setEditable(false);
		txtLop.setBounds(120, 139, 146, 22);
		panel_1.add(txtLop);
		txtLop.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(120, 203, 146, 22);
		panel_1.add(txtEmail);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(120, 170, 146, 22);
		panel_1.add(txtSDT);
		String OLDEmail = txtEmail.getText();
		String OLDSDT = txtSDT.getText();
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(Form_GV.class.getResource("/Images/iconedit.png")));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rgsdt = "\\d{10}";
                String rgemail = "^[A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				
				if(txtEmail.getText().isEmpty() || txtSDT.getText().isEmpty() || txtEmail.getText().equals(" ") || txtSDT.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ hoặc chỉnh sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(!txtEmail.getText().matches(rgemail)) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng email");
                    }
                    if(!txtSDT.getText().matches(rgsdt)) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số điện thoại (10 số)");
                    }
                    if(txtEmail.getText().matches(rgemail) && txtSDT.getText().matches(rgsdt)) {
                        TeacherDTO teacher = new TeacherDTO(txtMaGV.getText(), "", "", "", "", "", "", txtSDT.getText(), txtEmail.getText());
                        userBLL.updateEmailAndPhoneGV(teacher);
                    }	
				}
			}
		});
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setBackground(new Color(0, 153, 0));
		btnCapNhat.setBounds(120, 240, 126, 23);
		panel_1.add(btnCapNhat);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u1ECDc sinh", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "L\u1EDBp", "Ni\u00EAn kh\u00F3a", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email"
			}
		));
		table.setBounds(420, 137, 1, 1);
		jScrollPane2.setBounds(276, 38, 588, 225);
		panel_1.add(jScrollPane2);
		jScrollPane2.add(table);
		
		
		tblTKB = new JTable();
		tblTKB.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6"
			}
		));
		tblTKB.setBounds(420, 137, 1, 1);
		jScrollPane2.setBounds(276, 38, 588, 225);
		panel_1.add(jScrollPane2);
		jScrollPane2.add(tblTKB);
//		jScrollPane2.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 258, 388, -255);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 181));
		panel_2.setBounds(0, 321, 864, 140);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMkht = new JLabel("Mật khẩu hiện tại :");
		lblMkht.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMkht.setBounds(295, 11, 136, 24);
		panel_2.add(lblMkht);
		
		JLabel lblMkm = new JLabel("Mật khẩu mới :");
		lblMkm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMkm.setBounds(295, 41, 136, 24);
		panel_2.add(lblMkm);
		
		JLabel lblNlmk = new JLabel("Nhập lại mật khẩu :");
		lblNlmk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNlmk.setBounds(295, 72, 136, 24);
		panel_2.add(lblNlmk);
		
		txtMKHT= new JPasswordField();
		txtMKHT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKHT.setColumns(10);
		txtMKHT.setBounds(421, 15, 146, 22);
		panel_2.add(txtMKHT);
		
		txtMKMoi = new JPasswordField();
		txtMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKMoi.setColumns(10);
		txtMKMoi.setBounds(421, 42, 146, 22);
		panel_2.add(txtMKMoi);
		
		txtNhapLai = new JPasswordField();
		txtNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhapLai.setColumns(10);
		txtNhapLai.setBounds(421, 73, 146, 22);
		panel_2.add(txtNhapLai);
		
		JButton btnHien_MK = new JButton("Hiện");
		btnHien_MK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHien_MK.setBackground(new Color(0, 153, 0));
		btnHien_MK.setForeground(Color.WHITE);
		
		btnHien_MK.setBounds(572, 41, 68, 23);
		panel_2.add(btnHien_MK);
		btnHien_MK.addMouseListener(new MouseListener() {
			char c = '•';
			@Override
			public void mouseReleased(MouseEvent An_MK) {
				// TODO Auto-generated method stub
				if(An_MK.getSource() == btnHien_MK && btnHien_MK.getText().equalsIgnoreCase("Ẩn")) {
					btnHien_MK.setBackground(new Color(0, 153, 0));
				}
			}
			
			@Override
			public void mousePressed(MouseEvent Hien_MK) {
				// TODO Auto-generated method stub
				btnHien_MK.setBackground(new Color(0, 153, 0));
			}
			
			@Override
			public void mouseExited(MouseEvent An_MK) {
				// TODO Auto-generated method stub
				if(An_MK.getSource() == btnHien_MK) {
					txtMKMoi.setEchoChar(c);
				}
				btnHien_MK.setText("Hiện");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent Hien_MK) {
				// TODO Auto-generated method sHSduytub
				btnHien_MK.setBackground(new Color(0, 153, 0));
			}
			
			@Override
			public void mouseClicked(MouseEvent Hien_MK) {
				// TODO Auto-generated method stub
				if(Hien_MK.getSource() == btnHien_MK && btnHien_MK.getText().equalsIgnoreCase("Hiện")) {
					txtMKMoi.setEchoChar((char) 0);
					btnHien_MK.setText("Ẩn");
					btnHien_MK.setBackground(new Color(0, 153, 0));
				}else {
					if(Hien_MK.getSource() == btnHien_MK && btnHien_MK.getText().equalsIgnoreCase("Ẩn")) {
						txtMKMoi.setEchoChar(c);
						btnHien_MK.setText("Hiện");
						btnHien_MK.setBackground(new Color(0, 153, 0));
					}
				}
				
			}
		});
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXacNhan.setBackground(new Color(0, 153, 0));
		btnXacNhan.setBounds(319, 106, 101, 23);
		panel_2.add(btnXacNhan);
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String presentPass = ""; String reNewPass = ""; String newPass = "";
				//lấy mật khẩu mới sẽ đổi
				char[] n = txtMKMoi.getPassword();
				for(int j = 0; j < n.length; j++) {
					newPass = newPass + n[j];
				}
				//lấy mật khẩu hiện tại
				char[] p = txtMKHT.getPassword();
				for(int j = 0; j < p.length; j++) {
					presentPass = presentPass + p[j];
				}
				
				//lấy mật khẩu ở ô nhập lại
				char[] r = txtNhapLai.getPassword();
				for(int j = 0; j < r.length; j++) {
					reNewPass = reNewPass + r[j];
				}
				int rs1 = 0;
				if(newPass.equals(" ") || newPass.isEmpty()) { // nếu mật khẩu rỗng thì báo lỗi
					JOptionPane.showMessageDialog(null, "Mật khẩu mới không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(!newPass.equals(reNewPass)) { // kiểm tra mật khẩu mới với mật khẩu nhập lại
						JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại SAI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					} 
					else { // kiểm tra mật khẩu hiện tại
						if(!GUI.Login.getPass().equals(presentPass)) {
							JOptionPane.showMessageDialog(null, "Sai mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
						else { // nếu đúng hết điều kiện thì cập nhật lại mật khẩu
							try {
								int rs = userBLL.changePass(newPass);
								if(rs != 0){
									JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
									txtMKHT.setText("");
									txtMKMoi.setText("");
									txtNhapLai.setText("");
									setSize(870, 350);
								}
				
							} catch (Exception exp) {
								// TODO: handle exception
								System.out.println("fail");
							}
						}
						
					}
				}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBackground(new Color(0, 153, 0));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnHuy) {
					txtMKHT.setText("");
					txtMKMoi.setText("");
					txtNhapLai.setText("");
					setSize(870, 350);
				}
			}
		});
		btnHuy.setBounds(431, 106, 89, 23);
		panel_2.add(btnHuy);
		TT_GV();
		Email = txtEmail.getText();
		SDT = txtSDT.getText();
		//initComponents();
		
	}
	public void TT_GV() {
		String info = null;
		String thuoctinh = "*";
		String bang = "information";
		info = userBLL.getInfoByUserID(thuoctinh, bang, info);
		String[] thongtin = info.split("/");
		txtMaGV.setText(thongtin[0]);
		txtHoTen.setText(thongtin[1]);
		txtGioiTinh.setText(thongtin[3]);
		txtLop.setText(thongtin[5]);
		txtSDT.setText(thongtin[7]);
		txtEmail.setText(thongtin[8]);
	}
	private void showStudent() {
		DefaultTableModel dtm;
		String Lop = txtLop.getText();
        studentList =  StudentDAL.getDSLop(Lop);
        dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        studentList.forEach((StudentDTO) -> {
            dtm.addRow(new Object[] {StudentDTO.getID(), StudentDTO.getHoten(), 
                StudentDTO.getNgaysinh(), StudentDTO.getGioitinh(),StudentDTO.getDiachi(),
                StudentDTO.getLop(),StudentDTO.getNienKhoa(),StudentDTO.getSDT(),
                StudentDTO.getEmail()});
        });
    }
	public void showTKB(){
		
		String Lop = txtLop.getText();
		List<ThoiKhoaBieuDTO> tkbList = ThoiKhoaBieuBLL.getTkbByLop(Lop);
        dtm = (DefaultTableModel) tblTKB.getModel();
		dtm.setRowCount(0);
        tkbList.forEach((tkbDTO) -> {
            dtm.addRow(new Object[] {tkbDTO.getT2(),tkbDTO.getT3(), tkbDTO.getT4(),tkbDTO.getT5(),tkbDTO.getT6()});
        });
    }
}