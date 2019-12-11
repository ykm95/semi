package web.service.admin.admin_report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Report;

public interface ReportAdminService {
	/**
	 * 신고글 목록 조회
	 * @return
	 */
	public List<Report> getList();
	/**
	 * 페이징 정보를 활용하여 보여질 신고 목록만 조회
	 * @param paging
	 * @return
	 */
	public List<Report> getList(Paging paging);
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */
	public Paging getPaging(HttpServletRequest req);
	/**
	 * 요청 파라미터 회원 번호 파싱
	 * @param req
	 * @return
	 */
	public Report getUserno(HttpServletRequest req);
	/**
	 * 신고글 상세보기
	 * @param viewReport
	 * @return
	 */
	public Report view(Report viewReport);

	


}
