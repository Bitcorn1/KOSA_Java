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
import board.service.ReplyDeleteService;
import board.service.ReplyService;
import board.vo.Reply;
import member.vo.MemberName;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/replydelete")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
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
		String myid = request.getParameter("myId");
		String otherid = request.getParameter("otherId");
		int replynum = Integer.parseInt(request.getParameter("replynum"));
		Reply reply = new Reply();
		reply.setReplyNum(replynum);
		System.out.println(myid);
		ReplyDeleteService service = new ReplyDeleteService();
		List<Reply> list = null;
		
		
			
			int result = service.delete(reply);
			if(result != 0) {
				Reply replys = new Reply();
				replys.setBoardnumber(num);
				ReplyService rservice = new ReplyService();
				list = rservice.finalreply(replys);
			}
			
			if(result != 0) {
				
				session.setAttribute("replydelete", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
				request.setAttribute("replyList", list);
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
