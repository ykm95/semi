package web.controller.admin.admin_user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.service.admin.admin_user.UserAdminService;
import web.service.admin.admin_user.UserAdminServiceImpl;

/**
 * Servlet implementation class UserAdminDelete
 */
@WebServlet("/user/delete")
public class UserAdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserAdminService userAdminService = new UserAdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Member userAdmin = userAdminService.getUserno(req);
	
	userAdminService.delete(userAdmin);
		
	//리다이렉트
	resp.sendRedirect("/admin/userlist");
	}
}
