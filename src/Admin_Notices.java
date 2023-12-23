import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Admin_Notices extends JFrame
implements ActionListener
{
	JLabel background, l1;
	JTextArea ta1;
	// show all notices, delete notices, back, post notice
	JButton b1, b2, b3, b4;
	Font f1, f2;
	
	
	void admin_notices_func()
	{
		super.setTitle("Notices");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (27).jpg");
		background.setIcon(ic_background);
		
		f1 = new Font("", Font.BOLD, 35);
		f2 = new Font("", Font.BOLD, 20);
		
		l1 = new JLabel("Notices");
		l1.setBounds(50, 40, 200, 40);
		l1.setForeground(Color.black);
		l1.setFont(f1);
		background.add(l1);
		
		ta1 = new JTextArea();
		ta1.setBounds(80, 150, 900, 100);
		ta1.setFont(f2);
		background.add(ta1);
		
		b1 = new JButton("P O S T");
		b1.setBounds(450, 280, 200, 50);
		b1.setBackground(Color.orange);
		b1.setFont(f1);
		background.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("SHOW NOTICES");
		b2.setBounds(200, 400, 250, 40);
		b2.setBackground(Color.white);
		b2.setFont(f2);
		background.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("DELETE NOTICES");
		b3.setBounds(650, 400, 250, 40);
		b3.setBackground(Color.white);
		b3.setFont(f2);
		background.add(b3);	
		b3.addActionListener(this);
		
		b4 = new JButton("< < <   Back");
		b4.setBounds(50, 580, 200, 50);
		b4.setBackground(Color.white);
		background.add(b4);
		b4.addActionListener(this);
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			String notice = ta1.getText();
			if(notice.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Fill the entry first");
			}
			
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin","root","root");
					Statement st = co.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM notices");
					int sno = 0;
					while(rs.next())
					{
						sno = rs.getInt("Sno");
					}
					
					if(sno == 0)
					{
						sno++;
					}
					else
					{
						sno++;
					}
					st.executeUpdate("INSERT INTO notices VALUES('"+sno+"','"+notice+"')");
					int choice = JOptionPane.showConfirmDialog(this, "Notice Published, Do you want to add more");
					if(choice == 0)
					{
						Admin_Notices obj_admin_notices = new Admin_Notices();
						obj_admin_notices.admin_notices_func();
						super.dispose();
					}
					
					else if(choice == 1)
					{
						AdminDashboard al = new AdminDashboard();
						al.adminDashboardFunc();
						super.dispose();
					}
					
				}
				
				
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
		}
		
		else if(ae.getSource() == b2)
		{
			Student_Notices_List_View obj_notices_list_view = new Student_Notices_List_View();
			obj_notices_list_view.notice_list_view_func();
		}
	}
	
	
	public static void main(String[] args) 
	{
		Admin_Notices obj_admin_notices = new Admin_Notices();
		obj_admin_notices.admin_notices_func();
	}
}
