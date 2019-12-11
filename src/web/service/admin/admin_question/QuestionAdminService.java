package web.service.admin.admin_question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Question;

public interface QuestionAdminService {
	/**
	 * 문의글 목록 조회
	 * @return
	 */
	public List<Question> getList();
	/**
	 * 페이징 정보를 활용하여 보여질 문의 목록만 조회
	 * @param question
	 * @return
	 */
	public List<Question> getList(Paging paging);
	
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */
	public Paging getPaging(HttpServletRequest req);
	/**
	 * 요청 파라미터 회원 번호 파싱 
	 * @param req
	 * @return
	 */
	public Question getUserno(HttpServletRequest req);
	/**
	 * 문의글 상세보기
	 * @param viewQuestion 문의글을 상세보기할 userno
	 * @return
	 */
	public Question view(Question viewQuestion);
	
	/**
	 * 문의글 답변 파라미터 꺼내기
	 * @param req
	 * @return
	 */
	public Question getanswer(HttpServletRequest req);
	
	/**
	 * 문의글 작성
	 * @param req
	 */
//	public void answer(HttpServletRequest req);
	
	public void answer(Question answerQuesiton);

}
