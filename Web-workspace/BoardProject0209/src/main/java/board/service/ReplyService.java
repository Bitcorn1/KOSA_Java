package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.ReplyDao;
import board.vo.Reply;
import member.vo.MemberName;


public class ReplyService {

	public List<Reply> finalreply(Reply reply) {
		ReplyDao dao = new ReplyDao();
		List<Reply> list = dao.select(reply);
		return list;
	}

	

}
