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
import board.service.ReplyService;
import board.vo.Board;
import board.vo.Reply;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/replyupdate")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int num = Integer.parseInt(request.getParameter("num"));
		String myid = request.getParameter("myId");
		String otherid = request.getParameter("otherId");
		int replynum = Integer.parseInt(request.getParameter("replynum"));
		
		Board board = new Board();
		board.setBoardNum(num);
		System.out.println(num);
		
		BoardOneService service = new BoardOneService();
		
		Board result = service.selectBoardByNum(board);
		
		Reply reply = new Reply();
		reply.setBoardnumber(num);
		
		
		
		
		List<Reply> rlist = null;
		
		if(result != null) {
			ReplyService rservice = new ReplyService();
			rlist = rservice.finalreply(reply); // 보드를 가지고 있는 어레이 리스트를 하나 가지고 오겠다.
		}
		
		if (result != null) {
			session.setAttribute("myid", myid);
			session.setAttribute("replynum", replynum);
			session.setAttribute("boardnum", num);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReplyUpdate.jsp");
			
			System.out.println(num);
			
			dispatcher.forward(request, response);
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
