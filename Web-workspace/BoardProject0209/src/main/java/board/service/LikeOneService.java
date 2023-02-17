package board.service;

import board.dao.LikeOneDao;
import board.vo.LikeNum;
import member.controller.Like;

public class LikeOneService {

	public LikeNum like(LikeNum likenumber2) {
		LikeOneDao dao = new LikeOneDao();
		LikeNum result = dao.select(likenumber2);
		return result;
	}
	
}
