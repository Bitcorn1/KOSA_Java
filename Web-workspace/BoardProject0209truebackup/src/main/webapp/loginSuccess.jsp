<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, member.vo.MemberName, java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<!-- JSP에서는 나에게 할당된 session 객체를 그냥 사용할 수 있어요!
 		 어떤 이름을 사용해야 하나요? ==> session, 예전처럼 httpsession 이렇게 안해도됨 -->
 		 <!-- getattribute 하면 무조건 object 타입이기에 캐스팅해줘야함!!!!! -->
 		 
	<h1><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h1>
	
	<h3>게시글 목록</h3>
	<table border=2>
		<thead>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>댓글수</th>
			<th>좋아요</th>
		</thead>
		<tbody>
			<!-- request에서 보드 정도 뽑아내야함 -->
			<% List<MemberName> list = (List<MemberName>)request.getAttribute("boardList"); 
			
			for(MemberName board: list) {
			%>
			<tr>
				<td><%= board.getBoardNum() %></td>
				<td><a href="Comment.jsp"><%= board.getBoardTitle() %></a></td>
				<td><%= board.getMemberName() %></td>
				<td><%= board.getBoardDate() %></td>
				<td>0</td>
				<td><%= board.getBoardLike() %></td>
			</tr>
			<% 
			}
			%>
		</tbody>
	</table>
</body>
</html>