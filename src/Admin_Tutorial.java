import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Admin_Tutorial extends JFrame
{
	JLabel l1, background;
	
	
	
	
	
	void admin_tutorial_func()
	{
		super.setTitle("Tutorial");
		super.setBounds(140, 20, 1100, 700);
		super.setResizable(false);
		
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		super.setContentPane(scroll);
		
		background = new JLabel();
		background.setBounds(0, 0, 1100, 700);
		super.add(background);
		ImageIcon ic1 = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (31).jpg");
		background.setIcon(ic1);
	
		
		
		
		
		
		
		
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Admin_Tutorial obj_admin_tutorial = new Admin_Tutorial();
		obj_admin_tutorial.admin_tutorial_func();
	}
}
