package web.service.admin.admin_user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Member;

public interface UserAdminService {

	/**
	 * 게시글 목록 조회
	 *  
	 * @return List - 회원 목록
	 */
	public List<Member> getList();
	
	/**
	 * 페이징 정보를 활용하여 보여질 회원 목록만 조회
	 *  
	 * @param Paging - 페이징 정보
	 * @return List - 회원 목록
	 */
	public List<Member> getList(Paging paging);
	
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
	 * 
	 * @param req - 요청 정보 객체
	 * @return UserAdmin - 회원 번호를 가진 객체
	 */
	
	public Member getUserno(HttpServletRequest req);
	/**
	 * 회원 탈퇴
	 * @param admin
	 */
	public void delete(Member userAdmin);
}
