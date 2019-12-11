package web.service.member;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	public Member getMemParam(HttpServletRequest req);
	
	public void join(Member member);

	public Member getLoginMember(HttpServletRequest req);

	public boolean login(Member member_login);

	public Member getMemberByUserid(Member member_login);

	public Member getId(HttpServletRequest req);

	public boolean idCheck(Member userid);

	public Member getMemId(HttpServletRequest req);

	public boolean id_check(Member member_id);

	public Member getMemberByUserid_1(Member member_id);
	
	
	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 이메일 전송 메서드
	 * 
	 * @param member - 이메일이 담겨져있는 멤버 객체
	 */
	public void emailAuth(Member member);
	
	
	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 이메일 인증코드 생성
	 * 
	 * @param len - 인증 코드 길이
	 */
	public String getRamdomEmailCode(int len);
	
	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 이메일 인증번호를 업데이트
	 * 
	 * @param member - 업데이트 시킬 이메일 인증번호가 담겨있는 객체
	 */
	public void changeEmailCheckNo(Member member);
	
	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 이메일 인증 번호 가져오기
	 * 
	 * @param member - 이메일 인증 번호가 있는 객체
	 */
	public Member getEmailCheckNo(Member member);

	/**
	 * 12-03
	 * 김덕진
	 * @param member 본인이 입력한 ID
	 * 
	 */
	
	public Member getPwByMemberId(Member member);

	public boolean check_pw(Member member);

	public Member getChPw(HttpServletRequest req);

	public Member getChangdPw(Member changepw);

	
}
