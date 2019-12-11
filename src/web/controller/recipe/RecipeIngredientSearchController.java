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

@WebServlet("/search/ingredient")
public class RecipeIngredientSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RecipeService recipeService = new RecipeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = recipeService.getMoreIngrePaging(req);

		System.out.println(paging);

		// Paging 객체를 MODEL 값으로 지정
		req.setAttribute("paging", paging);

		List<Recipe> recipe = recipeService.getList(paging);
		
		recipe = recipeService.getrecipeno(req, paging);

		req.setAttribute("recipe", recipe);

		req.setCharacterEncoding("UTF-8");

		req.getRequestDispatcher("/WEB-INF/views/recipe/ingredientsearchlist.jsp").forward(req, resp);

	}
}