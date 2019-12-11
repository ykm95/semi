package web.service.recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Recipe;
import web.dto.RecipeIngredient;
import web.dto.RecipeProcess;
import web.dto.Recommend;

public interface RecipeService {
	
	public void write(HttpServletRequest req, HttpServletResponse resp);
	
	public Recipe setRecipeno();

	public void write(Recipe recipe);

	public void write(List<RecipeProcess> recipeProcessList);

	public Paging getPaging(HttpServletRequest req);

	public List<Recipe> getList(Paging paging);

	public Recipe getParam(HttpServletRequest req);

	public Recipe view(Recipe recipe, int i);

	public List<RecipeProcess> getProcess(HttpServletRequest req);

	public void scrap(HttpServletRequest req);

	public List<RecipeIngredient> getIngredient(int recipeno, int category);

	public Recommend getRecommend(HttpServletRequest req);

	public boolean recommend(Recommend recommendParam);

	public int getTotalCntRecommend(Recommend recommendParam);
	
	public boolean isRecommend(Recommend recommend);

	public Paging getCount(HttpServletRequest req);

	public List<Recipe> getrecipeno(HttpServletRequest req, Paging ingpaging);

	public Paging getMoreNamePaging(HttpServletRequest req);

	public Paging getMoreIngrePaging(HttpServletRequest req);

}