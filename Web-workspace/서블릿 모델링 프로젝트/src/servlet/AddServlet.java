package servlet;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;

// Servlet(서블릿)이라고 불리는 이 클래스는
// 원래 특정 클래스(HttpServlet)를 상속해서 만들어야 해요!
public class AddServlet {
	public void init() {
		// Servlet Instance의 초기화를 담당!
		// 생성자에서 하지 않고 여기서 해요
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 이 메소드는 이미 하는 일이 정해져 있어요!
		// request 객체를 뒤적뒤적 뒤져서.. 클라이언트의 요청방식이
		// request에 클라이언트요청한 내용 모든 정보 다있음 심지어 어떤 방식으로 보냇는지까지 알수있음
		// 만약 GET 방식이면 => doGet() 호출 
		doGet(request, response);
		// 만약 Post방식이면 doPost(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
			// 여기에서 request 객체와 response 객체를 이용해서 
			// 입력처리와 로직처리 그리고 출력처리를 진행! 여기가 종착점 같음
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
