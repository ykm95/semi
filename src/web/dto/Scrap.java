package web.dto;

public class Scrap {
	
	private int scrapno;
	private int recipeno;
	private String recipename;
	private int userno;
	private String username;
	private String recipic;
	
	
	@Override
	public String toString() {
		return "Scrap [scrapno=" + scrapno + ", recipeno=" + recipeno + ", recipename=" + recipename + ", userno="
				+ userno + ", username=" + username + ", recipic=" + recipic + "]";
	}


	public int getScrapno() {
		return scrapno;
	}


	public void setScrapno(int scrapno) {
		this.scrapno = scrapno;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRecipic() {
		return recipic;
	}


	public void setRecipic(String recipic) {
		this.recipic = recipic;
	}
	
}
