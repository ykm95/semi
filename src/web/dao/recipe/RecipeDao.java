package web.dao.recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Recipe;
import web.dto.RecipeIngredient;
import web.dto.RecipeProcess;

public interface RecipeDao {

	public Recipe selectRecipeno();

	public void insert(Recipe recipe);

	public void insert(RecipeProcess recipeProcess);

	public Recipe selectByRecipeno(Recipe recipe);

	public int selectCntAll(String search);

	public List<Recipe> selectAll(Paging paging);

	public List<RecipeProcess> selectProcess(int i);

	public String viewCheck(Recipe recipe, int i);

	public boolean checkScrap(HttpServletRequest req);

	public void scrapRecipe(HttpServletRequest req);

	public void deleteScrap(HttpServletRequest req);

	public void insertHit(Recipe recipe, int i);

	public void insert(RecipeIngredient ingre);

	public List<RecipeIngredient> selectMainIngredient(int recipeno);

	public List<RecipeIngredient> selectSubIngredient(int recipeno);

	public List<RecipeIngredient> selectSeasoning(int recipeno);

	public int selectCount(String search);

	public List<Recipe> selectingreno(String search, Paging ingpaging);

}