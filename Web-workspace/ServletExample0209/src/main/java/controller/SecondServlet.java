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
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.입력받고
		//2.로직처리 :아까 저장한 홍길동 가져와야함 servletcontext가져오기
		ServletContext context = this.getServletContext();
		// 일단 서블렛컨텍스트 다시 인스턴스만들어서 레퍼런스확보, 그래야 이걸이용해서 데이터 가져오지 
		// 저장할때는 setattribute, 가져올때는 getattribute
		String name = (String)context.getAttribute("memberName");
		// 에러나는이유 이게 최상위타입인object로 나오니깐 스트링으로 바꿔줘야 함
		//3. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("가져온 이름은 :" + name);
		// 클라이언트에게 링크를 제공함, 서블릿 호출하는것 secondServlet이 url mapping
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
