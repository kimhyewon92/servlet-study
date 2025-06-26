<%@ page import="com.gn.dto.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>Cookie🍪</h1>
	<ul>
		<li>
		<!-- a태그는 무조건 get방식으로 들어옴 -->
			<a href="/makecookie">쿠키 생성</a>
		</li>
		<li>
			<a href="/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href="/deleteCookie">쿠키 삭제</a>
		</li>
		<li>
			<a href="/practiceCookie">쿠키 연습하기</a>
		</li>
	</ul>
	
	<h2>현재 쿠키 값 확인</h2>
	<%
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if (cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("user_id")) {
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<p>user_id 쿠키값 : <%=userId %></p>
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/updateSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
		
	</ol>
	
	<%
		String memberId = "세션 없음";
		if(session != null) {
			if(session.getAttribute("member_id") != null) {
				memberId = (String)session.getAttribute("member_id");
			}
		}
	%>
	<p>세션 정보: <%=memberId %></p>
	
	<% 
		Account account;
		if(session != null) {
			if(session.getAttribute("account") != null) {
			account = (Account)session.getAttribute("account");
	%>
				<p><%= account.getName() %>님 환영합니다!<p>
				<a href="/logout">로그아웃</a>
	<%			
			} else { 
	%>
				<form action="/login" method="post">
				<label for="account_id">아이디 : </label>
				<input type="text" name="id"><br>
				<label for="password">비밀번호 : </label>
				<input type="password" name="pw">
				<input type="submit" value="로그인">
			</form>
	<%		}
		}
	%>
	
	<h1>장바구니</h1>
	<a href="/productList">목록 페이지</a>
	
</body>
</html>