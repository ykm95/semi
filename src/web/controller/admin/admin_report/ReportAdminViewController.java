package web.controller.admin.admin_report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Report;
import web.service.admin.admin_report.ReportAdminService;
import web.service.admin.admin_report.ReportAdminServiceImpl;

/**
 * Servlet implementation class ReportAdminViewController
 */
@WebServlet("/adminreport/view")
public class ReportAdminViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportAdminService reportAdminService = new ReportAdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//회원번호 파싱
	Report viewReport = reportAdminService.getUserno(req);
	viewReport = reportAdminService.view(viewReport);	
	
	//신고글 전달
	req.setAttribute("viewReport", viewReport);
	
	req.getRequestDispatcher("/WEB-INF/views/admin/report/report_view.jsp")
	.forward(req, resp);
	}
}
