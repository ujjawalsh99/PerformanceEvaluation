import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;

class BabyOfAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
	// create object of PA
	PasswordAuthentication pa = new PasswordAuthentication("<email>","<password>");
	
	// return object of PA
	return pa;
	}
}


public class Email
{
	void emailfunc()
	throws Exception
	{
	// create object of properties in order to
	// provide configuration info... about
	// mail server
	Properties p = new Properties();
	p.put("mail.smtp.host","smtp.gmail.com");
	p.put("mail.smtp.port","587");
	p.put("mail.smtp.starttls.enable","true");
	p.put("mail.smtp.auth","true");
	p.put("mail.smtp.ssl.trust","smtp.gmail.com");
	//p.put("mail.debug","true");
	
	// create object of Authenticator
	BabyOfAuthenticator baby = new BabyOfAuthenticator();
	
	// create object of session
	Session ses = Session.getInstance(p, baby);
	
	// create object of mime-message to denote
	// actual message to be sent to mail server
	MimeMessage message = new MimeMessage(ses);
	
	// provide a subject
	message.setSubject("OTP");
	
	String[] emails = "others@gmail.com".split(",");
	
	InternetAddress[] inadrs = new InternetAddress[emails.length];
	
	message.setFrom(new InternetAddress("<email>"));
	
	for(int i = 0; i < emails.length; i++)
	{
	// create object of internet-address to
	// denote email
	InternetAddress ina = new InternetAddress(emails[i]);
	
	// store this object inside array
	inadrs[i] = ina;
	}
	
	// lets specify the types of RCVRS
	message.addRecipients
	(RecipientType.TO, inadrs);
	
	// create some body parts
	MimeBodyPart body1 = new MimeBodyPart(),
			body2 = new MimeBodyPart();
	
	// associate a text with body1
	
	Random rd = new Random();
	int otp = (rd.nextInt())%1000000;
	
	if(otp<0)
	{
		otp = -otp;
	}
	
	
	try
	{
		String email = "<email>";
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/portal_admin","root","root");
		Statement st = co.createStatement();
		st.executeUpdate("UPDATE admin_info SET SecretCode= '"+otp+"' WHERE Email= '"+email+"'");
	}
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	
	
	
	body1.setContent
	("<p style='color : red;'>"+otp+"</p>", 
			"text/html");
	
	body2.setContent
	("<p style='color : black;'>This OTP is valid only for 5 minutes</p>", 
			"text/html");
	
	// associate attachments with body2 and body3
	
	
	// create multipart to store body parts
	MimeMultipart parts = new MimeMultipart();
	
	// store all the body parts inside multipart
	parts.addBodyPart(body1);
	parts.addBodyPart(body2);

	
	// store multipart inside message
	message.setContent(parts);
	
	// send this message to the mail server
	Transport.send(message);
	
	}
}