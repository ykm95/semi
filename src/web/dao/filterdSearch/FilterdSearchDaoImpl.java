package web.dao.filterdSearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Recipe;

public class FilterdSearchDaoImpl implements FilterdSearchDao {

	private Connection conn = null; // DB연결 객체

	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL수행 결과 객체
	
	@Override
	public List<Recipe> selectByCategory(String condition, int conditionnum, Paging paging) {
		
		conn = DBConn.getConnection(); // DB연결

		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "           recipeno, userno, recipename, recipic,";
		sql += "           (";
		sql += "           	SELECT nick FROM usertb";
		sql += "           	WHERE recipe.userno = usertb.userno";
		sql += "           )nick,";
		sql += "           (";
		sql += "			SELECT count(*)cnt FROM hit";
		sql += "			WHERE recipe.recipeno = hit.recipeno";
		sql += "			GROUP BY recipeno";
		sql += "           ) hit";
		sql += "       FROM recipe";
		sql += "       WHERE "+condition+" = ?";
		sql += "       AND recipename LIKE '%'||?||'%'";
		sql += "       ORDER BY recipeno DESC";
		sql += "    )B";
		sql += "    ORDER BY rnum";
		sql += ") recipe";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<Recipe> getList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, conditionnum);
			ps.setString(2, paging.getSearch());
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeno(rs.getInt("recipeno"));
				recipe.setUserno(rs.getInt("userno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setRecipic(rs.getString("recipic"));
				recipe.setHit(rs.getInt("hit"));
				recipe.setNick(rs.getString("nick"));
				getList.add(recipe);
				
				System.out.println(recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return getList;
	}
	
	@Override
	public int selectCntAll(String condition, int conditionnum, String search) {
		
		conn = DBConn.getConnection(); // DB연결

		String sql = "";
		sql += "SELECT count(*) FROM recipe";
		sql += "	WHERE "+condition+" = ?";
		sql += "	AND recipename LIKE '%'||?||'%'";

		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, conditionnum);
			ps.setString(2, search);

			rs = ps.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}
}