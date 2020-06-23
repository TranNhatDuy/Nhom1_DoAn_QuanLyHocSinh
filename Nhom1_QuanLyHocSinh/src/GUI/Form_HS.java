package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import BLL.DiemBLL;
import BLL.StudentBLL;
import BLL.ThoiKhoaBieuBLL;
import BLL.UserBLL;
import DAL.StudentDAL;
import DAL.UserDAL;
import DTO.DiemDTO;
import DTO.StudentDTO;
import DTO.ThoiKhoaBieuDTO;
import DTO.UserDTO;

import UTILS.ConnectionUtils;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import GUI.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
public class Form_HS extends JFrame {

	DefaultTableModel dtm;
	private static final String KeyCombination = null;
	private JPanel contentPane;
	private JTextField textField;
	private javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
	private JTable tableDiem;
	private JTable tableTKB;
	private JTable tableHocPhi;
	String pass = "";
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	private JButton btndangXuat;
	UserBLL userBLL = new UserBLL();
	private List<StudentDTO> studentList;
	public Form_HS() throws ClassNotFoundException {
		super("Học sinh");
		ThongTin_HS xemTT = new ThongTin_HS();
		setBackground(new Color(0, 0, 0));
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 360);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		panel_1.setBounds(0, 0, 679, 38);
		contentPane.add(panel_1);

		panel_1.setBorder(new EmptyBorder(0,500,0,0));
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 0));
		panel_1_1.setBounds(0, 0, 312, 38);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(218, 165, 32));
		menuBar.setBounds(0, 0, 311, 38);
		panel_1_1.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem itemNew = new JMenuItem("Làm mới", createImage("/Images/reload.png"));
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		itemNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				setVisible(true);
			}
		});
		mnFile.add(itemNew);
		mnFile.addSeparator();
		JMenuItem itemExit = new JMenuItem("Thoát", createImage ("/Images/exitIcon.png"));
		mnFile.add(itemExit);
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		itemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		JMenuItem itemTTPM = new JMenuItem("Thông tin phần mềm", createImage("/Images/HelpIcon.png"));
		menuHelp.add(itemTTPM);
		itemTTPM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		itemTTPM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Phần mềm quản lý học sinh được thiết kế bởi nhóm 1."+ "\n" 
						+ "Copyright @2020", "Thông tin phần mềm", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 191, 255));
		panel_1_2.setBounds(305, 0, 230, 38);
		panel_1.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblXinChao = new JLabel("Xin chào:");
		lblXinChao.setForeground(new Color(0, 0, 0));
		lblXinChao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXinChao.setBounds(10, 0, 68, 38);
		panel_1_2.add(lblXinChao);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(84, 0, 146, 38);
		
		panel_1_2.add(label);
		btndangXuat = new JButton("Đăng xuất");
		btndangXuat.setIcon(new ImageIcon(Form_HS.class.getResource("/Images/iconlogout.png")));
		btndangXuat.setBounds(535, 0, 144, 38);
		panel_1.add(btndangXuat);
		btndangXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndangXuat.setBackground(new Color(0, 153, 0));
		btndangXuat.setForeground(Color.WHITE);
		btndangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btndangXuat) {
					setVisible(false);
					xemTT.setVisible(false);
					Login lg = new Login();
					lg.setVisible(true);
					;
				}
			}
		});
		
		
		char[] a = GUI.Login.txtPassword.getPassword();
		for(int i = 0; i < a.length; i++) {
			pass = pass + a[i];
		}
		try {
			String thuoctinh = "*";
			String bang = "information";
			String info = null;
			info = UserBLL.getInfoByUserID(thuoctinh, bang, info);
			String[] Hoten = info.split("/");
			label.setText(Hoten[1]);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(0, 36, 679, 258);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*=======bảng thời khóa biểu=======*/
		tableTKB = new JTable();
		tableTKB.setModel(new DefaultTableModel(
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
		
		tableTKB.setBounds(420, 137, 1, 1);
		jScrollPane2.setBounds(10, 11, 659, 236);
		panel_2.add(jScrollPane2);
		jScrollPane2.add(tableTKB);
		
		/*=======bảng điểm=======*/
		tableDiem = new JTable();
		tableDiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null}	
			},
			new String[] {
				"Họ tên", "Lớp", "Tiếng Việt", "Toán", "Lịch sử và Địa lý", "Âm nhạc", "Mỹ thuật", "Thể dục", "Đạo đức", "Điểm trung bình", "Học lực"
			}
		));
		/*=======bảng học phí=======*/
		tableHocPhi = new JTable();
		tableHocPhi.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null}	
			},
			new String[] {
				"Họ tên", "Lớp", "Học phí"
			}
		));
		
		tableDiem.setBounds(420, 137, 1, 1);
		jScrollPane2.setBounds(10, 11, 659, 236);
		panel_2.add(jScrollPane2);
		jScrollPane2.add(tableDiem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 0));
		panel_3.setForeground(UIManager.getColor("Button.light"));
		panel_3.setBounds(0, 293, 679, 38);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTKB = new JButton("Xem TKB");
		btnTKB.setIcon(new ImageIcon(Form_HS.class.getResource("/Images/icon_formGV- Copy.png")));
		btnTKB.setForeground(Color.WHITE);
		btnTKB.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTKB.setBackground(new Color(0, 153, 0));
		panel_3.add(btnTKB);
		btnTKB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jScrollPane2.setViewportView(tableTKB);
				showTKB();
			}
		});
		
		JButton btnDiem = new JButton("Xem điểm học kì");
		btnDiem.setIcon(new ImageIcon(Form_HS.class.getResource("/Images/icongrades.png")));
		btnDiem.setForeground(Color.WHITE);
		btnDiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDiem.setBackground(new Color(0, 153, 0));
		panel_3.add(btnDiem);
		btnDiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jScrollPane2.setViewportView(tableDiem);
				showDiem();
			}
		});
		
		
		JButton btnHocPhi = new JButton("Xem học phí");
		btnHocPhi.setIcon(new ImageIcon(Form_HS.class.getResource("/Images/icons8-us-dollar-18.png")));
		btnHocPhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jScrollPane2.setViewportView(tableHocPhi);
				showHocPhi();
			}
		});
		btnHocPhi.setForeground(Color.WHITE);
		btnHocPhi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHocPhi.setBackground(new Color(0, 153, 0));
		panel_3.add(btnHocPhi);
		
		JButton btnXemTT = new JButton("Xem thông tin cá nhân");
		btnXemTT.setIcon(new ImageIcon(Form_HS.class.getResource("/Images/iconinfor.png")));
		btnXemTT.setForeground(Color.WHITE);
		btnXemTT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemTT.setBackground(new Color(0, 153, 0));
		btnXemTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						xemTT.setVisible(true);
				}
				catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Hệ thống lỗi.", "Error", JOptionPane.ERROR_MESSAGE);
				}    		  
			}
		});
		panel_3.add(btnXemTT);
	}
	private Icon createImage(String path) {
		// TODO Auto-generated method stub
		java.net.URL icon = Form_HS.class.getResource(path);
		if(icon != null) {
			return new ImageIcon(icon);
		}
		return null;
	}	
	public void showTKB(){
		
		String Lop = GUI.ThongTin_HS.txtLop.getText(); 
		List<ThoiKhoaBieuDTO> tkbList = ThoiKhoaBieuBLL.getTkbByLop(Lop);
        dtm = (DefaultTableModel) tableTKB.getModel();
		dtm.setRowCount(0);
        tkbList.forEach((tkbDTO) -> {
            dtm.addRow(new Object[] {tkbDTO.getT2(),tkbDTO.getT3(), tkbDTO.getT4(),tkbDTO.getT5(),tkbDTO.getT6()});
        });
    }
	String id = userBLL.getUserByNameAndPass();
	public void showDiem() {
		List<DiemDTO> diemCaNhan = DiemBLL.diemCaNhan(id);
		dtm = (DefaultTableModel) tableDiem.getModel();
		dtm.setRowCount(0);
		diemCaNhan.forEach((diemDTO) -> {
            dtm.addRow(new Object[] {diemDTO.getHoTen(), diemDTO.getLop(), diemDTO.getTiengViet(),diemDTO.getToan(),diemDTO.getLSDL(),diemDTO.getAmNhac(),diemDTO.getMyThuat(),diemDTO.getTheDuc(),diemDTO.getDaoDuc(), diemDTO.getDTB(), diemDTO.getHocLuc()});
        });
	}
	public void showHocPhi(){
		
		List<StudentDTO> hocPhi = StudentBLL.hocPhi(id);
        dtm = (DefaultTableModel) tableHocPhi.getModel();
		dtm.setRowCount(0);
        hocPhi.forEach((StudentDTO) -> {
            dtm.addRow(new Object[] {StudentDTO.getHoten(), StudentDTO.getLop(), StudentDTO.getHocPhi()});
        });
    }
	
}
