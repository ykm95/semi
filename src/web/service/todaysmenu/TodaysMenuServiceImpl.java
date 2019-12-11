package web.service.todaysmenu;

import java.util.ArrayList;
import java.util.List;

import web.dao.todaysmenu.TodaysMenuDao;
import web.dao.todaysmenu.TodaysMenuDaoImpl;
import web.dto.Recipe;

public class TodaysMenuServiceImpl implements TodaysMenuService{

	private TodaysMenuDao todaysMenuDao = new TodaysMenuDaoImpl();
	
	@Override
	public List<Recipe> searchTop() {
		
		List<Recipe> toprecipe = todaysMenuDao.getCount();
		
		List<Recipe> detailrecipe = new ArrayList();
		
		for(int i = 0; i<3; i++) {
			detailrecipe.add(
					todaysMenuDao.selectRecipeByHit(
							toprecipe.get(i).getRecipeno()));
		}
		
		return detailrecipe;
	}
}