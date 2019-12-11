package web.dao.mypage.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Question;

public interface QuestionDao {

	List<Question> selectAllQuestion(HttpServletRequest req);

	void insertQuestion(Question question);

	void deleteQuestion(HttpServletRequest req);

	Question selectQuestion(HttpServletRequest req);

}
