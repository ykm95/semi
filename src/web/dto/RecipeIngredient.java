package web.dto;

public class RecipeIngredient {
	private int recipeno;
	private int category;
	private int elementnum;
	private String ingrename;
	
	@Override
	public String toString() {
		return "RecipeIngredient [recipeno=" + recipeno + ", category=" + category + ", elementnum=" + elementnum
				+ ", ingrename=" + ingrename + "]";
	}
	
	public int getRecipeno() {
		return recipeno;
	}
	public void setRecipeno(int recipeno) {
		this.recipeno = recipeno;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getElementnum() {
		return elementnum;
	}
	public void setElementnum(int elementnum) {
		this.elementnum = elementnum;
	}
	public String getIngrename() {
		return ingrename;
	}
	public void setIngrename(String ingrename) {
		this.ingrename = ingrename;
	}
}