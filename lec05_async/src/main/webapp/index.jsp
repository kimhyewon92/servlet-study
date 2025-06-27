<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 연습하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>1. 텍스트 데이터</h1>
	<h2>(1) GET 방식</h2>
	<input type="text" name="user_id" id="user_id">
	<input type="button" value="아이디 길이 구하기" id="ajax_get_btn">
	<div id="ajax_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_get_btn").click(function(){
				console.log("1: 클릭 이벤트 동작");
				const userId = $("#user_id").val();
				console.log("2: 사용자 정보 받아와졌는가");
				$.ajax({
					url : "/getTextAjax?userId="+userId,
					type : "get",
					success : function(data){
						// data => <p>아이디 : OOO (n글자) </p>
						console.log("3: 요청 정상 동작 여부");
						// $("#ajax_get_div").html(data);
						
						const h3 = $('<h3>').text(data);
						$("#ajax_get_div").html(h3);
					},
					error : function(){
						alert("요청 실패!!");
					}
				});
			});		
		});
	</script>
	
	<h2>(2) POST 방식</h2>
	<button type="button" id="ajax_post_btn">
		아이디 길이 구하기 ver2.
	</button>
	<div id="ajax_post_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_post_btn").click(function(){
				const userId = $("#user_id").val();
				$.ajax({
					url: "/postTextAjax",
					type: "post",
					data : {userId : userId},
					success : function(data){
						const p = $("<p>").text(data);
						$("#ajax_post_div").html(p);
					},
					error : function(){
						alert("요청 실패!");
					}
					
				});
			});
		});
	</script>
	
	<h1>성적 계산기</h1>

	<label for="kor">국어 : </label>
	<input type="number" id="kor" name="kor"><br>
	
	<label for="eng">영어 : </label>
	<input type="number" id="eng" name="eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math" name="math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>
	
	<script>
		$(document).ready(function(){
			$("#btnPost").click(function(){
				console.log("11: 클릭 이벤트 동작");
				const kor = $("#kor").val();
				const eng = $("#eng").val();
				const math = $("#math").val();
				console.log("22: 사용자 정보 받아와졌는가");
				$.ajax({
					url: "/scorePostTextAjax",
					type: "post",
					data : {kor : kor, 
							eng : eng, 
							math : math},
					success : function(data){ // result
						console.log("33: 요청 정상 동작 여부");
						const p = $("<p>").text(data);
						$("#resultArea").html(p);
						// $("#resultArea").html('<p>'+result+"</p>");
					},
					error : function(){
						alert("요청 실패!");
					}
					
				});
			});
		});
	</script>
	<h1>JSON + AJAX</h1>
	<input type="text" id="searchName">
	<button type="button" id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#json_get_btn").click(function(){
				// 1. 사용자 이름 정보 가져오기
				const keyword = $("#searchName").val();
				// 2. get방식(비동기) 요청 ..쿼리스트링
					// name은 서블릿에서 사용
					// type: "get" 생략가능하지만 써주기
					// dataType: 순서 중요x 가독성좋게 type 아래 위치..
					// ajax 안에 주석 가능하면 쓰지x
				$.ajax({
					url: "/searchAccount?name="+keyword, 
					type: "get", 
					dataType : "json", 
					success : function(data){
						// 4. 화면에 목록 형태로 출력
						/* const no = data.no;
						const name = data.name;
						
						$('#json_get_div').append('<p>'+no+"번 : "+name+"</p>"); */
						
						if(data.arr.length != 0) {
							for(let i = 0; i <data.arr.length; i++){
								const account = data.arr[i];
								$("#json_get_div").append('<p>'+account.no+"번 : "+account.name+"</p>");
							}
						}
					}
				});
				
			});
		});
	</script>
	
	<h1>도서 검색</h1>
	<label>도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>
	
	<script>
		$(document).ready(function(){
			$("#book_get_btn").click(function(){
				const keyword = $("#searchBook").val();
				$.ajax({
					url: "/searchBook?name="+keyword,
					type: "get",
					dataType: "json",
					success: function(data){
						if(data.arr.length != 0) {
							for(let i = 0; i < data.arr.length; i++){
								const book = data.arr[i];
								$("#book_get_div").append('<p>'+book.no+ " : " + book.bookName + " - " +book.author +"</p>");
							}
						} else {
							alert("검색 결과가 없습니다.");
						}
					}
				});
			});
		});
	</script>
	
	<h1>카테고리별 상품 조회</h1>
	<select id="categorySelect">
		<option value="1">전자제품</option>
		<option value="2">생활용품</option>
		<option value="3">패션</option>
	</select>
	<button type="button" id="searchBtn">조회</button>
	<div id="productListArea"></div>
	<script>
		$(function(){
			$("#categorySelect").change(function(){
				// 1. 선택된 카테고리 정보 가져오기
				const categoryCode = $(this).val();
				console.log(categoryCode);
				// 2. ajax 통신을 통해 목록 조회
				// post는 ? 값x
				$.ajax({
					url : "/searchProduct",
					type : "post",
					data : {code : categoryCode},
					dataType : 'json',
					success : function(data) {
						// 3. 화면에 출력하기
						$("productListArea").empty(); // 혹은 .html("");
						if(data.arr.length === 0) {
							$("#productListArea").html("해당 카테고리의 상품이 없습니다.");
						} else {
							for(let i = 0; i < data.arr.length; i++) {
								const product = data.arr[i];
								$("productListArea").append("<p>"+product.name+"은 "+product.price+"원 입니다.</p>");
							}
						}
					}					
				});
			});
			
		});
	</script>
	
	<br>
	
	<a href="/visitorPage">방명록 페이지</a>	
	
</body>
</html>