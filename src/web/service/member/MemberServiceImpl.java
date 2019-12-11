package web.service.member;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import util.Gmail;
import web.dao.member.MemberDao;
import web.dao.member.MemberDaoImpl;
import web.dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = new MemberDaoImpl();

	/**
	 * 사용자가 입력한 데이터를 가저오는 메소드(getMemParam) 
	 */	
	@Override 
	public Member getMemParam(HttpServletRequest req) {

		Member member = new Member();
		String param = null;

		param=req.getParameter("userid");
		member.setUserid(param);

		param=req.getParameter("userpw");
		member.setUserpw(param);

		param=req.getParameter("email");
		member.setEmail(param);	

		param=req.getParameter("nick");
		member.setNick(param);		

		return member;
	}

	@Override
	public void join(Member member) {
		memberDao.insert(member);
	}


	@Override
	public Member getLoginMember(HttpServletRequest req) {
		Member member = new Member();
		String param = null;
		param=req.getParameter("userid");
		member.setUserid(param);

		param=req.getParameter("userpw");
		member.setUserpw(param);	

		return member;		
	}

	@Override
	public boolean login(Member member_login) {
		int result = memberDao.selectCntMemberByUserid(member_login);

		if(result == 1) {
			return true;			
		} else {
			return false;
		}

	}

	@Override
	public Member getMemberByUserid(Member member_login) {
		// 
		return memberDao.selectMemberByUserid(member_login);
	}

	@Override
	public Member getId(HttpServletRequest req) {
		
		Member member = new Member();
		String param = null;
		
		param=req.getParameter("userid");
		member.setUserid(param);
		
		return member;	
	}

	@Override
	public boolean idCheck(Member userid) {

		int result = memberDao.selectCntByUserid(userid);
		
		if(result > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Member getMemId(HttpServletRequest req) {
	
		Member member = new Member();
		String param = null;
		param=req.getParameter("userid");
		member.setUserid(param);

		return member;		
	}

	@Override
	public boolean id_check(Member member_id) {
		int result = memberDao.selectCntMemberByUserid_1(member_id);

		if(result == 1) {
			return true;			
		} else {
			return false;
		}

	}
	
	@Override
	public String getRamdomEmailCode(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' }; 
		int idx = 0;
		StringBuffer sb = new StringBuffer(); 
		for (int i = 0; i < len; i++) 
		{ 
			idx = (int) (charSet.length * Math.random()); 
			// 36 * 생성된 난수를 Int로 추출 (소숫점제거) 
			sb.append(charSet[idx]); }
		return sb.toString();
	}

	@Override
	public Member getMemberByUserid_1(Member member_id) {
		return memberDao.selectMemberByUserid_1(member_id);
	}
	
	

	@Override
	public void emailAuth(Member member) {

		 // 사용자에게 보낼 메시지를 기입합니다.
	      String from = "djin326@gmail.com";
	      
	      //이메일 인증 코드 생성
	      String emailCode = getRamdomEmailCode(8);
	      
	      //이메일 체크번호 객체에 담기
	      member.setEmailCheckNo(emailCode);
	      
	      //이메일 인증번호 삽입
	      changeEmailCheckNo(member);
	      
	      String subject = "Semore 이메일 인증코드 입니다.";
	      String content = "고객님의 인증 코드는 " + emailCode +  " 입니다.";

	      // SMTP에 접속하기 위한 정보를 기입합니다.
	      Properties p = new Properties();
	      p.put("mail.smtp.user", from);
	      p.put("mail.smtp.host", "smtp.googlemail.com");
	      p.put("mail.smtp.port", "465");
	      p.put("mail.smtp.starttls.enable", "true");
	      p.put("mail.smtp.auth", "true");
	      p.put("mail.smtp.debug", "true");
	      p.put("mail.smtp.socketFactory.port", "465");
	      p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      p.put("mail.smtp.socketFactory.fallback", "false");

	      try{
	         Authenticator auth = new Gmail();
	         Session ses = Session.getInstance(p, auth);
	         ses.setDebug(true);
	         MimeMessage msg = new MimeMessage(ses); 
	         msg.setSubject(subject);
	         Address fromAddr = new InternetAddress(from);
	         msg.setFrom(fromAddr);
	         Address toAddr = new InternetAddress(member.getEmail());
	         msg.addRecipient(Message.RecipientType.TO, toAddr);
	         msg.setContent(content, "text/html;charset=UTF-8");
	         Transport.send(msg);
	      } catch(Exception e){
	         e.printStackTrace();
	      }
		
	}

	@Override
	public void changeEmailCheckNo(Member member) {
		
		memberDao.updateEmailCheckNo(member);
	}

	@Override
	public Member getEmailCheckNo(Member member) {
		// TODO Auto-generated method stub
		return memberDao.selectEmailCheckNo(member);
		
	}

	@Override
	public Member getPwByMemberId(Member member) {
		return memberDao.selectPwByUserid(member);
		
	}

	@Override
	public boolean check_pw(Member member) {
		int result = memberDao.selectCntMemberByUserid_2(member);

		if(result == 1) {
			return true;			
		} else {
			return false;
		}
	}

	@Override
	public Member getChPw(HttpServletRequest req) {
		
		Member member = new Member();
		String param = null;
	
		param=req.getParameter("userpw");
		member.setUserpw(param);	

		return member;	
	}

	@Override
	public Member getChangdPw(Member changepw) {
		memberDao.changePw(changepw);
		return changepw;
	}
}