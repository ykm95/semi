package web.service.admin.admin_recipe;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.admin.admin_recipe.RecipeAdminDao;
import web.dao.admin.admin_recipe.RecipeAdminDaoImpl;
import web.dto.Member;
import web.dto.Recipe;

public class RecipeAdminServiceImpl implements RecipeAdminService{

	public RecipeAdminDao recipeAdminDao =new RecipeAdminDaoImpl();

	//	@Override
	//	public List<Recipe> gerList() {
	//		return racipeAdminDao.selectAll();
	//	}

	@Override
	public List<Recipe> getList(Paging paging, HttpServletRequest req) {
		return recipeAdminDao.selectAll(paging, req);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage =Integer.parseInt(param);
		}

		//Board TB와 curPage 값을 이용해 Paging 객체를 생성하고 반환
		int totalcount = recipeAdminDao.selectCntAll(req);

		//Paging 객체 생성
		Paging paging = new Paging(totalcount, curPage);

		//		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
		//			paging.setSearch(req.getParameter("search"));
		//		}

		return paging;
	}

	@Override
	public Recipe getRecipeno(HttpServletRequest req) {

		return recipeAdminDao.selectRecipeByRecipeno(req);
	}

	@Override
	public void deleteRecipe(HttpServletRequest req) {
		recipeAdminDao.deleteRecipe(req);
	}

	@Override
	public Member getUseridno(HttpServletRequest req) {
		return recipeAdminDao.selectUseridByUserno(req);
	}

	@Override
	public Recipe view(Recipe viewRecipe) {
		return recipeAdminDao.selectRecipeByRecipeno(viewRecipe);
	}

	@Override
	public Recipe getUserno(HttpServletRequest req) {
		//요청파라미터 userno를 파싱한다
		String param = req.getParameter("userno");
		int userno = 0;
		if( param!=null && !"".equals(param)) {
			userno = Integer.parseInt(param);
		}

		Recipe recipe =new Recipe();
		recipe.setUserno(userno);

		return recipe;
	}




}
