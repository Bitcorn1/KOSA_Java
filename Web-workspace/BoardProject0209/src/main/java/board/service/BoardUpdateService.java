package board.service;

import board.dao.BoardUpdateDao;
import board.vo.Board;

public class BoardUpdateService {

	public int update(Board board) {
		BoardUpdateDao dao = new BoardUpdateDao();
		int result = dao.update(board);
		return result;
	}

}
