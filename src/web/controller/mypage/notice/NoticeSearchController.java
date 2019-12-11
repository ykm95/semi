package web.controller.mypage.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import web.dto.Notice;
import web.service.member.MemberService;
import web.service.member.MemberServiceImpl;
import web.service.mypage.notice.NoticeService;
import web.service.mypage.notice.NoticeServiceImpl;

@WebServlet("/mypage/notice")
public class NoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		List<Notice> list = noticeService.getNotice(req);
		
		Member member = new Member();
		member.setUserid((String)session.getAttribute("userid"));
		member = memberService.getMemberByUserid(member);
		
		req.setAttribute("member", member);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/notice/notice.jsp")
		.forward(req, resp);
	}

}
