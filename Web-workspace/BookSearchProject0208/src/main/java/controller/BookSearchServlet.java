package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리!
		request.setCharacterEncoding("UTF-8");
		// 1. 입력을 받아보아요!
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		// 2. 로직처리해야 해요(데이터베이스 처리 포함해서!)
		// MyBatis 세팅부터 하고 왔어요!
		// 1. sqlSessionFactory 설정,(SqlMapConfig.xml)
		// 2. 연결정보 따로 분리해서 설정(driver.properties)
		// 3. SQL을 실행하기 위한 mapper 설정(sqlmap/Book.xml)
		
		// 클라이언트가 보내준 데이터를 이용해서 VO를 생성, sql 실행하기위해 데이터 두 개 키워드 프라이스 동시에 VO로만들어서 보내겠다!!
		Book book = new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		
		SqlSession session =
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		// opensession해야 세션이열리고 sql구문이 실행이됨		
		
		List<Book> result = session.selectList("myBook.selectBookByKeyword", book);
		// sql구문에서 select한 결과가 여러개구나!!!! () 안에는 어떤 sql인지 지정해야지 여기에 네임스페이스와 아이디입력해줘야지
		// sql 실행하려면 parametertype이 있어야 하는데 그게 아까 book이었지 book을 넣어줘야함 book 가지고 sql 구문 실행해라
		// 저 sql구문ㅎ수행하면 결과가 여러개잖아 그게 리스트로 나오게 되잖소
		// 다 끝나면 세션 클로스 닫아줌
		session.close();
		
		// 3. 결과출력!
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워드: " + keyword + "</h3>");
		out.println("<h3>검색가격: " + price + "</h3>");
		out.println("<ul>");
		
		for (Book tmp: result) {
			out.println("<li>" + tmp.getBtitle() + "," + tmp.getBprice() + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}

}
