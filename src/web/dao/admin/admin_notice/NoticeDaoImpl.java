package web.dao.admin.admin_notice;

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
import web.dto.Notice;

public class NoticeDaoImpl implements NoticeDao{
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
	@Override
	public void noticeinsert(Notice writenotice) {
		
		System.out.println(writenotice);
		
		conn= DBConn.getConnection();
		
		//쿼리수행
		String sql="";
		sql +="INSERT INTO notice(noticeno, notice, userno)";
		sql +=" VALUES ( ? ,?,?)";
	
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, writenotice.getNoticeno());
			ps.setString(2, writenotice.getNotice());
			ps.setInt(3, writenotice.getUserno());

			
			ps.executeUpdate();
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
	public int selectNoticeno() {
		conn=DBConn.getConnection();
		
		String sql="";
		sql+= "SELECT notice_seq.nextval";
		sql+= " FROM dual";
		
		int noticeno = 0;
		
		try {
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				noticeno = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(rs!=null) ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noticeno;
	}


	@Override
	public List<Notice> selectAll(Paging paging, HttpServletRequest req) {
		conn= DBConn.getConnection();
		
		//쿼리 수행
		String sql="";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += " 			userno, noticeno, notice,(SELECT userid FROM usertb WHERE usertb.userno=notice.userno) userid";
		sql += "        FROM notice WHERE userno=?";
		sql += "        ORDER BY noticeno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) notice";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Notice> noticelist = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("userno")));
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Notice notice = new Notice();
				
				notice.setUserno(rs.getInt("userno"));
				notice.setNoticeno(rs.getInt("noticeno"));
				notice.setNotice(rs.getString("notice"));
				notice.setUserid(rs.getString("userid"));
				
				System.out.println(notice);
				
				noticelist.add(notice);
			}
			
		} catch (SQLException e) {
		} finally {

			try {
				if(ps!=null)	ps.close();
				if(ps!=null)	rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noticelist;
	}


	@Override
	public int selectCntAll(HttpServletRequest req) {

		conn = DBConn.getConnection();
		
		String sql ="";
		sql+="SELECT count(*) FROM notice";
		sql+=" WHERE userno=?";
		sql+=" ORDER BY noticeno DESC";
		
		int cnt=0;
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("userno")));
			rs= ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	@Override
	public Notice selectNoticeByNoticeno(HttpServletRequest req) {
		conn= DBConn.getConnection();
		
		String sql="";
		sql+="SELECT * FROM notice WHERE noticeno = ?";
		
		Notice notice = new Notice();
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("noticeno")));
		
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				notice.setNoticeno(rs.getInt("noticeno"));
				notice.setNotice(rs.getString("notice"));
				notice.setUserno(rs.getInt("userno"));
				
				System.out.println(notice);
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
		
		return notice;
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
