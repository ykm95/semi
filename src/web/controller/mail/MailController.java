package web.controller.mail;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MailAuth;



@WebServlet("/send")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// FROM
		final String FROM = "djin326@gmail.com"; // <<------------------------------수정하세요
		final String FROMNAME = "DJ"; // <<------------------------------수정하세요

		// TO
		final String TO = "ejrwls95@naver.com"; // <<------------------------------수정하세요

		// 메일 제목
		final String SUBJECT = "세모레 인증 메일입니다"; // <<------------------------------수정하세요

		// 메일 본문
		final String BODY = String.join(
				
				"<p>인증을 원하시면 클릭하세요</p>",
				"<a href=http://localhost:8083/main>클릭!</a>"); // <<------------------------------수정하세요

		// 인증 객체
		Authenticator auth = new MailAuth("djin326@gmail.com", "dktlqkf18"); // <<------------------------------수정하세요

		// 연결 설정
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		// 메일 세션 객체 생성
		Session session = Session.getDefaultInstance(props, auth);

		// 메시지 생성
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(FROM, FROMNAME));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			msg.setSubject(SUBJECT);
			msg.setContent(BODY, "text/html;charset=utf-8");

			System.out.println("Sending...");

			//메시지 보내기
			Transport.send(msg);
			
			System.out.println("Email sent!");

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			
		} catch (MessagingException e) {
			e.printStackTrace();
			
			System.out.println("The email was not sent.");
			System.out.println("Error message: " + e.getMessage());
			
		} 			
	}
}
