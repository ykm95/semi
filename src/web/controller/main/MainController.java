package web.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Recipe;
import web.service.todaysmenu.TodaysMenuService;
import web.service.todaysmenu.TodaysMenuServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodaysMenuService todaysMenuService = new TodaysMenuServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Recipe> todaysmenu = todaysMenuService.searchTop();
		
		req.setAttribute("todaysmenu", todaysmenu);
		
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req,  resp);
		
	}
}