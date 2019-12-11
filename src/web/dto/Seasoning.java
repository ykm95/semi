package web.dto;

public class Seasoning {

	private int seasno; //양념번호
	private int recipeno; //레시피번호
	private String seasname; //양념이름
	
	@Override
	public String toString() {
		return "Seasoning [seasno=" + seasno + ", recipeno=" + recipeno + ", seasname=" + seasname + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getSeasno() {
		return seasno;
	}

	public void setSeasno(int seasno) {
		this.seasno = seasno;
	}

	public int getRecipeno() {
		return recipeno;
	}

	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}

	public String getSeasname() {
		return seasname;
	}

	public void setSeasname(String seasname) {
		this.seasname = seasname;
	}
	
	
}
