package web.dao.admin.admin_user;

import java.util.List;

import util.Paging;
import web.dto.Member;

public interface UserAdminDao {
	
	/**
	 * 회원 전체 목록 조회
	 * @return List - 조회된 회원 정보 목록
	 */
	public List<Member> selectAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param Paging - 페이징 정보
	 * @return List - 조회된 회원 목록
	 */
	public List<Member> selectAll(Paging paging);
	
	/**
	 * 총 회원 수 조회
	 * 
	 * @return int - 총 회원 수
	 */
	public int selectCntAll();
	
	/**
	 * 검색어를 이용한 총 게시글 수 조회
	 * 
	 * @return int - 총 게시글 수
	 */
	public int selectCntAll(String search);
	
	/**
	 * 회원 탈퇴
	 * @param admin
	 */
	public void delete(Member userAdmin);
}
