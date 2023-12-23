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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Admin_DeleteTopic extends JFrame
implements ActionListener
{
	
	JTextField tf1;
	JLabel l1, background;
	JButton b1, b2;
	ImageIcon ic_background;
	Font f1, f2;	
	JComboBox box1;
	
	void deletetopicfunc()
	{
		super.setTitle("Delete Topic");
		super.setBounds(350, 20, 700, 700);
		super.setResizable(false);
		
		
		background = new JLabel();
		background.setBounds(0, 0, 700, 700);
		super.add(background);
		ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (19).jpg");
		background.setIcon(ic_background);
		
		
		
		l1 = new JLabel("Topic");
		l1.setBounds(100, 100, 200, 40);
		f1 = new Font("", Font.BOLD, 35);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		
		box1 = new JComboBox();
		box1.setBounds(300, 100, 250, 40);
		f2 = new Font("", Font.BOLD, 30);
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
			e.printStackTrace();
		}
		
		
		b1 = new JButton("DELETE TOPIC");
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
		String topic_str = (String) box1.getSelectedItem();
		
		
		if(ae.getSource() == b1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
				Statement st = co.createStatement();
				st.executeUpdate("DROP TABLE "+ topic_str);
				JOptionPane.showMessageDialog(this, "Topic Deleted SUCCESSFULLY");
				int choice = JOptionPane.showConfirmDialog(this, "Do You want to Delete more Topics");
				if(choice == 0)
				{
					Admin_DeleteTopic obj_deletetopic = new Admin_DeleteTopic();
					obj_deletetopic.deletetopicfunc();
					super.dispose();
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
				JOptionPane.showMessageDialog(this, "Already Deleted");
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
		Admin_DeleteTopic obj_deletetopic = new Admin_DeleteTopic();
		obj_deletetopic.deletetopicfunc();
	}
}
