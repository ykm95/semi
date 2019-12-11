package web.service.recipe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import util.Paging;
import web.dao.recipe.RecipeDao;
import web.dao.recipe.RecipeDaoImpl;
import web.dao.recommend.RecommendDao;
import web.dao.recommend.RecommendDaoImpl;
import web.dto.Recipe;
import web.dto.RecipeIngredient;
import web.dto.RecipeProcess;
import web.dto.Recommend;

public class RecipeServiceImpl implements RecipeService {

	private RecipeDao recipeDao = new RecipeDaoImpl();
	private RecommendDao recommendDao = new RecommendDaoImpl();

	@Override
	public void write(HttpServletRequest req, HttpServletResponse resp) {

		ServletContext context = req.getServletContext();
		String saveDirectory = context.getRealPath("upload");

		System.out.println(saveDirectory);

		Recipe recipe = new Recipe();

		int maxPostSize = 10 * 1024 * 1024;

		String encoding = "UTF-8";

		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		MultipartRequest mul = null;
		try {
			mul = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);
		} catch (IOException e) {
			e.printStackTrace();
		}

		resp.setContentType("text/html; charset=utf-8");

		RecipeProcess recipeProcess = new RecipeProcess();

		if (mul.getParameter("recipename") != null && !"".equals(mul.getParameter("recipename"))) {
			recipe = setRecipeno();

			List<RecipeProcess> recipeProcessList = new ArrayList<RecipeProcess>();

			for (int i = 1; i <= Integer.parseInt(mul.getParameter("idxcount")); i++) {
				String exname = "processText[" + i + "]";
				String picname = "processPic[" + i + "]";

				recipeProcess.setRecipeno(recipe.getRecipeno());
				recipeProcess.setProcessex(mul.getParameter(exname));
				recipeProcess.setProcesspic("/upload/" + mul.getFilesystemName(picname));

				recipeProcessList.add(recipeProcess);

				recipeProcess = new RecipeProcess();
			}

			recipe.setUserno((int) req.getSession().getAttribute("userno"));
			recipe.setRecipename(mul.getParameter("recipename"));
			recipe.setRecipeex(mul.getParameter("recipeex"));
			recipe.setCategory(Integer.parseInt(mul.getParameter("category")));
			recipe.setOcassion(Integer.parseInt(mul.getParameter("ocassion")));
			recipe.setRecipic("/upload/" + mul.getFilesystemName("recipic"));

			// --------------------------------------

			write(recipe);
			write(recipeProcessList);

			String[] main = mul.getParameterValues("mainIngre");
			String[] sub = mul.getParameterValues("subIngre");
			String[] seas = mul.getParameterValues("seasoning");

			for (int i = 0; i < main.length; i++) {
				RecipeIngredient ingre = new RecipeIngredient();
				ingre.setRecipeno(recipe.getRecipeno());
				ingre.setCategory(1);
				ingre.setElementnum(Integer.parseInt(main[i]));

				recipeDao.insert(ingre);
			}
			for (int i = 0; i < sub.length; i++) {
				RecipeIngredient ingre = new RecipeIngredient();
				ingre.setRecipeno(recipe.getRecipeno());
				ingre.setCategory(2);
				ingre.setElementnum(Integer.parseInt(sub[i]));

				recipeDao.insert(ingre);
			}
			for (int i = 0; i < seas.length; i++) {
				RecipeIngredient ingre = new RecipeIngredient();
				ingre.setRecipeno(recipe.getRecipeno());
				ingre.setCategory(3);
				ingre.setElementnum(Integer.parseInt(seas[i]));

				recipeDao.insert(ingre);
			}
		}
	}

	@Override
	public Recipe setRecipeno() {

		return recipeDao.selectRecipeno();
	}

	@Override
	public void write(Recipe recipe) {
		recipeDao.insert(recipe);
	}

	@Override
	public void write(List<RecipeProcess> recipeProcessList) {
		for (int i = 0; i < recipeProcessList.size(); i++) {
			recipeDao.insert(recipeProcessList.get(i));
		}
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {

		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");

		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		param = req.getParameter("search");

		String search = "";
		if (param != null && !"".equals(param)) {
			search = req.getParameter("search");
		}

		int totalCount = recipeDao.selectCntAll(search);

//		param = req.getParameter("more");
//		
//		int more = 0;
//		if(param != null && !"".equals(param)) {
//			search = req.getParameter("search");
//		}
//		
//		Paging paging = null;
//		// Paging 객체 생성
//		if(true){
//			paging = new Paging(totalCount, curPage);
//		} else {
//			paging = new Paging(totalCount, curPage, 6);
//		}

		Paging paging = new Paging(totalCount, curPage, 6);

		paging.setSearch(req.getParameter("search"));

		return paging;
	}

	@Override
	public List<Recipe> getList(Paging paging) {
		return recipeDao.selectAll(paging);
	}

	@Override
	public Recipe getParam(HttpServletRequest req) {
		String param = req.getParameter("recipeno");
		// 전달 값이 없으면 종료
		if (param == null)
			return null;

		// 전달 파라미터를 int형으로 변환
		int recipeno = Integer.parseInt(param);
		Recipe recipe = new Recipe();
		recipe.setRecipeno(recipeno);

		return recipe;
	}

	@Override
	public Recipe view(Recipe recipe, int i) {

		String viewdate = recipeDao.viewCheck(recipe, i);

		Date date = new Date();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");

		String today = transFormat.format(date);

		if (!viewdate.equals(today)) {
			System.out.println("되냐");
			recipeDao.insertHit(recipe, i);
		}

		return recipeDao.selectByRecipeno(recipe);
	}

	@Override
	public List<RecipeProcess> getProcess(HttpServletRequest req) {
		return recipeDao.selectProcess(Integer.parseInt(req.getParameter("recipeno")));
	}

	@Override
	public void scrap(HttpServletRequest req) {
		boolean chk = recipeDao.checkScrap(req);

		if (!chk) {

			recipeDao.scrapRecipe(req);

		} else {

			recipeDao.deleteScrap(req);
		}
	}

	@Override
	public List<RecipeIngredient> getIngredient(int recipeno, int category) {

		if (category == 1) {
			return recipeDao.selectMainIngredient(recipeno);
		} else if (category == 2) {
			return recipeDao.selectSubIngredient(recipeno);
		} else {
			return recipeDao.selectSeasoning(recipeno);
		}

	}

	@Override
	public Recommend getRecommend(HttpServletRequest req) {
		System.out.println("gd");

		// 전달파라미터 파싱
		int recipeno = 0;
//		System.out.println(recipeno);

		String param = req.getParameter("recipeno");
//		System.out.println("--"+param);

		if (param != null && !"".equals(param)) {
			recipeno = Integer.parseInt(param);
		}

		// 로그인한 아이디
		int userno = (int) req.getSession().getAttribute("userno");

		Recommend recommend = new Recommend();
		recommend.setRecipeno(recipeno);
		recommend.setUserno(userno);

//		System.out.println(recommend);
//		
		return recommend;
	}

	@Override
	public boolean recommend(Recommend recommendParam) {

		if (isRecommend(recommendParam)) {
			recommendDao.deleteRecommend(recommendParam);
			return false;
		} else {
			recommendDao.insertRecommend(recommendParam);
			return true;
		}
	}

	@Override
	public int getTotalCntRecommend(Recommend recommendParam) {
		return recommendDao.selectTatalCntRecommend(recommendParam);
	}

	@Override
	public boolean isRecommend(Recommend recommend) {
		int cnt = recommendDao.selectCntRecommend(recommend);

		if (cnt > 0) { // 추천했음
			return true;

		} else { // 추천하지 않았음
			return false;

		}
	}

	@Override
	public Paging getCount(HttpServletRequest req) {

		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		String search = (String) req.getParameter("search");

		int totalCount = recipeDao.selectCount(search);

		System.out.println(totalCount);

		Paging paging = new Paging(totalCount, curPage, 6);

		paging.setSearch(req.getParameter("search"));

		return paging;
	}

	@Override
	public List<Recipe> getrecipeno(HttpServletRequest req, Paging ingpaging) {
		String search = req.getParameter("search");

		return recipeDao.selectingreno(search, ingpaging);
	}

	@Override
	public Paging getMoreNamePaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");

		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		param = req.getParameter("search");

		String search = "";
		if (param != null && !"".equals(param)) {
			search = req.getParameter("search");
		}

		int totalCount = recipeDao.selectCntAll(search);

		Paging paging = new Paging(totalCount, curPage);

		paging.setSearch(req.getParameter("search"));

		return paging;
	}

	@Override
	public Paging getMoreIngrePaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");

		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 검색어
		param = req.getParameter("search");

		String search = "";
		if (param != null && !"".equals(param)) {
			search = req.getParameter("search");
		}

		int totalCount = recipeDao.selectCount(search);

		Paging paging = new Paging(totalCount, curPage);

		paging.setSearch(req.getParameter("search"));

		return paging;
	}
}