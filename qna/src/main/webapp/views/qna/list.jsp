<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의응답</title>
</head>
<body>
<h2>상세 화면</h2>
<form name="form1" method="post">
<table border="1" style="width: 100%;">
 <tr>
  <td>날짜</td>
  <td>조회수</td>
 </tr>
 <tr>
  <td>이름</td>
 </tr>
 <tr>
  <td>제목</td>
 </tr>
 <tr>
  <td>본문</td>
 </tr>
 <tr>
  <td>비밀번호</td>
  <td colspan="3">
   <input type="password" name="passwd" id="passwd">
  </td>
 </tr>
 <tr>
  <td>첨부파일</td>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td colspan="4" align="center">
   <input type="hidden" name="num" value="번호">
   <input type="button" value="수정/삭제" id="btnEdit">
   <input type="button" value="답변" id="btnReply">
   <input type="button" value="목록" id="btnList">
  </td>
 </tr>
</table>
</form>
<!-- 댓글 쓰기 폼 -->
<table border="1" style="width: 100%;">
 <tr>
  <td><input id="writer" placeholder="이름"></td>
  <td rowspan="2">
   <button id="btnSave" type="button">확인</button>
  </td>
 </tr>
 <tr>
  <td><textarea rows="5" cols="80" placeholder="내용을 입력하세요" id="content"></textarea></td>
 </tr>
</table>

<!-- 댓글 목록을 출력할 영역 -->
<div id="commentList"></div>

</body>
</html>