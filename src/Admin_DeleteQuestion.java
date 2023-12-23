import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Admin_DeleteQuestion extends JFrame
implements ActionListener
{
	JLabel l1, l2, background;
	JTextArea ta1;
	JButton b1, b2, b3, b4;
	JComboBox box1, box2;	
	Font f1, f2;
	
	
	void deletequestionfunc()
	{
		super.setTitle("Delete Question");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (18).jpg");
		background.setIcon(ic_background);
		
	
		box1 = new JComboBox();
		box1.setBounds(900, 50, 150, 30);
		box1.setBackground(Color.white);
		box1.setForeground(Color.orange);
		f1 = new Font("", Font.BOLD, 20);
		box1.setFont(f1);
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
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		l2 = new JLabel("Question Number");
		l2.setBounds(80, 180, 180, 25);
		f2 = new Font("", Font.BOLD, 20);
		l2.setFont(f2);
		l2.setForeground(Color.white);
		background.add(l2);
		
		b1 = new JButton("Display Number of Question in this Topic");
		b1.setBounds(520, 180, 300, 30);
		b1.setBackground(Color.darkGray);
		b1.setForeground(Color.white);
		background.add(b1);
		b1.addActionListener(this);
		
		box2 = new JComboBox();
		box2.setBounds(300, 180, 150, 30);
		box2.setBackground(Color.white);
		box2.setForeground(Color.orange);
		f1 = new Font("", Font.BOLD, 20);
		box2.setFont(f1);
		background.add(box2);
		
		l1 = new JLabel("Question");
		l1.setBounds(80, 370, 150, 30);
		f1 = new Font("", Font.BOLD, 30);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		ta1 = new JTextArea();
		ta1.setBounds(300, 350, 700, 80);
		background.add(ta1);
		ta1.setFont(f1);
		
		b2 = new JButton("SHOW QUESTION");
		b2.setBounds(300, 320, 300, 30);
		b2.setBackground(Color.darkGray);
		b2.setForeground(Color.white);
		background.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("< < <   Back");
		b3.setBounds(50, 600, 200, 50);
		b3.setBackground(Color.white);
		background.add(b3);
		b3.addActionListener(this);
		
		b4 = new JButton("DELETE QUESTION");
		b4.setBounds(820, 600, 200, 50);
		b4.setBackground(Color.orange);
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
			String content_in_box2 = "";
			String choice_topic;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
				Statement st1 = co1.createStatement();
				choice_topic = (String) box1.getSelectedItem();
				ResultSet rs1 = st1.executeQuery("SELECT * FROM "+choice_topic);
			
				while(rs1.next())
				{
					content_in_box2 = rs1.getString("QuesNo");
					box2.addItem(content_in_box2);
				}
				b1.setEnabled(false);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		
		else if(ae.getSource() == b2)
		{
			String content_in_quesfield = "";
			String choice_topic;
			String choice_ques;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
				Statement st2 = co2.createStatement();
				choice_topic = (String) box1.getSelectedItem();
				choice_ques = (String) box2.getSelectedItem();
				ResultSet rs2 = st2.executeQuery("SELECT * FROM "+choice_topic+" WHERE QuesNo= "+choice_ques);
			
				while(rs2.next())
				{
					content_in_quesfield = rs2.getString("Questions");
					ta1.setText(content_in_quesfield);
				}
				
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}	
		}
		
		else if(ae.getSource() == b3)
		{
			AdminDashboard obj_admindashboard = new AdminDashboard();
			obj_admindashboard.adminDashboardFunc();
			super.dispose();
		}
			
		else if(ae.getSource() == b4)
		{
			String choice_ques = (String) box2.getSelectedItem();
			
			if(choice_ques.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Select Question First");
				
			}
			
			else
			{
				try
				{
					String choice_topic1 = (String) box1.getSelectedItem();
					String choice_ques1 = (String) box2.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection co3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
					Statement st3 = co3.createStatement();
					st3.executeUpdate("DELETE FROM "+choice_topic1+" WHERE QuesNo= '"+choice_ques1+"'");
					JOptionPane.showMessageDialog(this, "Question Deleted Successfully");
					AdminDashboard obj_admindashboard = new AdminDashboard();
					obj_admindashboard.adminDashboardFunc();
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
		Admin_DeleteQuestion al = new Admin_DeleteQuestion();
		al.deletequestionfunc();
	}
}
