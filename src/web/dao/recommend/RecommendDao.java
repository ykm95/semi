package web.dao.recommend;

import web.dto.Recommend;

public interface RecommendDao {

	public int selectCntRecommend(Recommend recommend);

	public void deleteRecommend(Recommend recommend);

	public void insertRecommend(Recommend recommend);

	public int selectTatalCntRecommend(Recommend recommend);

}
