package web.controller.member;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;


@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();





	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req,  resp);

	}





	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Member member_login = memberService.getLoginMember(req);	// 입력한 id/ pw를 req로 가져옴 
		boolean login = memberService.login(member_login);			// true/false 비교
		session.setAttribute("login", login);						// true or false 판단하기 위해 저장
		
		Member member_Info = memberService.getMemberByUserid(member_login);
//		System.out.println(member_Info);
		
		
		if (login == true) {					
			session.setAttribute("userno", member_Info.getUserno());
			session.setAttribute("userid", member_Info.getUserid());
			session.setAttribute("userpw", member_Info.getUserpw());
			session.setAttribute("email", member_Info.getEmail());
			session.setAttribute("nick", member_Info.getNick());
			
			resp.sendRedirect("/main");
			return;				
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>alert(' 아이디 혹은 비밀번호를 잘못입력하셨습니다 '); location.href='/member/login'</script>");
			out.flush();
		}	
		
	}


}