<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별 짓기</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="${starQty }">
		<c:forEach var="j" begin="1" end="${i }">
			⭐
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>