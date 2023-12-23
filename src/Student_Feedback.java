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
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class Student_Feedback extends JFrame 
implements ActionListener
{
	JLabel l1, background;
	JButton b1, b2;
	JTextArea ta1;
	JScrollBar js;
	
	
	void student_feedback_func()
	{
		super.setTitle("Student Feedback");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\\\eclipse\\\\eclipse-workspace\\\\PerformanceEvaluationPortal\\\\picture_score\\\\img (28).jpg");
		background.setIcon(ic1);
		
		l1 = new JLabel("Feedback");
		l1.setBounds(450, 50, 250, 50);
		Font f1 = new Font("", Font.BOLD, 40);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		
		ta1 = new JTextArea();
		ta1.setBounds(100, 140, 900, 350);
		Font f2 = new Font("", Font.CENTER_BASELINE, 25);
		ta1.setFont(f2);
		background.add(ta1);
		
		b1 = new JButton("< < <   Back");
		b1.setBounds(50, 580, 200, 50);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Submit");
		b2.setBounds(830, 580, 200, 50);
		b2.setBackground(Color.orange);
		background.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			Student_Dashboard obj_student_dashboard = new Student_Dashboard();
			obj_student_dashboard.student_dashboard_func();
			super.dispose();
		}
		
		else if(ae.getSource() == b2)
		{
			String feedback_content = ta1.getText();
			int sno = 0;
			if(feedback_content.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Field Empty");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
					Statement st = co.createStatement();
					ResultSet rs = st.executeQuery("SELECT Sno FROM student_feedback");
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
				
					st.executeUpdate("INSERT INTO student_feedback (Sno, Application_Number, Feedback) VALUES ('"+sno+"','"+Student_Login_Signup.current_active_user+"','"+feedback_content+"')");
					JOptionPane.showMessageDialog(this, "Feedback Submitted!! We are re-directing you to Homepage");
					Student_Dashboard obj_student_dashboard = new Student_Dashboard();
					obj_student_dashboard.student_dashboard_func();
					super.dispose();
					
				}
			
				catch (Exception e) 
				{
					// TODO: handle exception
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Student_Feedback obj_student_feedback = new Student_Feedback();
		obj_student_feedback.student_feedback_func();
	}
}
