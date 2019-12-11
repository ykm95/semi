package web.dao.mypage.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.dbutil.DBConn;
import web.dto.Notice;

public class NoticeDaoImpl implements NoticeDao {
	
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL 수행 객체
	private ResultSet rs = null; //SQL수행 결과 객체

	@Override
	public List<Notice> selectAllNotice(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM notice ";
		sql += "WHERE userno = ? ";
		sql += "ORDER BY noticeno DESC ";
		
		List<Notice> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeno(rs.getInt("noticeno"));
				notice.setUserno((int)session.getAttribute("userno"));
				notice.setNotice(rs.getString("notice"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void deleteNotice(HttpServletRequest req) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE notice ";
		sql += "WHERE noticeno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("noticeno")));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteAllNotice(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE notice ";
		sql += "WHERE userno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int selecNoticeCnt(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		int noticeCnt = 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM notice ";
		sql += "WHERE userno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				noticeCnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeCnt;
	}

}
