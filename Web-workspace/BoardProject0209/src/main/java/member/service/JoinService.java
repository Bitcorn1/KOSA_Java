package member.service;

import member.dao.JoinDao;
import member.vo.Member;

public class JoinService {

	public int join(Member member) {
		JoinDao dao = new JoinDao();
		int result = dao.insert(member);
		return result;
	}

}
