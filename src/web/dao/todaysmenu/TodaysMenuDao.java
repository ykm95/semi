package web.dao.todaysmenu;

import java.util.List;

import web.dto.Recipe;

public interface TodaysMenuDao {

	public List<Recipe> getCount();

	public Recipe selectRecipeByHit(int i);

}