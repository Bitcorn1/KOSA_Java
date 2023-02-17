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

import board.service.BoardDeleteService;
import board.service.BoardService;
import board.vo.Board;
import member.vo.MemberName;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			int num = Integer.parseInt(request.getParameter("num"));
			String myid = request.getParameter("myId");
			String otherid = request.getParameter("otherId");
			
			
			Board board = new Board();
			board.setBoardNum(num);
			
			BoardDeleteService service = new BoardDeleteService();
			List<MemberName> list = null;
			
			
			if(myid.equals(otherid)) {
				System.out.println(myid);
				int result = service.delete(board);
				if(result != 0) {
					BoardService bservice = new BoardService();
					list = bservice.getAllBoard();
				}
				
				if(result != 0) {
					HttpSession session = request.getSession(true);
					session.setAttribute("delete", list);
					RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
					request.setAttribute("boardList", list);
					dispatcher.forward(request, response);
				} else {
					response.sendRedirect("loginFail.html");
				}
			} else {
				response.sendRedirect("loginFail.html");
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
