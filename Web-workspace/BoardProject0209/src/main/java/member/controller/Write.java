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
import board.service.WriteService;
import board.vo.Board;
import member.vo.MemberName;

/**
 * Servlet implementation class Write
 */
@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
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
		// HttpSession session1 = request.getSession();
		HttpSession session = request.getSession(true);
		String memberid = ((String)session.getAttribute("memberid"));
		String userTitle= request.getParameter("userTitle");
		String userContent = request.getParameter("userContent");
		
		
		Board board = new Board();
		board.setBoardTitle(userTitle);
		board.setBoardContent(userContent);
		board.setBoardAuthor(memberid);
		
		WriteService service = new WriteService();
		List<MemberName> list = null;
		
		
		int result = service.write(board);
		
		if(result != 0) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		if(result != 0) {
			
			session.setAttribute("write", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WriteSuccess.jsp");
			request.setAttribute("boardList", list);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginFail.html");
		}
		
		
		
	}

}
