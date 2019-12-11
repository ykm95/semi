package web.dao.mypage.myrecipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Recipe;
import web.dto.RecipeIngredient;

public interface MyRecipeDao {
	
	/**
	 * 선택한 유저의 모든 레시피의 수를 조회한다
	 * @param req - 유저정보가 담긴 객체
	 * @return 레시피의 수
	 */
	public int selectCntAll(HttpServletRequest req);

	/**
	 * 
	 * @param paging - 페이징 객체
	 * @param req - 세션에 저장된 유저 정보
	 * @return 해당 유저가 작성한 모든 레시피
	 */
	public List<Recipe> selectAll(Paging paging, HttpServletRequest req);

	/**
	 * 선택한 레시피를 삭제한다
	 * @param req - 삭제할 레시피 정보
	 */
	public void deleteRecipe(HttpServletRequest req);

	/**
	 * 레시피 번호를 통해 레시피의 모든 정보를 불러온다
	 * @param req - 레시피 번호
	 * @return 해당 레시피의 정보
	 */
	public Recipe selectRecipeByRecipeno(HttpServletRequest req);

	
}
