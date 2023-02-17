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
import board.service.ReplyService;
import board.vo.Board;
import board.vo.Reply;
import member.vo.MemberName;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		int num = Integer.parseInt(request.getParameter("num"));
		Board board = new Board();
		board.setBoardNum(num);
		System.out.println(num);
		BoardOneService service = new BoardOneService();
		
		Board result = service.selectBoardByNum(board);
		
		Reply reply = new Reply();
		reply.setBoardnumber(num);
		
		
		
		
		List<Reply> rlist = null;
		// 마이바티스로부터 selectlist 해서 가져오겠지
		if(result != null) {
			ReplyService rservice = new ReplyService();
			rlist = rservice.finalreply(reply); // 보드를 가지고 있는 어레이 리스트를 하나 가지고 오겠다.
		}
		
		if (result != null) {
			
			session.setAttribute("board", result); // vo 통채로 저장
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
			request.setAttribute("replyList", rlist);
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
