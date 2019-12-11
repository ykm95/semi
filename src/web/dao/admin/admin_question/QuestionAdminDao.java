package web.dao.admin.admin_question;

import java.util.List;

import util.Paging;
import web.dto.Question;

public interface QuestionAdminDao {
	
	/**
	 * 문의글 전체 목록 조회
	 * @return
	 */
	public List<Question> selectAll();
	/**
	 * 페이징 대상 문의 목록 조회
	 * 
	 * @param Paging - 페이징 정보
	 * @return List - 문의 목록
	 */
	
	public List<Question> selectAll(Paging paging);
	/**
	 * 총 문의글 수 조회
	 * @return
	 */
	public int selectCntAll();
	/**
	 * 검색어(userno)로 문의글 조회 
	 * @param search
	 * @return
	 */
	
	public int selectCntAll(String search);
	
	/**
	 * 문의글 상세보기 조회
	 * @param viewQuesiton
	 * @return
	 */
	public Question selectQuestionByUserno(Question viewQuesiton);
	/**
	 * 게시글 입력
	 * @param question
	 */
	public void insert(Question answerQuestion);

}
