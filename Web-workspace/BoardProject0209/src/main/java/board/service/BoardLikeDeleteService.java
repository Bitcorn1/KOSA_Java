package board.service;

import board.dao.BoardLikeDao;
import board.dao.BoardLikeDeleteDao;
import board.vo.Board;

public class BoardLikeDeleteService {
	public int like(Board board) {
		BoardLikeDeleteDao dao = new BoardLikeDeleteDao();
		int result = dao.likedelete(board);
		return result;
}
}
