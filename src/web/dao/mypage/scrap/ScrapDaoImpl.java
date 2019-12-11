package web.dao.mypage.scrap;

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
import web.dto.Scrap;

public class ScrapDaoImpl implements ScrapDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL 수행 객체
	private ResultSet rs = null; //SQL수행 결과 객체
	
	@Override
	public List<Scrap> selectAllScrap(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM ";
		sql += "	(SELECT r.recipename, r.recipeno, r.recipic, s.scrapno, s.userno ";
		sql += "	FROM scrap s, recipe r ";
		sql += "	WHERE s.recipeno=r.recipeno ";
		sql += "	AND s.userno=?)le, ";
		sql += "	(SELECT r.recipename, u.userid ";
		sql += "	FROM recipe r, usertb u ";
		sql += "	WHERE r.userno = u.userno)ri ";
		sql += "WHERE le.recipename=ri.recipename ";
		sql += "ORDER BY scrapno DESC ";
		
		List<Scrap> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Scrap scrap = new Scrap();
				
				scrap.setRecipeno(rs.getInt("recipeno"));
				scrap.setRecipic(rs.getString("recipic"));
				scrap.setRecipename(rs.getString("recipename"));
				scrap.setUsername(rs.getString("userid"));
				
				list.add(scrap);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public void deleteScrap(HttpServletRequest req) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE scrap ";
		sql += "WHERE scrapno = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("scrapno")));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int selectCntAll(HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT count(*) FROM "; 
		sql += "	(SELECT r.recipename, r.recipeno, r.recipic, s.scrapno, s.userno ";
		sql += "	FROM scrap s, recipe r ";
		sql += "	WHERE s.recipeno=r.recipeno) ";
		sql += "WHERE userno=?";
		
		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
			
			sql += " AND recipename LIKE ?";
		}
		
		sql += "ORDER BY scrapno DESC ";
		
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
	public List<Scrap> selectAllScrap(Paging paging, HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql	+= "    SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT le.recipename, le.recipeno, le.recipic, le.scrapno, le.userno, ri.userid FROM ";
		sql += "			(SELECT r.recipename, r.recipeno, r.recipic, s.scrapno, s.userno ";
		sql += "			FROM scrap s, recipe r ";
		sql += "			WHERE s.recipeno=r.recipeno ";
		sql += "			AND s.userno=?)le, ";
		sql += "			(SELECT r.recipename, u.userid ";
		sql += "			FROM recipe r, usertb u ";
		sql += "			WHERE r.userno = u.userno)ri ";
		sql += "		WHERE le.recipename=ri.recipename ";
		
		if(paging.getSearch()!=null&&!"".equals(paging.getSearch())) {			
			sql	+=	"   AND ri.recipename LIKE ?";
		}
		
		sql += "		ORDER BY scrapno DESC ";
		sql	+= "    ) B";
		sql	+= "    ORDER BY rnum";
		sql	+= " ) BOARD";
		sql	+= " WHERE rnum BETWEEN ? AND ?";
		
		List<Scrap> list = new ArrayList<>();
		
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
				
				Scrap scrap = new Scrap();
				
				scrap.setRecipeno(rs.getInt("recipeno"));
				scrap.setRecipic(rs.getString("recipic"));
				scrap.setRecipename(rs.getString("recipename"));
				scrap.setUsername(rs.getString("userid"));
				
				list.add(scrap);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}



}
