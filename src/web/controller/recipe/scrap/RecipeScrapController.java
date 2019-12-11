package web.controller.recipe.scrap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.recipe.RecipeDao;
import web.dao.recipe.RecipeDaoImpl;
import web.dto.Scrap;
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;



@WebServlet("/recipe/scrap")
public class RecipeScrapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RecipeService recipeService = new RecipeServiceImpl();
	RecipeDao recipeDao = new RecipeDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Scrap scrap = new Scrap();
		
		scrap.setRecipeno(Integer.parseInt(req.getParameter("recipeno")));
		scrap.setUserno((int)session.getAttribute("userno"));
		
		recipeService.scrap(req);
		
		boolean result = recipeDao.checkScrap(req);
		
		resp.getWriter().println("{ \"result\" : "+result+"}");
		
	}
	
}
