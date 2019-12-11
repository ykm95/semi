package web.controller.mypage.question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import web.dto.Question;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.service.mypage.question.QuestionService;
import web.service.mypage.question.QuestionServiceImpl;

@WebServlet("/mypage/question")
public class QuestionSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QuestionService questionService = new QuestionServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		List<Question> list = questionService.getQuestion(req);
		
		Member member = new Member();
		member.setUserid((String)session.getAttribute("userid"));
		member = memberService.getMemberByUserid(member);
		
		req.setAttribute("member", member);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/question/question.jsp")
		.forward(req, resp);
		
	}

}
