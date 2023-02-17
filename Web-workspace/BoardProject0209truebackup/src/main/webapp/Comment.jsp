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
	<h3><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h3>
	<table border=2>
		<thead>
		</thead>
		<tbody>
		
		<tr>
		<td>글제목 :</td><td></td>
		</tr>
		<tr>
		<td>작성자 :</td><td></td>
		</tr>
		<tr>
		<td>작성일 :</td><td></td>
		</tr>
		<tr>
		<td>글내용 :</td><td></td>
		</tr>
		<tr>
		<td>댓글수 :</td><td></td>
		</tr>
		<tr>
		<td>댓글내용:</td><td></td>
		</tr>
		
		</tbody>
	</table>
</body>
</html>