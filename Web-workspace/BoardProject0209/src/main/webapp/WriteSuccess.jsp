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
	
 		 <% 
 		String ses = ((Member)session.getAttribute("member")).getMemberId();
 		 	session.setAttribute("memberid",ses);
 		 %>
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
			
			<% List<MemberName> list = (List<MemberName>)request.getAttribute("boardList"); 
			
			for(MemberName board: list) {
			%>
			<tr>
				<td><%= board.getBoardNum() %></td>
				<td><a href="comment?num=<%= board.getBoardNum()%>"><%= board.getBoardTitle() %></a></td>
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
	<button type="button" onclick="location.href='Write.html'">글작성</button><button type="button" onclick="location.href='login.html'">로그아웃</button>

</body>
</html>