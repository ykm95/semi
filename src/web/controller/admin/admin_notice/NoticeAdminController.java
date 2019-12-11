package web.controller.admin.admin_notice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.dto.Notice;
import web.dto.Question;
import web.service.admin.admin_notice.NoticeAdminService;
import web.service.admin.admin_notice.NoticeAdminServiceImpl;
import web.service.admin.admin_report.ReportAdminService;
import web.service.admin.admin_report.ReportAdminServiceImpl;

/**
 * Servlet implementation class NoticeAdminController
 */
@WebServlet("/admin/notice")
public class NoticeAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeAdminService noticeAdminService = new NoticeAdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("adminlogin") != null) {
			
			//회원 번호 파싱
			Notice noticeanswer = noticeAdminService.getUserno(req);

			Member member = noticeAdminService.getUseridno(req);
			req.setAttribute("member", member);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/notice/notice.jsp")
			.forward(req, resp);
		} else {
			resp.sendRedirect("/admin/admain");	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		Notice notice = noticeAdminService.getnotice(req);
		//알림글 삽입
		noticeAdminService.notice(notice);
		
		resp.sendRedirect("/adminnotice/list?userno="+notice.getUserno());
	}
}
