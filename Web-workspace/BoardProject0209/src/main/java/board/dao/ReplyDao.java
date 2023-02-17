package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import board.vo.Reply;
import common.mybatis.MybatisConnectionFactory;
import member.vo.MemberName;

public class ReplyDao {

	public List<Reply> select(Reply reply) {
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Reply> result = sqlSession.selectList("myReply.listReply", reply);
		sqlSession.close();
		return result;
	}

}
