package web.dao.todaysmenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.Recipe;

public class TodaysMenuDaoImpl implements TodaysMenuDao {

	private Connection conn = null; // DB연결 객체
	
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL수행 결과 객체
	
	@Override
	public List<Recipe> getCount() {
		
		conn = DBConn.getConnection(); // DB연결
		
		String sql = "";
		sql += "SELECT recipeno,count(*)cnt FROM hit";
		sql += "    GROUP BY recipeno";
		sql	+= "	    ORDER BY cnt DESC, recipeno DESC";
		
		List list = new ArrayList();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Recipe recipe = new Recipe();
				
				recipe.setRecipeno(rs.getInt("recipeno"));
				
				list.add(recipe);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Recipe selectRecipeByHit(int i) {
		
		conn = DBConn.getConnection(); // DB연결
		
		String sql = "";
		sql += "SELECT R.* ,U.nick FROM recipe R, usertb U";
		sql += "	WHERE R.userno = U.userno";
		sql += "	AND recipeno = ?";
		
		Recipe recipe = new Recipe();
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, i);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				recipe.setRecipeno(i);
				recipe.setUserno(rs.getInt("userno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setRecipeex(rs.getString("recipeex"));
				recipe.setCategory(rs.getInt("category"));
				recipe.setOcassion(rs.getInt("ocassion"));
				recipe.setRecipic(rs.getString("recipic"));
				recipe.setNick(rs.getString("nick"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return recipe;
	}
}