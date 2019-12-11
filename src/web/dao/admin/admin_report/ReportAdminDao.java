package web.dao.admin.admin_report;

import java.util.List;

import util.Paging;
import web.dto.Report;

public interface ReportAdminDao {

	/**
	 * 신고글 전체 목록 조회
	 * @return
	 */
	public List<Report> selectAll();
	/**
	 * 페이징 대상 신고 목록 조회
	 * @param paing
	 * @return
	 */
	public List<Report> selectAll(Paging paging);
	/**
	 * 총 신고글 수 조회
	 * @return
	 */
	public int selectCntAll();
	/**
	 * userno?userid로 신고글 조회
	 * @param search
	 * @return
	 */
	public int selectCntAll(String search);
	/**
	 * 신고글 상세보기 조회
	 * @param viewReport
	 * @return
	 */
	public Report selectReportByUserno(Report viewReport);
	

	
}
