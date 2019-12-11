package web.controller.recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dto.Recipe;
import web.dto.RecipeProcess;
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;

@WebServlet("/recipe/reg")
public class RecipeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/main");
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/recipe/registration.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		recipeService.write(req, resp);
		
		resp.sendRedirect("/recipe/list");
	}
	
}