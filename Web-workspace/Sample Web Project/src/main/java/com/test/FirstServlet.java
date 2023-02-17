package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/myservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("init()가 호출되었어요!");
    	// init()의 목적은 servlet instance를 초기화 하는데에 있어요!
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 클라이언트가 GET 방식으로 이 servlet을 호출하면 이 method가 호출되요!
		// 결과적으로 보았을 때 doGet() method가 호출됩니다.!!!!
		// 클라이언트의 호출 URL => http://127.0.0.1:8080/sample/myservlet
		// 이 클래스 안에 있는 doGet()이 호출되요.
		
		// 여기서 코드를 작성하면 되요! 서버쪽에서 내가 해야 될일 여기다가 작성한다
		// 프로그램 처리방식대로 작성해 보아요~!
		// 프로그램 처리? 일단 1.입력을 받는다, 2.로직 처리, 3.출력 처리
		// 입력을 받는다 없어요 입력처리 넘어가요
		// 로직처리한다 없어요 로직 처리도 넘어가요
		// 출력처리한다.
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 1. 내가 클라이언트에게 전달한 데이터가 어떤 데이터인지 설정부터 해야 해요!
		response.setContentType("text/html; charset=UTF-8"); // 문자열이고 html이다 html문서가 나온다 출력된다라는 뜻
		// 결과를 만들어서 줄건데 그것은 유니코드 들어가 있어서 한글이 올꺼니가 utf-8해줌
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>이건 서블릿의 결과에요.. 소리없는 아우성!!</body>");
		out.println("</html>");
		
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
