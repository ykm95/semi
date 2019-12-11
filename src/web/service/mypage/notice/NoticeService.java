package web.service.mypage.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Notice;

public interface NoticeService {

	List<Notice> getNotice(HttpServletRequest req);

	void delete(HttpServletRequest req);

	void deleteAll(HttpServletRequest req);

	int getNoticeCnt(HttpServletRequest req);

}
