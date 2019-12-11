package web.controller.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Randomrecipe;
import web.service.radommenu.RandomMenuService;
import web.service.radommenu.RandomMenuServiceImpl;

@WebServlet("/random/menu")
public class RandomMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private RandomMenuService randomMenuService = new RandomMenuServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int menuno = randomMenuService.getParam();
		
		Randomrecipe randomrecipe = new Randomrecipe();
		randomrecipe.setRanmenuno(menuno);
		
		randomrecipe = randomMenuService.getRandomrecipe(randomrecipe);
		
		req.setAttribute("randomrecipe", randomrecipe);
		
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/main/randommenu.jsp").forward(req,  resp);
		
	}
}