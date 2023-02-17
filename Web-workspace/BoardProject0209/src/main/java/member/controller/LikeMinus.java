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

import board.service.BoardLikeDeleteService;
import board.service.BoardLikeService;
import board.service.BoardService;
import board.service.DeleteLikeService;
import board.service.LikeOneService;
import board.vo.Board;
import board.vo.LikeNum;
import member.vo.MemberName;

/**
 * Servlet implementation class LikeMinus
 */
@WebServlet("/likeminus")
public class LikeMinus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeMinus() {
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
		
		Board board = new Board();
		board.setBoardNum(num);
		
		BoardLikeDeleteService service = new BoardLikeDeleteService();
		List<MemberName> list = null;
		
		LikeNum likenumber1 = new LikeNum();
		likenumber1.setBoardNumber(num);
		likenumber1.setMyId(myid);
		
		DeleteLikeService service1 = new DeleteLikeService();
		
		LikeNum likenumber2 = new LikeNum();
		likenumber2.setBoardNumber(num);
		likenumber2.setMyId(myid);
		
		LikeOneService service2 = new LikeOneService();
		LikeNum result2 = service2.like(likenumber2);
		if(result2 != null) {
			
			
			
			
			
			if(!myid.equals(otherid)) {
				int result = service.like(board);
				int result1 = service1.delete(likenumber1);

				if(result != 0) {
					BoardService bservice = new BoardService();
					list = bservice.getAllBoard();
				}	
					
					
						
					
						session.setAttribute("like", list);
						RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
						request.setAttribute("boardList", list);
						dispatcher.forward(request, response);
					
//				} else {
//					response.sendRedirect("loginFail.html");
//				}
			} else {
				response.sendRedirect("loginFail.html");
				return;
			} }else {
				response.sendRedirect("loginFail.html");
				return;
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
