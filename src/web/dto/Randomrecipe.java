package web.dto;

import java.io.File;

public class Randomrecipe {
	private int ranmenuno;
	private String ranmenuname;
	private String ranmenupic;
	
	
	@Override
	public String toString() {
		return "Randomrecipe [ranmenuno=" + ranmenuno + ", ranmenuname=" + ranmenuname + ", ranmenupic=" + ranmenupic
				+ "]";
	}
	
	
	public int getRanmenuno() {
		return ranmenuno;
	}
	public void setRanmenuno(int ranmenuno) {
		this.ranmenuno = ranmenuno;
	}
	public String getRanmenuname() {
		return ranmenuname;
	}
	public void setRanmenuname(String ranmenuname) {
		this.ranmenuname = ranmenuname;
	}
	public String getRanmenupic() {
		return ranmenupic;
	}
	public void setRanmenupic(String ranmenupic) {
		this.ranmenupic = ranmenupic;
	}
}