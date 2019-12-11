package web.dao.comment;

import java.util.List;

import web.dto.Comment;
import web.dto.Recipe;

public interface CommentDao {

	public void insertComment(Comment comment);

	public List selectComment(Recipe recipe);

	public void deleteComment(Comment comment);

	public int countComment(Comment comment);

}
