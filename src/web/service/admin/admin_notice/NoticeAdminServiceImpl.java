package web.service.admin.admin_notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.admin.admin_notice.NoticeDao;
import web.dao.admin.admin_notice.NoticeDaoImpl;
import web.dto.Member;
import web.dto.Notice;

public class NoticeAdminServiceImpl implements NoticeAdminService{

	NoticeDao noticeDao = new NoticeDaoImpl();

	@Override
	public void notice(Notice writenotice) {
		writenotice.setNoticeno(noticeDao.selectNoticeno());
		noticeDao.noticeinsert(writenotice);

	}

	@Override
	public Notice getnotice(HttpServletRequest req) {

		Notice notice = new Notice();


		String param = req.getParameter("noticeno");
		if (param != null && !"".equals(param)) {
			notice.setNoticeno(Integer.parseInt(param));
		}

		param = req.getParameter("userno");
		if (param != null && !"".equals(param)) {
			notice.setUserno(Integer.parseInt(param));
		}

		notice.setNotice(req.getParameter("notice"));
		return notice;
	}

	@Override
	public Notice getUserno(HttpServletRequest req) {
		//요청파라미터 userno를 파싱한다
		String param = req.getParameter("userno");
		int userno = 0;
		if( param!=null && !"".equals(param)) {
			userno = Integer.parseInt(param);
		}


		Notice notice=new Notice();
		notice.setUserno(userno);
		return notice;
	}

	@Override
	public List<Notice> getList(Paging paging, HttpServletRequest req) {
		return noticeDao.selectAll(paging, req);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage =Integer.parseInt(param);
		}

		//Board TB와 curPage 값을 이용해 Paging 객체를 생성하고 반환
		int totalcount = noticeDao.selectCntAll(req);

		//Paging 객체 생성
		Paging paging = new Paging(totalcount, curPage);
		return paging;
	}

	@Override
	public Notice getNoticeno(HttpServletRequest req) {
		return noticeDao.selectNoticeByNoticeno(req);
	}

	@Override
	public Member getUseridno(HttpServletRequest req) {
		return noticeDao.selectUseridByUserno(req);
	}
}
