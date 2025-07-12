<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의응답 작성 페이지</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form id="postQnaFrm">
		<label for="category">카테고리:</label>
		<select name="qnaCategory" id="qnaCategory">
		  <option value="facility">시설</option>
		  <option value="seat">좌석</option>
		  <option value="refund">환불</option>
		  <option value="etc">기타</option>
		</select>
		
		<input type="hidden" name="qnaWriter" value="${loginMember.memberNo }">
	    <label>제목:</label><br>
	    <input type="text" name="qnaTitle" required><br><br>
	    
	    <label>내용:</label><br>
	    <textarea name="boardContent" rows="5" cols="40" required></textarea><br><br>
	    
	    <label>파일첨부:</label><br>
	    <input type="file" name="boardFile" ><br><br>
	    
	    <input type="submit" value="등록">
	</form>
	<script>
		$("#postQnaFrm").submit(function(e){
			e.preventDefault();
			
			const form = document.getElementById("postQnaFrm");
			const formData = new FormData(form);
			// 유효성 검사
			
			$.ajax({
				url : "/qnaPost",
				type : "post",
				data : formData,
				enctype : "multipart/form-data",
				contentType : false,
				processData : false,
				cache : false,
				dataType : "json",
				success : function(data){
					alert(data.res_msg);
					if(data.res_code == 200){
						location.href = "<%=request.getContextPath() %>/boardList";
					}
				}
			})
		});
	</script>
</body>
</html>