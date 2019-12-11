package web.controller.mypage.scrap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.mypage.scrap.ScrapService;
import web.service.mypage.scrap.ScrapServiceImpl;

@WebServlet("/mypage/scrap/delete")
public class ScrapDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ScrapService scrapService = new ScrapServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		scrapService.delete(req);
		
		resp.sendRedirect("/mypage/scrap");
		
	}

}
