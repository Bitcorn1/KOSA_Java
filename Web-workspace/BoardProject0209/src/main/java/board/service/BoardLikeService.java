package board.service;

import board.dao.BoardLikeDao;
import board.vo.Board;

public class BoardLikeService {
	public int like(Board board) {
		BoardLikeDao dao = new BoardLikeDao();
		int result = dao.likeupdate(board);
		return result;
}
}