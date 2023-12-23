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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Student_Signup_Procedure_Step2 extends JFrame
implements ActionListener
{
	JLabel background, l1, l2, l3, l4, l5;
	JTextArea ta1;
	JTextField tf1, tf2;
	Font f1, f2, f3, f4;
	JComboBox box1;
	JButton b1;

	String name_session = "" , application_no_int = "";
	
	void signup_procedure_step2_func()
	{
		super.setTitle("Sign Up Process");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (22).jpg");
		background.setIcon(ic1);
		
		f1 = new Font("", Font.TYPE1_FONT, 50);
		f2 = new Font("", Font.BOLD, 30);
		f3 = new Font("", Font.BOLD, 20);
		f4 = new Font("", Font.CENTER_BASELINE, 15);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Student_info");
			while(rs.next())
			{
				name_session = rs.getString("Name");
				application_no_int = rs.getString("Application_Number");
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		l1 = new JLabel("Hello "+name_session+"...");
		l1.setBounds(50, 20, 1000, 90);
		l1.setForeground(Color.orange);
		l1.setFont(f1);
		background.add(l1);
		

		l2 = new JLabel("Your Application Number is "+ application_no_int);
		l2.setBounds(50, 110, 1000, 30);
		l2.setFont(f2);
		l2.setForeground(Color.orange);
		background.add(l2);
			
		
		l3 = new JLabel("Address");
		l3.setBounds(50, 200, 100, 30);
		l3.setFont(f3);
		l3.setForeground(Color.black);
		background.add(l3);
		
		ta1 = new JTextArea();
		ta1.setBounds(50, 250, 300, 100);
		ta1.setForeground(Color.DARK_GRAY);
		ta1.setFont(f4);
		background.add(ta1);
		
		
		l4 = new JLabel("Higher Education");
		l4.setBounds(650, 200, 200, 30);
		l4.setFont(f3);
		l4.setForeground(Color.black);
		background.add(l4);
		
		String [] array = {"Matriculation (Class X)", "Intermediate (Class XII)", "Undergraduate", "Postgraduate", "Bsc Hons", "Others"};
		box1 = new JComboBox(array);
		box1.setBounds(650, 250, 200, 30);
		box1.setFont(f4);
		box1.setBackground(Color.white);
		background.add(box1);
		
		
		l5 = new JLabel("Institution Name");
		l5.setBounds(650, 340, 200, 30);
		l5.setFont(f3);
		l5.setForeground(Color.black);
		background.add(l5);
		
		tf2 = new JTextField();
		tf2.setBounds(650, 390, 300, 30);
		tf2.setForeground(Color.DARK_GRAY);
		tf2.setFont(f4);
		background.add(tf2);
		
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(820, 580, 200, 50);
		b1.setFont(f2);
		b1.setForeground(Color.white);
		b1.setBackground(Color.gray);
		background.add(b1);
		b1.addActionListener(this);
		
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		String content_of_box = (String) box1.getSelectedItem();
		String address, institution;
		address = ta1.getText();
		institution = tf2.getText();
		
		if(ae.getSource() == b1)
		{
			if(address.isEmpty() || institution.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Fill the entries first");
			}
		
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st2 = co2.createStatement();
					st2.executeUpdate("UPDATE Student_info SET Address= '"+address+"', Higher_Education= '"+content_of_box+"', Institution_Name= '"+institution+"' WHERE Name= '"+name_session+"'");
					JOptionPane.showMessageDialog(this, "Sign Up Successfull... Login to Proceed");
					Student_Login_Signup obj_student_login_signup = new Student_Login_Signup();
					obj_student_login_signup.student_login_signup_func();
					super.dispose();
				}
			
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Student_Signup_Procedure_Step2 obj_signupprocedurestep2 = new Student_Signup_Procedure_Step2();
		obj_signupprocedurestep2.signup_procedure_step2_func();
	}
	
	
	
}
