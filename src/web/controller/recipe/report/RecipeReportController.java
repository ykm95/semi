package web.controller.recipe.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Report;
import web.service.recipe.report.RecipeReportService;
import web.service.recipe.report.RecipeReportServiceImpl;

@WebServlet("/recipe/report")
public class RecipeReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RecipeReportService recipeReportService = new RecipeReportServiceImpl();		
		
		req.setAttribute("recipeno", req.getParameter("recipeno"));
		req.setAttribute("recipename", recipeReportService.getRecipeName(Integer.parseInt(req.getParameter("recipeno"))));
		
		req.getRequestDispatcher("/WEB-INF/views/recipe/report.jsp")
		.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		
		Report report = new Report();
		
		RecipeReportService recipeReportService = new RecipeReportServiceImpl();
		
		report.setRecipeno(Integer.parseInt(req.getParameter("recipeno")));
		report.setRepotitle(req.getParameter("title"));
		report.setRepocontent(req.getParameter("content"));
		report.setUserno((int)session.getAttribute("userno"));
		report.setUserid((String)session.getAttribute("userid"));
		
		recipeReportService.report(report);
		
		resp.sendRedirect("/recipe/list");
		
	}

}
