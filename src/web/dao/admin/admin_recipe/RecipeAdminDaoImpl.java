package web.dao.admin.admin_recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Member;
import web.dto.Recipe;


public class RecipeAdminDaoImpl implements RecipeAdminDao {


	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	//	@Override
	//	public List<Recipe> selectAll() {
	//
	//		conn = DBConn.getConnection();
	//
	//		//쿼리 수행
	//		String sql="";
	//		sql+="SELECT recipeno, recipename, category, ocassion";
	//		sql+=" (SELECT userid FROM usertb WHERE userno=question.userno) userid";
	//		sql+=" FROM recipe";
	//		sql+=" ORDER BY recipeno DESC";
	//
	//		List<Recipe> userRlist = new ArrayList<>();
	//
	//		try {
	//			ps=conn.prepareStatement(sql);
	//			rs=ps.executeQuery();
	//
	//			while(rs.next()) {
	//				Recipe recipe= new Recipe();
	//
	//				recipe.setRecipeno(rs.getInt("recipeno"));
	//				recipe.setRecipename(rs.getString("recipename"));
	//				recipe.setCategory(rs.getInt("category"));
	//				recipe.setOcassion(rs.getInt("occassion"));
	//				recipe.setUserid(rs.getString("userid"));
	//
	//				userRlist.add(recipe);
	//			}
	//
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally {
	//			try {
	//				if(rs!=null)	rs.close();
	//				if(ps!=null)	ps.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//
	//		return userRlist;
	//	}
	@Override
	public List<Recipe> selectAll(Paging paging, HttpServletRequest req) {
		conn = DBConn.getConnection(); 


		//쿼리 수행
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += " 			userno, recipeno, recipename, category, ocassion, recipic,";
		sql	+= " 	(SELECT userid FROM usertb WHERE userno=recipe.userno) userid";
		sql += "        FROM recipe WHERE userno=?";
		
//		if(paging.getSearch()!=null&&!"".equals(paging.getSearch())) {			
//			sql	+=	"        AND recipename LIKE ?";
//		}
		sql += "        ORDER BY recipeno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) recipe";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<Recipe> userRlist = new ArrayList<>();

		try {
			ps=conn.prepareStatement(sql);
//
//			if(paging.getSearch()!=null&&!"".equals(paging.getSearch())) {
//			
			ps.setInt(1,  Integer.parseInt(req.getParameter("userno") ));
//			ps.setString(2, "%"+paging.getSearch()+"%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			rs=ps.executeQuery();
//
//			}else{
//				ps.setInt(1, Integer.parseInt(req.getParameter("userno") ));
	//			ps.setInt(1, paging.getStartNo());
		//		ps.setInt(2, paging.getEndNo());
//			}

			while(rs.next()) {
				Recipe recipe = new Recipe();

				recipe.setUserno(rs.getInt("userno"));
				recipe.setRecipeno(rs.getInt("recipeno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setCategory(rs.getInt("category"));
				recipe.setOcassion(rs.getInt("ocassion"));
				recipe.setUserid(rs.getString("userid"));
				recipe.setRecipic(rs.getString("recipic"));

				userRlist.add(recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(ps!=null)	ps.close();
				if(ps!=null)	rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//		System.out.println(userRlist);
		return userRlist;
	}
	
	@Override
	public int selectCntAll(HttpServletRequest req) {
		conn=DBConn.getConnection();

		//쿼리 수행
		String sql="";
		sql+="SELECT count(*) FROM recipe";
		sql+=" WHERE userno=?";
//		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
//
//			sql += " AND recipename LIKE ?";
//		}
		sql += " ORDER BY recipeno DESC";

		int cnt=0;

		try {
			ps= conn.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(req.getParameter("userno") ));
//			if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
//
//				ps.setString(2, "%"+req.getParameter("search")+"%");
//			}

			rs= ps.executeQuery();

			if(rs.next()) {
				cnt =rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}
	@Override
	public Recipe selectRecipeByRecipeno(HttpServletRequest req) {

		conn = DBConn.getConnection();

		String sql="";
		sql+="SELECT * FROM recipe WHERE recipeno = ?";

		Recipe recipe = new Recipe();

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));

			rs= ps.executeQuery();
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
		} finally {

			try {
				if(ps!=null)	ps.close();
				if(ps!=null)	rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return recipe;
	}
	@Override
	public void deleteRecipe(HttpServletRequest req) {

	    conn = DBConn.getConnection();
	      
	      String sql1 = "";
	      sql1 += "DELETE recipe_ingredient ";
	      sql1 += "WHERE recipeno=? ";

	      String sql2 = "";
	      sql2 += "DELETE processtb ";
	      sql2 += "WHERE recipeno=? ";

	      String sql3 = "";
	      sql3 += "DELETE scrap ";
	      sql3 += "WHERE recipeno=? ";

	      String sql4 = "";
	      sql4 += "DELETE report ";
	      sql4 += "WHERE recipeno=? ";

	      String sql5 = "";
	      sql5 += "DELETE commenttb ";
	      sql5 += "WHERE recipeno=? ";

	      String sql6 = "";
	      sql6 += "DELETE hit ";
	      sql6 += "WHERE recipeno=? ";

	      String sql7 = "";
	      sql7 += "DELETE recipe ";
	      sql7 += "WHERE recipeno=? ";      
	      
	      try {
	         ps = conn.prepareStatement(sql1);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql2);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql3);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql4);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql5);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql6);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	         
	         ps = conn.prepareStatement(sql7);
	         ps.setInt(1, Integer.parseInt(req.getParameter("recipeno")));
	         ps.execute();
	   
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

	}

	@Override
	public Recipe selectRecipeByRecipeno(Recipe viewRecipe) {
		
		conn = DBConn.getConnection();
		
		String sql="";
		sql+="SELECT recipeno, userno, recipename, recipeex, recipic, category, ocassion,";
		sql+="(SELECT userid FROM usertb WHERE userno= recipe.userno) userid";
		sql+=" FROM recipe WHERE recipeno = ?";
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, viewRecipe.getRecipeno());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				viewRecipe = new Recipe();
				
				viewRecipe.setRecipeno(rs.getInt("recipeno"));
				viewRecipe.setUserno(rs.getInt("userno"));
				viewRecipe.setRecipename(rs.getString("recipename"));
				viewRecipe.setRecipeex(rs.getString("recipeex"));
				viewRecipe.setRecipic(rs.getString("recipic"));
				viewRecipe.setCategory(rs.getInt("category"));
				viewRecipe.setOcassion(rs.getInt("ocassion"));
				viewRecipe.setUserid(rs.getString("userid"));
				
			}
			System.out.println(viewRecipe);
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
		
		return viewRecipe;
	}

	@Override
	public Member selectUseridByUserno(HttpServletRequest req) {
	conn = DBConn.getConnection();
		
		String sql ="";
		sql +="SELECT userid, userno, userpic, usercom FROM usertb WHERE userno=?";
		
		Member member = new Member();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("userno")));
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			
				member.setUserid(rs.getString("userid"));
				member.setUserno(rs.getInt("userno"));
				member.setUserpic(rs.getString("userpic"));
				member.setUsercom(rs.getString("usercom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(ps!=null)	ps.close();
				if(ps!=null)	rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}





}
