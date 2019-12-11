package web.controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.recipe.RecipeDao;
import web.dao.recipe.RecipeDaoImpl;
import web.dto.Comment;
import web.dto.Recipe;
import web.dto.RecipeIngredient;
import web.dto.Recommend;
import web.service.comment.CommentService;
import web.service.comment.CommentServiceImpl;
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;


@WebServlet("/recipe/view")
public class RecipeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeService recipeService = new RecipeServiceImpl();
	private CommentService commentService = new CommentServiceImpl();
	private RecipeDao recipeDao = new RecipeDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Recipe recipe = recipeService.getParam(req);
//		System.out.println(recipe);	
		
		try {
			recipe = recipeService.view(recipe, Integer.parseInt(session.getAttribute("userno").toString()));
		}catch (NullPointerException e) {
			recipe = recipeDao.selectByRecipeno(recipe);
		}

		List<RecipeIngredient> main = recipeService.getIngredient(recipe.getRecipeno(), 1);
		List<RecipeIngredient> sub = recipeService.getIngredient(recipe.getRecipeno(), 2);
		List<RecipeIngredient> seas = recipeService.getIngredient(recipe.getRecipeno(), 3);
		
		req.setAttribute("recipeno", recipe.getRecipeno());
		req.setAttribute("userno", recipe.getUserno());
		req.setAttribute("recipename", recipe.getRecipename());
		req.setAttribute("recipeex", recipe.getRecipeex());
		req.setAttribute("category", recipe.getCategory());
		req.setAttribute("ocassion", recipe.getOcassion());
		req.setAttribute("recipic", recipe.getRecipic());
		
		req.setAttribute("recipe", recipe);
		
		List<Comment> commentList = commentService.getCommentList(recipe);
		
//		for(Comment c : commentList)
//			System.out.println(c);
		
//		System.out.println(main);
//		System.out.println(sub);
//		System.out.println(seas);
		
		System.out.println(session.getAttribute("userno"));
		
		Recommend recommend = new Recommend();
		recommend.setRecipeno(recipe.getRecipeno());// 레시피 번호
		
		
		if(req.getSession().getAttribute("userno") != null) {
			recommend.setUserno((int)req.getSession().getAttribute("userno"));
			req.setAttribute("userno", session.getAttribute("userno"));
			
			boolean isRecommend = recipeService.isRecommend(recommend);
			req.setAttribute("isRecommend", isRecommend);
		}
		
		//추천 수 조회
		int cnt = recipeService.getTotalCntRecommend(recommend);
		
		req.setAttribute("cnt", cnt);
		
		req.setAttribute("commentList", commentList);
		req.setAttribute("main", main);
		req.setAttribute("sub", sub);
		req.setAttribute("seas", seas);
		
		
		req.getRequestDispatcher("/WEB-INF/views/recipe/view.jsp")
		.forward(req, resp);
	}
	
}
