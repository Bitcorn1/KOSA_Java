package board.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.Reply;
import common.mybatis.MybatisConnectionFactory;

public class ReplyWriteDao {

	public int insert(Reply reply) {
		int result = 0;
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
		result = sqlSession.insert("myReply.writeReply", reply);
		} catch (Exception e) {
			e.printStackTrace(); } finally {
				sqlSession.commit();
				sqlSession.close();
			} return result;
	}

}
