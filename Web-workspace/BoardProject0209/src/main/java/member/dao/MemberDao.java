package member.dao;

import org.apache.ibatis.session.SqlSession;

import member.vo.Member;
import common.mybatis.MybatisConnectionFactory;

public class MemberDao {
	
	public Member select(Member member) {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		//ybatisConnectionFactory.getSqlSessionFactory() 공장가져옴
		//openSession(); 그 공장에서 세션 오픈
		Member result = sqlSession.selectOne("myMember.login", member);
	return result;
	}
}
