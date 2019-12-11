package web.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dbutil.DBConn;
import web.dto.Member;

public class MemberDaoImpl implements MemberDao {

	//DB연결 객체
	private Connection conn = null;   // DB 연결 객체
	private PreparedStatement ps = null;   // SQL 수행 객체
	private ResultSet rs = null;   // SQL 수행 결과 객체


	@Override
	public void insert(Member member) {

		conn = DBConn.getConnection();   // DB 연결
		String sql = "INSERT INTO usertb(userno, userid, userpw, email, nick) VALUES(user_seq.nextval,?,?,?,?)";

		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getNick());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}


	@Override
	public int selectCntMemberByUserid(Member member_login) {
		conn = DBConn.getConnection(); // DB 연결		
		String sql = "SELECT count(*) FROM usertb WHERE userid=? AND userpw=?";
		int cnt = 0;

		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member_login.getUserid());
			ps.setString(2, member_login.getUserpw());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}


	@Override
	public Member selectMemberByUserid(Member member_login) {
		conn = DBConn.getConnection(); //DB연결
		String sql = "SELECT * FROM usertb WHERE userid=?";
		
		Member res = new Member();		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member_login.getUserid());
			rs=ps.executeQuery();

			while(rs.next()) {
				res.setUserno(rs.getInt("userno"));
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setNick(rs.getString("nick"));
				res.setUserpic(rs.getString("userpic"));
				res.setUsercom(rs.getString("usercom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;	
	}


	@Override
	public int selectCntByUserid(Member userid) {
		conn = DBConn.getConnection(); // DB 연결		
		String sql = "SELECT count(*) FROM usertb WHERE userid=?";
		int cnt = 0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid.getUserid());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}


	@Override
	public int selectCntMemberByUserid_1(Member member_id) {
		conn = DBConn.getConnection(); // DB 연결		
		String sql = "SELECT count(*) FROM usertb WHERE userid=";
		int cnt = 0;

		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member_id.getUserid());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}


	@Override
	public Member selectMemberByUserid_1(Member member_id) {
		conn = DBConn.getConnection(); //DB연결
		String sql = "SELECT * FROM usertb WHERE userid=?";
		
		Member res = new Member();		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member_id.getUserid());
			rs=ps.executeQuery();

			while(rs.next()) {
				res.setUserno(rs.getInt("userno"));
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setNick(rs.getString("nick"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;	
	}


	@Override
	public void updateEmailCheckNo(Member member) {
		conn = DBConn.getConnection();   //DB 연결
		String sql = "";
		sql += "UPDATE usertb set emailcheckno = ? where userid = ?";

		try {
			ps = conn.prepareStatement(sql);   //수행 객체 얻기
			ps.setString(1, member.getEmailCheckNo());   //SQL쿼리의 ? 채우기
			ps.setString(2, member.getUserid());   //SQL쿼리의 ? 채우기
			rs = ps.executeQuery();            //SQL 수행 결과 얻기

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)   ps.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}      
	}


	@Override
	public Member selectEmailCheckNo(Member mebmer) {
		conn = DBConn.getConnection(); //DB연결
		String sql = "SELECT * FROM usertb WHERE userid=?";
		
		Member res = new Member();		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mebmer.getUserid());
			rs=ps.executeQuery();

			while(rs.next()) {
				res.setUserno(rs.getInt("userno"));
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setNick(rs.getString("nick"));
				res.setUsercom(rs.getString("usercom"));
				res.setUserpic(rs.getString("userpic"));
				res.setEmailCheckNo(rs.getString("emailcheckno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;	
	}


	@Override
	public Member selectPwByUserid(Member member) {
		conn = DBConn.getConnection(); //DB연결
		String sql = "SELECT * FROM usertb WHERE userid=?";
		
		Member res = new Member();		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			rs=ps.executeQuery();

			while(rs.next()) {
				res.setUserno(rs.getInt("userno"));
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setNick(rs.getString("nick"));
				res.setUsercom(rs.getString("usercom"));
				res.setUserpic(rs.getString("userpic"));
				res.setEmailCheckNo(rs.getString("emailcheckno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;	
	}


	@Override
	public int selectCntMemberByUserid_2(Member member) {
		conn = DBConn.getConnection(); // DB 연결		
		String sql = "SELECT count(*) FROM usertb WHERE userid=?";
		int cnt = 0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}


	@Override
	public void changePw(Member changepw) {
		conn = DBConn.getConnection();   // DB 연결
		String sql = "UPDATE usertb SET userpw = ?";
		sql += "	WHERE userno = ?";

		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, changepw.getUserpw());
			ps.setInt(2, changepw.getUserno());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

}
