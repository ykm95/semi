package web.service.admin.admin_login;

import javax.servlet.http.HttpServletRequest;

import web.dao.admin.admin_login.AdminLoginDao;
import web.dao.admin.admin_login.AdminLoginDaoImpl;
import web.dto.Admin;

public class AdminLoginServiceImpl implements AdminLoginService{

	//AdminDao 객체
	private AdminLoginDao adminDao = new AdminLoginDaoImpl();

	@Override
	public Admin getLogin(HttpServletRequest req) {
		Admin admin = new Admin();
		String param =null;
		
		param=req.getParameter("adminid");
		admin.setAdminid(param);
		
		param=req.getParameter("adminpw");
		admin.setAdminpw(param);
		
		return admin;
	}

	@Override
	public boolean login(Admin admin_login) {
		
		int result = adminDao.selectCntAdminByAdminidAndAdminpw(admin_login);
		
		if(result == 1) {
			//로그인 성공
			return true;
		}else {
			//로그인 실패
			return false;
	}
	}

	@Override
	public Admin getAdminByAdminid(Admin admin_login) {
		return adminDao.selectAdminByAdminid(admin_login);
	}

	@Override
	public Admin getAdminParam(HttpServletRequest req) {
		
		Admin admin = new Admin();
		String param =null;
		
		param=req.getParameter("adminid");
		admin.setAdminid(param);
		
		param=req.getParameter("adminpw");
		admin.setAdminpw(param);
		
		return admin;
	}
}