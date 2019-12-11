package web.controller.mypage.myrecipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Paging;
import web.dto.Member;
import web.dto.Recipe;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.service.mypage.myrecipe.MyRecipeService;
import web.service.mypage.myrecipe.MyRecipeServiceImpl;

@WebServlet("/mypage/myrecipe")
public class MyRecipeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MyRecipeService myRecipeService = new MyRecipeServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Paging paging = myRecipeService.getPaging(req);
		
		//Paging 객체를 MODEL값으로 지정
		req.setAttribute("paging", paging);
				
		List<Recipe> list = myRecipeService.getList(paging, req);
		
		Member member = new Member();
		member.setUserid((String)session.getAttribute("userid"));
		member = memberService.getMemberByUserid(member);
		
		String url = "/mypage/myrecipe";
		
		req.setAttribute("member", member);
		req.setAttribute("list", list);
		req.setAttribute("url", url);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/myrecipe/myrecipe.jsp")
		.forward(req, resp);
		
	}
}
