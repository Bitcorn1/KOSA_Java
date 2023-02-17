package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;

public class BoardOneDao {

	public Board select(Board board) {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		Board result = sqlSession.selectOne("myBoard.BoardOne", board);
		return result;
	}

}
