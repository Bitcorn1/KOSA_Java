package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 서블릿을 호출하려면
		// http://127.0.0.1:8080/first/sum?num1=10&num2=20
		
		// 1. 입력처리
		// Query String으로부터 데이터를 받으려면..
		// 일단 기억해야 하는 건 입력받은 데이터는 무조건 문자열이에요!
		// 입력에 관련된 객체이니 request 객체 사용해야지
		String num1 = request.getParameter("num1"); // "10"
		// 쿼리스트링 입력값 객체에 저장해 보겟다 입력 객체
		String num2 = request.getParameter("num2"); // "20"
		
		// 2. 로직처리
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		
		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");  
		PrintWriter out = response.getWriter(); // getwriter하면 클라이언트한테 스트림 뚫어주는느낌
		out.println("<html><head></head><body>"+sum+"</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력처리
				// Query String으로부터 데이터를 받으려면..
				// 일단 기억해야 하는 건 입력받은 데이터는 무조건 문자열이에요!
				// 입력에 관련된 객체이니 request 객체 사용해야지
				String num1 = request.getParameter("myNum1"); // "10"
				// 쿼리스트링 입력값 객체에 저장해 보겟다 입력 객체
				String num2 = request.getParameter("myNum2"); // "20"
				
				// 2. 로직처리
				int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
				
				// 3. 출력처리
				response.setContentType("text/html; charset=UTF-8");  
				PrintWriter out = response.getWriter(); // getwriter하면 클라이언트한테 스트림 뚫어주는느낌
				out.println("<html><head></head><body>"+sum+"</body></html>");
				out.close();
		
	}

}
