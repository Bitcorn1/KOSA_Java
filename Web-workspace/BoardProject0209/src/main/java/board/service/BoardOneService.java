package board.service;

import board.dao.BoardOneDao;
import board.vo.Board;

public class BoardOneService {

	public Board selectBoardByNum(Board board) {
		BoardOneDao dao = new BoardOneDao();
		Board result=dao.select(board);
		return result;
	}
		
}
