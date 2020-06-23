package GUI;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeEvent extends JFrame {
	JTree tree;
	private JPanel contentPane;
	public JButton btnOK;
	public static String URL = "";
	JTextField txtJT;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public JTreeEvent() {
		setResizable(false);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    DefaultMutableTreeNode top = new DefaultMutableTreeNode("This PC");

	    DefaultMutableTreeNode c = new DefaultMutableTreeNode("C:");
	    top.add(c);
	    
	    c.add(new DefaultMutableTreeNode("Users"));
	    c.add(new DefaultMutableTreeNode("Windows"));
	    c.add(new DefaultMutableTreeNode("xampp"));
	    
	    DefaultMutableTreeNode d = new DefaultMutableTreeNode("D:");
	    top.add(d);
	    
	    d.add(new DefaultMutableTreeNode("Import_Users_Informations.xlsx"));
	    d.add(new DefaultMutableTreeNode("Import_Users.xlsx"));
	    d.add(new DefaultMutableTreeNode("Temp.txt"));

	    tree = new JTree(top);

	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    JScrollPane jsp = new JScrollPane(tree, v, h);

	    add(jsp, BorderLayout.CENTER);

	    txtJT = new JTextField("", 20);
	    btnOK = new JButton("OK");
	    btnOKEvent();
	    add(btnOK, BorderLayout.SOUTH);

	    tree.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(MouseEvent me) {
	    	  TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
	    	    if (tp != null)
	    	    	txtJT.setText(tp.toString());
	    	    else
	    	    	txtJT.setText("");
	    	     URL = txtJT.getText();
	    	     URL = URL.replace(", ", "\\");
	    	     URL = URL.replace("[", "");
	    	     URL = URL.replace("]", "");
	    	     URL = URL.replace("This PC\\", "");
	      }
	    });
	   
	  
	}
	private void btnOKEvent() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
}
