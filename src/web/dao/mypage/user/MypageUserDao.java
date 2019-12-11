package web.dao.mypage.user;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MypageUserDao {

	void secessionUserByUserno(HttpServletRequest req);

	void updateUserComment(HttpServletRequest req);

	void updateUserPic(Member member);

}
