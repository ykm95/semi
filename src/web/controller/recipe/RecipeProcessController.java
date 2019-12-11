package web.controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.RecipeProcess;
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;

/**
 * Servlet implementation class RecipeProcessController
 */
@WebServlet("/recipe/process")
public class RecipeProcessController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("recipeno"));
		
		List<RecipeProcess> processList = recipeService.getProcess(req);
		
		req.setAttribute("processList", processList);
		
		req.getRequestDispatcher("/WEB-INF/views/recipe/recipeProcess.jsp")
			.forward(req, resp);;
		
	}
}