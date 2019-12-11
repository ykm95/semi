package web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;

/**
 * Servlet implementation class MemberIdCheckController
 */
@WebServlet("/member/check")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/member/check - TEST");
		Member userid = memberService.getId(req);

		boolean check = memberService.idCheck(userid);

		String cen = null;

		if(check == true) {
			cen = "중복 아이디";

		}else {
			cen = "사용가능 아이디";
		}


		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().println("{\"cen\":\"" + cen + "\"}");
	}




}
