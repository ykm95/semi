package web.dao.admin.admin_question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Paging;
import web.dbutil.DBConn;
import web.dto.Question;

public class QuestionAdminDaoImpl implements QuestionAdminDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Question> selectAll() {

		conn =DBConn.getConnection();

//		sql += " SELECT idx, title, contents, hits, reco, boardno, userno, regdate,";
//	    sql   += " (SELECT usernick FROM buser WHERE b.userno = userno)usernick";
//	    sql += " FROM bboard b WHERE idx = ?";
		String sql ="";
//		sql+="SELECT userno questitle FROM question";
		sql+="SELECT userno, questitle,";
		sql+=" (SELECT userid FROM usertb WHERE userno=question.userno) userid";
		sql+=" FROM question";
		sql+=" ORDER BY questionno DESC";

		List<Question> qlist = new ArrayList<>();

		try {
			ps=conn.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				Question question = new Question();

				question.setUserno(rs.getInt("userno"));
				question.setQuestitle(rs.getString("questitle"));
				question.setUserid(rs.getString("userid"));

				qlist.add(question);
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

		return qlist;
	}

	@Override
	public List<Question> selectAll(Paging paging) {
		
		conn= DBConn.getConnection();

		//쿼리 수행
		String sql="";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            qt.userno, qt.questitle, ut.userid"; 
		sql += "			FROM usertb UT, question QT";
		sql += "			WHERE ut.userno = qt.userno";
		sql += "			AND userid LIKE '%'||?||'%'"; 
		sql += "        ORDER BY questionno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Question> qlist = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs=ps.executeQuery();
			

			System.out.println(paging.getSearch());
			System.out.println(paging.getStartNo());
			System.out.println(paging.getEndNo());
			
			while(rs.next()) {
				
				System.out.println(1);
				
				Question question = new Question();

				question.setUserno(rs.getInt("userno"));
				question.setQuestitle(rs.getString("questitle"));
				question.setUserid(rs.getString("userid"));

				qlist.add(question);
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
		System.out.println(qlist);
		return qlist;
	}

	@Override
	public int selectCntAll() {
		conn =DBConn.getConnection();

		//쿼리 수행
		String sql="";
		sql+="SELECT count(*) FROM question";

		int cnt=0;
		try {
			ps =conn.prepareStatement(sql);
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
		conn = DBConn.getConnection();

		String sql="";
		
		sql+="SELECT count(*) FROM question qt,usertb ut";
		sql+=" WHERE qt.userno = ut.userno";
		sql+=" AND userid LIKE '%'||?||'%'";
		
		int cnt =0;

		try {
			ps =conn.prepareStatement(sql);
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
	public Question selectQuestionByUserno(Question viewQuesiton) {

		conn= DBConn.getConnection();

		String sql="";
		sql+="SELECT questionno, userno, question, questionpic, questitle, answer,";
		sql+="(SELECT userid FROM usertb WHERE userno= question.userno) userid";
		sql+=" FROM question WHERE userno = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewQuesiton.getUserno());

			rs=ps.executeQuery();

			while(rs.next()) {
				viewQuesiton = new Question();
				
				viewQuesiton.setQuestionno(rs.getInt("questionno"));
				viewQuesiton.setUserno(rs.getInt("userno"));
				viewQuesiton.setQuestion(rs.getString("question"));
				viewQuesiton.setQuestionpic(rs.getString("questionpic"));
				viewQuesiton.setQuestitle(rs.getString("questitle"));
				viewQuesiton.setAnswer(rs.getString("answer"));
				viewQuesiton.setUserid(rs.getString("userid"));
				
				//System.out.println(viewQuesiton);
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
		return viewQuesiton;
	}

	@Override
	public void insert(Question answerQuestion) {
		
		conn = DBConn.getConnection();
		
		//쿼리 수행
		String sql="";
		sql += "UPDATE question set answer=?";
		sql += "	WHERE questionno = ?";
		
		try {
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, answerQuestion.getAnswer());
			ps.setInt(2, answerQuestion.getQuestionno());
			
			System.out.println(answerQuestion.getAnswer());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



}
