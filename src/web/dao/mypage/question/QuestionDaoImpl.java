package web.dao.mypage.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.dbutil.DBConn;
import web.dto.Question;

public class QuestionDaoImpl implements QuestionDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL 수행 객체
	private ResultSet rs = null; //SQL수행 결과 객체
	
	@Override
	public List<Question> selectAllQuestion(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM question ";
		sql += "WHERE userno = ? ";
		sql += "ORDER BY questionno DESC ";
		
		List<Question> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int)session.getAttribute("userno"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Question question = new Question();
				
				question.setQuestionno(rs.getInt("questionno"));
				question.setUserno(rs.getInt("userno"));
				question.setQuestitle(rs.getString("questitle"));
				question.setQuestion(rs.getString("question"));
				question.setQuestionpic("/upload/"+rs.getString("questionpic"));
				question.setAnswer(rs.getString("answer"));
				
				list.add(question);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void insertQuestion(Question question) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "INSERT INTO question(questionno, userno, questitle, question, questionpic) ";
		sql += "VALUES(question_seq.nextVal, ?, ?, ?, ?) ";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, question.getUserno());
			ps.setString(2, question.getQuestitle());
			ps.setString(3, question.getQuestion());
			ps.setString(4, question.getQuestionpic());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void deleteQuestion(HttpServletRequest req) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql += "DELETE FROM question ";
		sql += "WHERE questionno = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("questionno")));
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Question selectQuestion(HttpServletRequest req) {
		
		conn = DBConn.getConnection();
		
		Question question = new Question();
		
		String sql = "";
		sql += "SELECT * FROM question ";
		sql += "WHERE questionno = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("questionno")));

			rs = ps.executeQuery();
			
			if(rs.next()) {
				question.setQuestionno(rs.getInt("questionno"));
				question.setQuestitle(rs.getString("questitle"));
				question.setQuestion(rs.getString("question"));
				question.setQuestionpic(rs.getString("questionpic"));
				question.setAnswer(rs.getString("answer"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return question;
	}

}
