package web.controller.admin.admin_recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Recipe;
import web.service.admin.admin_recipe.RecipeAdminService;
import web.service.admin.admin_recipe.RecipeAdminServiceImpl;

/**
 * Servlet implementation class RecipeAdminViewController
 */
@WebServlet("/adminrecipe/view")
public class RecipeAdminViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeAdminService recipeAdminService = new RecipeAdminServiceImpl();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//게시물번호 파싱
		Recipe viewRecipe = recipeAdminService.getRecipeno(req);
		
		viewRecipe = recipeAdminService.view(viewRecipe);
//		System.out.println(viewRecipe);
		
		req.setAttribute("viewRecipe", viewRecipe);
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/recipe/recipe_view.jsp")
		.forward(req, resp);
	}
}
