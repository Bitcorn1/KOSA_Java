package board.service;

import board.dao.FinalUpdateDao;
import board.dao.WriteDao;
import board.vo.Board;

public class FinalUpdateService {

	public int finalupdate(Board board) {
		FinalUpdateDao dao = new FinalUpdateDao();
		int result = dao.update(board);
		return result;
	}

}
