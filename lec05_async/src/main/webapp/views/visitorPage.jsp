<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 페이지</title>
</head>
<body>
 <form action="/getNameMsg">
 	<label for="visitorName">이름 : </label>
 	<input type="text" id="visitorName" name="visitorName">
 	<br>
 	<label for="visitorMsg">메시지 : </label>
 	<input type="text" id="visitorMsg" name="visitorMsg">
 	<button type="button" id="submitNameMsg">등록</button>
 	
 </form>
 
 <script>
 	$(document).ready(function(){
 		$("#submitNameMsg").click(function(){
 			console.log("1: 클릭 이벤트 동작");
 			const visitorName = $("visitorName").val();
 			const visitorMsg = $("visitorMsg").val();
 			$.ajax({
 				url: "visitorPostTextAjax?name"+keyword,
 				type: "post",
 				dataType: "json",
 				data : {
 					
 				}
 			});
 		});
 	});
 
 
 
 </script>
</body>
</html>