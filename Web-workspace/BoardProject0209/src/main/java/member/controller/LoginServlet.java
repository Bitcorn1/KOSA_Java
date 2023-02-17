package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;
import member.vo.MemberName;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userID");
		String userPw=request.getParameter("userPW");
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		MemberService service = new MemberService();
		Member result = service.login(member);
		List<MemberName> list = null;
		if(result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard(); 
		}
		
		
		if(result != null) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result); // vo 통채로 저장
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list);
			dispatcher.forward(request, response);
			// 이렇게 되면 한 번의 큰 과정이 끝난 것임
		} else {
			response.sendRedirect("loginFail.html");
			// 위 코드는 클라이언트에게 loginfail.html로 다시 접속하라는 코드
		}
	}

}
