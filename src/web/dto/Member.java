package web.dto;

public class Member {
	private int userno;
	private String userid;
	private String userpw;
	private String email;
	private String nick;
	private String userpic;
	private String usercom;
	private String emailCheckNo;
	@Override
	public String toString() {
		return "Member [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", email=" + email + ", nick="
				+ nick + ", userpic=" + userpic + ", usercom=" + usercom + ", emailCheckNo=" + emailCheckNo + "]";
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getUsercom() {
		return usercom;
	}
	public void setUsercom(String usercom) {
		this.usercom = usercom;
	}
	public String getEmailCheckNo() {
		return emailCheckNo;
	}
	public void setEmailCheckNo(String emailCheckNo) {
		this.emailCheckNo = emailCheckNo;
	}
	
}
