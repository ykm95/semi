package web.service.admin.admin_login;

import javax.servlet.http.HttpServletRequest;

import web.dto.Admin;

public interface AdminLoginService {
	
	/**
	 * 로그인 정보 파싱
	 * @param req-요청 정보 객체
	 * @return- 로그인 정보
	 */
	public Admin getLogin(HttpServletRequest req);

	/**
	 * 로그인 처리
	 * @param admin - 로그인 정보
	 * @return boolean - true(인증), false(비인증)
	 */
	public boolean login(Admin admin_login);
	
	public Admin getAdminByAdminid(Admin admin_login);
	
	public Admin getAdminParam(HttpServletRequest req);
}
