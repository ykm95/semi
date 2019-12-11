package web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;

/**
 * Servlet implementation class MemberMailCodeInput
 */
@WebServlet("/member/code")
public class MemberMailCodeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("메일 잘 보내졌어요");
		
		Member member = memberService.getMemParam(req);
		
		Member emailMember = memberService.getEmailCheckNo(member);
		
		System.out.println("담겨있나 테스트 해보자" + emailMember);
		
	    req.setAttribute("member", emailMember);
	     
	    req.getRequestDispatcher("/WEB-INF/views/member/emailchecked.jsp").forward(req, resp);
		
		
	}

}
