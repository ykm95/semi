package web.controller.admin.admin_recipe;

import java.io.IOException;
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

/**
 * Servlet implementation class RecipeAdminListController
 */
@WebServlet("/admin/recipeadmin/list")
public class RecipeAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = recipeService.getPaging(req);
		
		paging.setSearch(req.getParameter("search"));
		
		req.setAttribute("paging",  paging);
		
		List<Recipe> recipe = recipeService.getList(paging);
		
		req.setAttribute("list", recipe);		

		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/recipe/recipe_list.jsp").forward(req,  resp);
//		req.getRequestDispatcher("/WEB-INF/views/recipe/list.jsp").forward(req,  resp);

	}

}
