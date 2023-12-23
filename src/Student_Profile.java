import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Student_Profile extends JFrame
implements ActionListener
{
	JLabel background1, background2, background3, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
	Font f1, f2;
	JButton b1, b2, b3, bu1, bu2;
	JTextField tf1, tf2, tf3, tf4;
	
	static String actual_password = "";
	static String actual_mobile = "";
	
	void student_profile_func()
	{
		super.setTitle("Student Profile");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
	
		background1 = new JLabel();
		background1.setBounds(0, 0, 1100, 700);
		super.add(background1);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (24).jpg");
		background1.setIcon(ic1);
		
		f1 = new Font("", Font.BOLD, 20);
		f2 = new Font("", Font.CENTER_BASELINE, 25);
		
		l1 = new JLabel("Name");
		l1.setBounds(20, 80, 200, 20);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background1.add(l1);
		
		l2 = new JLabel("Email");
		l2.setBounds(20, 130, 200, 20);
		l2.setFont(f1);
		l2.setForeground(Color.white);
		background1.add(l2);
		
		l3 = new JLabel("Mobile Number");
		l3.setBounds(20, 180, 200, 20);
		l3.setFont(f1);
		l3.setForeground(Color.white);
		background1.add(l3);
		
		l4 = new JLabel("Application Number");
		l4.setBounds(20, 230, 200, 20);
		l4.setFont(f1);
		l4.setForeground(Color.white);
		background1.add(l4);
		
		l5 = new JLabel("Address");
		l5.setBounds(20, 280, 200, 20);
		l5.setFont(f1);
		l5.setForeground(Color.white);
		background1.add(l5);
		
		l6 = new JLabel("Higher Education");
		l6.setBounds(20, 330, 200, 20);
		l6.setFont(f1);
		l6.setForeground(Color.white);
		background1.add(l6);
		
		l7 = new JLabel("Institution");
		l7.setBounds(20, 380, 200, 20);
		l7.setFont(f1);
		l7.setForeground(Color.white);
		background1.add(l7);
		
		try
		{
			String name = "", email = "", appnum = "", address = "", higher_edu = "", inst = "";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM student_info WHERE Application_Number= '"+Student_Login_Signup.current_active_user+"'");
			while(rs.next())
			{
				name = rs.getString("Name");
				email = rs.getString("Email");
				actual_mobile = rs.getString("Mobile");
				actual_password = rs.getString("Password");
				address = rs.getString("Address");
				higher_edu = rs.getString("Higher_Education");
				inst = rs.getString("Institution_Name");
			}
			
			l8 = new JLabel(name);
			l8.setBounds(270, 80, 300, 20);
			l8.setFont(f2);
			l8.setForeground(Color.cyan);
			background1.add(l8);
			
			l9 = new JLabel(email);
			l9.setBounds(270, 130, 300, 20);
			l9.setFont(f2);
			l9.setForeground(Color.cyan);
			background1.add(l9);
			
			l10 = new JLabel(actual_mobile);
			l10.setBounds(270, 180, 300, 20);
			l10.setFont(f2);
			l10.setForeground(Color.cyan);
			background1.add(l10);
			
			l11 = new JLabel(Student_Login_Signup.current_active_user);
			l11.setBounds(270, 230, 300, 20);
			l11.setFont(f2);
			l11.setForeground(Color.cyan);
			background1.add(l11);
			
			l12 = new JLabel(address);
			l12.setBounds(270, 280, 300, 20);
			l12.setFont(f2);
			l12.setForeground(Color.cyan);
			background1.add(l12);
			
			l13 = new JLabel(higher_edu);
			l13.setBounds(270, 330, 300, 20);
			l13.setFont(f2);
			l13.setForeground(Color.cyan);
			background1.add(l13);
			
			l14 = new JLabel(inst);
			l14.setBounds(270, 380, 300, 20);
			l14.setFont(f2);
			l14.setForeground(Color.cyan);
			background1.add(l14);
			
			b1 = new JButton("Change Mobile number");
			b1.setBounds(450, 450, 200, 40);
			b1.setBackground(Color.orange);
			background1.add(b1);
			b1.addActionListener(this);
			
			b2 = new JButton("Change Password");
			b2.setBounds(450, 520, 200, 40);
			b2.setBackground(Color.orange);
			background1.add(b2);
			b2.addActionListener(this);
			
			b3 = new JButton("< < <   Back");
			b3.setBounds(50, 580, 200, 50);
			b3.setBackground(Color.white);
			background1.add(b3);
			b3.addActionListener(this);
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	void change_mobile()
	{
		
		super.setTitle("Change Mobile Number");
		super.setBounds(450, 200, 500, 300);
		super.setResizable(false);
		
		background2 = new JLabel();
		background2.setBounds(0, 0, 500, 300);
		super.add(background2);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (26).jpg");
		background2.setIcon(ic1);
		
		l15 = new JLabel("Current Mobile");
		l15.setBounds(50, 50, 150, 20);
		l15.setForeground(Color.white);
		background2.add(l15);
		
		tf1 = new JTextField();
		tf1.setBounds(250, 50, 150, 20);
		background2.add(tf1);
		
		l16 = new JLabel("New Mobile");
		l16.setBounds(50, 100, 150, 20);
		l16.setForeground(Color.white);
		background2.add(l16);
		
		tf2 = new JTextField();
		tf2.setBounds(250, 100, 150, 20);
		background2.add(tf2);
		
		bu1 = new JButton("Apply");
		bu1.setBounds(200, 200, 100, 40);
		bu1.setBackground(Color.cyan);
		background2.add(bu1);
		bu1.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		
	}
	
	void change_password()
	{
		
		super.setTitle("Change Password");
		super.setBounds(450, 200, 500, 300);
		super.setResizable(false);
		
		background3 = new JLabel();
		background3.setBounds(0, 0, 500, 300);
		super.add(background3);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (25).jpg");
		background3.setIcon(ic1);
		
		l17 = new JLabel("Current Password");
		l17.setBounds(50, 50, 150, 20);
		l17.setForeground(Color.white);
		background3.add(l17);
		
		tf3 = new JTextField();
		tf3.setBounds(250, 50, 150, 20);
		background3.add(tf3);
		
		l18 = new JLabel("New Password");
		l18.setBounds(50, 100, 150, 20);
		l18.setForeground(Color.white);
		background3.add(l18);
		
		tf4 = new JTextField();
		tf4.setBounds(250, 100, 150, 20);
		background3.add(tf4);
		
		bu2 = new JButton("Apply");
		bu2.setBounds(200, 200, 100, 40);
		bu2.setBackground(Color.cyan);
		background3.add(bu2);
		bu2.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			Student_Profile obj_change_mobile  = new Student_Profile();
			obj_change_mobile.change_mobile();
		}
		
		else if(ae.getSource() == b2)
		{
			Student_Profile obj_change_password  = new Student_Profile();
			obj_change_password.change_password();
		}
		
		else if(ae.getSource() == bu1)
		{
			String previous_mobile = tf1.getText();
			String new_mobile = tf2.getText();
			
			if(previous_mobile.isEmpty() || new_mobile.isEmpty())
			{
					JOptionPane.showMessageDialog(this, "Empty Fields");
			}
			
			else if(!(previous_mobile.equals(actual_mobile)))
			{
				JOptionPane.showMessageDialog(this, "Please enter correct Mobile Number");
			}
				
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st = co.createStatement();
					st.executeUpdate("UPDATE student_info SET Mobile= '"+new_mobile+"' WHERE Application_Number= '"+Student_Login_Signup.current_active_user+"'");
					JOptionPane.showMessageDialog(this, "Mobile Number Successfully Updated");
					Student_Profile obj_student_profile = new Student_Profile();
					obj_student_profile.student_profile_func();
					super.dispose();
				}
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
				
		}
		
		else if(ae.getSource() == bu2)
		{
			String previous_password = tf3.getText();
			String new_password = tf4.getText();
			
			if(previous_password.isEmpty() || new_password.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Empty Fields");
			}
			
			else if(!(previous_password.equals(actual_password)))
			{
				JOptionPane.showMessageDialog(this, "Please enter correct Password");
			}
				
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st = co.createStatement();
					st.executeUpdate("UPDATE student_info SET Password= '"+new_password+"' WHERE Application_Number= '"+Student_Login_Signup.current_active_user+"'");
					JOptionPane.showMessageDialog(this, "Password Successfully Updated");
					Student_Profile obj_student_profile = new Student_Profile();
					obj_student_profile.student_profile_func();
					super.dispose();
				}
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
				
		}
		
		else if(ae.getSource() == b3)
		{
			Student_Dashboard obj_student_dashboard = new Student_Dashboard();
			obj_student_dashboard.student_dashboard_func();
			super.dispose();
		}
		
	}
				
	
	public static void main(String[] args) 
	{
		Student_Profile obj_student_profile = new Student_Profile();
		obj_student_profile.student_profile_func();
	}
}
