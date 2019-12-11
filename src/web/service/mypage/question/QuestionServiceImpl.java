package web.service.mypage.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.mypage.question.QuestionDao;
import web.dao.mypage.question.QuestionDaoImpl;
import web.dto.Question;

public class QuestionServiceImpl implements QuestionService {

	QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public List<Question> getQuestion(HttpServletRequest req) {
		
		return questionDao.selectAllQuestion(req);
	}

	@Override
	public void write(Question question) {
		
		questionDao.insertQuestion(question);
		
	}

	@Override
	public void delete(HttpServletRequest req) {

		questionDao.deleteQuestion(req);
		
	}

	@Override
	public Question getQuestionView(HttpServletRequest req) {

		return questionDao.selectQuestion(req);
	}


}
