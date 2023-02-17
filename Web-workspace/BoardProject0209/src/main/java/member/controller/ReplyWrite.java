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
import board.service.ReplyService;
import board.service.ReplyWriteService;
import board.vo.Reply;
import member.vo.MemberName;

/**
 * Servlet implementation class ReplyWrite
 */
@WebServlet("/replywrite")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyWrite() {
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
		HttpSession session = request.getSession(false);
		int num = (Integer)session.getAttribute("replynum");
		String otherid = (String)session.getAttribute("otherid");
		String memberid = ((String)session.getAttribute("memberid"));
		String replycontent = request.getParameter("replyContent");
		System.out.println(num);
		System.out.println(memberid);
		System.out.println(replycontent);
		System.out.println(otherid);
		
		
		Reply reply = new Reply();
		reply.setReplyContent(replycontent);
		reply.setReplyAuthor(memberid);
		reply.setBoardnumber(num);
		reply.setBoardAuthor(otherid);
		
		
		
		ReplyWriteService service = new ReplyWriteService();
		List<Reply> list = null;
		
		
		
			int result = service.replywrite(reply);
			
			if(result != 0) {
				Reply replys = new Reply();
				replys.setBoardnumber(num);
				ReplyService rservice = new ReplyService();
				list = rservice.finalreply(replys);
			}
			
			if(result != 0) {
				
				session.setAttribute("reply", list);
				request.setAttribute("replyList", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
				
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("loginFail.html");
			}
		
		
	}

}
