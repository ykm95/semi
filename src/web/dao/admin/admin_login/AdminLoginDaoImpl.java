package web.dao.admin.admin_login;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.Admin;

public class AdminLoginDaoImpl implements AdminLoginDao{
	
	//DB관련 객체
	private Connection conn = null; 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntAdminByAdminidAndAdminpw(Admin admin_login) {
		
		conn = DBConn.getConnection();
			
		//쿼리 작성
		String sql="";
		sql += "SELECT count(*) FROM admintb WHERE adminid=? AND adminpw=?";
		int cnt = 0;
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, admin_login.getAdminid());
			ps.setString(2, admin_login.getAdminpw());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public Admin selectAdminByAdminid(Admin admin_login) {
		conn = DBConn.getConnection(); //DB연결
		String sql = "SELECT * FROM admintb WHERE adminid=?";
		
		Admin res = new Admin();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, admin_login.getAdminid());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res.setAdminid(rs.getString("adminid"));
				res.setAdminpw(rs.getString("adminpw"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

}
