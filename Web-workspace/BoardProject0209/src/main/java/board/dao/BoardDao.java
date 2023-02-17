package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;
import member.vo.Member;
import member.vo.MemberName;

public class BoardDao {

	public List<MemberName> selectAll() {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<MemberName> result = sqlSession.selectList("myName.allBoards");
		sqlSession.close();
		return result;
	}

}
