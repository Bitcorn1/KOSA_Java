package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/sayHello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 호출되면.. 결국은 돌고 돌아서 이 method가 
		// Thread에 의해서 호출되는거에요!
		// 1. client가 보내준 데이터 받음 => request 객체 이용해서 데이터 받음
		// 2. 로직처리해요! (DB처리 포함해서!)
		// 3. 출력처리해요! 웹브라우저한테 너가 원하는게 이거니?라면서 보내줌 => response 객체를 이용.
		//      데이터 주기 전에 처리한결과가 어떤 데이터인지 데이터 주기 전에 미리 알려줘야 함
		//   1. 처리된 결과 보내주기 전에.. 먼저 처리한 결과가 어떤 데이터인지를
		//      먼저 알려줘야 해요!
		response.setContentType("text/html; charset=UTF-8");  
		// mimetype이라는게 text 문자열이고 html 양식이에요, text/plain 문자열인데 xml html아니고 일반적인 문자열입니다.
		// mimetype은 오타 나면 안됨 다운로드 창이보이면 마임타입 문제가 있지 않을까 생각 오타 나면 다운로드 창이 뜸
		// 	 2. 실제 결과 데이터를 전송하면 되요!
		//      네트웤을 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송! 구멍 뚫어서 거기다 데이터 보내주는 느낌
		PrintWriter out = response.getWriter(); // getwriter하면 클라이언트한테 스트림 뚫어주는느김
		out.println("<html><head></head><body>까꿍!!</body></html>");
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
