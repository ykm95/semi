package web.controller.mypage.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.user.MypageUserServiceImpl;
import web.service.mypage.user.MypageUserService;

@WebServlet("/mypage/user/secession")
public class UserSeccessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MypageUserService mypageUserService = new MypageUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/user/secession.jsp")
		.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mypageUserService.secessionUser(req);
		
		req.getSession().invalidate();
		
		resp.sendRedirect("/main");
		
	}

}
