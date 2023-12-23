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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Student_Login_Signup extends JFrame 
implements ActionListener
{
	
	JTextField tf1, tf2, tf3, tf4;
	JButton b1, b2, b3;
	JLabel background, l1, l2, l3, l4, l5, l6, l7, l8;
	JPasswordField pf1, pf2, pf3;
	Font f1, f2, f3;
	
	static String current_active_user = "";
	
	void student_login_signup_func()
	{
		super.setTitle("Student Login Signup");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (21).jpg");
		background.setIcon(ic1);
		
		
		l1 = new JLabel("Email or Phone");
		l1.setBounds(550, 20, 100, 20);
		l1.setForeground(Color.black);
		background.add(l1);
		tf1 = new JTextField();
		tf1.setBounds(550, 50, 180, 20);
		background.add(tf1);
		
		l2 = new JLabel("Password");
		l2.setBounds(750, 20, 100, 20);
		l2.setForeground(Color.black);
		background.add(l2);
		pf1 = new JPasswordField();
		pf1.setBounds(750, 50, 180, 20);
		background.add(pf1);
		
		b1 = new JButton("Log in");
		b1.setBounds(950, 50, 80, 20);
		b1.setForeground(Color.white);
		b1.setBackground(Color.gray);
		background.add(b1);
		b1.addActionListener(this);
		
		
		
		l3 = new JLabel("Create an account");
		l3.setBounds(450, 60, 500, 200);
		f1 = new Font("", Font.BOLD, 50);
		l3.setForeground(Color.darkGray);
		l3.setFont(f1);
		background.add(l3);		
		
		f2 = new Font("", Font.BOLD, 30);
		f3 = new Font("", Font.CENTER_BASELINE, 20);
		
		l4 = new JLabel("Name");
		l4.setBounds(500, 280, 270, 30);
		l4.setFont(f2);
		l4.setForeground(Color.black);
		background.add(l4);
		
		tf2 = new JTextField();
		tf2.setBounds(720, 280, 300, 30);
		tf2.setFont(f3);
		background.add(tf2);
		
		
		l5 = new JLabel("Email");
		l5.setBounds(500, 330, 270, 30);
		l5.setFont(f2);
		l5.setForeground(Color.black);
		background.add(l5);
		
		tf3 = new JTextField();
		tf3.setBounds(720, 330, 300, 30);
		tf3.setFont(f3);
		background.add(tf3);
		
		
		l6 = new JLabel("Mobile");
		l6.setBounds(500, 380, 270, 30);
		l6.setFont(f2);
		l6.setForeground(Color.black);
		background.add(l6);
		
		tf4 = new JTextField();
		tf4.setBounds(720, 380, 300, 30);
		tf4.setFont(f3);
		background.add(tf4);
		
		
		l7 = new JLabel("Password");
		l7.setBounds(470, 430, 270, 30);
		l7.setFont(f2);
		l7.setForeground(Color.black);
		background.add(l7);
		
		pf2 = new JPasswordField();
		pf2.setBounds(720, 430, 300, 30);
		pf2.setFont(f3);
		background.add(pf2);
		
		
		l8 = new JLabel("Confirm Password");
		l8.setBounds(400, 480, 270, 30);
		l8.setFont(f2);
		l8.setForeground(Color.black);
		background.add(l8);
		
		pf3 = new JPasswordField();
		pf3.setBounds(720, 480, 300, 30);
		pf3.setFont(f3);
		background.add(pf3);
				
		
		b2 = new JButton("Sign Up");
		b2.setBounds(820, 580, 200, 50);
		b2.setFont(f2);
		b2.setForeground(Color.white);
		b2.setBackground(Color.gray);
		background.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("< < <   Back");
		b3.setBounds(50, 580, 150, 50);
		b3.setBackground(Color.white);
		background.add(b3);
		b3.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			String email_or_mobile, pass;
			email_or_mobile = tf1.getText();
			pass = String.valueOf(pf1.getPassword());
			
			if(email_or_mobile.isEmpty() || pass.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Fill the entries first");
			}
			
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st = co.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM student_info WHERE (Email= '"+email_or_mobile+"' OR Mobile= '"+email_or_mobile+"')");
					String actual_pass = "";
					while(rs.next())
					{
						actual_pass = rs.getString("Password");
						Student_Login_Signup.current_active_user = rs.getString("Application_Number");
					}

					if(pass.equals(actual_pass))
					{
						JOptionPane.showMessageDialog(this, "Login Successfull");
						Student_Dashboard obj_student_dashboard = new Student_Dashboard();
						obj_student_dashboard.student_dashboard_func();
						super.dispose();
					}
					
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Credentials");
					}
				}
				
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(this, "Account Not Available, Please Sign Up First");
				}
			}
			
			
		}
		
		else if(ae.getSource() == b2)
		{
			String name, email, mobile, password, cnf_password;
			name = tf2.getText();
			email = tf3.getText();
			mobile = tf4.getText();
			password = String.valueOf(pf2.getPassword());
			cnf_password = String.valueOf(pf3.getPassword());
			
			if(name.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty() || cnf_password.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Fill the entries first");
			}
			
			else if(!(password.equals(cnf_password)))
			{
				JOptionPane.showMessageDialog(this, "Password mis-match");
			}
			
			else
			{
				String actual_appno = "";
				int application_no_int = 2019000000;
				int actual_appno_int = 0;

				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st = co.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM student_info");
					while(rs.next())
					{
						actual_appno = rs.getString("Application_Number");
					}
					
					if(actual_appno == "")
					{
						application_no_int++;
					}
					
					else
					{
						actual_appno_int = Integer.parseInt(actual_appno);
						actual_appno_int++;
						application_no_int = actual_appno_int;
					}
						
					st.executeUpdate("INSERT INTO student_info (Name, Email, Mobile, Password, Application_Number) VALUES ('"+name+"','"+email+"','"+mobile+"','"+password+"','"+application_no_int+"')");
					JOptionPane.showMessageDialog(this, "Sign Up Successful");
					Student_Signup_Procedure_Step2 obj_signupprocedurestep2 = new Student_Signup_Procedure_Step2();
					obj_signupprocedurestep2.signup_procedure_step2_func();
					super.dispose();
				}
				
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(this, "Existing User! Please login");
				}
			}
		
		}
		
		else if(ae.getSource() == b3)
		{
			GuiForHomepage obj_homepage = new GuiForHomepage();
			obj_homepage.frameLayout();
			super.dispose();
		}
	}
	
	
	
	
	public static void main(String[] args) 
	{
		Student_Login_Signup obj = new Student_Login_Signup();
		obj.student_login_signup_func();
	}
	
}
