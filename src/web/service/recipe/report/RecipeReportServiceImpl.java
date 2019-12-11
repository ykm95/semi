package web.service.recipe.report;

import web.dao.recipe.report.RecipeReportDao;
import web.dao.recipe.report.RecipeReportDaoImpl;
import web.dto.Report;

public class RecipeReportServiceImpl implements RecipeReportService {

	RecipeReportDao recipeReportDao = new RecipeReportDaoImpl();
	
	@Override
	public void report(Report report) {
		
		recipeReportDao.insertReport(report);
		
	}

	
	@Override
	public String getRecipeName(int reportno) {
		
		return recipeReportDao.selectRecipeName(reportno);
	}

}
