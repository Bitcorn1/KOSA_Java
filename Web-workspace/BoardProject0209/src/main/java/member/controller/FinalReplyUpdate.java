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

import board.service.FinalReplyUpdateService;
import board.service.ReplyService;
import board.vo.Reply;
import member.vo.MemberName;

/**
 * Servlet implementation class FinalReplyUpdate
 */
@WebServlet("/finalreplyupdate")
public class FinalReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalReplyUpdate() {
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
		HttpSession session = request.getSession(true);
		int replynum = ((Integer)session.getAttribute("replynum"));
		String replyContent = request.getParameter("replyContent");
		int bnum = ((Integer)session.getAttribute("bnum"));
		Reply reply = new Reply();
		reply.setReplyContent(replyContent);
		reply.setReplyNum(replynum);
		System.out.println(replynum);
		System.out.println(bnum);
		System.out.println(replyContent);
		FinalReplyUpdateService service = new FinalReplyUpdateService();
		
		Reply replys = new Reply();
		replys.setBoardnumber(bnum);
		
		List<Reply> list = null;
		
		int result = service.update(reply);
		
		if(result != 0) {
			
			ReplyService rservice = new ReplyService();
			list = rservice.finalreply(replys);
		}
		
		if(result != 0) {
			
			//session.setAttribute("replyupdate", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
			request.setAttribute("replyList", list);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginFail.html");
		}
		
	}

}
