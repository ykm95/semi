package web.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.comment.CommentDao;
import web.dbutil.DBConn;
import web.dto.Comment;
import web.dto.Recipe;

public class CommentDaoImpl implements CommentDao{
	// DB 연결 객체
	private Connection conn = null;

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public void insertComment(Comment comment) {
		conn = DBConn.getConnection();

		String sql
		= "INSERT INTO commenttb ("
				+ "		commentno,"
				+ "		recipeno,"
				+ "		userno,"
				+ "		comcontent )"
				+ "	VALUES ("
				+ "		comment_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		? )";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, comment.getRecipeno());
			ps.setInt(2, comment.getUserno());
			ps.setString(3, comment.getComcontent());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public List selectComment(Recipe recipe) {
		conn = DBConn.getConnection();

		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, B.* FROM ("
				+ "	SELECT"
				+ "		U.userid,"
				+ "		commentno,"
				+ "		recipeno,"
				+ "		U.userno,"
				+ "		comcontent"				
				+ "	FROM commenttb C, usertb U"
				+ "	WHERE U.userno = C.userno"
				+ "	AND recipeno = ?"
				+ "	ORDER BY commentno "
				+ "	) B"
				+ ") R ORDER BY rnum DESC";
		
		List commentList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, recipe.getRecipeno() );

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				Comment comment = new Comment();

				comment.setRownum(rs.getInt("rnum"));
				comment.setCommentno(rs.getInt("commentno"));
				comment.setRecipeno(rs.getInt("recipeno"));
				comment.setUserno(rs.getInt("userno"));
				comment.setComcontent(rs.getString("comcontent"));
				comment.setUserid(rs.getString("userid"));

				commentList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return commentList;
	}
	
	@Override
	public void deleteComment(Comment comment) {
		conn = DBConn.getConnection();
		String sql
		= "DELETE commenttb"
				+ "	WHERE commentno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getCommentno());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public int countComment(Comment comment) {

		conn = DBConn.getConnection();

		String sql = "SELECT COUNT(*) FROM commenttb WHERE commentno=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getCommentno());
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
}