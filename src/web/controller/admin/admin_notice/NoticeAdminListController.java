package web.controller.admin.admin_notice;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Member;
import web.dto.Notice;
import web.service.admin.admin_notice.NoticeAdminService;
import web.service.admin.admin_notice.NoticeAdminServiceImpl;

/**
 * Servlet implementation class NoticeAdminListController
 */
@WebServlet("/adminnotice/list")
public class NoticeAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeAdminService noticeAdminService= new NoticeAdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getSession().getAttribute("adminlogin")!=null) {
			
			Paging paging = noticeAdminService.getPaging(req);
			
			req.setAttribute("paging", paging);
			
			//알림 목록 조회
			List<Notice> noticelist = noticeAdminService.getList(paging, req);
			
			Member member = noticeAdminService.getUseridno(req);
			
			req.setAttribute("noticelist", noticelist);
			req.setAttribute("member", member);
			System.out.println(member);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/notice/notice_list.jsp")
			.forward(req, resp);
			
		} else {
			resp.sendRedirect("/admin/admain");
		}
	
	}

}
