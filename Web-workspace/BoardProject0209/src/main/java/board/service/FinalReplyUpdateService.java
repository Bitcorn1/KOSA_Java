package board.service;

import board.dao.FinalReplyUpdateDao;
import board.vo.Reply;

public class FinalReplyUpdateService {

	public int update(Reply reply) {
		FinalReplyUpdateDao dao = new FinalReplyUpdateDao();
		int result = dao.update(reply);
		return result;
	}

}
