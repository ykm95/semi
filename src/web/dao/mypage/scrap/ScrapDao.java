package web.dao.mypage.scrap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Scrap;

public interface ScrapDao {

	List<Scrap> selectAllScrap(HttpServletRequest req);

	void deleteScrap(HttpServletRequest req);

	int selectCntAll(HttpServletRequest req);

	List<Scrap> selectAllScrap(Paging paging, HttpServletRequest req);

}
