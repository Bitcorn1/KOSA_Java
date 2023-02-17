<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 입력받고
		// 2. 로직처리하고
		// 여기에 mybatis 코드들도 나옴. 이러다보니 유지보수 문제 mvc 패턴 안되어있음 모든 것을 jsp 파일 하나에서 다 하려다보니 유지보수 어려움. 
		// 3. 출력은 HTML에 끼워넣기
		// 그래서 이제는 3번 출력만 jsp가 담당하게 되었음 화면 결과 출력 용도로 사용함.
	%>
	<%
		String name = "홍길동";  // 지역변수 : 메소드 내에서 실행되었기에 지역변수
		for(int i=0; i<5; i++) {	
	%>
		<h1>반복되요!</h1>
	<% 
		}
	%>
	이것은 소리없는 아우성!!
	사용자의 이름은 : <%= name %> 입니다.
</body>
</html>