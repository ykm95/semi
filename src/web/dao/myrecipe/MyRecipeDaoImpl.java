package web.dao.myrecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Recipe;

public class MyRecipeDaoImpl implements MyRecipeDao {
	
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL 수행 객체
	private ResultSet rs = null; //SQL수행 결과 객체

	@Override
	public int selectCntAll(HttpServletRequest req) {
		
		HttpSession session = req.getSession();

		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT count(*)";
		sql += " FROM recipe";
		sql += " WHERE userno=?";
		
		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
				
			sql += " AND recipename LIKE ?";
		}
		
		sql += " ORDER BY recipeno DESC";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
				
				ps.setString(2, "%"+req.getParameter("search")+"%");
			}
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				cnt = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<Recipe> selectAll(Paging paging, HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql	+=	"    SELECT rownum rnum, B.* FROM (";
		sql	+=	"        SELECT *";
		sql	+=	"        FROM recipe";
		sql	+=	"        WHERE userno=?";
		
		if(paging.getSearch()!=null&&!"".equals(paging.getSearch())) {			
			sql	+=	"        AND recipename LIKE ?";
		}
		
		sql	+=	"        ORDER BY recipeno DESC";
		sql	+=	"    ) B";
		sql	+=	"    ORDER BY rnum";
		sql	+=	" ) BOARD";
		sql	+=	" WHERE rnum BETWEEN ? AND ?";

		List<Recipe> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			if(paging.getSearch()!=null&&!"".equals(paging.getSearch())) {
				
				ps.setInt(1, (int)session.getAttribute("userno"));
				ps.setString(2, "%"+paging.getSearch()+"%");
				ps.setInt(3, paging.getStartNo());
				ps.setInt(4, paging.getEndNo());
				
			} else {
				
				ps.setInt(1, (int)session.getAttribute("userno"));
				ps.setInt(2, paging.getStartNo());
				ps.setInt(3, paging.getEndNo());
				
			}
			
			
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				Recipe recipe = new Recipe();
				
				recipe.setRecipeno(rs.getInt("recipeno"));
				recipe.setUserno(rs.getInt("userno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setRecipeex(rs.getString("recipeex"));
				recipe.setRecipic(rs.getString("recipic"));
				recipe.setCategory(rs.getInt("category"));
				recipe.setOcassion(rs.getInt("ocassion"));
				
				list.add(recipe);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void deleteRecipe(HttpServletRequest req) {

		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE recipe ";
		sql += "WHERE recipeno = ? ";		
		
		try {
			ps = conn.prepareStatement(sql);		
			ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
			
			ps.execute();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Recipe selectRecipeByRecipeno(HttpServletRequest req) {

		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM recipe ";
		sql += "WHERE recipeno = ? ";
		
		Recipe recipe = new Recipe();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				recipe.setRecipeno(rs.getInt("recipeno"));
				recipe.setUserno(rs.getInt("userno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setRecipeex(rs.getString("recipeex"));
				recipe.setRecipic(rs.getString("recipic"));
				recipe.setCategory(rs.getInt("category"));
				recipe.setOcassion(rs.getInt("ocassion"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(recipe);
		
		return recipe;
	}
	
}

