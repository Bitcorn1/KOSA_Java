package board.service;

import board.dao.ReplyWriteDao;
import board.vo.Reply;

public class ReplyWriteService {

	public int replywrite(Reply reply) {
		ReplyWriteDao dao = new ReplyWriteDao();
		int result = dao.insert(reply);
		return result;
	}

}
