package web.service.filterdSearch;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.filterdSearch.FilterdSearchDao;
import web.dao.filterdSearch.FilterdSearchDaoImpl;
import web.dto.Recipe;

public class FilterdSearchServiceImpl implements FilterdSearchService{

	private FilterdSearchDao filterdSearchDao = new FilterdSearchDaoImpl();

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		int conditionnum = 0;
		String condition = null;
		
		if(req.getParameter("category") != null) {
			conditionnum = Integer.parseInt(req.getParameter("category"));
			condition = "category";
		} else if(req.getParameter("ocassion") != null) {
			conditionnum = Integer.parseInt(req.getParameter("ocassion"));
			condition = "ocassion";
		}

		int totalCount = filterdSearchDao.selectCntAll(condition, conditionnum, req.getParameter("search"));

		System.out.println(totalCount);
		
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public List<Recipe> getfilteredList(String condition, int conditionnum, Paging paging) {	
		
		return filterdSearchDao.selectByCategory(condition, conditionnum, paging);
	}
}