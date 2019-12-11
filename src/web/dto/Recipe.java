package web.dto;

import java.io.File;

public class Recipe {
	private int recipeno;
	private int userno;
	private String nick;
	private String recipename;
	private String recipeex;
	private String recipic;
	private int category;
	private int ocassion;
	private int hit;
	private String userid;
	
	@Override
	public String toString() {
		return "Recipe [recipeno=" + recipeno + ", userno=" + userno + ", nick=" + nick + ", recipename=" + recipename
				+ ", recipeex=" + recipeex + ", recipic=" + recipic + ", category=" + category + ", ocassion="
				+ ocassion + ", hit=" + hit + ", userid=" + userid + "]";
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getRecipename() {
		return recipename;
	}
	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}
	public String getRecipeex() {
		return recipeex;
	}
	public void setRecipeex(String recipeex) {
		this.recipeex = recipeex;
	}
	public String getRecipic() {
		return recipic;
	}
	public void setRecipic(String recipic) {
		this.recipic = recipic;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getOcassion() {
		return ocassion;
	}
	public void setOcassion(int ocassion) {
		this.ocassion = ocassion;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

}