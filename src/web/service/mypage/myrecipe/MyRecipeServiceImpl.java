package web.service.mypage.myrecipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import util.Paging;
import web.dao.mypage.myrecipe.MyRecipeDao;
import web.dao.mypage.myrecipe.MyRecipeDaoImpl;
import web.dto.Recipe;
import web.dto.RecipeIngredient;

public class MyRecipeServiceImpl implements MyRecipeService {

	MyRecipeDao myRecipeDao = new MyRecipeDaoImpl();
	
//	@Override
//	public Recipe getParam(HttpServletRequest req) {
//		
//		Recipe recipe = new Recipe();
//		
//		recipe.setUserno(Integer.parseInt(req.getParameter("userno")));
//		
//		return recipe;
//	}

	@Override
	public Paging getPaging(HttpServletRequest req) {

		//요청파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = myRecipeDao.selectCntAll(req);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
			paging.setSearch(req.getParameter("search"));
		}
		
		return paging;
		
	}

	@Override
	public List<Recipe> getList(Paging paging, HttpServletRequest req) {
				
		return myRecipeDao.selectAll(paging, req);
	}

	@Override
	public void deleteMyRecipe(HttpServletRequest req) {
		
		myRecipeDao.deleteRecipe(req);
		
	}

	@Override
	public Recipe getRecipe(HttpServletRequest req) {
		
		return myRecipeDao.selectRecipeByRecipeno(req);
	}


}
