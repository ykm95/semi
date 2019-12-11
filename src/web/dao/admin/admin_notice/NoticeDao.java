package web.dao.admin.admin_notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Member;
import web.dto.Notice;

public interface NoticeDao {
	
	/**
	 * 알림 글쓰기
	 * @param noticesend
	 */
	public void noticeinsert(Notice writenotice); 
	/**
	 * 다음 알림 번호 반환
	 * 알림글에 들어갈 게시글 번호 미리 추출?
	 * @return
	 */
	public int selectNoticeno();
	/**
	 * 알림글 리스트 불러오기
	 * @param paging
	 * @param req
	 * @return
	 */
	public List<Notice> selectAll(Paging paging, HttpServletRequest req);

	/**
	 * 총 알림 수 조회
	 * @param req
	 * @return
	 */
	public int selectCntAll(HttpServletRequest req);
	/**
	 * 알림번호로 알림정보 가져오기
	 * @param req
	 * @return
	 */
	public Notice selectNoticeByNoticeno(HttpServletRequest req);
	/**
	 * userno으로 userid, userno 조회
	 * @param req
	 * @return
	 */
	public Member selectUseridByUserno(HttpServletRequest req);

	
}
