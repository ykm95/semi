package web.controller.recipe.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Comment;
import web.service.comment.CommentService;
import web.service.comment.CommentServiceImpl;

/**
 * Servlet implementation class CommentDelController
 */
@WebServlet("/comment/delete")
public class CommentDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService commentService = new CommentServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Comment comment = new Comment();
		
		String commentno = (String) req.getParameter("commentno");
		
		comment.setCommentno( Integer.parseInt(commentno));
		
		boolean success = commentService.deleteComment(comment);
		resp.getWriter().append("{\"success\":"+success+"}");
	}
	
	

}
