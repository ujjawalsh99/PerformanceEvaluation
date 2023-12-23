import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.colorchooser.ColorChooserComponentFactory;

@SuppressWarnings("serial")
public class Admin_AddTopic extends JFrame
implements ActionListener
{
	JTextField tf1;
	JLabel l1, background;
	JButton b1, b2;
	ImageIcon ic_background;
	Font f1, f2;
	
	void addTopicFunc()
	{
		super.setTitle("Add Topics");
		super.setBounds(350, 20, 700, 700);
		super.setResizable(false);
		
		
		background = new JLabel();
		background.setBounds(0, 0, 700, 700);
		super.add(background);
		ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (3).jpg");
		background.setIcon(ic_background);
		
		
		
		l1 = new JLabel("Topic");
		l1.setBounds(100, 100, 200, 40);
		f1 = new Font("", Font.BOLD, 35);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		
		tf1 = new JTextField();
		tf1.setBounds(300, 100, 250, 40);
		f2 = new Font("", Font.BOLD, 30);
		tf1.setFont(f2);
		//tf1.setBackground(Color.lightGray);
		background.add(tf1);
		
		
		b1 = new JButton("ADD TOPIC");
		b1.setBounds(250, 350, 200, 60);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		
		b2 = new JButton("< < <   Back");
		b2.setBounds(50, 540, 150, 40);
		b2.setBackground(Color.WHITE);
		background.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		String topic_str = tf1.getText();
		
		
		if(ae.getSource() == b1)
		{
			if(topic_str.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Fill the entry First");
			}
			
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
					Statement st = co.createStatement();
					st.executeUpdate("CREATE TABLE "+ topic_str +" (QuesNo VARCHAR(10) PRIMARY KEY, Questions VARCHAR(100), Ans1 VARCHAR(100), Ans2 VARCHAR(100), Ans3 VARCHAR(100), Ans4 VARCHAR(100), CorrectAns VARCHAR(100))");
					JOptionPane.showMessageDialog(this, "Topic Added SUCCESSFULLY");
					int choice = JOptionPane.showConfirmDialog(this, "Do You want to Add more Topics");
					if(choice == 0)
					{
						Admin_AddTopic obj_addtopic = new Admin_AddTopic();
						obj_addtopic.addTopicFunc();
					}
					
					else if(choice == 1)
					{
						AdminDashboard obj_admindashboard = new AdminDashboard();
						obj_admindashboard.adminDashboardFunc();
						super.dispose();
					}
				}
				
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(this, "Topic already Exist");
				}
			}
			
		}
		
		else if(ae.getSource() == b2)
		{
			AdminDashboard obj_admindashboard = new AdminDashboard();
			obj_admindashboard.adminDashboardFunc();
			super.dispose();
		}
			
	}
	
	public static void main(String[] args) 
	{
		Admin_AddTopic al = new Admin_AddTopic();
		al.addTopicFunc();
	}
}
