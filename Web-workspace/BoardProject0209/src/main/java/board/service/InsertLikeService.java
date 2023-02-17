package board.service;

import board.dao.InsertLikeOneDao;
import board.vo.LikeNum;

public class InsertLikeService {

	public int insert(LikeNum likenumber1) {
		InsertLikeOneDao dao = new InsertLikeOneDao();
		int result = dao.insert(likenumber1);
		return result;
	}

}
