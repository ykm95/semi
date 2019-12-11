package web.dao.mypage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.dbutil.DBConn;
import web.dto.Member;

public class MypageUserDaoImpl implements MypageUserDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void secessionUserByUserno(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "UPDATE usertb SET ";
		sql += "userid = '삭제된회원'||userno ";
		sql += ",userpw = null ";
		sql += ",email = null ";
		sql += ",nick = null ";
		sql += ",usercom = null ";
		sql += ",userpic = null ";
		sql += ",emailcheckno = null ";
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
	public void updateUserComment(HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "UPDATE usertb SET usercom=? ";
		sql += "WHERE userno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, req.getParameter("usercom"));
			ps.setInt(2, (int)session.getAttribute("userno"));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUserPic(Member member) {

		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "UPDATE usertb SET userpic=? ";
		sql += "WHERE userno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserpic());
			ps.setInt(2, member.getUserno());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
