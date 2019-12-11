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
 * Servlet implementation class RecipeAdminDeleteController
 */
@WebServlet("/adminrecipe/delete")
public class RecipeAdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeAdminService recipeAdminService = new RecipeAdminServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Recipe recipe = recipeAdminService.getRecipeno(req);
		
		recipeAdminService.deleteRecipe(req);
		
		resp.sendRedirect("/adminrecipe/userRecipelist?userno="+recipe.getUserno());
	
	}

}
