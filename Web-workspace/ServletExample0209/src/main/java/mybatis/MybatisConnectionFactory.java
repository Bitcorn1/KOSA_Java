package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	   
	   static {
	      // 공장을 만들 때 필요한 XML 설정 파일
	      String resource = "./SqlMapConfig.xml"; 
	      try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         
	         if( sqlSessionFactory == null ) {
	        	 // XML 설정을 이용해서 공장객체를 만들어요! 팩토리 빌더가 공장을 만드는 것임
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   
	   public static SqlSessionFactory getSqlSessionFactory() {
	      return sqlSessionFactory;
	   }
}
