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
public class Admin_AddQuestion extends JFrame
implements ActionListener
{
	JLabel l1, l2, l3, l4, l5, l6, background;
	JTextArea ta1, ta2, ta3, ta4, ta5, ta6;
	JButton b1, b2;
	JComboBox box;	
	Font f1, f2, f3;
	
	
	void addQuestionFunc()
	{
		super.setTitle("Add Question");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (13).jpg");
		background.setIcon(ic_background);
		
		
		box = new JComboBox();
		box.setBounds(900, 50, 150, 30);
		box.setBackground(Color.white);
		box.setForeground(Color.orange);
		f3 = new Font("", Font.BOLD, 20);
		box.setFont(f3);
		background.add(box);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SHOW TABLES FROM portal_admin_part2");
			ResultSetMetaData rsmd = rs.getMetaData();
			int column_count = rsmd.getColumnCount();
			String content_in_box;
			while(rs.next())
			{
				for(int i=1; i<=column_count; i++)
				{
					content_in_box = rs.getString(i);
					box.addItem(content_in_box);
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		l1 = new JLabel("Question");
		l1.setBounds(80, 120, 150, 30);
		f1 = new Font("", Font.BOLD, 30);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		ta1 = new JTextArea();
		ta1.setBounds(300, 100, 700, 80);
		background.add(ta1);
		ta1.setFont(f1);
		
		l2 = new JLabel("Answer 1");
		l2.setBounds(80, 250, 150, 20);
		f2 = new Font("", Font.BOLD, 20);
		l2.setFont(f2);
		l2.setForeground(Color.white);
		background.add(l2);
		ta2 = new JTextArea();
		ta2.setBounds(300, 240, 700, 50);
		background.add(ta2);
		ta2.setFont(f2);
		
		l3 = new JLabel("Answer 2");
		l3.setBounds(80, 320, 150, 20);
		l3.setFont(f2);
		l3.setForeground(Color.white);
		background.add(l3);
		ta3 = new JTextArea();
		ta3.setBounds(300, 310, 700, 50);
		background.add(ta3);
		ta3.setFont(f2);
		
		l4 = new JLabel("Answer 3");
		l4.setBounds(80, 390, 150, 20);
		l4.setFont(f2);
		l4.setForeground(Color.white);
		background.add(l4);
		ta4 = new JTextArea();
		ta4.setBounds(300, 380, 700, 50);
		background.add(ta4);
		ta4.setFont(f2);
		
		l5 = new JLabel("Answer 4");
		l5.setBounds(80, 460, 150, 20);
		l5.setFont(f2);
		l5.setForeground(Color.white);
		background.add(l5);
		ta5 = new JTextArea();
		ta5.setBounds(300, 450, 700, 50);
		background.add(ta5);
		ta5.setFont(f2);
		
		l6 = new JLabel("Correct Answer");
		l6.setBounds(80, 530, 150, 20);
		l6.setFont(f2);
		l6.setForeground(Color.white);
		background.add(l6);
		ta6 = new JTextArea();
		ta6.setBounds(300, 520, 700, 50);
		background.add(ta6);
		ta6.setFont(f2);
		
		b1 = new JButton("ADD QUESTION");
		b1.setBounds(820, 600, 200, 50);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("< < <   Back");
		b2.setBounds(50, 600, 200, 50);
		b2.setBackground(Color.white);
		background.add(b2);
		b2.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String question, ans1, ans2, ans3, ans4, correct_ans, text_from_box;
		text_from_box = (String) box.getSelectedItem();
		question = ta1.getText();
		ans1 = ta2.getText();
		ans2 = ta3.getText();
		ans3 = ta4.getText();
		ans4 = ta5.getText();
		correct_ans = ta6.getText();
		
		if(ae.getSource() == b1)
		{
			if(question.isEmpty() || ans1.isEmpty() || ans2.isEmpty() || ans3.isEmpty() || ans4.isEmpty() || correct_ans.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Fill all the entries first");
			}
			
			else if(!(ans1.equals(correct_ans) || ans2.equals(correct_ans) || ans3.equals(correct_ans) || ans4.equals(correct_ans)))
			{
				JOptionPane.showMessageDialog(this, "Provide correct answer accurately");
			}
			
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
					Statement st = co.createStatement();
					ResultSet rs1 = st.executeQuery("SELECT * FROM "+text_from_box);
					String ques_no = "";
					String ques_no_check = "";
					while(rs1.next())
					{
						ques_no_check = rs1.getString("QuesNo");		
					}
					
					if(ques_no_check == "")
					{
						ques_no = "1";
					}
					
					else
					{
						int ques_no_check_int = Integer.parseInt(ques_no_check);
						ques_no_check_int++;
						ques_no = String.valueOf(ques_no_check_int);
					}
					st.executeUpdate("INSERT INTO "+text_from_box+" VALUES('"+ques_no+"','"+question+"','"+ans1+"',"
									+ "'"+ans2+"','"+ans3+"','"+ans4+"','"+correct_ans+"')");
					
					JOptionPane.showMessageDialog(this, "Question Successfully Added");
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
		
		else if(ae.getSource() == b2)
		{
			AdminDashboard obj_admindashboard = new AdminDashboard();
			obj_admindashboard.adminDashboardFunc();
			super.dispose();
		}
	}
	
	
	public static void main(String[] args) 
	{
		Admin_AddQuestion al = new Admin_AddQuestion();
		al.addQuestionFunc();
	}
	
}
