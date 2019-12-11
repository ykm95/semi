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
 * Servlet implementation class MemberJoinController
 */
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req,  resp);

	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    //요청 데이터 한글 인코딩 UTF-8 설정
	    req.setCharacterEncoding("UTF-8");

	    //응답 데이터 형식 설정
	    resp.setContentType("text/html; charset=utf-8");
		
		
		Member member = memberService.getMemParam(req);
		
		
		memberService.join(member);
		
		
		//이메일 전송 메서드 호출
		memberService.emailAuth(member);		
		
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/member/code").forward(req,  resp);
	}


}
