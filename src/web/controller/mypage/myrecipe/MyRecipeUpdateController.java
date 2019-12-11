package web.controller.mypage.myrecipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Ingredient;
import web.dto.Recipe;
import web.dto.RecipeIngredient;
import web.service.mypage.myrecipe.MyRecipeService;
import web.service.mypage.myrecipe.MyRecipeServiceImpl;

@WebServlet("/mypage/myrecipe/update")
public class MyRecipeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MyRecipeService myRecipeService = new MyRecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Recipe recipe = myRecipeService.getRecipe(req);
		
		req.setAttribute("recipe", recipe);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/myrecipe/update.jsp")
		.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.sendRedirect("/mypage/myrecipe?userno="+session.getAttribute("userno"));
	}
}
