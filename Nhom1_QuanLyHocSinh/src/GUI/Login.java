package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import  DTO.UserDTO ;
import BLL.UserBLL;
import DAL.UserDAL;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import GUI.*;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUserName;
	public static JPasswordField txtPassword;
	public static String pass;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 329, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		panelNorth();
		panelCenter();
		panelSouth();
		setContentPane(contentPane);
}
	public void addControl() {
	}
	public void panelNorth() {
		contentPane.setLayout(null);
		JPanel pn0 = new JPanel();
		pn0.setLocation(0, 0);
		contentPane.add(pn0);
		pn0.setSize(new Dimension(323, 33));
		pn0.setBackground(Color.pink);
		pn0.add(lblWelcome());
	}
	private JLabel lblWelcome() {
		JLabel welcome = new JLabel("Chương trình quản lý học sinh");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		return welcome;
	}
	public void panelCenter() {
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.YELLOW);
		pn1.setBounds(0, 32, 334, 275);
		contentPane.add(pn1);
		pn1.setLayout(null);
		pn1.add(UserName());
		pn1.add(Password());
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setBounds(46, 136, 116, 20);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pn1.add(lblPassword);
		
		JLabel lblUserName = new JLabel("Tên đăng nhập");
		lblUserName.setForeground(new Color(255, 255, 0));
		lblUserName.setBackground(Color.WHITE);
		lblUserName.setBounds(46, 74, 116, 20);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		pn1.add(lblUserName);
		JLabel lblLogo = new JLabel(new ImageIcon(Login.class.getResource("/Images/logoSGU.png")));
		lblLogo.setBounds(10, 214, 50, 50);
		pn1.add(lblLogo);
		
		pn1.add(anh());
	}
	private JLabel anh () {
		JLabel lblIcon = new JLabel(new ImageIcon(Login.class.getResource("/Images/sgu.png")));
		lblIcon.setBackground(Color.WHITE);
		lblIcon.setForeground(Color.BLACK);
		lblIcon.setBounds(0, 0, 324, 275);
		return lblIcon;
	}

	
	private JTextField UserName() {
		txtUserName = new JTextField();
		txtUserName.setBounds(46, 105, 229, 20);
		txtUserName.setColumns(20);
		return txtUserName;
	}
	
	
	private JPasswordField Password() {
		txtPassword = new JPasswordField();
		txtPassword.setBounds(46, 167, 229, 20);
		txtPassword.setColumns(20);
		return txtPassword;
	}
	private void panelSouth() {
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 307, 323, 39);
		contentPane.add(pn2);
		pn2.add(LOGIN());
		pn2.add(CLOSE());
		pn2.add(REFRESH());
	}
	private JButton LOGIN() {
            JButton btnlogin = new JButton("Đăng nhập");
            btnlogin.setForeground(Color.WHITE);
            btnlogin.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnlogin.setBackground(new Color(0, 153, 0));
            btnlogin.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin!","Error", JOptionPane.ERROR_MESSAGE);
                }
                else {			       
                    try {
                    	UserBLL userBLL = new UserBLL();
                    	String role = null;
                        role = userBLL.getRoleToLogin(role);
                        Date date = java.util.Calendar.getInstance().getTime();  
                        if(role.equals("HS")|| role.equals("GV") || role.equals("AD")){
                            
                            if(role.equalsIgnoreCase("HS")) {
                                JOptionPane.showMessageDialog(null, "Học sinh đăng nhập thành công. \n" + date, "Message", JOptionPane.INFORMATION_MESSAGE);
                                Form_HS hs = new Form_HS();
                                hs.setVisible(true);
                                setVisible(false);
                            }
                            if(role.equalsIgnoreCase("GV")){
                                JOptionPane.showMessageDialog(null, "Giáo viên đăng nhập thành công. \n" + date, "Message", JOptionPane.INFORMATION_MESSAGE);
                                Form_GV gv = new Form_GV();
                                gv.setVisible(true);
                                setVisible(false);
                            }
                            if(role.equalsIgnoreCase("AD")){
                                JOptionPane.showMessageDialog(null, "Admin đăng nhập thành công. \n" + date, "Message", JOptionPane.INFORMATION_MESSAGE);
                                Form_AD ad = new Form_AD();
                                UserDAL userDAL = new UserDAL();
                            //    userDAL.getRoleAllUser();
                                ad.setVisible(true);
                                setVisible(false);
                            }
                        }
                        else {
                        	JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                            catch (Exception e2) {
                                    // TODO: handle exception
                                JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
                                System.out.println(ERROR);
                            }    		       
                }
            }
            });
            return btnlogin;
        }
	private JButton CLOSE() {
            JButton btnclose = new JButton("Đóng");
            btnclose.setForeground(Color.WHITE);
            btnclose.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnclose.setBackground(new Color(0, 153, 0));
            btnclose.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if(e.getSource() == btnclose) {
                            setVisible(false);
                    }
                }
            });
            return btnclose;
	}
	private JButton REFRESH() {
		JButton btnrefresh = new JButton("Thử lại");
		btnrefresh.setForeground(Color.WHITE);
		btnrefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrefresh.setBackground(new Color(0, 153, 0));
		btnrefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btnrefresh) {
					setVisible(false);
					Login newLogin = new Login();
					newLogin.setVisible(true);
					
				}
			}
		});
		return btnrefresh;
	}
	public static String getPass() {
		pass  = "";
		char[] a = txtPassword.getPassword();
		for(int i = 0; i < a.length; i++) {
			pass = pass + a[i];
		}
		return pass;
	}
}
