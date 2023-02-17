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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.service.BoardLikeService;
import board.service.BoardService;
import board.service.InsertLikeService;
import board.service.LikeOneService;
import board.service.LikenumLikeService;
import board.vo.Board;
import board.vo.LikeNum;
import member.vo.MemberName;

/**
 * Servlet implementation class LikeAjax
 */
@WebServlet("/likeajax")
public class LikeAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeAjax() {
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
		int num = Integer.parseInt(request.getParameter("bnum"));
		int likenum = Integer.parseInt(request.getParameter("likenum"));
		String myid = request.getParameter("myid");
		String otherid = request.getParameter("otherid");
		String liketitle = request.getParameter("liketitle");
		String likedate = request.getParameter("likedate");
		String likecontent = request.getParameter("likecontent");
		int ajaxresult = 0;
		int likeresult = -1;
		
		Board board = new Board();
		board.setBoardNum(num);
		
		BoardLikeService service = new BoardLikeService();
		List<MemberName> list = null;
//---------------------------------------------------------		
		LikeNum likenumber1 = new LikeNum();
		likenumber1.setBoardNumber(num);
		likenumber1.setMyId(myid);
		
		InsertLikeService service1 = new InsertLikeService();
		
//---------------------------------------------------------		
		LikeNum likenumber2 = new LikeNum();
		likenumber2.setBoardNumber(num);
		likenumber2.setMyId(myid);
				
		LikeOneService service2 = new LikeOneService();
		LikeNum result2 = service2.like(likenumber2);
		System.out.println(num);
		System.out.println(likenum);
		System.out.println(myid);
		System.out.println(otherid);
		if(result2 == null) {
			
			
			
			
			
			if(!myid.equals(otherid)) {
				int result = service.like(board);
				int result1 = service1.insert(likenumber1);

				if(result != 0) {
					BoardService bservice = new BoardService();
					list = bservice.getAllBoard();
				}	
					
					
				
				ajaxresult = 7;
				

			} else {
				ajaxresult = 4;
				
			} }else {
				ajaxresult = 1;
				
			}
		
		LikeNum likenumber3 = new LikeNum();
		likenumber3.setBoardNumber(num);
		
		
		LikenumLikeService lservice = new LikenumLikeService(); 
		likeresult = lservice.getLikenumLike(likenumber3);
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("ajaxresult", ajaxresult);
		jsonObject.addProperty("likeresult", likeresult);
		String find = gson.toJson(jsonObject);
		response.getWriter().write(find);
		
	}

}
