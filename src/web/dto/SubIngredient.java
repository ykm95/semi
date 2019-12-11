package web.dto;

public class SubIngredient {
	
	private int subingno; //부재료번호
	private int recipeno; //레시피번호
	private String subingname; //부재료이름
	
	@Override
	public String toString() {
		return "SubIngredlient [subingno=" + subingno + ", recipeno=" + recipeno + ", subingname=" + subingname + "]";
	}

	public int getSubingno() {
		return subingno;
	}

	public void setSubingno(int subingno) {
		this.subingno = subingno;
	}

	public int getRecipeno() {
		return recipeno;
	}

	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}

	public String getSubingname() {
		return subingname;
	}

	public void setSubingname(String subingname) {
		this.subingname = subingname;
	}
	
	

}
