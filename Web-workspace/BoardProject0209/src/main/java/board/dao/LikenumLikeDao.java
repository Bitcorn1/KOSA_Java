package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.LikeNum;
import common.mybatis.MybatisConnectionFactory;
import member.vo.MemberName;

public class LikenumLikeDao {

	public int countAll(LikeNum likenumber3) {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		int result = sqlSession.selectOne("mylike.countlike", likenumber3);
		sqlSession.close();
		return result;
	}

}
