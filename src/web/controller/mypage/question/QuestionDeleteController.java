package web.controller.mypage.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.question.QuestionService;
import web.service.mypage.question.QuestionServiceImpl;

@WebServlet("/mypage/question/delete")
public class QuestionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuestionService questionService = new QuestionServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		questionService.delete(req);
		
		resp.sendRedirect("/mypage/question");
		
	}
	
}
