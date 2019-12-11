package web.dto;

public class Recommend {
	private int userno;
	private int recipeno;
	@Override
	public String toString() {
		return "Recommend [userno=" + userno + ", recipeno=" + recipeno + "]";
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getRecipeno() {
		return recipeno;
	}
	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}
	
		
	
		
}
