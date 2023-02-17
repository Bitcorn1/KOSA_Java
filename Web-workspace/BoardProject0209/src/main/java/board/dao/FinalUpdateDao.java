package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;

public class FinalUpdateDao {

	public int update(Board board) {
		int result = 0;
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
		result = sqlSession.insert("myBoard.BoardUpdate", board);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
			} return result;
		}
	}


