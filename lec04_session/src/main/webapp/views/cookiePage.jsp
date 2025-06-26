<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 연습하기</title>
</head>
<body>
	<h1>쿠키 연습하기</h1>
	<form action="/saveNick" method="post">
	   <input type="text" name="saveNick" placeholder="닉네임 입력">
	   <input type="submit" value="저장">
	</form>
	<% 
	Cookie[] cookie = request.getCookies(); 
	String saveNick = "____";

	if (cookie != null) {
		for(Cookie c : cookie) {
			if ("saveNick".equals(c.getName())) {
				saveNick = c.getValue();
				break;
			}
		}
	}
	%>	
	
	<!-- 값이 하나일 때 -->
	<%
	 	String userNick = null;
	 	Cookie[] cookies = request.getCookies();
	 	if(cookies != null){
	 		for(Cookie c : cookies){
	 			if("user_nick".equals(c.getName())){
	 				userNick = c.getValue();
	 			}
	 		}
	 	}
	 %>
	<!-- <p>닉네임 : <%=userNick == null ? "_____" : userNick %></p> -->
	<p>닉네임: <%=saveNick %></p>
	
	<form action="/removeNick" method="post">
	   <input type="submit" value="삭제">
	</form>
	
</body>
</html>