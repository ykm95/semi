package web.dao.admin.admin_report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Report;

public class ReportAdminDaoImpl implements ReportAdminDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Report> selectAll() {
		conn=DBConn.getConnection();

		String sql="";
		sql+="SELECT userno, reportno, repcontent, repotitle, ";
		sql+=" (SELECT userid FROM usertb WHERE userno=report.userno) userid";
		sql+=" FROM reporttb";
		sql+=" ORDER BY userno DESC";

		List<Report> rlist = new ArrayList<>();

		try {
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();

			while(rs.next()) {
				Report report = new Report();
				
				report.setUserno(rs.getInt("userno"));
				report.setReportno(rs.getInt("reportno"));
				//유저아이디
				report.setUserid(rs.getString("userid"));
				report.setRepocontent(rs.getString("repcontent"));
				report.setRepotitle(rs.getString("repotitle"));
				
				rlist.add(report);
				
			}

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
		return rlist;
	}

	@Override
	public List<Report> selectAll(Paging paging) {
		conn=DBConn.getConnection();
		
		//쿼리수행
		String sql="";
		
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            rt.userno, rt.reportno, rt.repcontent, ut.userid, rt.repotitle"; 
		sql += "			FROM usertb UT, report RT";
		sql += "			WHERE ut.userno = rt.userno";
		sql += "			AND userid LIKE '%'||?||'%'"; 
		sql += "        ORDER BY userno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
	//	sql+="SELECT * FROM (SELECT rownum rnum, B.* FROM (SELECT reportno, userno,(SELECT userid FROM usertb WHERE userno= report.userno) userid FROM report	WHERE userno LIKE '%'||?||'%' ORDER BY userno DESC) B ORDER BY rnum) report WHERE rnum BETWEEN ? AND ?";
		
		
		List<Report> rlist =new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs=ps.executeQuery();
	//		System.out.println(paging.getSearch());
	//		System.out.println(paging.getStartNo());
	//		System.out.println(paging.getEndNo());
			
			while(rs.next()) {
				Report report = new Report();
				
				report.setUserno(rs.getInt("userno"));
				report.setReportno(rs.getInt("reportno"));
				//유저 아이디
				report.setUserid(rs.getString("userid"));
				report.setRepocontent(rs.getString("repcontent"));
				report.setRepotitle(rs.getString("repotitle"));
				
	//			System.out.println(1);
				
				rlist.add(report);
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
		System.out.println(rlist);
		return rlist;
	}

	@Override
	public int selectCntAll() {
		conn=DBConn.getConnection();
		
		//쿼리 수행
		String sql="";
		sql+="SELECT count(*) FROM report";
		
		int cnt=0;
		
		try {
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt(1);
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
		return cnt;
	}

	@Override
	public int selectCntAll(String search) {
		conn= DBConn.getConnection();
		
		String sql="";
		sql+="SELECT count(*) FROM report rt, usertb ut";
		sql+=" WHERE rt.userno = ut.userno";
		sql+=" AND userid LIKE '%'||?||'%'";
		
		int cnt=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, search);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt(1);
			}
			
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
		return cnt;
	}

	@Override
	public Report selectReportByUserno(Report viewReport) {

		conn=DBConn.getConnection();
		
		String sql="";//userid, title 추가?
//		sql+="SELECT userno, recipe.reportno, recipe.recipeno, repcontent ";
		//서브쿼리를 통해 userid 를 가져온다
//		sql+=" (SELECT userid FROM usertb WHERE userno= report.userno) userid,";
//		sql+=" (SELECT recipename FROM recipe WHERE recipeno= recipe.recipeno) recipename";
		
//		sql+=" FROM report,recipe WHERE  recipe.recipeno=report.recipeno and userno= ?";
		
		sql+="SELECT rt.userno, rt.reportno, rt.recipeno, rt.repcontent,ut.userid,re.recipename, rt.repotitle";
		sql+=" from report rt"; 
		sql+=" left join usertb ut on (rt.userno = ut.userno)";
		sql+=" left join recipe re on (rt.recipeno = re.recipeno)";
		sql+=" where ut.userno =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewReport.getUserno());
		
			rs=ps.executeQuery();
			
			while(rs.next()) {
				viewReport= new Report();
				
				viewReport.setUserno(rs.getInt("userno"));
				viewReport.setReportno(rs.getInt("reportno"));
				viewReport.setRecipeno(rs.getInt("recipeno"));
				viewReport.setRepocontent(rs.getString("repcontent"));
				viewReport.setUserid(rs.getString("userid"));
				viewReport.setRecipename(rs.getString("recipename"));
				viewReport.setRepotitle(rs.getString("repotitle"));
			}
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
		return viewReport;
	}
}