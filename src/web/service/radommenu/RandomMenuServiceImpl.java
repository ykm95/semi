package web.service.radommenu;

import java.util.List;

import web.dao.randommenu.RandomMenuDao;
import web.dao.randommenu.RandomMenuDaoImpl;
import web.dto.Randomrecipe;

public class RandomMenuServiceImpl implements RandomMenuService{

	private RandomMenuDao randomMenuDao = new RandomMenuDaoImpl();
	
	@Override
	public int getParam() {
		
		List<Randomrecipe> randomMenu = randomMenuDao.randomMenuno();
		
		int menuno = (int)(Math.random()*randomMenu.size()+1);
		
		return menuno;
	}

	@Override
	public Randomrecipe getRandomrecipe(Randomrecipe randomrecipe) {
		
		return randomMenuDao.selectByMenuno(randomrecipe);
	}
	
}