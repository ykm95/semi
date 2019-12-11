package web.dao.recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.Recommend;

public class RecommendDaoImpl implements RecommendDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntRecommend(Recommend recommend) {
		
		conn = DBConn.getConnection(); 

		String sql = "";
		sql += "SELECT count(*) FROM recommend";
		sql += " WHERE recipeno = ?";
		sql += " 	AND userno = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		int cnt = -1;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getRecipeno());
			ps.setInt(2, recommend.getUserno());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	
	
	@Override
	public void deleteRecommend(Recommend recommend) {
		conn = DBConn.getConnection(); 
		// TODO Auto-generated method stub
		String sql = "";
		sql += "DELETE recommend";
		sql += " WHERE userno = ?";
		sql += " 	AND recipeno = ?";
		
		//DB 객체
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getUserno());
			ps.setInt(2, recommend.getRecipeno());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void insertRecommend(Recommend recommend) {
		conn = DBConn.getConnection(); 
		
		String sql = "";
		sql += "INSERT INTO recommend";
		sql += " VALUES ( ?, ? )";
		
		//DB 객체
		
//		System.out.println(recommend);
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getUserno());
			ps.setInt(2, recommend.getRecipeno());

			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	@Override
	public int selectTatalCntRecommend(Recommend recommend) {
		
		conn = DBConn.getConnection(); 
		
		String sql = "SELECT COUNT(*) FROM recommend"
				+ " WHERE recipeno=?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getRecipeno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
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
		
		return cnt;
	}

}
