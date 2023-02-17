package board.service;

import board.dao.DeleteDao;
import board.vo.Board;

public class BoardDeleteService {

	public int delete(Board board) {
		DeleteDao dao = new DeleteDao();
		int result = dao.delete(board);
		return result;
	}
	
}
