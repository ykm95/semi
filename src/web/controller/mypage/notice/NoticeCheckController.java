package web.controller.mypage.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.notice.NoticeService;
import web.service.mypage.notice.NoticeServiceImpl;

@WebServlet("/mypage/notice/chk")
public class NoticeCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int noticeCnt = noticeService.getNoticeCnt(req);
		
		resp.getWriter().println("{ \"noticeCnt\" : "+ noticeCnt+" }");
		
	}

}
