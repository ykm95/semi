package web.controller.recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Recipe;
import web.service.filterdSearch.FilterdSearchService;
import web.service.filterdSearch.FilterdSearchServiceImpl;

@WebServlet("/recipe/filter")
public class RecipeFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilterdSearchService filterdSearchService
	= new FilterdSearchServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Recipe> list = new ArrayList<Recipe>();
		
		Paging paging = filterdSearchService.getPaging(req);
		
		paging.setSearch(req.getParameter("search"));
		
		req.setAttribute("paging",  paging);
		
		String condition = null;
		int conditionnum = 0;
		
		if(req.getParameter("category") != null) {
			condition = "category";
			conditionnum = Integer.parseInt(req.getParameter("category"));
		} else if(req.getParameter("ocassion") != null) {
			condition = "ocassion";
			conditionnum = Integer.parseInt(req.getParameter("ocassion"));
		}
		
		list = filterdSearchService.getfilteredList(condition, conditionnum, paging);
		
		req.setAttribute("list", list);
		req.setAttribute("condition", condition);
		req.setAttribute("conditionnum", conditionnum);
		
		req.getRequestDispatcher("/WEB-INF/views/recipe/filteredlist.jsp")
		.forward(req, resp);
		
	}
	
}