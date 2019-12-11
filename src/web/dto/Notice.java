package web.dto;

public class Notice {
	
	private int noticeno;
	private int userno;
	private String notice;
	private String userid;
	
	@Override
	public String toString() {
		return "Notice [noticeno=" + noticeno + ", userno=" + userno + ", notice=" + notice + ", userid=" + userid
				+ "]";
	}
	public int getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
