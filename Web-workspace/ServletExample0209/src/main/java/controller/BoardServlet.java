package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 나 클라이언트에게 기존에 할당된 세션객체가 있으면 그거 주세요!
		// 만약 없으면 만들지 말고 null을 리턴하세요. 아까 true 였을 때는 어떻든 객체를 만들었는데 여기서는 안 만듬
		// 아무튼 null이 나오면 이전에 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		if(session!=null) {
			String name = (String)session.getAttribute("loginName");
			out.println("<h1>" + name + "님 게시판에 오신 것을 환영합니다.</h1>");
		} else {
			out.println("<h1>로그인을 해야 사용할 수 있어요! 페이지 재설정</h1>");
		}
		// out.println("<h1>게시판에 오신 것을 환영합니다.</h1>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
