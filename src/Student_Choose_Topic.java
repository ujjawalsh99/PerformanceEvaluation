import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Student_Choose_Topic extends JFrame
implements ActionListener
{
	JLabel l1, l2, background;
	JComboBox box1;
	JButton b1, b2, b3, b4;
	JTextArea ta1;
	Font f1, f2, f3;
	
	
	void choose_topic_func()
	{
		super.setTitle("Choose Topic");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		f1 = new Font("", Font.TYPE1_FONT, 40);
		f2 = new Font("", Font.CENTER_BASELINE, 25);
		f3 = new Font("", Font.PLAIN, 20);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		ImageIcon ic1 = new ImageIcon("A:\\\\eclipse\\\\eclipse-workspace\\\\PerformanceEvaluationPortal\\\\picture_score\\\\img (29).jpg");
		background.setIcon(ic1);
		super.add(background);
		
		l1 = new JLabel("Choose Topic");
		l1.setBounds(50, 80, 300, 50);
		l1.setFont(f1);
		l1.setForeground(Color.yellow);
		background.add(l1);
		
		box1 = new JComboBox();
		box1.setBounds(50, 180, 250, 40);
		box1.setFont(f2);
		box1.setBackground(Color.white);
		background.add(box1);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SHOW TABLES FROM portal_admin_part2");
			ResultSetMetaData rsmd = rs.getMetaData();
			int column_count = rsmd.getColumnCount();
			while(rs.next())
			{
				for(int i=1; i<=column_count; i++)
				{
					String content_in_box1 = rs.getString(i);
					box1.addItem(content_in_box1);
				}
			}
		} 
		
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		b1 = new JButton("SELECT TOPIC");
		b1.setBounds(70, 350, 200, 50);
		b1.setBackground(Color.pink);
		background.add(b1);
		b1.addActionListener(this);

		l2 = new JLabel("Enrolled Topics");
		l2.setBounds(700, 80, 300, 50);
		l2.setFont(f1);
		l2.setForeground(Color.yellow);
		background.add(l2);
		
		ta1 = new JTextArea();
		ta1.setBounds(680, 180, 380, 280);
		ta1.setFont(f3);
		background.add(ta1);
		
		
		
		
		b2 = new JButton("SEARCH");
		b2.setBounds(820, 500, 100, 40);
		b2.setBackground(Color.pink);
		background.add(b2);
		b2.addActionListener(this);
		
		b4 = new JButton("< < <   Back");
		b4.setBounds(50, 580, 200, 50);
		b4.setBackground(Color.orange);
		background.add(b4);
		b4.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String content_from_box = (String) box1.getSelectedItem();
		String reg_cousrse = "";
		if(ae.getSource() == b1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
				Statement st = co.createStatement();
				st.executeUpdate("INSERT INTO student_enrolled_courses VALUES ('"+Student_Login_Signup.current_active_user+"','"+content_from_box+"')");
				JOptionPane.showMessageDialog(this, "Topic Added Successfully!");
				
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		if(ae.getSource()==b2)
		{
			try 
			{
				ta1.setText("");
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery("SELECT DISTINCT Course FROM student_enrolled_courses WHERE Application_Number = '"+Student_Login_Signup.current_active_user+"'");
				while(rs.next())
				{
					reg_cousrse = rs.getString("Course");
					ta1.append(reg_cousrse);
					ta1.append("\n");
				}		
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		if(ae.getSource() == b4)
		{
			Student_Dashboard obj_student_dashboard = new Student_Dashboard();
			obj_student_dashboard.student_dashboard_func();
			super.dispose();
		}
	}
	
	public static void main(String[] args) 
	{
		Student_Choose_Topic obj_student_choose_topic = new Student_Choose_Topic();
		obj_student_choose_topic.choose_topic_func();
	}
}
