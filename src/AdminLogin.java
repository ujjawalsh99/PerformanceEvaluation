import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminLogin extends JFrame
implements ActionListener
{
	JLabel l1, background;
	JButton b1, b2, b3;
	JPasswordField tf1;
	ImageIcon ic_background;
	
	void adminLoginFunc()
	{
		super.setTitle("Admin Login");
		super.setBounds(350, 20, 700, 700);
		super.setResizable(false);
		
		
		background = new JLabel();
		background.setBounds(0, 0, 700, 700);
		super.add(background);
		ic_background = new ImageIcon("A:\\eclipse\\eclipse-workspace\\PerformanceEvaluationPortal\\picture_score\\img (2).jpg");
		background.setIcon(ic_background);
		
		Font font1 = new Font("", Font.BOLD, 20);
		Font font2 = new Font("", Font.BOLD, 16);
		
		l1  = new JLabel("Secret Number");
		l1.setBounds(60, 90, 200, 30);
		l1.setFont(font1);
		l1.setForeground(Color.white);
		background.add(l1);
		tf1 = new JPasswordField();
		tf1.setFont(font2);
		tf1.setBounds(300, 90, 250, 30);
		
		background.add(tf1);
		
		b1 = new JButton("Generate Secret Number");
		b1.setBounds(230, 250, 250, 40);
		b1.setBackground(Color.orange);
		background.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Proceed   > > >");
		b2.setBounds(500, 540, 150, 40);
		b2.setBackground(Color.WHITE);
		background.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("< < <   Back");
		b3.setBounds(50, 540, 150, 40);
		b3.setBackground(Color.WHITE);
		background.add(b3);
		b3.addActionListener(this);
		
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		char [] code_decoded = tf1.getPassword();
		String code = String.valueOf(code_decoded);
		
		
		if(ae.getSource() == b1)
		{
			Email obj_email = new Email();
			try 
			{
				obj_email.emailfunc();
				JOptionPane.showMessageDialog(this, "OTP is send to your registered Email ID. Login within 5 minutes");
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
		}
		
		else if (ae.getSource() == b3)
		{
			GuiForHomepage obj_homepage = new GuiForHomepage();
			obj_homepage.frameLayout();
		}
		
		else if (ae.getSource() == b2)
		{
			try
			{
				String pass = "";
				String email = "ujjawal";
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin","root","root");
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM admin_info WHERE Email= '"+email+"'");
				while(rs.next())
				{
					pass = rs.getString("SecretCode");
				}
				
				if(code.equals(pass))
				{
					AdminDashboard obj_admindashboard = new AdminDashboard();
					obj_admindashboard.adminDashboardFunc();
					super.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter a valid Code");
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) 
	{
		AdminLogin al = new AdminLogin();
		al.adminLoginFunc();
	}
	
}
