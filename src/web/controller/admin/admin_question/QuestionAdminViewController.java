package web.controller.admin.admin_question;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Question;
import web.service.admin.admin_question.QuestionAdminService;
import web.service.admin.admin_question.QuestionAdminServiceImpl;

@WebServlet("/adminquestion/view")
public class QuestionAdminViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionAdminService questionAdminService = new QuestionAdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//회원 번호 파싱
		Question viewQuestion = questionAdminService.getUserno(req);
		
		viewQuestion = questionAdminService.view(viewQuestion);
		
		//문의글 전달
		req.setAttribute("viewQuestion", viewQuestion);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/question/question_view.jsp").forward(req, resp);
	}

}
