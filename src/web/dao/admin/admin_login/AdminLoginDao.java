package web.dao.admin.admin_login;

import web.dto.Admin;

public interface AdminLoginDao {
	
	/**
	 * Adminid 와 Adminpw가 일치 조회
	 * @param Admin
	 * @return
	 */
	
	public int selectCntAdminByAdminidAndAdminpw(Admin admin_login);

	public Admin selectAdminByAdminid(Admin admin_login);
}
