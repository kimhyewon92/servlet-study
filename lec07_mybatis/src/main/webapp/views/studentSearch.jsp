<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키워드로 학생 정보 출력하기</title>
</head>
<body>
	<c:forEach var="s" items="${list }">
		<tr>
			<td>${s.studentNo }</td>
			<td>${s.studentName }</td>
			<td>${s.studentAge }</td>
		</tr>
	</c:forEach>
</body>
</html>