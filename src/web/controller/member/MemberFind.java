package web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;

/**
 * Servlet implementation class MemberFindPw
 */
@WebServlet("/member/find")
public class MemberFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/member/findpw.jsp").forward(req,  resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		Member member = memberService.getMemId(req);
		System.out.println(member);
		Member member_pw = memberService.getPwByMemberId(member);
		System.out.println(member_pw);
		
		boolean check = memberService.check_pw(member);
		
		System.out.println(check);
		
		if(check == true ) {
//			req.setAttribute("userpw", member_pw.getUserpw());
			req.setAttribute("userno", member_pw.getUserno());
			req.setCharacterEncoding("UTF-8");
			req.getRequestDispatcher("/WEB-INF/views/member/findpw_2.jsp").forward(req,  resp);
		} else {
			PrintWriter out=resp.getWriter();
			out.println("<script>alert(' 없는 아이디입니다 '); close();</script>");
//			resp.sendRedirect("/member/login");
			out.flush();
		}
		
		
	}

}
