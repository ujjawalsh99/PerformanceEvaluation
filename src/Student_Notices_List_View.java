import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Student_Notices_List_View extends JFrame
implements ActionListener
{
	JLabel background, l1, l2;
	ArrayList array_of_notices = new ArrayList();
	Font f1, f2;
	JButton b1;
	
	void notice_list_view_func()
	{
		super.setTitle("Notices");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		f1 = new Font("", Font.CENTER_BASELINE, 30);
		f2 = new Font("", Font.CENTER_BASELINE, 20);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (27).jpg");
		background.setIcon(ic_background);
		
		l1 = new JLabel("Notices");
		l1.setBounds(480, 10, 250, 50);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		background.add(l1);
		
		b1 = new JButton("< < <   Back");
		b1.setBounds(50, 580, 200, 50);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		
		try
		{
			
			int space = 0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notices");
			String notice_from_db = "";
			while(rs.next())
			{
				space = rs.getInt("Sno");
				notice_from_db = rs.getString("Notice");
				array_of_notices.add(notice_from_db);
			}
			int x = 80;
			for (int i = 0; i < array_of_notices.size(); i++) 
			{
				l2 = new JLabel();
				l2.setBounds(40, x, 1000, 50);
				x = x + 60;
				l2.setFont(f2);
				background.add(l2);
				l2.setText((String) array_of_notices.get(i));
			}

		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
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
	}
	
	public static void main(String[] args) 
	{
		Student_Notices_List_View obj_notices_list_view = new Student_Notices_List_View();
		obj_notices_list_view.notice_list_view_func();
	}
}
