package web.dto;

public class Comment {
	private int rownum;
	private int commentno;
	private int recipeno;
	private int userno;
	private String comcontent;
	private String userid;

	
	@Override
	public String toString() {
		return "Comment [rownum=" + rownum + ", commentno=" + commentno + ", recipeno=" + recipeno + ", userno="
				+ userno + ", comcontent=" + comcontent + ", userid=" + userid + "]";
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getCommentno() {
		return commentno;
	}

	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}

	public int getRecipeno() {
		return recipeno;
	}

	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getComcontent() {
		return comcontent;
	}

	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}
	
}