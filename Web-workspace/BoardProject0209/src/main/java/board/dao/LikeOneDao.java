package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import board.vo.LikeNum;
import common.mybatis.MybatisConnectionFactory;
import member.controller.Like;

public class LikeOneDao {

	public LikeNum select(LikeNum likenumber2) {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		LikeNum result = sqlSession.selectOne("mylike.likeOne", likenumber2);
		return result;
	}

}
