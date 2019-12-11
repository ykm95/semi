package web.service.admin.admin_recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Member;
import web.dto.Recipe;

public interface RecipeAdminService {
	/**
	 * 회원이 작성한 게시물 목록
	 * @return
	 */
//	public List<Recipe> gerList();
	
	
	/**
	 * 페이징 정보를 활용해 보여질 게시물 목록만 조회
	 * @param paging
	 * @return
	 */
	public List<Recipe> getList(Paging paging, HttpServletRequest req);
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */	
	public Paging getPaging(HttpServletRequest req);
	/**
	 * 요청 파라미터 레시피번호 파싱
	 * 
	 * @param req - 요청 정보 객체
	 * @return 
	 */
	public Recipe getRecipeno(HttpServletRequest req);
	/**
	 * 게시글 삭제
	 * @param req
	 */
	public void deleteRecipe(HttpServletRequest req);
	/**
	 * usertb에서 userid 가져오기
	 * @param req
	 */
	public Member getUseridno(HttpServletRequest req);
	/**
	 * 게시글 상세보기
	 * @param viewRecipe
	 * @return
	 */
	public Recipe view(Recipe viewRecipe);
	/**
	 * 회원번호 파싱
	 * @param req
	 * @return
	 */
	public Recipe getUserno(HttpServletRequest req);
	

}
