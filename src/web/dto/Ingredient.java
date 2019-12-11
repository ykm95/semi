package web.dto;

public class Ingredient {
	
	private int ingreno; //재료번호
	private int recipeno; //레시피번호
	private String ingrename; //재료이름
	
	@Override
	public String toString() {
		return "Ingredlient [ingreno=" + ingreno + ", recipeno=" + recipeno + ", ingrename=" + ingrename + "]";
	}

	public int getIngreno() {
		return ingreno;
	}

	public void setIngreno(int ingreno) {
		this.ingreno = ingreno;
	}

	public int getRecipeno() {
		return recipeno;
	}

	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}

	public String getIngrename() {
		return ingrename;
	}

	public void setIngrename(String ingrename) {
		this.ingrename = ingrename;
	}
	
	

}
