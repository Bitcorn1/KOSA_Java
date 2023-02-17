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

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// Servlet은 MVC(Model-View-Controller) pattern에서 Controller의 역할을 해요!
		// Model : 1. Data Model -> VO 클래스가 이 역할을 담당
		//		   2. Business Logic Model -> Service class가 이 역할을 담당
		//			  -데이터베이스 처리가 들어올 수 있어요! 이 데이터베이스 처리는 DAO가 담당해요! 처리를다하면 서비스가 받아서 전달해줌
		// View : client가 직접 대면하고 눈으로 보고 이벤트 처리 입력하고 프로젝트와 인터랙션하는 것 여기서는 html 역할을 함
		// 동적인 view 역할은 jsp가 한다. View : Jsp(생긴게 html이잖어), html
		// controller : view와 model을 연결해주는 역할담당 => Servlet이 역할을 담당함
		// 				View로부터 사용자 데이터를 받아서 Model(Service)에게 전달해서
		// 				로직처리시키고 로직처리된 결과를 Model(Service)로부터 받아와요!
		// 				그 결과를 보고 여기서 결과를 jsp, html 둘중 무엇에게 보여줄지 선택.
		//				그 뷰를 클라이언트에게 전달하도록 시켜요~
		
		// 1. 입력받고 controller servlet이 담당 , vo에 데이터 담아서 전달, vo는 데이터베이스 테이블을 기준으로 만들어야지
		request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userID");
		String userPw=request.getParameter("userPW");
		// 입력받은 데이터로 VO를 생성해요!
		// 데이터베이스 테이블을 기준으로 VO를 생성해야 하니... 당연히 Table이 있어야 해요!
		// 테이블을 생성한후 VO를 만들고 데이터를 세팅해서 Service에게 넘겨줄 준비를 했어요!
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		// 2. 패키지를 분리시킨다.  
		// 로직처리를 하기 위해 Service 객체를 생성해야 해요!
		MemberService service = new MemberService();
		// 객체가 생성되었으면 이제 일을 시켜요!
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고와요.
		// 만약 로그인이 실패하면 null을 리턴받을꺼에요!
		// vo로 담아서 왔다갔다한다
		Member result = service.login(member);
		List<Board> list = null;
		// 마이바티스로부터 selectlist 해서 가져오겠지
		if(result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard(); // 보드를 가지고 있는 어레이 리스트를 하나 가지고 오겠다.
		}
		
		// 3. 출력처리해요!
		if(result != null) {
			// 로그인에 성공했어요!
			// 로그인에 성공한 흔적을 남겨놔야 해요! => session에 남겨놓으면 좋아요!
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result); // vo 통채로 저장
			// session.setAttribute("boardList", list); // 이러면 세션이 점점 커져
			// 세션에 박는 것은 두고두고 사용할려고 흔적을 남길려고 그래서 result는 괜찮은데 보드 게시판은 두고두고 사용은 아님
			// 리스트를 클라이언트가 보여준것을 객체화한 request에 저장할 것임, request 는 map구조임
			// 게시판 HTML 페이지를 클라이언트에게 전송해요!(JSP)
			// 이쪽은 일반 html 적용하면 프로그램적 요소를 전송할수없음. ~~님 환영합니다. ~~라는 값을 전달 프로그램적요소가 있으니 여기는 html이 아니라 jsp로 전송
			// JSP는 그 실체가 Servlet이에요!
			// html -> servlet -> service -> dao -> service -> controller -> jsp(servlet) -> client
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list);
			// 일회성 게시판 보드도 이렇게 보내면서 다 날라감, 이런 두고두고 흔적이 아닌 일회성은 request 객체에 보낸다 장기적으로 로그인여부를 판단한다면 이런 장기적인 로직은 세션에 붙임
			// 다음에 실행할 jsp 가 저것이라고 지정
			// 제어권을 넘기겠다라는 클라이언트한테 보여줄 jsp 하나 있어야 함
			dispatcher.forward(request, response);
			// 이렇게 되면 한 번의 큰 과정이 끝난 것임
		} else {
			// 로그인에 실패했어요!
			// 오류 HTML 페이지를 클라이언트에게 전송해요!(HTML)
			// 그냥 정적인 html 페이지 전송하면됨
			// HTML 전송할 때에는 
			response.sendRedirect("loginFail.html");
			// 위 코드는 클라이언트에게 loginfail.html로 다시 접속하라는 코드
		}
	}

}
