package web.dao.admin.admin_recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Member;
import web.dto.Recipe;

public interface RecipeAdminDao {

	/**
	 * 페이징 대상 게시글 목록 조회
	 * @param paging-페이징 조회
	 * @return List -조회된 회원 게시물 목록
	 */
	public List<Recipe> selectAll(Paging paging, HttpServletRequest req);
	/**
	 * 총 레시피 수 조회
	 * @return
	 */
	public int selectCntAll(HttpServletRequest req);
	/**
	 * 레시피 번호를 통해 레시피 정보 불러오기
	 * @param req
	 * @return
	 */
	
	public Recipe selectRecipeByRecipeno(HttpServletRequest req);
	/**
	 * 레시피 삭제
	 * @param req
	 */
	public void deleteRecipe(HttpServletRequest req);
	/**
	 * userno으로 userid, userno 조회
	 * @param req
	 * @return
	 */
	public Member selectUseridByUserno(HttpServletRequest req);
	/**
	 * 게시글 상세보기
	 * @param viewRecipe
	 * @return
	 */
	public Recipe selectRecipeByRecipeno(Recipe viewRecipe); 

}
