package web.dao.randommenu;

import java.util.List;

import web.dto.Randomrecipe;

public interface RandomMenuDao {

	public List<Randomrecipe> randomMenuno();

	public Randomrecipe selectByMenuno(Randomrecipe randomrecipe);
	
}