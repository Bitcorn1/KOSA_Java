package board.service;

import board.dao.ReplyDeleteDao;
import board.vo.Reply;

public class ReplyDeleteService {

	public int delete(Reply reply) {
		ReplyDeleteDao dao = new ReplyDeleteDao();
		int result = dao.delete(reply);
		return result;
	}

}
