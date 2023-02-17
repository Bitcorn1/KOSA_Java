package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;
import member.vo.MemberName;

public class BoardService {

	public List<MemberName> getAllBoard() {
		BoardDao dao = new BoardDao();
		List<MemberName> list = dao.selectAll();
		return list;
	}

}
