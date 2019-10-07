package p1;

import java.io.IOException;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		session=request.getSession(true);
		session.setAttribute("email", email);
		String fromEmail="abcbankbtm@gmail.com"; //sender's mail id.
		String pwd="abcfortech";		//sender's mail pwd.
		String toEmail=email;  //reciever's mail id.
		
		String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
		String msg="click here to change your password http://localhost:9090/AbcBank/changeNewPwd.html"; //mail body
		
		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		});

		try {
		//Composing the Mail
		Message mesg = new MimeMessage(session);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
		mesg.setSubject(subject);  
		mesg.setText(msg);  
			
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(fromEmail));
//			InternetAddress[] addresses = InternetAddress.parse(toEmail);//one or more addresses
//			message.addRecipients(RecipientType.TO, addresses);
//			message.setReplyTo(addresses);
//			message.setSubject(subject);
		
		//Sending the Mail
		Transport.send(mesg);
		System.out.println("Mail Sent!!");
		response.sendRedirect("/AbcBank/resetLink.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
