package board.service;

import board.dao.LikenumLikeDao;
import board.vo.LikeNum;

public class LikenumLikeService {

	public int getLikenumLike(LikeNum likenumber3) {
		LikenumLikeDao dao = new LikenumLikeDao();
		int count = dao.countAll(likenumber3);
		return count;
	}

}
