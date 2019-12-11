package web.service.filterdSearch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Recipe;

public interface FilterdSearchService {

	public Paging getPaging(HttpServletRequest req);

	public List<Recipe> getfilteredList(String condition, int search, Paging paging);
	
}
