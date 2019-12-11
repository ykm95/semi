package web.dao.randommenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dbutil.DBConn;
import web.dto.Randomrecipe;

public class RandomMenuDaoImpl implements RandomMenuDao{

	private Connection conn = null; // DB연결 객체
	
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL수행 결과 객체
	
	@Override
	public List<Randomrecipe> randomMenuno() {
		
		conn = DBConn.getConnection(); // DB연결
		
		String sql = "";
		sql += "SELECT ranmenuno FROM randomrecipe";
		
		List list = new ArrayList();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Randomrecipe randomrecipe = new Randomrecipe();
				
				randomrecipe.setRanmenuno(rs.getInt("ranmenuno"));
				
				list.add(randomrecipe);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public Randomrecipe selectByMenuno(Randomrecipe randomrecipe) {
		
		conn = DBConn.getConnection(); // DB연결
		
		String sql = "";
		sql += "SELECT * FROM randomrecipe";
		sql += "	WHERE ranmenuno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, randomrecipe.getRanmenuno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				randomrecipe.setRanmenuname(rs.getString("ranmenuname"));
				randomrecipe.setRanmenupic(rs.getString("ranmenupic"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return randomrecipe;
	}
	
}