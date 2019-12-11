package web.dao.filterdSearch;

import java.util.List;

import util.Paging;
import web.dto.Recipe;

public interface FilterdSearchDao {

	public List<Recipe> selectByCategory(String condition, int search, Paging paging);

	public int selectCntAll(String condition, int search, String string);

}
