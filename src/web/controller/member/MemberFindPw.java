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
@WebServlet("/member/findpw")
public class MemberFindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println(req.getParameter("userno"));
		Member changepw = memberService.getChPw(req);
		System.out.println(changepw);
		
		changepw.setUserno(Integer.parseInt(req.getParameter("userno")));
		Member changeUserPw = memberService.getChangdPw(changepw);
		
		PrintWriter out=resp.getWriter();
		out.println("<script>alert(' 변경완료되었습니다 '); close();</script>");
		out.flush();
	}




}
