package web.controller.admin.admin_user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Member;
import web.service.admin.admin_user.UserAdminService;
import web.service.admin.admin_user.UserAdminServiceImpl;



/**
 * Servlet implementation class UserAdminListController
 */
@WebServlet("/admin/userlist")
public class UserAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserAdminService userAdminService = new UserAdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		if (req.getSession().getAttribute("adminlogin") != null) {
		//요청파라미터에서 curPage를 구하고 Paging객체반환
		Paging paging = userAdminService.getPaging(req);
//		System.out.println("BoardListController : " + paging);

		//Paging 객체를 MODEL 값으로 지정
		req.setAttribute("paging", paging);

		//회원 목록 조회
		List<Member> list = userAdminService.getList(paging);

		
		//회원 목록을 MODEL값으로 지정
		req.setAttribute("list", list);
		req.setAttribute("userno", req.getParameter("userno"));
		req.getRequestDispatcher("/WEB-INF/views/admin/user/user_list.jsp").forward(req, resp);

		} else {
			resp.sendRedirect("/admin/admain");
		}
	}

}
