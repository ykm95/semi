package web.controller.admin.admin_report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Report;
import web.service.admin.admin_report.ReportAdminService;
import web.service.admin.admin_report.ReportAdminServiceImpl;

/**
 * Servlet implementation class ReportAdminListController
 */
@WebServlet("/adminreport/list")
public class ReportAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportAdminService reportAdminService = new ReportAdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("adminlogin") != null) {
			Paging paging = reportAdminService.getPaging(req);

			req.setAttribute("paging", paging);

			//신고글 목록 조회
			List<Report> rlist = reportAdminService.getList(paging);
			//	System.out.println(paging);
			//		System.out.println(rlist);

			req.setAttribute("rlist", rlist);


			req.getRequestDispatcher("/WEB-INF/views/admin/report/report_list.jsp")
			.forward(req, resp);
		}else {
			resp.sendRedirect("/admin/admain");
		}
	}
}
