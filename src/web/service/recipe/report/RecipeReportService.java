package web.service.recipe.report;

import web.dto.Report;

public interface RecipeReportService {

	void report(Report report);

	String getRecipeName(int reportno);

}
