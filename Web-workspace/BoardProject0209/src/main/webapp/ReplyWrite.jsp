<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, member.vo.MemberName, board.vo.Reply, java.util.List" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
 		int num = ((Board)session.getAttribute("board")).getBoardNum();
 		 	session.setAttribute("replynum",num);
 		 	 
 	 		String other = ((Board)session.getAttribute("board")).getBoardAuthor();
 	 		 	session.setAttribute("otherid",other);
 	 		 
 		 %>
	<h3><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h3>
	<form action="replywrite" method="post">
	<h1>댓글을 작성하세요!</h1>
	댓글내용: <input type="content" name="replyContent">
	<br><br>
	<!--  아이디: <input type="id" name="replyId">
	<br><br> -->
	<button type="submit">완료</button><button type="button" onclick="location.href='Comment.jsp'">취소</button>	
	</form>
</body>
</html>
