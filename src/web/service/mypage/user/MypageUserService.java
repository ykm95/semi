package web.service.mypage.user;

import javax.servlet.http.HttpServletRequest;

public interface MypageUserService {

	void secessionUser(HttpServletRequest req);

	void updateCom(HttpServletRequest req);

}
