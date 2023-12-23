import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Student_Dashboard extends JFrame
implements ActionListener
{

	
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
	JLabel background;
	
	
	void student_dashboard_func()
	{
		super.setTitle("Admin Dashboard");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (23).jpg");
		background.setIcon(ic_background);
		
		
		b1 = new JButton("MY PROFILE");
		b1.setBounds(100, 100, 200, 60);
		background.add(b1);
		b1.setBackground(Color.white);
		b1.addActionListener(this);
		
		
		b2 = new JButton("NOTICES");
		b2.setBounds(100, 220, 200, 60);
		background.add(b2);
		b2.setBackground(Color.white);
		b2.addActionListener(this);
		
		b3 = new JButton("CHOOSE TOPICS");
		b3.setBounds(100, 340, 200, 60);
		background.add(b3);
		b3.setBackground(Color.white);
		b3.addActionListener(this);
		
		b4 = new JButton("START EXAM");
		b4.setBounds(100, 460, 200, 60);
		background.add(b4);
		b4.setBackground(Color.white);
		b4.addActionListener(this);
		
		b6 = new JButton("REPORT CARD");
		b6.setBounds(800, 100, 200, 60);
		background.add(b6);
		b6.setBackground(Color.white);
		b6.addActionListener(this);
		
		b7 = new JButton("TUTORIAL");
		b7.setBounds(800, 220, 200, 60);
		background.add(b7);
		b7.setBackground(Color.white);
		b7.addActionListener(this);
		
		b8 = new JButton("SEARCH JOB");
		b8.setBounds(800, 340, 200, 60);
		background.add(b8);
		b8.setBackground(Color.white);
		b8.addActionListener(this);
		
		b9 = new JButton("FEEDBACK");
		b9.setBounds(800, 460, 200, 60);
		background.add(b9);
		b9.setBackground(Color.white);
		b9.addActionListener(this);
		
		b10 = new JButton("LOG OUT");
		b10.setBounds(480, 580, 150, 50);
		background.add(b10);
		b10.setBackground(Color.orange);
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
			Student_Profile obj_student_profile = new Student_Profile();
			obj_student_profile.student_profile_func();
			super.dispose();
		}
		else if(ae.getSource() == b2)
		{
			Student_Notices_List_View obj_notices_list_view = new Student_Notices_List_View();
			obj_notices_list_view.notice_list_view_func();
			super.dispose();
		}
		else if(ae.getSource() == b3)
		{
			Student_Choose_Topic obj_student_choose_topic = new Student_Choose_Topic();
			obj_student_choose_topic.choose_topic_func();
			super.dispose();
		}
		else if(ae.getSource() == b4)
		{
			Student_Start_Exam obj_student_start_exam = new Student_Start_Exam();
			obj_student_start_exam.reg_topic_selection();
			super.dispose();
		}
		else if(ae.getSource() == b9)
		{
			Student_Feedback obj_student_feedback = new Student_Feedback();
			obj_student_feedback.student_feedback_func();
			super.dispose();
		}
	}
	
	public static void main(String[] args) 
	{
		Student_Dashboard obj_student_dashboard = new Student_Dashboard();
		obj_student_dashboard.student_dashboard_func();
	}
}
