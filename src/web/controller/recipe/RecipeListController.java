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
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;
import web.service.todaysmenu.TodaysMenuService;
import web.service.todaysmenu.TodaysMenuServiceImpl;

@WebServlet("/recipe/list")
public class RecipeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeService recipeService = new RecipeServiceImpl();
	private TodaysMenuService todaysMenuService = new TodaysMenuServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println(req.getParameter("search"));
		
		Paging titlepaging = recipeService.getPaging(req);

		req.setAttribute("titlepaging", titlepaging);

		List<Recipe> recipe = recipeService.getList(titlepaging);

		req.setAttribute("recipe", recipe);

		// ---------------------------------------------------

		List<Recipe> recipenoList = new ArrayList<>();

		Paging ingpaging = recipeService.getCount(req);

		req.setAttribute("ingpaging", ingpaging);

		recipenoList = recipeService.getrecipeno(req, ingpaging);

		req.setAttribute("recipenoList", recipenoList);

		// ----------------------------------------------------------

		List<Recipe> todaysmenu = todaysMenuService.searchTop();
		
		req.setAttribute("todaysmenu", todaysmenu);
		
		// ------------------------------------------------------
		
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/recipe/list.jsp").forward(req, resp);

	}
}