import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage 
{
	public static void main(String[] args) 
	{
		GuiForHomepage gfh = new GuiForHomepage();
		gfh.frameLayout();
	}
}



class GuiForHomepage extends JFrame
implements ActionListener
{
	JButton b1, b2, b3;
	ImageIcon ic1, ic2, ic3, ic_background;
	JLabel background;
	
	
	void frameLayout()
	{
		super.setTitle("Homepage");
		super.setBounds(350, 20, 700, 700);
		super.setResizable(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 700, 700);
		super.add(background);
		ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (1).jpg");
		background.setIcon(ic_background);
		
		
		b1 = new JButton();
		b1.setBounds(260, 20, 150, 150);
		background.add(b1);
		ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\admin_icon.png");
		b1.setIcon(ic1);
		b1.addActionListener(this);
		
		b2 = new JButton();
		b2.setBounds(260, 250, 150, 150);
		background.add(b2);
		ic2 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\student_icon.png");
		b2.setIcon(ic2);
		b2.addActionListener(this);
		
		b3 = new JButton();
		b3.setBounds(260, 480, 150, 150);
		background.add(b3);
		ic3 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\company_icon.png");
		b3.setIcon(ic3);
		b3.addActionListener(this);
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			AdminLogin obj_adminlogin = new AdminLogin();
			obj_adminlogin.adminLoginFunc();
			super.dispose();
		}
		
		else if(ae.getSource() == b2)
		{
			Student_Login_Signup obj_studentloginsignup = new Student_Login_Signup();
			obj_studentloginsignup.student_login_signup_func();
			super.dispose();
		}
		
		else if(ae.getSource() == b3)
		{
			
		}
	}
	

}
