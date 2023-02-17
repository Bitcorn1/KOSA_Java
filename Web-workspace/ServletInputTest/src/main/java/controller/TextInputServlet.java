package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/inputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	// field를 만들 수 있어요!
	int count = 0; // 이 field는 client thread에 의해서 공유되요!
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		count += 1; // 진짜 공유되는지 확인도 할겸 겸사겸사.. 이렇게 하면 dopost 호출할때마다 카운트가 오르겄지
		// 1. 입력받고
		// String으로받음
		String data = request.getParameter("userID");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data+"님 환영합니다.");
		out.println("<br><br>");
		out.println("이건 GET방식이에요!");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청을 처리하면 되는데
		// POST 방식일 경우!!!
		// 클라이언트로부터 서블릿으로 전송된 문자 데이터는 ISO_8859_1 한글 인식할 수 없는 영문 인코딩으로 되어 있어요. 기본적으로는 한글처리가 안되요!
		// 인코딩을 바꿔서 한글 처리를 해 줘야 해요!
		// 여기서 count += 1 이런 것 하지마라 필드를 이용하니깐 stateful이 됨. 동기화 문제 발생 가능 single tone으로 무조건 돌지는 않으니
		request.setCharacterEncoding("UTF-8");
		count += 1; // 진짜 공유되는지 확인도 할겸 겸사겸사.. 이렇게 하면 dopost 호출할때마다 카운트가 오르겄지
		// 1. 입력받고
		// String으로받음
		String data = request.getParameter("userID");
		// 2. 로직처리하고
		// 3. 출력처리하면 되요!
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data+"님 환영합니다.");
		out.println("</body></html>");
		out.close();
		// 앞으로는 1,2,3 의 과정을 mvc 형태로 하는 듯 여기서는 그냥 여기서 다 하고
		
	}

}
