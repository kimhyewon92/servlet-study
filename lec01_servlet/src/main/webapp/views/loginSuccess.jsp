<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과화면</title>
</head>
<body>
	<h1><%= request.getAttribute("id") %></h1>
	<h2><%= request.getAttribute("pw") %></h2>
	<a href="/">홈페이지로 이동</a>
</body>
</html>