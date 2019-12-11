package web.dao.recipe.report;

import web.dto.Report;

public interface RecipeReportDao {

	void insertReport(Report report);

	String selectRecipeName(int reportno);

}
