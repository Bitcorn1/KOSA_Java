package board.service;

import board.dao.WriteDao;
import board.vo.Board;
import member.controller.Write;

public class WriteService {
	public int write(Board board) {
		WriteDao dao = new WriteDao();
		int result = dao.insert(board);
		return result;
	}
}
