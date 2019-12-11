package web.service.mypage.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Question;

public interface QuestionService {

	List<Question> getQuestion(HttpServletRequest req);

	void write(Question question);

	void delete(HttpServletRequest req);

	Question getQuestionView(HttpServletRequest req);


}
