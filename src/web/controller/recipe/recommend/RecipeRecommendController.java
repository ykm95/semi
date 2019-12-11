package web.controller.recipe.recommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Recommend;
import web.service.recipe.RecipeService;
import web.service.recipe.RecipeServiceImpl;

/**
 * Servlet implementation class RecipeRecommendController
 */
@WebServlet("/recipe/recommend")
public class RecipeRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 추천 정보 얻기 // userno가 추천한 recipeno 가져옴
		Recommend recommendParam = recipeService.getRecommend(req);
//		System.out.println(recommendParam);
		
		// 추천정보 토글
		boolean result = recipeService.recommend(recommendParam);		
		
		//추천 수 조회
		int cnt = recipeService.getTotalCntRecommend(recommendParam);
		
		//결과 JSON응답
		resp.getWriter().println("{\"result\": "+result+", \"cnt\": " +cnt+"}");
		
		
		
	}
	
	
}
