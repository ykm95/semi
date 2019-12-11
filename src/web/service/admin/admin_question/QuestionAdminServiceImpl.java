package web.service.admin.admin_question;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.admin.admin_question.QuestionAdminDao;
import web.dao.admin.admin_question.QuestionAdminDaoImpl;
import web.dto.Question;

public class QuestionAdminServiceImpl implements QuestionAdminService{

	public QuestionAdminDao questionAdminDao = new QuestionAdminDaoImpl();

	@Override
	public List<Question> getList() {
		return questionAdminDao.selectAll();
	}

	@Override
	public List<Question> getList(Paging paging) {
		return questionAdminDao.selectAll(paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage =Integer.parseInt(param);
		}
		//		System.out.println("curPage : " + curPage);

		//검색어
		String search = req.getParameter("search");

		//Board TB와 curPage 값을 이용해 Paging 객체를 생성하고 반환
		int totalcount = questionAdminDao.selectCntAll(search);

		//Paging 객체 생성
		Paging paging = new Paging(totalcount, curPage);

		//검색어
		paging.setSearch(search);
		return paging;
	}

	@Override
	public Question getUserno(HttpServletRequest req) {
		//요청파라미터 userno를 파싱한다
		String param = req.getParameter("userno");
		int userno = 0;
		if( param!=null && !"".equals(param)) {
			userno = Integer.parseInt(param);
		}
		
		Question question =new Question();
		question.setUserno(userno);
		
		return question;
	}

	@Override
	public Question view(Question viewQuestion) {
		return questionAdminDao.selectQuestionByUserno(viewQuestion);
	}

	@Override
	public void answer(Question answerQuesiton) {
		questionAdminDao.insert(answerQuesiton);
		
	}

	@Override
	public Question getanswer(HttpServletRequest req) {
		
	//	questionno, userno, answer
		
		Question question = new Question();
		
//		System.out.println(req.getParameter("questionno"));
//		System.out.println(req.getParameter("userno"));
//		System.out.println(req.getParameter("answer"));
		
		question.setQuestionno(Integer.parseInt(req.getParameter("questionno")) );
		question.setUserno(Integer.parseInt(req.getParameter("userno")));
		question.setAnswer(req.getParameter("answer"));
		
		return question;
		
		
	}




	
	

	




}
