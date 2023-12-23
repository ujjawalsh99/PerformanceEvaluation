import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Student_Start_Exam extends JFrame
implements ActionListener
{
	JLabel background, l1, l2;
	JButton b1, b2, b3, b4;
	JScrollPane scroll;
	JComboBox box1;
	Font f1, f2, f3;
	static String reg_courses = "";
	static int count = 0;
	
	
	JLabel background1, l3;
	Font f4, f5;
	JRadioButton rb1, rb2, rb3, rb4;
	ButtonGroup bg1;
	JButton b5, b6;
	
	/*ArrayList arr_no = new ArrayList();
	ArrayList arr_ques = new ArrayList();
	ArrayList arr_ch1 = new ArrayList();
	ArrayList arr_ch2 = new ArrayList();
	ArrayList arr_ch3 = new ArrayList();
	ArrayList arr_ch4 = new ArrayList();
	ArrayList arr_cr_ans = new ArrayList();
	int i=0;
	int total_ques=0;
	String ques_no, ques, ch1, ch2, ch3, ch4, correct_ans;*/
	
	
	
	void reg_topic_selection()
	{
		super.setTitle("Start Exam");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		f1 = new Font("", Font.BOLD, 50);
		f2 = new Font("", Font.BOLD, 25);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (30).jpg");
		background.setIcon(ic1);
		
		l1 = new JLabel("Select the Exam topic:");
		l1.setBounds(30, 20, 600, 100);
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		background.add(l1);
		
		l2 = new JLabel("Choose topic:");
		l2.setBounds(100, 150, 200, 100);
		l2.setForeground(Color.yellow);
		l2.setFont(f2);
		background.add(l2);
		
		box1 = new JComboBox();
		box1.setBounds(100, 250, 200, 50);
		box1.setBackground(Color.white);
		box1.setFont(f2);
		background.add(box1);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_student","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("Select Course from student_enrolled_courses where Application_Number = '"+Student_Login_Signup.current_active_user+"'");
			while(rs.next())
			{
				reg_courses = rs.getString("Course");
				box1.addItem(reg_courses);
			}
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		b1 = new JButton("NEXT");
		b1.setBounds(850, 550, 150, 50);
		b1.setFont(f2);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("< < < BACK");
		b2.setBounds(80, 550, 150, 50);
		b2.setBackground(Color.orange);
		background.add(b2);
		b2.addActionListener(this);
		
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
	}
	
	void guidelines()
	{
		super.setTitle("Start Exam");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (30).jpg");
		background.setIcon(ic1);
		
		f1 = new Font("", Font.BOLD, 50);
		f2 = new Font("", Font.CENTER_BASELINE, 25);
		
		
		l1 = new JLabel("Instructions");
		l1.setBounds(380, 50, 350, 60);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		background.add(l1);
		
		l2 = new JLabel("<html>This test consists of multiple-choice question section. Each question in this section is a multiple-choice question with four answer choices."+
						" Read each question and answer choice carefully and choose the ONE best answer. Try to answer all questions."+
						" In general, if you have some knowledge about a question, it is better to try to answer it. You will not be penalized for guessing."+
						" Be sure to allocate your time carefully so you are able to complete the entire test within the testing session."+
						" You may go back and review your answers at any time during the testing session. You may NOT use a calculator or reference materials during the testing session."+
						" Select the Next button to continue </html>");
		l2.setBounds(120, 100, 900, 400);
		l2.setFont(f2);
		l2.setForeground(Color.yellow);
		background.add(l2);
		
		b3 = new JButton("NEXT");
		b3.setBounds(450, 550, 150, 50);
		b3.setFont(f2);
		b3.setBackground(Color.orange);
		background.add(b3);
		b3.addActionListener(this);
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
	}
	
	/*void start_exam_func2()
	{
		super.setTitle("Start Exam");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		background1 = new JLabel();
		background1.setBounds(0, 0, 1100, 700);
		super.add(background1);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (30).jpg");
		background1.setIcon(ic1);
		
		f4 = new Font("", Font.CENTER_BASELINE, 40);
		f5 = new Font("", Font.CENTER_BASELINE, 20);
		
		//ques_from_database();
		
		
		bg1 = new ButtonGroup();
		
		b5 = new JButton("NEXT");
		b5.setBounds(450, 570, 150, 50);
		b5.setFont(f5);
		b5.setBackground(Color.orange);
		background1.add(b5);
		b5.addActionListener(this);
		
		l3 = new JLabel();
		l3.setBounds(70, 100, 500, 40);
		l3.setFont(f4);
		l3.setForeground(Color.white);
		background1.add(l3);
					
		rb1 = new JRadioButton();
		rb1.setBounds(50, 250, 500, 40);
		rb1.setFont(f5);
		bg1.add(rb1);
		background1.add(rb1);
					
		rb2 = new JRadioButton();
		rb2.setBounds(50, 320, 500, 40);
		rb2.setFont(f5);
		bg1.add(rb2);
		background1.add(rb2);
			
			
		rb3 = new JRadioButton();
		rb3.setBounds(50, 400, 500, 40);
		rb3.setFont(f5);
		bg1.add(rb3);
		background1.add(rb3);

		rb4 = new JRadioButton();
		rb4.setBounds(50, 480, 500, 40);
		rb4.setFont(f5);
		bg1.add(rb4);
		background1.add(rb4);
		
		b6 = new JButton("SUBMIT");
		b6.setBounds(850, 570, 150, 50);
		b6.setFont(f5);
		b6.setBackground(Color.orange);
		b6.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
	}
	
	void ques_from_database()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin_part2","root","root");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM java");
			
			while(rs.next())
			{
				ques_no = rs.getString("QuesNO");
				arr_no.add(ques_no);
				ques = rs.getString("Questions");
				arr_ques.add(ques);
				ch1 = rs.getString("Ans1");
				arr_ch1.add(ch1);
				ch2 = rs.getString("Ans2");
				arr_ch2.add(ch2);
				ch3 = rs.getString("Ans3");
				arr_ch3.add(ch3);
				ch4 = rs.getString("Ans4");
				arr_ch4.add(ch4);
				correct_ans = rs.getString("CorrectAns");
				arr_cr_ans.add(correct_ans);
			}
			total_ques = arr_no.size();
			for(int i = 0; i<total_ques;i++)
			{
				System.out.println(arr_ques.get(i));
			}
		}
		
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	void counter()
	{
	
		if(i<arr_no.size())
		{
			l3.setText((String) arr_ques.get(i));
			rb1.setText((String) arr_ch1.get(i));
			rb2.setText((String) arr_ch2.get(i));
			rb3.setText((String) arr_ch3.get(i));
			rb4.setText((String) arr_ch4.get(i));
			i++;
		}
	}*/
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b1)
		{
			Student_Start_Exam obj_student_start_exam = new Student_Start_Exam();
			obj_student_start_exam.guidelines();
			super.dispose();
		}
		else if(ae.getSource() == b2)
		{
			Student_Dashboard obj_student_dashboard = new Student_Dashboard();
			obj_student_dashboard.student_dashboard_func();
			super.dispose();
		}
		else if(ae.getSource() == b3)
		{
			Student_Start_Exam2 obj_student_start_exam2 = new Student_Start_Exam2();
			obj_student_start_exam2.start_exam_func2();
			super.dispose();
		}
		/*else if(ae.getSource() == b5)
		{
			if(i<arr_no.size())
			{
				l3.setText((String) arr_ques.get(i));
				rb1.setText((String) arr_ch1.get(i));
				rb2.setText((String) arr_ch2.get(i));
				rb3.setText((String) arr_ch3.get(i));
				rb4.setText((String) arr_ch4.get(i));
				i++;
			}
			
			if(i==total_ques)
			{
				b5.setVisible(false);
				background1.add(b6);
				b6.getIcon();
			}
		}	*/	
	}
	
	
	public static void main(String[] args) 
	{
		Student_Start_Exam obj_student_start_exam = new Student_Start_Exam();
		obj_student_start_exam.reg_topic_selection();
	
	}
}
