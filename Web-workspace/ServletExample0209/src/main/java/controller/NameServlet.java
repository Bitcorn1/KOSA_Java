package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/saveName")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
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
		// 1. 입력처리
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("userName");
		
		// 2. 로직처리
		// ServletContext를 가져와서 여기에 이름을 저장해 놓을꺼에요!
		// ServletContext는 Map구조에요.. key와 value의 쌍으로 저장하는 구조
		ServletContext context = this.getServletContext();
		context.setAttribute("memberName", name);
		// memberName이라고 키를 설정한 다음에 key에 맞게 내가 넣고 싶은 데이터 value 집어넣음
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<a href='secondServlet'>두 번째 서블릿 호출<a>");
		// 클라이언트에게 링크를 제공함, 서블릿 호출하는것 secondServlet이 url mapping
		out.println("</body></html>");
	}

}
