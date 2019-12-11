package web.dao.mypage.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Notice;

public interface NoticeDao {

	/**
	 * 유저번호를 통해서 해당 유저가 가진 모든 알림들을 반환한다
	 * @param req - 유저넘버
	 * @return - 해당 유저가 가진 모든 알림들
	 */
	List<Notice> selectAllNotice(HttpServletRequest req);

	void deleteNotice(HttpServletRequest req);

	void deleteAllNotice(HttpServletRequest req);

	int selecNoticeCnt(HttpServletRequest req);


}
