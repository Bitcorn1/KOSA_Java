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

import board.service.BoardOneService;
import board.service.BoardService;
import board.service.BoardUpdateService;
import board.vo.Board;
import member.vo.Member;
import member.vo.MemberName;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		HttpSession session = request.getSession(true);
		int bnum = ((Integer)session.getAttribute("boardnum"));
		String userTitle= request.getParameter("userTitle");
		String userContent = request.getParameter("userContent");
		
		
		
		Board board = new Board();
		board.setBoardTitle(userTitle);
		board.setBoardContent(userContent);
		board.setBoardNum(bnum);
		
		BoardUpdateService service = new BoardUpdateService();
		
		
		List<MemberName> list = null;
		
		
		int result = service.update(board);
		
		if(result != 0) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
			
		}
		
		if(result != 0) {
			
			session.setAttribute("update", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list);
			dispatcher.forward(request, response);
			
		} else {
			response.sendRedirect("loginFail.html");
		}
	

	}
}