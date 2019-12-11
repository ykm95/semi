package web.controller.recipe.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.dto.Recipe;
import web.service.comment.CommentService;
import web.service.comment.CommentServiceImpl;

/**
 * Servlet implementation class CommentInserController
 */
@WebServlet("/comment/insert")
public class CommentInserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService commentService = new CommentServiceImpl();
	private Recipe recipe = new Recipe();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Comment comment = commentService.getComment(req);
		
		commentService.insertComment(comment);
		
//		comment = recipeService.getCommentList(recipe);
		
		resp.sendRedirect("/recipe/view?recipeno="+comment.getRecipeno()+"#commentbody");
		
	}
	
}
