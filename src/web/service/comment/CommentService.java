package web.service.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Comment;
import web.dto.Recipe;

public interface CommentService {

	public Comment getComment(HttpServletRequest req);	//전달 파라미터 꺼내기

	public void insertComment(Comment comment);
	
	public List getCommentList(Recipe recipe);

	public boolean deleteComment(Comment comment);
	

}
