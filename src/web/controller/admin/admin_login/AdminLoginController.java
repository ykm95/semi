package web.controller.admin.admin_login;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Admin;
import web.dto.Member;
import web.service.admin.admin_login.AdminLoginService;
import web.service.admin.admin_login.AdminLoginServiceImpl;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLoginService adminMemberService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/admin/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
		
	//로그인 정보 가져오기
	Admin admin_login = adminMemberService.getLogin(req);
	
	System.out.println(req.getParameter("adminid"));
	System.out.println(req.getParameter("adminpw"));
	
	//로그인 인증
	boolean adminlogin = adminMemberService.login(admin_login);
	session.setAttribute("adminlogin", adminlogin);
	
	Admin admin_Info = adminMemberService.getAdminByAdminid(admin_login);
	
	if (adminlogin==true) {
		session.setAttribute("adminid", admin_Info.getAdminid());
		session.setAttribute("adminpw", admin_Info.getAdminpw());
		
		resp.sendRedirect("/admin/admain");
		return;
	} else {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println("<script>alert(' 아이디 혹은 비밀번호를 잘못입력하셨습니다 '); location.href='/admin/login'</script>");
		out.flush();
	}
	
	}
}
