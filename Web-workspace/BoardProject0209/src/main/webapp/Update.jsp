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
 		int fix = ((Board)session.getAttribute("board")).getBoardNum();
 		 	session.setAttribute("boardnum",fix);
 		 %>
	<h3><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h3>
	<h1>글을 수정하세요!</h1>
	<form action="update" method="post">
	글제목: <input type="title" name="userTitle">
	<br><br>
	글내용: <input type="content" name="userContent">
	<br><br>
	<button type="submit">완료</button><button type="button" onclick="location.href='Comment.jsp'">취소</button>
	</form>
</body>
</html>