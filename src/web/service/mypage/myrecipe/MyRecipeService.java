package web.service.mypage.myrecipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Recipe;
import web.dto.RecipeIngredient;

public interface MyRecipeService {

	
	/**
	 * 페이지를 구성한다
	 * @param req - 현재 페이지
	 * @return
	 */
	Paging getPaging(HttpServletRequest req);

	
	/**
	 * 작성한 레시피들을 불러온다
	 * @param paging - 페이지 구성 객체
	 * @return 내가 작성한 레시피 리스트
	 */
	List<Recipe> getList(Paging paging, HttpServletRequest req);

	/**
	 * 선택한 레시피를 삭제한다
	 * @param req - 삭제할 레시피 번호
	 */
	void deleteMyRecipe(HttpServletRequest req);


	/**
	 * 레시피 번호를 통해서 레시피 정보를 받는다
	 * @param req
	 * @return
	 */
	Recipe getRecipe(HttpServletRequest req);


}
