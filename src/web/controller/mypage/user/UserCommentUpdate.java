package web.controller.mypage.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.user.MypageUserService;
import web.service.mypage.user.MypageUserServiceImpl;

@WebServlet("/mypage/user/comupdate")
public class UserCommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MypageUserService mypageUserService = new MypageUserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		mypageUserService.updateCom(req);
		
		resp.sendRedirect(req.getHeader("referer"));
	}
		
}
