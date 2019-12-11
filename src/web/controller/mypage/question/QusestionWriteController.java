package web.controller.mypage.question;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import web.dto.Question;
import web.service.mypage.question.QuestionService;
import web.service.mypage.question.QuestionServiceImpl;

@WebServlet("/mypage/question/write")
public class QusestionWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QuestionService questionService = new QuestionServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/question/write.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		// 1. 요청 객체 - req
		
		// 2. 파일 저장 위치 - 서버 real path를 이용
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");
				
		// 3. 업로드 제한 사이즈
		int maxPostSize = 10 * 1024 * 1024; // 10MB
				
		// 4. 인코딩
				
		String encoding = "UTF-8";
				
		// 5. 중복 파일 이름 정책
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
				
		// --- 준비 완료 ---
				
				
				
		// --- COS 파일 업로드 객체 생성 ---
		MultipartRequest mul = new MultipartRequest
				(req, saveDirectory, maxPostSize, encoding, policy);
		// ---------------------------
				
				
		// --- 업로드 정보 확인 ---
		resp.setContentType("text/html; charset=utf-8");
				
		// -------------------
		Question question = new Question();
		
		question.setUserno((int)session.getAttribute("userno"));
		question.setQuestitle(mul.getParameter("title"));
		question.setQuestion(mul.getParameter("content"));
		question.setQuestionpic(mul.getFilesystemName("file"));

		questionService.write(question);
		
		resp.sendRedirect("/mypage/question");
		
	}

}
