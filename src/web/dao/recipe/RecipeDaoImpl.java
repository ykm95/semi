package web.dao.recipe;

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
import web.dto.RecipeIngredient;
import web.dto.RecipeProcess;

public class RecipeDaoImpl implements RecipeDao {

	private Connection conn = null; // DB연결 객체

	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL수행 결과 객체

	@Override
	public Recipe selectRecipeno() {

		conn = DBConn.getConnection(); // DB연결

		String sql = "";
		sql += "SELECT recipe_seq.nextVal FROM dual";

		Recipe recipe = new Recipe();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			rs.next();
			recipe.setRecipeno(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recipe;
	}

	@Override
	public void insert(Recipe recipe) {
		conn = DBConn.getConnection(); // DB연결

		String sql = "";
		sql += "INSERT INTO recipe";
		sql += "	VALUES (?,?,?,?,?,?,?)";

		System.out.println(recipe);

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, recipe.getRecipeno());
			ps.setInt(2, recipe.getUserno());
			ps.setString(3, recipe.getRecipename());
			ps.setString(4, recipe.getRecipeex());
			ps.setInt(5, recipe.getCategory());
			ps.setInt(6, recipe.getOcassion());
			ps.setString(7, recipe.getRecipic());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(RecipeProcess recipeProcess) {
		conn = DBConn.getConnection(); // DB연결

		String sql = "";
		sql += "INSERT INTO processtb";
		sql += "	VALUES (process_seq.nextval,?,?,?)";

		System.out.println(recipeProcess);

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, recipeProcess.getRecipeno());
			ps.setString(2, recipeProcess.getProcessex());
			ps.setString(3, recipeProcess.getProcesspic());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public Recipe selectByRecipeno(Recipe recipe) {
		conn = DBConn.getConnection(); // DB 연결

		String sql = "SELECT * FROM recipe WHERE recipeno=?";
		Recipe res = new Recipe();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recipe.getRecipeno());
			rs = ps.executeQuery();

			while (rs.next()) {
				res.setRecipeno(rs.getInt("recipeno"));
				res.setUserno(rs.getInt("userno"));
				res.setRecipename(rs.getString("recipename"));
				res.setRecipeex(rs.getString("recipeex"));
				res.setRecipic(rs.getString("recipic"));
				res.setCategory(rs.getInt("category"));
				res.setOcassion(rs.getInt("ocassion"));
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
		return res;
	}

	@Override
	public int selectCntAll(String search) {
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM recipe";
		sql += " WHERE recipename LIKE '%'||?||'%'";

		// 최종 결과 변수
		int cnt = 0;

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, search);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
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

		// 최종 결과 반환
		return cnt;
	}

	@Override
	public List<Recipe> selectAll(Paging paging) {
		conn = DBConn.getConnection();

		// 수행할 DB쿼리
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
		sql += "       WHERE recipename LIKE '%'||?||'%'";
		sql += "       ORDER BY recipeno DESC";
		sql += "    )B";
		sql += "    ORDER BY rnum";
		sql += ") recipe";
		sql += " WHERE rnum BETWEEN ? AND ?";

		// 결과 저장 리스트
		List<Recipe> getList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

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
	public List<RecipeProcess> selectProcess(int i) {
		
		conn = DBConn.getConnection();

		// 수행할 DB쿼리
		String sql = "";
		sql += "SELECT * FROM processtb";
		sql += "	WHERE recipeno=?";
		sql += "	ORDER BY processno";
		
		List<RecipeProcess> list = new ArrayList<RecipeProcess>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, i);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				RecipeProcess process = new RecipeProcess();
				process.setProcessno(rs.getInt("processno"));
				process.setRecipeno(rs.getInt("recipeno"));
				process.setProcessex(rs.getString("processex"));
				process.setProcesspic(rs.getString("processpic"));
				
				list.add(process);
			}
			
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
		return list;
	}

	@Override
	public String viewCheck(Recipe recipe, int i) {
		conn = DBConn.getConnection();

		String sql = "";
		sql += "SELECT TO_CHAR(viewdate, 'YYYY/MM/DD') FROM hit";
		sql += "	WHERE recipeno=?";
		sql += "	AND userno=?";
		sql += "	ORDER BY viewdate";
		
		String date = "";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipe.getRecipeno());
			ps.setInt(2, i);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				date = rs.getString(1);
				System.out.println(date);
			}

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

		return date;
	}

	@Override
	public boolean checkScrap(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT count(*) FROM scrap ";
		sql += "WHERE userno = ? AND recipeno = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			ps.setInt(2, Integer.parseInt(req.getParameter("recipeno")));

			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				cnt = rs.getInt(1);
			}
			
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
		
		if(cnt==0) {
			
			return false;
			
		} else {
			
			return true;
		}
	}

	@Override
	public void scrapRecipe(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "INSERT INTO scrap(scrapno, userno, recipeno) ";
		sql += "VALUES(scrap_seq.nextVal, ?, ?) ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			ps.setInt(2, Integer.parseInt(req.getParameter("recipeno")));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteScrap(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE scrap ";
		sql += "WHERE userno=? AND recipeno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			ps.setInt(2, Integer.parseInt(req.getParameter("recipeno")));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertHit(Recipe recipe, int i) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "INSERT INTO hit(recipeno, userno)";
		sql += "	VALUES (?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipe.getRecipeno());
			ps.setInt(2, i);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert(RecipeIngredient ingre) {
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "INSERT INTO recipe_ingredient";
		sql += "	VALUES (?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ingre.getRecipeno());
			ps.setInt(2, ingre.getCategory());
			ps.setInt(3, ingre.getElementnum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<RecipeIngredient> selectMainIngredient(int recipeno) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT ingrename FROM recipe_ingredient,ingredient";
		sql += "	WHERE recipe_ingredient.elementnum = ingredient.ingreno";
		sql += "	AND recipeno = ?";
		sql += "	AND ing_group = 1";
		
		List<RecipeIngredient> main = new ArrayList<RecipeIngredient>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipeno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				RecipeIngredient ingredient = new RecipeIngredient();
				
				ingredient.setIngrename(rs.getString("ingrename"));
				
				main.add(ingredient);
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
		
		
		return main;
	}

	@Override
	public List<RecipeIngredient> selectSubIngredient(int recipeno) {
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT ingrename FROM recipe_ingredient,ingredient";
		sql += "	WHERE recipe_ingredient.elementnum = ingredient.ingreno";
		sql += "	AND recipeno = ?";
		sql += "	AND ing_group = 2";
		
		List<RecipeIngredient> sub = new ArrayList<RecipeIngredient>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipeno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				RecipeIngredient ingredient = new RecipeIngredient();
				
				ingredient.setIngrename(rs.getString("ingrename"));
				
				sub.add(ingredient);
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
		
		return sub;
	}

	@Override
	public List<RecipeIngredient> selectSeasoning(int recipeno) {
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT seasname FROM recipe_ingredient,seasoning";
		sql += "	WHERE recipe_ingredient.elementnum = seasoning.seasno";
		sql += "	AND recipeno = ?";
		sql += "	AND ing_group = 3";
		
		List<RecipeIngredient> seas = new ArrayList<RecipeIngredient>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, recipeno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				RecipeIngredient ingredient = new RecipeIngredient();
				
				ingredient.setIngrename(rs.getString("seasname"));
				
				seas.add(ingredient);
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
		return seas;
	}

	@Override
	public int selectCount(String search) {
		conn = DBConn.getConnection();

		// 수행할 DB쿼리
		String sql = "";
		sql += "SELECT count(*)"; 
		sql += " FROM RECIPE_INGREDIENT RI,recipe R, ingredient I";
		sql += " WHERE RI.recipeno = R.recipeno";
		sql += " AND RI.elementnum = I.ingreno";
		sql += " AND I.ingrename=?";
		sql += " AND ri.ing_group=1";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt(1);
			
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
		
		return cnt;
	}

	@Override
	public List<Recipe> selectingreno(String search, Paging ingpaging) {
		
		conn = DBConn.getConnection();

		// 수행할 DB쿼리
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT R.recipeno";
		sql += "		, (SELECT nick FROM usertb U WHERE u.userno = r.userno) nick";
		sql += "		, recipename";
		sql += "		, recipeex";
		sql += "		, recipic";
		sql += "		FROM RECIPE_INGREDIENT RI,recipe R, ingredient I";
		sql += "		WHERE RI.recipeno = R.recipeno";
		sql += "		AND RI.elementnum = I.ingreno";
		sql += "		AND I.ingrename=?";
		sql += "		AND ri.ing_group=1";
		sql += "		ORDER BY RI.recipeno DESC";
		sql += "    )B";
		sql += "    ORDER BY rnum";
		sql += ") recipe";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Recipe> list = new ArrayList<Recipe>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			ps.setInt(2, ingpaging.getStartNo());
			ps.setInt(3, ingpaging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Recipe recipe = new Recipe();
				
				recipe.setNick(rs.getString("nick"));
				recipe.setRecipeno(rs.getInt("recipeno"));
				recipe.setRecipename(rs.getString("recipename"));
				recipe.setRecipeex(rs.getString("recipeex"));
				recipe.setRecipic(rs.getString("recipic"));
				
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
}