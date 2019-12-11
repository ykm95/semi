package web.controller.admin.admin_recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Member;
import web.dto.Recipe;
import web.service.admin.admin_recipe.RecipeAdminService;
import web.service.admin.admin_recipe.RecipeAdminServiceImpl;

/**
 * Servlet implementation class RecipeAdminUserListController
 */
@WebServlet("/adminrecipe/userRecipelist")
public class RecipeAdminUserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeAdminService recipeAdminService = new RecipeAdminServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	if(req.getSession().getAttribute("adminlogin")!=null) {
		Paging paging = recipeAdminService.getPaging(req);
	
		req.setAttribute("paging", paging);
		
		//게시물 목록 조회
		List<Recipe> list = recipeAdminService.getList(paging, req);
	
		Member member = recipeAdminService.getUseridno(req);
		
//		String userid = 
	//	list = recipeAdminService.getList(paging, req);
		
		req.setAttribute("list", list);
		req.setAttribute("member", member);
		System.out.println(member);
		
//		System.out.println(list);
		req.getRequestDispatcher("/WEB-INF/views/admin/recipe/recipe_userlist.jsp")
		.forward(req, resp);
		
	} else {
		resp.sendRedirect("/admin/admain");
	}
		
	
	}
}







