package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인이라는 Transaction(작업)처리를 진행해요!
		// 하지만...로그인이라는 작업은 별다른 로직처리할게 없어요!
		// 데이터베이스 처리가 사실 전부에요!
		// 데이터베이스 처리를 여기서 하나요? 당연히 아니에요! => 따로 분리해서 퍼시스턴스레이어에서 처리 즉 DAO에서 해요!
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		return result;
	}
	
}
