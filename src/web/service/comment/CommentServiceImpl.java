package web.service.comment;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.comment.CommentDao;
import web.dao.comment.CommentDaoImpl;
import web.dto.Comment;
import web.dto.Recipe;

public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao = new CommentDaoImpl();


	@Override
	public Comment getComment(HttpServletRequest req) {

		//		String commentno = (String) req.getParameter("commentno");
		String recipeno = (String) req.getParameter("recipeno");
		String userno = (String) req.getParameter("userno");
		String comcontent = (String) req.getParameter("comcontent");

		Comment comment = new Comment();
		//		comment.setCommentno( Integer.parseInt(commentno) );
		comment.setRecipeno( Integer.parseInt(recipeno) );
		comment.setUserno( Integer.parseInt(userno) );
		comment.setComcontent(comcontent);
		
		return comment;
	}


	@Override
	public void insertComment(Comment comment) {
		commentDao.insertComment(comment);
	}


	@Override
	public List getCommentList(Recipe recipe) {
		// TODO Auto-generated method stub
		return commentDao.selectComment(recipe);
	}


	@Override
	public boolean deleteComment(Comment comment) {
		commentDao.deleteComment(comment); 

		if( commentDao.countComment(comment) > 0 ) {
			return false;
		} else {
			return true;
		}
	}
}