<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>

<body>

	<h3 class="my-4">상품 등록</h3>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link text-dark fs-5"
			data-tab="basicInfo">기본정보</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-5 active"
			data-tab="optionSettings">옵션설정</a></li>
	</ul>



	<form action="option/insert" method="post" name="itemInsertForm"
		id="itemInsertForm" enctype="multipart/form-data">

<div class="form-group my-4"> <!--style="display: none;"--> 
			<h4>상품번호</h4>
			<input class="form-control input-lg" type="number" placeholder="상품번호"
				name="goods_no" id="goods_no" value="${goodsInfo.goods_no}" />
		</div>
		
	
 		<div class="form-group my-4"> <!--style="display: none;"--> 
			<h4>가맹점번호</h4>
			<input class="form-control input-lg" type="number" placeholder="가맹점번호"
				name="store_no" id="store_no" value="${loginInfo.store_no}" />
		</div>
		<!-- 상품등록 -->

		<div class="tab-pane active my-4" id="itemInsert_1">
	
		
			<hr class="divider-w mt-10 mb-20">

		<button type="button" class="btn btn-secondary my-4" id="option">옵션추가</button>
		
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


document.addEventListener("DOMContentLoaded", function() {
    const catemainSelect = document.getElementById("item_catemain");
    const catesubSelect = document.getElementById("item_catesub");
    
    const subCategories = {
        1: ["니트/스웨터","후드 티셔츠", "맨투맨/스웨트셔츠", "긴소매 티셔츠", "셔츠/블라우스", "피케/카라티셔츠", "반소매 티셔츠", "민소매 티셔츠", "기타 상의"], // 예시: 각 대분류에 맞는 소분류들
        2: ["후드 집업", "블루종/MA-1", "레더/라이더스 재킷", "무스탕/퍼", "트러커 재킷" , "슈트/블레이저 재킷", "카디건", "아노락 재킷", "플리스/뽀글이",
        	"트레이닝 재킷", "환절기 코트", "겨울 싱글 코트", "겨울 더블 코트", "롱패딩/롱헤비 아우터", "숏패딩/숏헤비 아우터","패딩 베스트", "베스트", "사파리/헌팅 재킷", "나일론/코치 재킷", "기타 아우터"],
        3: [ "데님 팬츠", "코튼 팬츠", "슈트 팬츠/슬랙스", "트레이닝/조거 팬츠", "숏 팬츠", "레깅스", "점프 슈트/오버올", "스포츠 하의", "기타 바지" ],
		4: [ "미니 원피스", "미디 원피스", "맥시 원피스" ],
        5: [ "미니스커트", "미디스커트", "롱스커트" ],
		6: [ "구두", "로퍼", "힐/펌프스", "플랫 슈즈", "블로퍼", "샌들", "슬리퍼", "기타 신발", "모카신/보트 슈즈", "신발 용품", "캔버스/단화", "패션스니커즈화", "스포츠 스니커즈", "기타 스니커즈" ],
        7 : [ "백팩", "메신저/크로스 백", "숄더백", "토트백", "에코백", "보스턴/드럼/더플백", "웨이스트 백", "파우치 백", "모카신/보트 슈즈", "브리프케이스", "캐리어", "가방 소품", "지갑/머니클립", "클러치 백", "기타 가방" ],
		8: [ "팔찌", "반지", "목걸이/펜던트", "귀걸이", "발찌", "브로치/배지", "헤어 악세사리", "기타 악세사리" ],
        9: [ "양말", "스타킹", "기타 양말" ],
		10: [ "디지털", "쿼츠 아날로그", "오토매틱 아날로그", "시계 용품", "기타 시계" ],
		11 : [ "캡/야구 모자", "헌팅캡/베레모", "페도라", "버킷/사파리햇", "비니", "트루퍼", "기타 모자" ],

    };
    
    catemainSelect.addEventListener("change", function() {
        const selectedCatemain = catemainSelect.value;
        catesubSelect.innerHTML = ""; // 먼저 기존의 소분류 옵션들을 지웁니다.

        const subCats = subCategories[selectedCatemain];
        for (let i = 0; i < subCats.length; i++) {
            const subCat = subCats[i];
            const option = document.createElement("option");
            option.value = i + 1;
            option.textContent = subCat;
            catesubSelect.appendChild(option);
        }
    });




$(document).ready(function() {
	  var optionCount = 1; // 추가된 옵션 개수 초기값
	  var selectedSize = "";
	   var goodsColor;
	   var goodsCnt;

	 
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
			
			var optionId = "option_" + optionCount;
			
		    var newOption = '<div class="option" id="' + optionId + '">' +
	        '<input type="text" for="newOption" class="p-2 g-col-6" name="goods_option_size" value= "'+selectedSize+'">' + selectedSize + '</input>'+
	        '<input type="text" for="newOption" class="p-2 g-col-6" name="goods_option_color" value="'+goodsColor+'">' + goodsColor + '</input>'+
	        '<input type="text" for="newOption" class="p-2 g-col-6" name="goods_option_cnt" value="'+goodsCnt+'">' + goodsCnt + '</input>'+
	        '<button type="button" class="btn btn-secondary optionDelete" id="optionDelete" data-option-id="' + optionId + '">삭제</button>'+
	        '</div>'; 
				console.log(optionId);
			
	        console.log("item_color 값:", goodsColor);
	        
		    $("#options-container").append(newOption);
		    optionCount++; // 옵션 개수 증가
		 
		    // 삭제 버튼 클릭 이벤트 처리
		    $(document).on("click", ".optionDelete", function() {
		        var optionIdToDelete = $(this).data("option-id");
		        $("#" + optionIdToDelete).remove();
		    });
		 }
		 
		 

	  });
	  

// 	  $('#regist').click(function(){
// 		  console.log("goods_size 값:", $('[name=goods_option_size]').val() );
// 		  console.log("goods_color 값:", $('[name=goods_option_color]').val() );
// 		  console.log("goods_cnt 값:", $('[name=goods_option_cnt]').val() );
// 	  })
	  
	  
	});


});

</script>

</html>