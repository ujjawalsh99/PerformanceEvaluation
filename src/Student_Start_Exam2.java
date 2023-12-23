import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Student_Start_Exam2 extends JFrame
implements ActionListener
{
	JLabel background1, l3;
	Font f4,f5;
	ButtonGroup bg1;
	JRadioButton jb[]=new JRadioButton[5];
	JRadioButton rb1, rb2, rb3, rb4;
	JButton b5, b6;
	
	ArrayList arr_no = new ArrayList();
	ArrayList arr_ques = new ArrayList();
	ArrayList arr_ch1 = new ArrayList();
	ArrayList arr_ch2 = new ArrayList();
	ArrayList arr_ch3 = new ArrayList();
	ArrayList arr_ch4 = new ArrayList();
	ArrayList arr_cr_ans = new ArrayList();
	int i=0;
	int total_ques=0;
	String ques_no, ques, ch1, ch2, ch3, ch4, correct_ans;

	
	void start_exam_func2()
	{
		ques_from_database();
		
		
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
		
		for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            jb[i].setFont(f5);
            background1.add(jb[i]);
            bg1.add(jb[i]);  
        }  
		
		jb[0].setBounds(50, 250, 500, 40);
		jb[1].setBounds(50, 320, 500, 40);
		jb[2].setBounds(50, 390, 500, 40);
		jb[3].setBounds(50, 460, 500, 40);
		
		/*rb1 = new JRadioButton();
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
		background1.add(rb4);*/
		
		b6 = new JButton("SUBMIT");
		b6.setBounds(850, 570, 150, 50);
		b6.setFont(f5);
		b6.setBackground(Color.orange);
		background1.add(b6);
		b6.setEnabled(false);
		b6.addActionListener(this);
		
		counter();
		
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
			//System.out.println(i);
			l3.setText((String) arr_ques.get(i));
			jb[0].setText((String) arr_ch1.get(i));
			jb[1].setText((String) arr_ch2.get(i));
			jb[2].setText((String) arr_ch3.get(i));
			jb[3].setText((String) arr_ch4.get(i));
			//i++;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == b5)
		{
			i++;
			counter();
			
			if(i==total_ques)
			{
				//b5.setEnabled(false);
				b5.setVisible(false);
				b6.setEnabled(true);
				//b6.getIcon();
			}
		}	
	}
	
	public static void main(String[] args)
	{
		Student_Start_Exam2 obj_student_start_exam2 = new Student_Start_Exam2();
		obj_student_start_exam2.start_exam_func2();
	}
	
}
