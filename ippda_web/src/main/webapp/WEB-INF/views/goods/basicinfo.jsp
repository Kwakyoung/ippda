<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bs-stepper/dist/css/bs-stepper.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bs-stepper/dist/js/bs-stepper.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


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
			<form action="insert" method="post" enctype="multipart/form-data" id="insert">
		<div class="row gy-4">
			<div class="col-md-8 mt-5">
				<div id="stepper2" class="bs-stepper">
					<div class="bs-stepper-header">
						<div class="step" data-target="#test-nl-1">
							<button type="button" class="btn step-trigger">
								<span class="bs-stepper-circle">1</span> <span
									class="bs-stepper-label">상품 분류</span>
							</button>
						</div>
						<div class="line"></div>
						<div class="step" data-target="#test-nl-2">
							<div class="btn step-trigger">
								<span class="bs-stepper-circle">2</span> <span
									class="bs-stepper-label">기본 정보</span>
							</div>
						</div>
						<div class="line"></div>
						<div class="step" data-target="#test-nl-3">
							<button type="button" class="btn step-trigger">
								<span class="bs-stepper-circle">3</span> <span
									class="bs-stepper-label">상세 정보</span>
							</button>
						</div>
						<div class="line"></div>
						<div class="step" data-target="#test-nl-4">
							<button type="button" class="btn step-trigger">
								<span class="bs-stepper-circle">4</span> <span
									class="bs-stepper-label">이미지</span>
							</button>
						</div>




					</div>
					<div class="bs-stepper-content">
						<div id="test-nl-1" class="content">
							<div class="form-group my-3" style="">
								<h4>대분류</h4>
								<select class="form-control" name="goods_middle_category"
									id="item_catemain" title="상품 대분류">
									<option value="">(선택)</option>
									<option value="1">상의</option>
									<option value="2">아우터</option>
									<option value="3">하의</option>
									<option value="4">원피스</option>
									<option value="5">스커트</option>
									<option value="6">신발</option>
									<option value="7">가방</option>
									<option value="8">악세사리</option>
									<option value="9">양말</option>
									<option value="10">시계</option>
									<option value="11">모자</option>
								</select>

								<hr class="divider-w mt-10 mb-20">
								<h4 class="my-2">소분류</h4>
								<select class="form-control" name="goods_sub_category"
									id="item_catesub" title="상품 소분류">
									<option value="">(선택)</option>
								</select>
								<hr class="divider-w mt-10 mb-20">
								<h4>스타일</h4>
								<select class="form-control" name="goods_style" id="goods_style"
									title="상품 스타일">
									<option value="">(선택)</option>
									<option value="201">캐쥬얼</option>
									<option value="202">스트릿</option>
									<option value="203">댄디</option>
									<option value="204">아메카지</option>
									<option value="205">고프코어</option>
									<option value="206">스포츠</option>
									<option value="207">로맨틱</option>
									<option value="208">걸리쉬</option>
									<option value="209">시크</option>
								</select>
							</div>

							<div class="d-flex justify-content-between  mb-5">
							<a class="btn btn-primary text-white justify-content-end" onclick="stepper2.next()">다음</a>
							</div>
						</div>

						<div id="test-nl-2" class="content">
							<div class="form-group my-4 ">
								<h4>상품명</h4>
								<input class="form-control input-lg" type="text"
									placeholder="상품명" name="goods_name" id="goods_name"
									value="${vo.goods_name}" />
							</div>
							<hr class="divider-w mt-10 mb-20">
							<div class="form-group">
								<h4>판매가</h4>
								<input class="form-control input-lg" type="number"
									placeholder="판매가 / 단위 : 원" name="goods_price" id="goods_price"
									value="${vo.goods_price}" />
							</div>
							<hr class="divider-w mt-10 mb-20">

							<div class="form-group">

								<h4>할인율</h4>
								<select class="form-control" name="goods_sale_percent"
									id="goods_sale_percent" title="할인율">
									<option value="0">(없음)</option>
									<option value="10">10%</option>
									<option value="20">20%</option>
									<option value="30">30%</option>
									<option value="40">40%</option>
									<option value="50">50%</option>
									<option value="60">60%</option>
									<option value="70">70%</option>
									<option value="80">80%</option>
									<option value="90">90%</option>
									<option value="100">100%</option>
								</select>
							</div>

							<button type="button" class="btn btn-secondary my-4"
								id="checkPriceBtn">상품가격 확인하기</button>
							<div class="form-group">
								<h3 id="calculated_price_display"></h3>
								<input id="calculated_price" name="goods_sale_price"
									value="${vo.goods_sale_price}" style="display: none">
							</div>
							<div class="d-flex justify-content-between  mb-5">
							<a class="btn btn-info text-white justify-content-start" onclick="stepper2.previous()">이전</a>
							<a class="btn btn-primary text-white justify-content-start" onclick="stepper2.next()">다음</a>
							</div>
						</div>

						<div id="test-nl-3" class="content">
							<div class="form-group">
								<h4>상품내용</h4>
								<textarea class="form-control input-lg" placeholder="내용을 입력하세요"
									name="goods_info" id="goods_info">${vo.goods_info}</textarea>
							</div>


							<div class="form-group my-4">
								<h4>상품성별</h4>
								<select class="form-control" name="goods_gender"
									id="goods_gender" title="상품성별">
									<option value="남">남</option>
									<option value="여">여</option>
									<option value="남여공용">남녀공용</option>
								</select>
							</div>
							<div class="d-flex justify-content-between  mb-5">
							<a class="btn btn-info text-white justify-content-start" onclick="stepper2.previous()">이전</a>
							<a class="btn btn-primary text-white justify-content-start" onclick="stepper2.next()">다음</a>
							</div>
						</div>
						<div id="test-nl-4" class="content">

							<div class="form-group ">
								<h3>메인이미지 ( 썸네일 )</h3>
								<input class="form-control input-lg" type="file" name="file"
									id="itemMainImg" />
								<!-- 수정 화면에서 기존 이미지 및 파일 이름 표시 -->
								<div class="image-info my-3">
									<p>현재 메인 이미지: ${vo.file_main_name}</p>
									<img src="${vo.goods_main_image}" alt="Main Image">
								</div>
								<input name="file_main_name" value="${vo.file_main_name}"
									style="display: none"> <input name="goods_main_image"
									value="${vo.goods_main_image}" style="display: none">
							</div>


							<hr class="divider-w mt-10 mb-20">

							<div class="form-group ">
								<h3>서브이미지 ( 상품설명 이미지 )</h3>
								<input class="form-control input-lg" type="file" name="file"
									id="itemSubImg" />
								<div class="image-info my-3">
									<p>현재 서브 이미지: ${vo.file_sub_name}</p>
									<img src="${vo.goods_sub_image}" alt="Sub Image">
								</div>
								<input name="file_sub_name" value="${vo.file_sub_name}"
									style="display: none"> <input name="goods_sub_image"
									value="${vo.goods_sub_image}" style="display: none">
							</div>


							<div class="d-flex justify-content-between  mb-5">
							<a class="btn btn-info text-white justify-content-start" onclick="stepper2.previous()">이전</a>
							</div>
						</div>
					</div>
				</div>
			</div>
 			 <div class="col-lg-4">
 			  <section id="portfolio-details" class="portfolio-details">
            <div class="portfolio-info">
              <h3>${vo.goods_info }</h3>
              <ul>
                <li><strong>분류</strong>:<span class="badge badge-primary">New</span> 
                	<span class="badge badge-primary">New</span>
                	<span class="badge badge-primary">New</span>
                </li>
                <li><strong>상품명</strong>:상품이름</li>
                <li><strong>가격정보</strong>: 판매가 할인율 <del>판매가</del></li>
                <li><strong>성별</strong>:성별 </li>
                <li><strong>상세정보</strong>:상세정보다 </li>
                <li><strong>메인이미지</strong>:상세정보다 </li>
                <li><strong>서브이미지</strong>:상세정보다 </li>
           
              </ul>
            </div>
         		</section>
         			<input  type="hidden" name="goods_no" id="goods_no"
						value="0" />
         		 <a type="submit" class="btn text-white btn-success col-md-12" id="submit">입력완료</a> 
          </div>
	
		</div>
		</form>
		


	<!-- 		<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link text-dark active fs-5"
					data-tab="basicInfo">기본정보</a></li>
			</ul> -->

		<%-- 	<form action="update" method="post" enctype="multipart/form-data" id="update">


				<div class="form-group my-4" style="display: none;">
					<!--style="display: none;"-->
					<h4>상품번호</h4>
					<input class="form-control input-lg" type="number"
						placeholder="상품번호" name="goods_no" id="goods_no"
						value="${vo.goods_no}" />
			

				<div class="form-group my-3" style="">
					<h4>대분류</h4>
					<select class="form-control" name="goods_middle_category"
						id="item_catemain" title="상품 대분류">
						<option value="">(선택)</option>
						<option value="1">상의</option>
						<option value="2">아우터</option>
						<option value="3">하의</option>
						<option value="4">원피스</option>
						<option value="5">스커트</option>
						<option value="6">신발</option>
						<option value="7">가방</option>
						<option value="8">악세사리</option>
						<option value="9">양말</option>
						<option value="10">시계</option>
						<option value="11">모자</option>
					</select>

					<hr class="divider-w mt-10 mb-20">
					<h4 class="my-2">소분류</h4>
					<select class="form-control" name="goods_sub_category"
						id="item_catesub" title="상품 소분류">
						<option value="">(선택)</option>


					</select>
					<hr class="divider-w mt-10 mb-20">
					<h4>스타일</h4>
					<select class="form-control" name="goods_style" id="goods_style"
						title="상품 스타일">
						<option value="">(선택)</option>
						<option value="201">캐쥬얼</option>
						<option value="202">스트릿</option>
						<option value="203">댄디</option>
						<option value="204">아메카지</option>
						<option value="205">고프코어</option>
						<option value="206">스포츠</option>
						<option value="207">로맨틱</option>
						<option value="208">걸리쉬</option>
						<option value="209">시크</option>
					</select>
				</div>

				<hr class="divider-w mt-10 mb-20">

				<div class="form-group my-4 ">
					<h4>상품명</h4>
					<input class="form-control input-lg" type="text" placeholder="상품명"
						name="goods_name" id="goods_name" value="${vo.goods_name}" />
				</div>
				<hr class="divider-w mt-10 mb-20">
				<div class="form-group">
					<h4>판매가</h4>
					<input class="form-control input-lg" type="number"
						placeholder="판매가 / 단위 : 원" name="goods_price" id="goods_price"
						value="${vo.goods_price}" />
				</div>
				<hr class="divider-w mt-10 mb-20">

				<div class="form-group">

					<h4>할인율</h4>
					<select class="form-control" name="goods_sale_percent"
						id="goods_sale_percent" title="할인율">
						<option value="0">(없음)</option>
						<option value="10">10%</option>
						<option value="20">20%</option>
						<option value="30">30%</option>
						<option value="40">40%</option>
						<option value="50">50%</option>
						<option value="60">60%</option>
						<option value="70">70%</option>
						<option value="80">80%</option>
						<option value="90">90%</option>
						<option value="100">100%</option>
					</select>
				</div>

				<button type="button" class="btn btn-secondary my-4"
					id="checkPriceBtn">상품가격 확인하기</button>
				<div class="form-group">
					<h3 id="calculated_price_display"></h3>
					<input id="calculated_price" name="goods_sale_price"
						value="${vo.goods_sale_price}" style="display: none">
				</div>

				<div class="form-group">
					<h4>상품내용</h4>
					<textarea class="form-control input-lg" placeholder="내용을 입력하세요"
						name="goods_info" id="goods_info">${vo.goods_info}</textarea>
				</div>


				<div class="form-group my-4">
					<h4>상품성별</h4>
					<select class="form-control" name="goods_gender" id="goods_gender"
						title="상품성별">
						<option value="남">남</option>
						<option value="여">여</option>
						<option value="남여공용">남녀공용</option>
					</select>
				</div>

				<hr class="divider-w mt-10 mb-20">

				<div class="form-group ">
					<h3>메인이미지 ( 썸네일 )</h3>
					<input class="form-control input-lg" type="file" name="file"
						id="itemMainImg" />
					<!-- 수정 화면에서 기존 이미지 및 파일 이름 표시 -->
					<div class="image-info my-3">
						<p>현재 메인 이미지: ${vo.file_main_name}</p>
						<img src="${vo.goods_main_image}" alt="Main Image">
					</div>
					<input name="file_main_name" value="${vo.file_main_name}"
						style="display: none"> <input name="goods_main_image"
						value="${vo.goods_main_image}" style="display: none">
				</div>


				<hr class="divider-w mt-10 mb-20">

				<div class="form-group ">
					<h3>서브이미지 ( 상품설명 이미지 )</h3>
					<input class="form-control input-lg" type="file" name="file"
						id="itemSubImg" />
					<div class="image-info my-3">
						<p>현재 서브 이미지: ${vo.file_sub_name}</p>
						<img src="${vo.goods_sub_image}" alt="Sub Image">
					</div>
					<input name="file_sub_name" value="${vo.file_sub_name}"
						style="display: none"> <input name="goods_sub_image"
						value="${vo.goods_sub_image}" style="display: none">
				</div>






				<a type="submit" class="btn btn-secondary my-4" id="submit">입력완료</a>
			</form>
 --%>
		</div>

	</section>


</body>

<script>
var stepper2 = new Stepper(document.querySelector('#stepper2'), {
	linear : false,
	animation : true
});
document.addEventListener("DOMContentLoaded", function() {
    const catemainSelect = document.getElementById("item_catemain");
    const catesubSelect = document.getElementById("item_catesub");
    const calculated_price = document.getElementById("calculated_price");
	
    
    
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
    
    //  총상품가격 확인
	  $("#checkPriceBtn").click(function() {
		        const goodsPriceInput = document.getElementById("goods_price");
		        const salePercentSelect = document.getElementById("goods_sale_percent");
		        const calculatedPriceDisplay = document.getElementById("calculated_price_display");
		
		            const goodsPrice = parseFloat(goodsPriceInput.value);
		            const salePercent = parseFloat(salePercentSelect.value);
		            console.log(goodsPrice);
		            console.log(salePercent);
		            
		            if (!isNaN(goodsPrice) && !isNaN(salePercent)) {
		                const calculatedPrice = goodsPrice - (goodsPrice * salePercent / 100);
		                
		                if(calculatedPrice % 10 !== 0){
		                	alert("총 상품가격은 10원단위로만 가능합니다.")
		                }else{
		                    calculatedPriceDisplay.textContent = "총 상품가격: " + calculatedPrice + "원";
			                document.getElementById("calculated_price").value = calculatedPrice;
		                }
		           
		            } else {
		                alert("상품가격과 세일퍼센트를 입력해주세요")
		            }
		 
	  });
	  
	  
	  // 등록완료 버튼 눌렀을 때 처리
	  $("#submit").click(function() {
			 goodsCategoryMain = document.getElementById("item_catemain").value;
			 goodsCategorySub = document.getElementById("item_catesub").value;
			 goodsStyle = document.getElementById("goods_style").value;
		     goodsName = $("#goods_name").val();		    
		     goodsPrice = $("#goods_price").val();
		     goodsSalePercent = $("goods_sale_percent").val();
		     resultPrice = $("#calculated_price").val();
		     goodsInfo = $("#goods_info").val();
			 const fileInput = document.getElementById("itemMainImg");
			 const fileInput1 = document.getElementById("itemSubImg");
		        const selectedFile = fileInput.files[0]; // 선택된 파일
		        const selectedFile1 = fileInput1.files[0]; // 선택된 파일
		     

		     
		 if(goodsCategoryMain === ""){
			 alert("카테고리를 입력해주세요")
			 
		 }else if(goodsStyle === ""){
			 alert("스타일을 입력해주세요")
		 }else if (goodsName === "") {
			 alert("상품명을 입력해주세요")
		 }else if (goodsPrice === "") {
			 alert("가격을 입력해주세요")
		 }else if (goodsSalePercent === "") {
			alert("세일퍼센트를 입력해주세요")
		}else if(resultPrice === ""){
			alert("상품가격확인하기 버튼을 눌러주세요")
		}else if (goodsInfo === "") {
			alert("상품내용을 입력해주세요")
		}else if(!selectedFile){
			alert("메인이미지를 첨부해주세요")
		}else if(!selectedFile1)
			alert("서브이미지를 첨부해주세요")
		else{
			        const form = document.getElementById("insert"); // 폼 ID를 실제로 사용한 값으로 바꾸세요
			        form.submit();
		}
	
		
	
	  
		});
	  
	

    

});


</script>
</html>