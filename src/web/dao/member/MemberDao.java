package web.dao.member;

import web.dto.Member;

public interface MemberDao {

	public void insert(Member member);

	public int selectCntMemberByUserid(Member member_login);

	public Member selectMemberByUserid(Member member_login);

	public int selectCntByUserid(Member userid);

	public int selectCntMemberByUserid_1(Member member_id);

	public Member selectMemberByUserid_1(Member member_id);

	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 랜덤생성한 이메일인증 코드를 DB에 업데이트
	 * 
	 * @param member - 이메일 인증 코드가 담겨있는 member 객체
	 */
	public void updateEmailCheckNo(Member member);
	
	/**
	 * 2019-12-03
	 * 김덕진
	 * 
	 * 이메일 인증코드 가져오기
	 * 
	 * @param mebmer - 이메일이 담겨있는 객체
	 * @return Member - 이메일 인증번호가 담겨있는 객체
	 */
	public Member selectEmailCheckNo(Member mebmer);

	public Member selectPwByUserid(Member member);

	public int selectCntMemberByUserid_2(Member member);

	public void changePw(Member changepw);
	
}
