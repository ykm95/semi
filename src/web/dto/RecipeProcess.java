package web.dto;

public class RecipeProcess {
	private int processno;
	private int recipeno;
	private String processex;
	private String processpic;
	
	
	@Override
	public String toString() {
		return "RecipeProcess [processno=" + processno + ", recipeno=" + recipeno + ", processex=" + processex
				+ ", processpic=" + processpic + "]";
	}


	public int getProcessno() {
		return processno;
	}
	public void setProcessno(int processno) {
		this.processno = processno;
	}
	public int getRecipeno() {
		return recipeno;
	}
	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}
	public String getProcessex() {
		return processex;
	}
	public void setProcessex(String processex) {
		this.processex = processex;
	}
	public String getProcesspic() {
		return processpic;
	}
	public void setProcesspic(String processpic) {
		this.processpic = processpic;
	}
}