import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminDashboard extends JFrame
implements ActionListener
{
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	JLabel background;
	
	
	
	
	void adminDashboardFunc()
	{
		super.setTitle("Admin Dashboard");
		super.setBounds(350, 20, 700, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 700, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (6).jpg");
		background.setIcon(ic_background);
		
		b1 = new JButton("ADD TOPIC");
		b1.setBounds(60, 100, 180, 40);
		background.add(b1);
		b1.setBackground(Color.white);
		b1.addActionListener(this);
		
		
		b2 = new JButton("DELETE TOPIC");
		b2.setBounds(60, 180, 180, 40);
		background.add(b2);
		b2.setBackground(Color.white);
		b2.addActionListener(this);
		
		b3 = new JButton("ADD QUESTION TO TOPIC");
		b3.setBounds(60, 260, 180, 40);
		background.add(b3);
		b3.setBackground(Color.white);
		b3.addActionListener(this);
		
		b4 = new JButton("DELETE QUESTIONS");
		b4.setBounds(60, 340, 180, 40);
		background.add(b4);
		b4.setBackground(Color.white);
		b4.addActionListener(this);
		
		b5 = new JButton("FIND STUDENT");
		b5.setBounds(60, 420, 180, 40);
		background.add(b5);
		b5.setBackground(Color.white);
		b5.addActionListener(this);
		
		b6 = new JButton("TUTORIAL");
		b6.setBounds(440, 100, 180, 40);
		background.add(b6);
		b6.setBackground(Color.white);
		b6.addActionListener(this);
		
		b7 = new JButton("APPROVE COMPANY");
		b7.setBounds(440, 180, 180, 40);
		background.add(b7);
		b7.setBackground(Color.white);
		b7.addActionListener(this);
		
		b8 = new JButton("DISAPPROVE COMPANY");
		b8.setBounds(440, 260, 180, 40);
		background.add(b8);
		b8.setBackground(Color.white);
		b8.addActionListener(this);
		
		b9 = new JButton("APPROVAL FEEDBACK");
		b9.setBounds(440, 340, 180, 40);
		background.add(b9);
		b9.setBackground(Color.white);
		b9.addActionListener(this);
		
		b11 = new JButton("NOTICES");
		b11.setBounds(440, 420, 180, 40);
		background.add(b11);
		b11.setBackground(Color.white);
		b11.addActionListener(this);
		
		b10 = new JButton("LOG OUT");
		b10.setBounds(280, 580, 120, 40);
		background.add(b10);
		b10.setBackground(Color.white);
		b10.setForeground(Color.black);
		b10.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			Admin_AddTopic obj_addtopic = new Admin_AddTopic();
			obj_addtopic.addTopicFunc();
			super.dispose();
		}
		
		else if(ae.getSource() == b2)
		{
			Admin_DeleteTopic obj_deletetopic = new Admin_DeleteTopic();
			obj_deletetopic.deletetopicfunc();
			super.dispose();
		}

		else if(ae.getSource() == b3)
		{
			Admin_AddQuestion obj_addquestion = new Admin_AddQuestion();
			obj_addquestion.addQuestionFunc();
			super.dispose();
		}

		else if(ae.getSource() == b4)
		{
			Admin_DeleteQuestion obj_deletequestion = new Admin_DeleteQuestion();
			obj_deletequestion.deletequestionfunc();
			super.dispose();
		}

		else if(ae.getSource() == b5)
		{
			
		}

		else if(ae.getSource() == b6)
		{
			
		}

		else if(ae.getSource() == b7)
		{
			
		}

		else if(ae.getSource() == b8)
		{
			
		}

		else if(ae.getSource() == b9)
		{
			
		}
		
		else if(ae.getSource() == b11)
		{
			Admin_Notices obj_admin_notices = new Admin_Notices();
			obj_admin_notices.admin_notices_func();
		}

		else if(ae.getSource() == b10)
		{
			int choice = JOptionPane.showConfirmDialog(this, "Are You Sure Want to LogOut!");
			if(choice == 0)
			{
				GuiForHomepage obj_homepage = new GuiForHomepage();
				obj_homepage.frameLayout();
				super.dispose();
			}
			else if(choice == 1)
			{
				AdminDashboard obj_admindashboard = new AdminDashboard();
				obj_admindashboard.adminDashboardFunc();
				super.dispose();
			}
					
		}
		
		
	}
	
	
	
	public static void main(String[] args) 
	{
		AdminDashboard al = new AdminDashboard();
		al.adminDashboardFunc();
	}
}
