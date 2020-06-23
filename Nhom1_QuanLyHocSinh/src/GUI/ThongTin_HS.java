package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.UserBLL;
import DTO.StudentDTO;
import DTO.TeacherDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ThongTin_HS extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtMaHS;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtDiachi;
	public static JTextField txtEmail;
	public static JTextField txtSDT;
	String pass= "";
	static String newPass = "";
	private JPasswordField txtMKHT;
	private static JPasswordField txtMKMoi;
	
	private JPasswordField txtNhapLai;
	static JTextField txtLop;
	private JTextField txtKhoa;
	private JLabel lblKhoa;
	
	public static String Email;
	public static String SDT;
	UserBLL userBLL = new UserBLL();
	private JTextField txtGVCN;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ThongTin_HS() {
		super("Thông tin học sinh");
		setResizable(false);
		setBackground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 349);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 36, 494, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaHS = new JLabel("Mã học sinh");
		lblMaHS.setBounds(10, 11, 73, 14);
		panel.add(lblMaHS);
		
		txtMaHS = new JTextField();
		txtMaHS.setBounds(81, 8, 100, 20);
		panel.add(txtMaHS);
		txtMaHS.setColumns(10);
		txtMaHS.setEditable(false);
		
		JLabel lblHoten = new JLabel("Họ tên");
		lblHoten.setBounds(10, 50, 46, 14);
		panel.add(lblHoten);
		
		txtHoTen = new JTextField();
		txtHoTen.setText("");
		txtHoTen.setBounds(81, 47, 100, 20);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		txtHoTen.setEditable(false);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(10, 91, 73, 14);
		panel.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(81, 88, 100, 20);
		panel.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setEditable(false);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBounds(10, 136, 61, 14);
		panel.add(lblGiiTnh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBounds(81, 133, 100, 20);
		panel.add(txtGioiTinh);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setEditable(false);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(10, 218, 46, 14);
		panel.add(lblDiaChi);
		
		txtDiachi = new JTextField();
		txtDiachi.setBounds(81, 215, 369, 20);
		panel.add(txtDiachi);
		txtDiachi.setColumns(10);
		txtDiachi.setEditable(false);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 176, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(81, 173, 369, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(207, 136, 81, 14);
		panel.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(286, 133, 164, 20);
		panel.add(txtSDT);
		txtSDT.setColumns(11);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE));
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(0, 246, 494, 39);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCapNhat = new JButton("Cập nhật thông tin");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setBackground(new Color(0, 153, 0));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String rgsdt = "\\d{10}";
                String rgemail = "^[A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
                 
				if(txtEmail.getText().isEmpty() || txtSDT.getText().isEmpty() || txtEmail.getText().equals(" ") ||  txtSDT.getText().equals(" ")) {
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
                        StudentDTO student = new StudentDTO(txtMaHS.getText(), "", "", "", "", "", "", txtSDT.getText(), txtEmail.getText());
                        userBLL.updateEmailAndPhoneHS(student);
                    }
				}
			}
		});
		
		JButton btnMatKhau = new JButton("Đổi Mật khẩu");
		btnMatKhau.setForeground(Color.WHITE);
		btnMatKhau.setBackground(new Color(0, 153, 0));
		btnMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnMatKhau);
		btnMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent doiMK) {
				// TODO Auto-generated method stub
				if(doiMK.getSource() == btnMatKhau) {
					setSize(500, 486);
				}
			}
		});
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(new Color(0, 153, 0));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent thoat) {
				// TODO Auto-generated method stub
				if(thoat.getSource() == btnThoat) {
					setVisible(false);
					
				}
			}
		}); 
		
		JLabel lblLop = new JLabel("Lớp");
		lblLop.setBounds(207, 11, 46, 14);
		panel.add(lblLop);
		
		txtLop = new JTextField();
		txtLop.setEditable(false);
		txtLop.setBounds(286, 8, 164, 20);
		panel.add(txtLop);
		txtLop.setColumns(10);
		
		lblKhoa = new JLabel("Năm học");
		lblKhoa.setBounds(207, 91, 69, 14);
		panel.add(lblKhoa);
		
		txtKhoa = new JTextField();
		txtKhoa.setEditable(false);
		txtKhoa.setBounds(286, 88, 164, 20);
		panel.add(txtKhoa);
		txtKhoa.setColumns(10);
		
		JLabel lblGVCN = new JLabel("GV chủ nhiệm");
		lblGVCN.setBounds(207, 50, 81, 14);
		panel.add(lblGVCN);
		
		txtGVCN = new JTextField();
		txtGVCN.setEditable(false);
		txtGVCN.setBounds(286, 47, 164, 20);
		panel.add(txtGVCN);
		txtGVCN.setColumns(20);	
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(0, 0, 494, 37);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLienHeGV = new JLabel("Liên hệ giáo viên:");
		lblLienHeGV.setBackground(Color.WHITE);
		lblLienHeGV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLienHeGV.setBounds(0, 0, 97, 37);
		panel_3.add(lblLienHeGV);
		
		JLabel lblNewLabel = new JLabel("Số điện thoại");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(107, 0, 85, 37);
		panel_3.add(lblNewLabel);
		
		JLabel lblSDT_GV = new JLabel("New label");
		lblSDT_GV.setForeground(Color.RED);
		lblSDT_GV.setBounds(202, 0, 92, 37);
		panel_3.add(lblSDT_GV);
		
		
		JLabel lblEmailGV = new JLabel("New label");
		lblEmailGV.setForeground(Color.RED);
		lblEmailGV.setBounds(348, 0, 146, 37);
		panel_3.add(lblEmailGV);
		
		
		JLabel lblEmal = new JLabel("Email");
		lblEmal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmal.setBounds(304, 0, 34, 37);
		panel_3.add(lblEmal);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 228, 181));
		panel_4.setBounds(0, 320, 494, 140);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMKHienTai = new JLabel("Mật khẩu hiện tại:");
		lblMKHienTai.setForeground(new Color(0, 0, 0));
		lblMKHienTai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKHienTai.setBounds(95, 11, 151, 20);
		panel_4.add(lblMKHienTai);
		
		txtMKHT = new JPasswordField();
		txtMKHT.setBounds(256, 11, 117, 20);
		panel_4.add(txtMKHT);
		txtMKHT.setColumns(20);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setForeground(new Color(0, 0, 0));
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatKhauMoi.setBounds(95, 42, 151, 20);
		panel_4.add(lblMatKhauMoi);
		
		txtMKMoi = new JPasswordField();
		txtMKMoi.setBounds(256, 42, 117, 20);
		panel_4.add(txtMKMoi);
		txtMKMoi.setColumns(20);
		
		JButton btnHien_MK = new JButton("Hiện");
		btnHien_MK.setForeground(Color.WHITE);
		btnHien_MK.setBackground(new Color(0, 153, 0));
		btnHien_MK.setBounds(383, 41, 64, 23);
		panel_4.add(btnHien_MK);
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
		
		JLabel lblNhapLai = new JLabel("Nhập lại mật khẩu mới:");
		lblNhapLai.setForeground(new Color(0, 0, 0));
		lblNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhapLai.setBounds(95, 73, 151, 20);
		panel_4.add(lblNhapLai);
		
		txtNhapLai = new JPasswordField();
		txtNhapLai.setBounds(256, 73, 117, 20);
		panel_4.add(txtNhapLai);
		txtNhapLai.setColumns(20);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setBackground(new Color(0, 153, 0));
		btnXacNhan.setBounds(136, 104, 98, 23);
		panel_4.add(btnXacNhan);
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String presentPass = ""; String reNewPass = "";String newPass = "";
				char[] n = txtMKMoi.getPassword();
				for(int i = 0; i < n.length; i++) {
					newPass = newPass + n[i];
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
								String NewPassWord = newPass;
								int rs = userBLL.changePass(NewPassWord);
								if(rs != 0){
									JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
									txtMKHT.setText("");
									txtMKMoi.setText("");
									txtNhapLai.setText("");
									setSize(500, 349);
								}
							} catch (Exception exp) {
								// TODO: handle exception
							}
						}
						
					}
				}
			}

		});
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(new Color(0, 153, 0));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuy.setBounds(256, 104, 89, 23);
		panel_4.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent huy) {
				// TODO Auto-generated method stub
				if(huy.getSource() == btnHuy) {
					txtMKHT.setText("");
					txtMKMoi.setText("");
					txtNhapLai.setText("");
					setSize(500, 349);
				}
			}
		});
		TT_HS();
		Email = txtEmail.getText();
		SDT = txtSDT.getText();
		String gvcn = userBLL.getGVCN(txtLop.getText());
		String[] infor = gvcn.split("/");
		txtGVCN.setText(infor[0]);
		lblSDT_GV.setText(infor[1]);
		lblEmailGV.setText(infor[2]);
	}
	public void TT_HS() {

		try {
				String thuoctinh = "*";
				String bang = "information";
				String info = null;
				info = UserBLL.getInfoByUserID(thuoctinh, bang, info);
				String[] userInfo = info.split("/");
				
				txtMaHS.setText(userInfo[0]);
				txtHoTen.setText(userInfo[1]);
				txtNgaySinh.setText(userInfo[2]);
				txtGioiTinh.setText(userInfo[3]);
				txtDiachi.setText(userInfo[4]);
				txtLop.setText(userInfo[5]);
				txtKhoa.setText(userInfo[6]);
				txtSDT.setText(userInfo[7]);
				txtEmail.setText(userInfo[8]);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail");
		}
	}
}