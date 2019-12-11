package web.service.mypage.scrap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.mypage.scrap.ScrapDao;
import web.dao.mypage.scrap.ScrapDaoImpl;
import web.dto.Scrap;

public class ScrapServiceImpl implements ScrapService {

	ScrapDao scrapDao = new ScrapDaoImpl();
	
	@Override
	public List<Scrap> getScrap(HttpServletRequest req) {
		
		return scrapDao.selectAllScrap(req);
	}

	@Override
	public void delete(HttpServletRequest req) {
		
		scrapDao.deleteScrap(req);
		
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {

		//요청파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = scrapDao.selectCntAll(req);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		paging.setListCount(6);
		
		if(req.getParameter("search")!=null&&!"".equals(req.getParameter("search"))) {
			paging.setSearch(req.getParameter("search"));
		}
		
		return paging;
		
	}

	@Override
	public List<Scrap> getScrap(Paging paging, HttpServletRequest req) {
		
		return scrapDao.selectAllScrap(paging, req);
	}


}
