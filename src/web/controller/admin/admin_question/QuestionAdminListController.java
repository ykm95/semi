package web.controller.admin.admin_question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Question;
import web.service.admin.admin_question.QuestionAdminService;
import web.service.admin.admin_question.QuestionAdminServiceImpl;

/**
 * Servlet implementation class QuestionAdminListController
 */
@WebServlet("/adminquestion/list")
public class QuestionAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuestionAdminService questionAdminService = new QuestionAdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("adminlogin") != null) {
			//curpage를 구하고 paging 객체반환
			Paging paging = questionAdminService.getPaging(req);

			//Paging 객체를 MODEL 값으로 지정
			req.setAttribute("paging", paging);

			//문의글 목록 조회
			List<Question> qlist = questionAdminService.getList(paging);

			//문의 목록을 MODEL값으로 지정
			req.setAttribute("qlist", qlist);

			req.getRequestDispatcher("/WEB-INF/views/admin/question/question_list.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/admin/admain");
		}
	}

}
