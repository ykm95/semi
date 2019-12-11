package web.controller.mypage.scrap;

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
import web.dto.Scrap;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.service.mypage.scrap.ScrapService;
import web.service.mypage.scrap.ScrapServiceImpl;

@WebServlet("/mypage/scrap")
public class ScrapSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ScrapService scrapService = new ScrapServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Paging paging = scrapService.getPaging(req);
		
		req.setAttribute("paging", paging);
		
		List<Scrap> list = scrapService.getScrap(paging, req);
		
		Member member = new Member();
		member.setUserid((String)session.getAttribute("userid"));
		member = memberService.getMemberByUserid(member);
		
		String url = "/mypage/scrap";
		
		req.setAttribute("member", member);
		req.setAttribute("list", list);
		req.setAttribute("url", url);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/scrap/scrap.jsp")
		.forward(req, resp);
		
	}

}
