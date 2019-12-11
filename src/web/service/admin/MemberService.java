package web.service.admin;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	public Member getMemParam(HttpServletRequest req);
	
	public void join(Member member);

	public Member getLoginMember(HttpServletRequest req);

	public boolean login(Member member_login);

	public Member getMemberByUserid(Member member_login);

	
}
