package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		return result;
	}
	
}
