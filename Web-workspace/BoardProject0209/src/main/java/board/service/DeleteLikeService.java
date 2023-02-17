package board.service;

import board.dao.BoardLikeDao;
import board.dao.DeleteLikeDao;
import board.vo.Board;
import board.vo.LikeNum;

public class DeleteLikeService {

	public int delete(LikeNum likenumber1) {
		DeleteLikeDao dao = new DeleteLikeDao();
		int result = dao.delete(likenumber1);
		return result;
	}
	
}
