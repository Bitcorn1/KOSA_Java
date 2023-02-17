package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;
import member.vo.Member;

public class BoardDao {

	public List<Board> selectAll() {
		// Database처리만 하면 되요!
		// MyBatis 이용해요!
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Board> result = sqlSession.selectList("myBoard.allBoards");
		sqlSession.close();
		return result;
	}

}
