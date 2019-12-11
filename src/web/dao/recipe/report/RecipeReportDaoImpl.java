package web.dao.recipe.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.Report;

public class RecipeReportDaoImpl implements RecipeReportDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insertReport(Report report) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "INSERT INTO report(reportno, recipeno, userno, repcontent, repotitle) ";
		sql += "VALUES(report_seq.nextVal, ?, ?, ?, ?) ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, report.getRecipeno());
			ps.setInt(2, report.getUserno());
			ps.setString(3, report.getRepocontent());
			ps.setString(4, report.getRepotitle());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	@Override
	public String selectRecipeName(int reportno) {
		
		conn = DBConn.getConnection();
		
		String sql = "SELECT recipename FROM recipe ";
		sql += "WHERE recipeno = ?";
		
		String recipename = "";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reportno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				recipename = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return recipename;
	}

}
