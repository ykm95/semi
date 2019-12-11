package web.service.admin.admin_user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dao.admin.admin_user.UserAdminDao;
import web.dao.admin.admin_user.UserAdminDaoImpl;
import web.dto.Member;


public class UserAdminServiceImpl implements UserAdminService{

	private UserAdminDao userAdminDao = new UserAdminDaoImpl();

	@Override
	public List<Member> getList() {
		return userAdminDao.selectAll();
	}

	@Override
	public List<Member> getList(Paging paging) {
		return userAdminDao.selectAll(paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage =Integer.parseInt(param);
		}
		//		System.out.println("curPage : " + curPage);

		//검색어
		String search = (String)req.getParameter("search");
		
		//Board TB와 curPage 값을 이용해 Paging 객체를 생성하고 반환
		int totalcount = userAdminDao.selectCntAll(search);

		//Paging 객체 생성
		Paging paging = new Paging(totalcount, curPage);

		//검색어
		paging.setSearch(search);
		return paging;
	}

	@Override
	public Member getUserno(HttpServletRequest req) {
		//요청파라미터 userno를 파싱한다
		String param = req.getParameter("userno");
		int userno = 0;
		if( param!=null && !"".equals(param) ) {
			userno = Integer.parseInt(param);
		}

		// 회원번호를 DTO에 넣기
		Member userAdmin = new Member();
		userAdmin.setUserno(userno);

		return userAdmin;

	}

	@Override
	public void delete(Member userAdmin) {
		userAdminDao.delete(userAdmin);
		
	}



}
