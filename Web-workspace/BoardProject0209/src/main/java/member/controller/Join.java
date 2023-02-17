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
import member.service.JoinService;
import member.vo.Member;
import member.vo.MemberName;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
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
		String userid= request.getParameter("userID");
		String username = request.getParameter("userName");
		String usernum = request.getParameter("userNumber");
		
		Member member = new Member();
		member.setMemberId(userid);
		member.setMemberName(username);
		member.setMemberPw(usernum);
		
		JoinService service = new JoinService();
		List<MemberName> list = null;
		int result = service.join(member);
		
		if(result != 0) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		if(result != 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("write", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			request.setAttribute("boardList", list);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginFail.html");
		}
		
	}

}
