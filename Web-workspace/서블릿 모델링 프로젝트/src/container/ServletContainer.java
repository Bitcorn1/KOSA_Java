package container;

import ThreadInvoker.ClientThread;
import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

// Tomcat(WAS)안의 Servlet Container 역할을 하는
// 클래스
public class ServletContainer {
	
	// 일반 자바 프로그램이기 때문에 있는거고.. 실제로
	// Servlet Container는 가지고 있지 않아요!
	public static void main(String[] args) {
		// 1. 사용자의 요청사항(request)을 분석
		// 		어떤 서블릿을 실행하는지 알아내기. => Add Servlet을 실행하라!
		
		// 2. Add라는 서블릿의 instance가 있는지를 확인해요,
		//    Container안에 객체가 있는지를 확인해요
		
		// 3. 객체가 없기 때문에 Add Servlet을 찾아서 객체를 생성해요!
		AddServlet servlet = new AddServlet();
		
		// 4. Servlet Instance가 생성되면 바로 다음에 해당 서블릿의 init()을 호출해요!
		servlet.init();
		
		// 5. 클라이언트가 보내준 request 내용을 기반으로 객체를 하나 생성해요!
		//    (객체를 만들려면 클래스가 있어야함 클래스가지고 객체 만듬)
		//    당연히 이 객체에는 클라이언트가 보내준 데이터가 들어가 있어요
		HttpServletRequest request = new HttpServletRequest();
		
		// 6. 클라이언트에게 최종 결과를 보내주기 위해서 response 객체 하나
		HttpServletResponse response = new HttpServletResponse();
		
		// 7. 클라이언트의 요청을 실제로 처리하기 위해서 쓰레드가 있어야 해요
		ClientThread thread = new ClientThread(servlet, request, response);
		thread.start();
	}
}

