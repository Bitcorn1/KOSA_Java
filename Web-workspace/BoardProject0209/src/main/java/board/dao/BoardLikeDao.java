package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;

public class BoardLikeDao {

	public int likeupdate(Board board) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlSession.update("myBoard.BoardLike", board);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
		} return result;
	}
	
	
}
