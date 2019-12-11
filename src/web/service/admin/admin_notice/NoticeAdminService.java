package web.service.admin.admin_notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Member;
import web.dto.Notice;

public interface NoticeAdminService {
	
	/**
	 * 알림 보내기
	 * @param req
	 */
	public void notice(Notice writenotice);
	/**
	 * 알림 보낸거 가져오기
	 * @param req
	 * @return
	 */
	public Notice getnotice(HttpServletRequest req);
	/**
	 * 요청 파라미터 회원번호
	 * @param req
	 * @return
	 */
	public Notice getUserno(HttpServletRequest req);
	/**
	 * 페이징 정보를 활용해 보여질 알림 목록만 조회
	 * @param paging
	 * @param req
	 * @return
	 */
	public List<Notice> getList(Paging paging, HttpServletRequest req);
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */	
	public Paging getPaging(HttpServletRequest req);
	/*
	 * 요청 파라미터 알림번호 파싱
	 */
	public Notice getNoticeno(HttpServletRequest req);
	/**
	 * usertb에서 userid 가져오기
	 * @param req
	 */
	public Member getUseridno(HttpServletRequest req);

}
