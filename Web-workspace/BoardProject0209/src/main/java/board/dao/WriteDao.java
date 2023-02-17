package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;
import member.controller.Write;

public class WriteDao {

	public int insert(Board board) {
		int result = 0;
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
		result = sqlSession.insert("myBoard.writeBoard", board);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
			} return result;
		}
	}


