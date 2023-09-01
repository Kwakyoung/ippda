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
select#goods_size { width: 100px }
</style>
</head>
<body>
	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="<c:url value="${category_url }"/>">${category_main}</a></li>
				<li>${category_sub}</li>
			</ol>
			<h2>${category_sub}</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container ">
	<form action="option/update" method="post" name="itemInsertForm"
		id="itemInsertForm" enctype="multipart/form-data">

		<div class="form-group my-4" style="display: none;"> <!--style="display: none;"--> 
			<h4>상품번호</h4>
			<input class="form-control input-lg" type="number" placeholder="상품번호"
				name="goods_no" id="goods_no" value="${goods_no} "  />
		</div>
		
	
 		<div class="form-group my-4" style="display: none;"> <!--style="display: none;"--> 
			<h4>가맹점번호</h4>
			<input class="form-control input-lg" type="number" placeholder="가맹점번호"
				name="store_no" id="store_no" value="${store_no}"/>
		</div>
		<!-- 상품등록 -->

		<div class="tab-pane active my-4" id="itemInsert_1">
	
		



			<c:forEach var="option" items="${vo}">
				<div class="options-container"  data-no="${option.goods_option_no}">
			
					<div class="option" style="display: none;">
						<p>옵션 번호</p>
						<input type="text" class="p-2 g-col-6" name="goods_option_no" value="${option.goods_option_no}" id="goods_option_no">
					</div>
					<div class="option" id="option1">
						<p>사이즈 :</p>
<%-- 						<input type="text" class="p-2 g-col-6" name="goods_size" value="${option.goods_size}"> --%>
						<select class="form-control" id="goods_size"  name="goods_size"
							title="상품 사이즈">
							<option value="">(선택)</option>
							<option value="2XS" ${option.goods_size == '2XS' ? 'selected' : ''}>2XS</option>
							<option value="XS" ${option.goods_size == 'XS' ? 'selected' : ''}>XS</option>
							<option value="S" ${option.goods_size == 'S' ? 'selected' : ''}>S</option>
							<option value="M" ${option.goods_size == 'M' ? 'selected' : ''}>M</option>
							<option value="L" ${option.goods_size == 'L' ? 'selected' : ''}>L</option>
							<option value="XL" ${option.goods_size == 'XL' ? 'selected' : ''}>XL</option>
							<option value="2XL" ${option.goods_size == '2XL' ? 'selected' : ''}>2XL</option>
							<option value="3XL" ${option.goods_size == '3XL' ? 'selected' : ''}>3XL</option>
							<option value="FREE" ${option.goods_size == 'FREE' ? 'selected' : ''}>FREE</option>
						</select>
					</div>

					<div class="option" id="option2">
						<p>색깔 :</p>
						<input type="text" class="p-2 g-col-6" name="goods_color" value="${option.goods_color}">
					</div>
					
						<div class="option" id="option3">
						<p>수량 :</p>
						<input type="text" class="p-2 g-col-6" name="goods_cnt" value=" ${option.goods_cnt}">
					</div>
					
					<button type="button" class="btn btn-secondary optionDelete" >삭제</button>

				</div>
			</c:forEach>
			<div id="options-container"></div>x
		
		</div>
		<button type="submit" class="btn btn-secondary" >수정완료</button>
	</form>
	</div>
	</section>
	<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>
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
		 

	  }
	

	  
	  });

	  $(".optionDelete").click(function() {
		  modalAlert('danger', '옵션 삭제', '선택한 옵션을 삭제하시겠습니까?')
		  new bootstrap.Modal('#modal-alert').show();
		  $('#modal-alert').attr( 'data-no', $(this).closest('.options-container').data('no') );
	  });
	  
	  
	//모달창으로 삭제여부 confirm 시 예 버튼 클릭할때만 서브밋
	  $('#modal-alert .btn-danger').click(function(){
		  
	  	$.ajax({
	  		url: 'deleteOption',
	  		data: {goods_option_no: $('#modal-alert').data('no') },
	  		success: function(result) {
				if(result == 1){
					$('.options-container[data-no="'+ $('#modal-alert').data('no') + '"]').remove()  
					$('#modal-alert').removeClass('show').addClass('fade')
					$('#modal-alert .btn-ok').trigger('click');
				}
			}
	  		
	  	});
	  	
	  });
});

</script>

</html>