package web.service.admin.admin_report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.admin.admin_report.ReportAdminDao;
import web.dao.admin.admin_report.ReportAdminDaoImpl;
import web.dto.Report;

public class ReportAdminServiceImpl implements ReportAdminService{
	public ReportAdminDao reportAdminDao = new ReportAdminDaoImpl();

	@Override
	public List<Report> getList() {
		return reportAdminDao.selectAll();
	}

	@Override
	public List<Report> getList(Paging paging) {
		return reportAdminDao.selectAll(paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage =Integer.parseInt(param);
		}

		//검색어
		String search = (String)req.getParameter("search");

		//Board TB와 curPage 값을 이용해 Paging 객체를 생성하고 반환
		int totalcount = reportAdminDao.selectCntAll(search);

		//Paging 객체 생성
		Paging paging = new Paging(totalcount, curPage);

		//검색어
		paging.setSearch(search);
		return paging;
	}

	@Override
	public Report getUserno(HttpServletRequest req) {
		//요청파라미터 userno를 파싱한다
		String param = req.getParameter("userno");
		int userno = 0;
		if( param!=null && !"".equals(param)) {
			userno = Integer.parseInt(param);
		}

		Report report = new Report();
		report.setUserno(userno);

		return report;
	}

	@Override
	public Report view(Report viewReport) {
		return reportAdminDao.selectReportByUserno(viewReport);
	}

	

	

	

}
