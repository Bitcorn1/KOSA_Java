package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisConnectionFactory;
import vo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid  = request.getParameter("userID");
		String password = request.getParameter("userPW");
		
		User user = new User();
		user.setId(userid);
		user.setPassword(password);
		
		SqlSession sqlsession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		User result = sqlsession.selectOne("myUser.selectUserById", user);
		sqlsession.close();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<ul>");
		
		if (result != null) {
			// 로그인 성공
			// 로그인한 흔적을 남기기 위해 servlet container에게 session 객체를 요청해요!
			HttpSession session = request.getSession(true); 
			// true는 만약 기존에 내가 할당받은 세션 객체가 있으면 그거 주세요!
			// 그리고 기존에 할당받은 세션객체가 없으면 만들어 주세요! 아무튼 어떻든 객체가 만들어짐
			// 이 세션객체는 map 형태에요
			session.setAttribute("loginName", result.getName());
			out.println(result.getName()+"님 환영합니다");
			out.println("<br><br>");
			out.println("<a href='board'>게시판 들어가기</a>");
		} else {
			out.println("로그인에 실패했습니다.");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}

}
