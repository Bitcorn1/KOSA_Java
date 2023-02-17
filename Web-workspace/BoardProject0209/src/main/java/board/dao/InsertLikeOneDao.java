package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.LikeNum;
import common.mybatis.MybatisConnectionFactory;

public class InsertLikeOneDao {

	public int insert(LikeNum likenumber1) {
		int result = 0;
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
		result = sqlSession.insert("mylike.insertlike", likenumber1);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
			} return result;
	}

}
