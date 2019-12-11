package web.service.mypage.scrap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Scrap;

public interface ScrapService {

	List<Scrap> getScrap(HttpServletRequest req);

	void delete(HttpServletRequest req);

	Paging getPaging(HttpServletRequest req);

	List<Scrap> getScrap(Paging paging, HttpServletRequest req);


}
