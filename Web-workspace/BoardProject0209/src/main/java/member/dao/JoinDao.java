package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MybatisConnectionFactory;
import member.vo.Member;

public class JoinDao {

	public int insert(Member member) {
		int result = 0;
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
		result = sqlSession.insert("myMember.join", member);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
			} return result;
		}
	}


