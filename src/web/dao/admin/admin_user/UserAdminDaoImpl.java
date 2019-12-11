package web.dao.admin.admin_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Member;

public class UserAdminDaoImpl implements UserAdminDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Member> selectAll() {

		conn = DBConn.getConnection(); //DB 연결

		//쿼리 수행
		String sql="";
		sql +="SELECT userno, userid, email, nick FROM usertb";
		sql +=" ORDER BY userno DESC";

		List<Member> list = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);

			rs= ps.executeQuery();

			while(rs.next()) {
				Member userAdmin = new Member();

				userAdmin.setUserno(rs.getInt("userno"));
				userAdmin.setUserid(rs.getString("userid"));
				userAdmin.setEmail(rs.getString("email"));
				userAdmin.setNick(rs.getString("nick"));

				list.add(userAdmin);
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
		//최종결과 반환
		return list;
	}

	@Override
	public List<Member> selectAll(Paging paging) {
		conn = DBConn.getConnection(); //DB 연결


		//수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            userno, userid, email, nick"; 
		sql += "        FROM usertb";
		sql += "		WHERE userid LIKE '%'||?||'%'"; 
		sql += "        ORDER BY userno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) usertb";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<Member> list = new ArrayList<>();

		try {
			ps=conn.prepareStatement(sql);

			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs=ps.executeQuery();

			while(rs.next()) {
				Member userAdmin =new Member();

				userAdmin.setUserno(rs.getInt("userno"));
				userAdmin.setUserid(rs.getNString("userid"));
				userAdmin.setEmail(rs.getString("email"));
				userAdmin.setNick(rs.getString("nick"));

				list.add(userAdmin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			try {
				if(ps!=null)	ps.close();
				if(ps!=null)	rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public int selectCntAll() {
		conn = DBConn.getConnection(); //DB연결

		//sql 쿼리
		String sql="";
		sql +="SELECT count(*) FROM usertb";

		int cnt=0;

		try {
			ps= conn.prepareStatement(sql);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public int selectCntAll(String search) {
		conn = DBConn.getConnection(); //DB 연결

		//sql 쿼리
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM usertb";
		sql += " WHERE userid LIKE '%'||?||'%'";

		//최종 결과 변수
		int cnt=0;

		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, search);

			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			while(rs.next()) {
				cnt =rs.getInt(1);
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
	public void delete(Member userAdmin) {

		conn = DBConn.getConnection();
		
		String sql="";
		sql+="UPDATE usertb set";
		sql+=" userid='탈퇴회원', userpw='', email='', nick='', userpic='', usercom=''";
		sql+=" WHERE userno=?";
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userAdmin.getUserno());
			
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

	

}
