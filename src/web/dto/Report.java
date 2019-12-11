package web.dto;

public class Report {
	
	private int reportno;
	private int recipeno;
	private String recipename;
	private int userno;
	private String userid;
	private String repocontent;
	private String repotitle;
	
	@Override
	public String toString() {
		return "Report [reportno=" + reportno + ", recipeno=" + recipeno + ", recipename=" + recipename + ", userno="
				+ userno + ", userid=" + userid + ", repocontent=" + repocontent + ", repotitle=" + repotitle + "]";
	}


	public int getReportno() {
		return reportno;
	}


	public void setReportno(int reportno) {
		this.reportno = reportno;
	}


	public int getRecipeno() {
		return recipeno;
	}


	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}


	public String getRecipename() {
		return recipename;
	}


	public void setRecipename(String recipename) {
		this.recipename = recipename;
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


	public String getRepocontent() {
		return repocontent;
	}


	public void setRepocontent(String repocontent) {
		this.repocontent = repocontent;
	}


	public String getRepotitle() {
		return repotitle;
	}


	public void setRepotitle(String repotitle) {
		this.repotitle = repotitle;
	}
	
}