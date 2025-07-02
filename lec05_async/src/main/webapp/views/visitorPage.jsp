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
 <div id ="resultArea"></div>
 
 <script>
 	$(document).ready(function(){
 		$("#submitNameMsg").click(function(){
 			console.log("111: 클릭 이벤트 동작");
 			const visitorName = $("visitorName").val();
 			const visitorMsg = $("visitorMsg").val();
 			const visitDatetime = $("visitDatetime").val();
 			console.log("222: 사용자 정보 받아와졌는가");
 			$.ajax({
 				url: "visitorPostTextAjax?name"+keyword,
 				type: "post",
 				dataType: "json",
 				data : {visitorName : visitorName,
 						visitorMsg : visitorMsg,
 						visitDatetime : visitDatetime},
 				success : function(data){
 					console.log("333: 요청 정상 동작 여부");
 					const p = $("<p>").text(data);
 					$("#resultArea").html(p);
 				},
 				error : function() {
 					alert("요청 실패!");
 				}
 			});
 		});
 	});
 
 
 
 </script>
</body>
</html>