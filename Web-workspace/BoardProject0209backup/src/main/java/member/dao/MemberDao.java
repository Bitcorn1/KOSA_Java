package member.dao;

import org.apache.ibatis.session.SqlSession;

import member.vo.Member;
import common.mybatis.MybatisConnectionFactory;

public class MemberDao {
	
	public Member select(Member member) {
	// 데이터베이스 처리를 하면되요!
	// Mybatis를 이용해서 Database처리를 할꺼에요!
	// SqlSession이라는게 있어야 해요! => 이걸 가지고 XML에 있는 Query를 실행할 수 있어요!
	// SqlSession은 누가 만들어 주나요? => SqlSessionFactory가 만들어줘요!
	// SqlSessionFactory가 있어야 해요! => 이 공장을 만들려면 데이터베이스 연결정보와 같은
	// XML 정보를 줘서 이 공장을 만들어줘야 해요! 공장만드는 팩토리빌더이용해서 공장만들고 공장에서 세션 찍어냄
	// sql 지정하는 xml, 공장 설정하는 xml 이거를 mapper라고 함
	// 이 공장 짓는 코드는 이미 어느 정도 정해져 있음
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		//ybatisConnectionFactory.getSqlSessionFactory() 공장가져옴
		//openSession(); 그 공장에서 세션 오픈
		Member result = sqlSession.selectOne("myMember.login", member);
	return result;
	}
}
