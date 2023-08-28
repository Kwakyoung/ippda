<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.options-container {
  display: flex; /* Display children in a row */
  gap: 10px; /* Gap between option divs */
}

.option {
  display: flex; /* Display contents in a row */
 
}
</style>
</head>
<body>
	<h3 class="my-4">옵션 수정</h3>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link text-dark fs-5 active"
			data-tab="optionSettings">옵션설정</a></li>
	</ul>



	<form action="option/insert" method="post" name="itemInsertForm"
		id="itemInsertForm" enctype="multipart/form-data">

<div class="form-group my-4"> <!--style="display: none;"--> 
			<h4>상품번호</h4>
			<input class="form-control input-lg" type="number" placeholder="상품번호"
				name="goods_no" id="goods_no" value="${goods_no}" />
		</div>
		
	
 		<div class="form-group my-4"> <!--style="display: none;"--> 
			<h4>가맹점번호</h4>
			<input class="form-control input-lg" type="number" placeholder="가맹점번호"
				name="store_no" id="store_no" value="${store_no}" />
		</div>
		<!-- 상품등록 -->

		<div class="tab-pane active my-4" id="itemInsert_1">
	
		
			<hr class="divider-w mt-10 mb-20">

		<button type="button" class="btn btn-secondary my-4" id="option">옵션추가</button>

			<c:forEach var="option" items="${vo}">
				<div class="options-container">
				
					<div class="option">
						<p>옵션 번호</p>
						<input type="text" class="p-2 g-col-6" name="goods_option_no" value="${option.goods_option_no}" id="goods_option_no">
					</div>
					<div class="option" id="option1">
						<p>사이즈 :</p>
						<input type="text" class="p-2 g-col-6" name="goods_size" value="${option.goods_size}">
					</div>

					<div class="option" id="option2">
						<p>색깔 :</p>
						<input type="text" class="p-2 g-col-6" name="goods_color" value="${option.goods_color}">
					</div>
					
						<div class="option" id="option3">
						<p>수량 :</p>
						<input type="text" class="p-2 g-col-6" name="goods_cnt" value=" ${option.goods_cnt}">
					</div>
					
					<button type="button" class="btn btn-secondary optionDelete" id="btn-delete">삭제</button>

				</div>
			</c:forEach>
			<div id="options-container"></div>
			<h4>사이즈</h4>
			<select class="form-control" id="goods_size"
				title="상품 사이즈">
				<option value="">(선택)</option>
				<option value="2XS">2XS</option>
				<option value="XS">XS</option>
				<option value="S">S</option>
				<option value="M">M</option>
				<option value="L">L</option>
				<option value="XL">XL</option>
				<option value="2XL">2XL</option>
				<option value="3XL">3XL</option>
				<option value="FREE">FREE</option>
			</select>

			<hr class="divider-w mt-10 mb-20">
			<div class="form-group">
				<h4>색상</h4>
				<input class="form-control input-lg" type="text" placeholder="색상"
					 id="goods_color"/>
			</div>
			<hr class="divider-w mt-10 mb-20">

			<div class="form-group">
				<h4>수량</h4>
				<input class="form-control input-lg" type="number" placeholder="수량"
				 id="goods_cnt" />
			</div>
			<hr class="divider-w mt-10 mb-20">
		</div>
<!-- 		<button type="button" class="btn btn-secondary" id="regist">등록완료</button> -->
		<button type="submit" class="btn btn-secondary">등록완료</button>
	</form>
</body>

<script>


$(document).ready(function() {
	  var optionCount = 1; // 추가된 옵션 개수 초기값
	  var selectedSize = "";
	   var goodsColor;
	   var goodsCnt;
		var goods_option_no = document.getElementById("goods_option_no")
	 
	    document.getElementById("goods_size").addEventListener("change", function(event) {
	        selectedSize = event.target.value; // 선택한 사이즈 업데이트
	        console.log("Selected Size:", selectedSize);
	    });
	    
			
	    
	    
	    
	  // 버튼 클릭 이벤트 처리
	  $("#option").click(function() {
		     goodsColor = $("#goods_color").val();		    
			 goodsCnt = $("#goods_cnt").val();
			 
		 if(selectedSize === ""){
			 alert("사이즈를 선택해주세요")
		 }else if(goodsColor === ""){
			 alert("색상을 입력해주세요")
		 }else if(goodsCnt === ""){
			 alert("수량을 입력해주세요")
		 }else{
			
			var optionId = optionCount;
			
		    var newOption = '<div class="options-container" id="' + optionId + '">' +'<p>사이즈 : </p>' +
		    '<div class="option">'+
	        '<input type="text" class="p-2 g-col-6" name="goods_option_size" value= "'+selectedSize+'"></input>'+
	        '</div>'+
	        '<p>색깔 : </p>' +
	        '<div class="option">'+
	        '<input type="text" class="p-2 g-col-6" name="goods_option_color" value="'+goodsColor+'"></input>'+
	        '</div>'+
	        '<p>수량 : </p>' +
	        '<div class="option">'+
	        '<input type="text" class="p-2 g-col-6" name="goods_option_cnt" value="'+goodsCnt+'"></input>'+
	        '</div>'+
	        '<button type="button" class="btn btn-secondary optionDelete" id="optionDelete" data-option-id="' + optionId + '">삭제</button>'+
	        '</div>'; 
				console.log(optionId);
			
	        console.log("item_color 값:", goodsColor);
	        
		    $("#options-container").append(newOption);
		    optionCount++; // 옵션 개수 증가
		 

	  });
	  

	 }
	  
	  document.getElementById("optionDelete").addEventListener("click", function() {
	        // AJAX 요청을 통해 스프링 컨트롤러에 데이터 전송
	        $.ajax({
	            type: "POST",
	            url: "/deleteOption", // 해당 URL은 스프링 컨트롤러의 매핑과 일치해야 함
	            success: function(response) {
	                // 서버에서 응답을 받아서 처리하는 코드
	            },
	            error: function(xhr, status, error) {
	                // 에러 처리 코드
	            }
	        });
	    });


</script>

</html>