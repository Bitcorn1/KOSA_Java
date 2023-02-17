<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, member.vo.MemberName, board.vo.Reply, java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<h3><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h3>
	<table border=2>
		<thead>
		</thead>
		
		<tbody>
		<tr>
		<td>글번호 :</td><td><%= ((Board)session.getAttribute("board")).getBoardNum() %></td>
		</tr>
		<tr>
		<td>글제목 :</td><td><%= ((Board)session.getAttribute("board")).getBoardTitle() %></td>
		</tr>
		<tr>
		<td>작성자 :</td><td><%= ((Board)session.getAttribute("board")).getBoardAuthor() %></td>
		</tr>
		<tr>
		<td>작성일 :</td><td><%= ((Board)session.getAttribute("board")).getBoardDate() %></td>
		</tr>
		<tr>
		<td>글내용 :</td><td><%= ((Board)session.getAttribute("board")).getBoardContent() %></td>
		</tr>
		<tr>
		<td>좋아요 수 : <span id="likecount"></span></td>
		 </tr>
		</tbody>
	</table>
	<table border=2>
	<thead>
			<th>댓글번호</th>
			<th>댓글내용</th>
			<th>ID</th>
			<th>댓글수정</th>
			<th>댓글삭제</th>
		</thead>
		<!--  <tbody> -->
		<% String myid = ((Member)session.getAttribute("member")).getMemberId();
	   String otherid = ((Board)session.getAttribute("board")).getBoardAuthor();
	   int boardnum = ((Board)session.getAttribute("board")).getBoardNum();
	   int likenum = 1;
	   String title = ((Board)session.getAttribute("board")).getBoardTitle();
	   String date = ((Board)session.getAttribute("board")).getBoardDate();
	   String content = ((Board)session.getAttribute("board")).getBoardContent();
		%>
			<% List<Reply> rlist = (List<Reply>)request.getAttribute("replyList");
			
			for(Reply replys: rlist) {
			%>
			<tr>
				<td><%= replys.getReplyNum() %></td>
				<td><%= replys.getReplyContent() %></td>
				<td><%= replys.getReplyAuthor() %></td>
				<% String replyid = replys.getReplyAuthor(); %>
				<% if(myid.equals(replyid)) { %>
				<td><button type="button" onclick="location.href='replyupdate?num=<%= ((Board)session.getAttribute("board")).getBoardNum() %>&myId=<%= ((Member)session.getAttribute("member")).getMemberId() %>&otherId=<%= ((Board)session.getAttribute("board")).getBoardAuthor() %>&replynum=<%= replys.getReplyNum() %>'">댓글수정</button></td>
				<td><button type="button" onclick="location.href='replydelete?num=<%= ((Board)session.getAttribute("board")).getBoardNum() %>&myId=<%= ((Member)session.getAttribute("member")).getMemberId() %>&otherId=<%= ((Board)session.getAttribute("board")).getBoardAuthor() %>&replynum=<%= replys.getReplyNum() %>'">댓글삭제</button></td>
				<% 
				}
				%>
				<% 
				}
				%>
			</tr>
				
		<!--  </tbody> -->
	</table>
	
	<% if(myid.equals(otherid)) { %>
	<button type="button" onclick="location.href='Update.jsp'">수정</button>
	<% } %>
	<br>
	<% if(myid.equals(otherid)) { %>
	<button type="button" onclick="location.href='delete?num=<%= ((Board)session.getAttribute("board")).getBoardNum() %>&myId=<%= ((Member)session.getAttribute("member")).getMemberId() %>&otherId=<%= ((Board)session.getAttribute("board")).getBoardAuthor() %>'">삭제</button>
	<% } %>
	<br>
	<button type="button" onclick="location.href='like?num=<%= ((Board)session.getAttribute("board")).getBoardNum() %>&myId=<%= ((Member)session.getAttribute("member")).getMemberId() %>&otherId=<%= ((Board)session.getAttribute("board")).getBoardAuthor() %>&likenum=1'">좋아요</button>
	<br>
	<button type="button" onclick="location.href='likeminus?num=<%= ((Board)session.getAttribute("board")).getBoardNum() %>&myId=<%= ((Member)session.getAttribute("member")).getMemberId() %>&otherId=<%= ((Board)session.getAttribute("board")).getBoardAuthor() %>&likenum=1'">좋아요 취소</button>
	<br>
	<button type="button" onclick="location.href='ReplyWrite.jsp'">댓글작성</button>
	
	<form id = "likeajax">
	<input id = "myid" type="hidden" name="myId" value = "<%= myid %>">
	<input id = "otherid" type="hidden" name="otherId" value = "<%= otherid %>">
	<input id = "boardnum" type="hidden" name="boardNum" value = "<%= boardnum %>">
	<input id = "likenum" type="hidden" name="likeNum" value = "<%= likenum %>">
	<input id = "liketitle" type="hidden" name="likeTitle" value = "<%= title %>">
	<input id = "likedate" type="hidden" name="likelDate" value = "<%= date %>">
	<input id = "likecontent" type="hidden" name="likeContent" value = "<%= content %>">
	<input id = "buttonlike" type="button" name="GoodAjax" value="GoodAjax" onclick="return like()"/>
	</form>
	
	<form id = "likecancelajax">
	<input id = "myid" type="hidden" name="myId" value = "<%= myid %>">
	<input id = "otherid" type="hidden" name="otherId" value = "<%= otherid %>">
	<input id = "boardnum" type="hidden" name="boardNum" value = "<%= boardnum %>">
	<input id = "likenum" type="hidden" name="likeNum" value = "<%= likenum %>">
	<input id = "liketitle" type="hidden" name="likeTitle" value = "<%= title %>">
	<input id = "likedate" type="hidden" name="likelDate" value = "<%= date %>">
	<input id = "likecontent" type="hidden" name="likeContent" value = "<%= content %>">
	<input id = "buttonlikecancel" type="button" name="GoodCancelAjax" value="GoodCancelAjax" onclick="cancellike()"/>
	</form>
	
</body>
<script>
function like() {
	$.ajax({
		url : "likeajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
				},
		success : function(data) {
			
			var values = Object.values(data);
			let liketr = $("<tr></tr>");
			
			if(data['ajaxresult'] == 7){
			console.log('좋아요 성공하셨습니다!');
			$('#likecount').text(data['likeresult']);
			} else if(data['ajaxresult'] == 4) {
				alert('당신이 작성한 글입니다!');
			} else {
				alert('이미 좋아요를 하셨습니다!');
			}
		},
		error: function(data) {
			alert('ajax 실패!');
		}
			
	});
}

function cancellike() {
	$.ajax({
		url : "likecancelajax",
		type : "POST",
		async : "false",
		dataType : "json",
		data : { myid: $("#myid").val(),
				 otherid: $("#otherid").val(),
				 bnum: $("#boardnum").val(),
				 likenum: $("#likenum").val()
		},
		success : function(data) {
			
			var values = Object.values(data);
			let cancelliketr = $("<tr></tr>");
			
			if(data['ajaxresult']==7) {
				console.log('좋아요 취소하셨습니다!');
				$('#likecount').text(data['likeresult']);
				
				
			} else if(data['ajaxresult']==4) {
				alert('좋아요를 하지 않았습니다!');
			} else {
				alert('당신이 작성한 글입니다!');
			}
			
		},
		error: function(data) {
			alert('ajax 실패!');
		}
	});
}
</script>
</html>