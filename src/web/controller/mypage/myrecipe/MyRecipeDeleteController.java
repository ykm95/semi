package web.controller.mypage.myrecipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.myrecipe.MyRecipeService;
import web.service.mypage.myrecipe.MyRecipeServiceImpl;

@WebServlet("/mypage/myrecipe/delete")
public class MyRecipeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MyRecipeService myRecipeService = new MyRecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		myRecipeService.deleteMyRecipe(req);
		
		resp.sendRedirect(req.getHeader("referer"));
		
	}
}
