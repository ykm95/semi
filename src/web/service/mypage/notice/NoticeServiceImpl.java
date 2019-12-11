package web.service.mypage.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.mypage.notice.NoticeDao;
import web.dao.mypage.notice.NoticeDaoImpl;
import web.dto.Notice;

public class NoticeServiceImpl implements NoticeService {

	NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public List<Notice> getNotice(HttpServletRequest req) {
		
		return noticeDao.selectAllNotice(req);
	}

	@Override
	public void delete(HttpServletRequest req) {
		
		noticeDao.deleteNotice(req);
		
	}

	@Override
	public void deleteAll(HttpServletRequest req) {
		
		noticeDao.deleteAllNotice(req);
		
	}

	@Override
	public int getNoticeCnt(HttpServletRequest req) {
		
		return noticeDao.selecNoticeCnt(req);
	}

}
