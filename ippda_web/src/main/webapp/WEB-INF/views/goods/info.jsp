<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table img{

	max-height: 120px;

}


</style>

</head>
<body>


   <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

     	<ol>
          <li><a href="<c:url value="/goods/list"/>">상품</a></li>
          <li>상품 상세정보</li>
        </ol>
        <h2>상품 상세정보</h2>		
  	

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- 나중에 상품 이미지가 여러개라면-->
    <section id="portfolio-details" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                  <img src="<c:url value='/img/portfolio/portfolio-1.jpg' />" alt="상품이미지준비중">
                </div>

                <div class="swiper-slide">
                  <img src="<c:url value='/img/portfolio/portfolio-2.jpg' />" alt="상품이미지준비중">
                </div>

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>${vo.goods_info }</h3>
              <ul>
                <li><strong>종류</strong>:${vo.goods_name }</li>
                <li><strong>가격</strong>: <del style="color: gray;">${vo.goods_price}</del><strong>${vo.goods_sale_price }원</strong></li>
                <li><strong>등록일자</strong>:${vo.goods_date }</li>
                
                  <c:choose>
      	<c:when test="${vo.goods_status eq '판매중'}">
      		 	  <li><strong>상태</strong>: <span class="badge badge-primary">${vo.goods_status}</span></li>
      	</c:when>
      	 	<c:when test="${vo.goods_status eq '품절'}">
      	 	  <li><strong>상태</strong>: <span class="badge badge-danger">${vo.goods_status}</span></li>
      	</c:when>
      	<c:otherwise>
        <li><strong>상태</strong>:${vo.goods_status }</li>
      	</c:otherwise>
      </c:choose>
                
                <li>  <button type="button" class="btn btn-light"onclick="location='modify?goods_no=${vo.goods_no}'" >상품수정</button>        
      
  <button type="button" class="btn btn-light"onclick="location='modify/option?goods_no=${vo.goods_no}'">옵션수정</button> </li>
              </ul>
            </div>
            <div class="portfolio-info" style="padding: 5px;">
            <table class="table table-striped">
  <thead>
    <tr>
      <th colspan="2">상품정보 제공고시</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th >제품 소재</th>
      <td>OOFOAM (한국에서 개발한 특수 소재)</td>
    </tr>
          <tr>
                <th s>색상</th>
                <td ><pre>Black / 블랙</pre></td>
            </tr>
                    <tr>
                <th >치수</th>
                <td ><pre>상세설명 별도표기</pre></td>
            </tr>
                    <tr>
                <th>제조사</th>
                <td ><pre>OOFOS</pre></td>
            </tr>
                    <tr>
                <th >제조국</th>
                <td ><pre>대한민국, 베트남</pre></td>
            </tr>
                    <tr>
                <th >취급시 주의사항</th>
                <td ><pre>상세페이지 참고</pre></td>
            </tr>
               
                    <tr>
                <th scope="row">A/S책임자 ∙ 전화번호</th>
                <td ><pre>OOFOS 담당자</pre></td>
            </tr>
    
    
    
  </tbody>
</table>
            
            
         
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Details Section -->


<%-- 
<table class="table table-dark table-striped">
    <colgroup>
        <col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px">
        <col width="100px"><col width="100px">
    </colgroup>
    <tr>
        <th>상품명</th>
        <th>총 상품가격</th>
        <th>가격</th>
        <th>세일퍼센트</th>
        <th>상품이미지</th>
        <th>상태</th>
        <th>등록일자</th>
          <th></th>
            <th></th>
    </tr> 

        <tr>
            <td><a class="text-link" href="info?goods_no=${vo.goods_no}">${vo.goods_name}</a></td>
        	<td>${vo.goods_sale_price} 원</td>
            <td>${vo.goods_price} 원</td>
            <td>${vo.goods_sale_percent}%</td>
            <td><img src="${vo.goods_main_image}" alt="상품 이미지"></td>
            <td>${vo.goods_status}</td>
            <td>${vo.goods_date}</td>
            
            <td class="col-auto">
				<button type="button" onclick="location='modify?goods_no=${vo.goods_no}'" class="btn btn-secondary">수정</button>
			</td>
            	<td class="col-auto">
				<button type="button" onclick="location='option?goods_no=${vo.goods_no}'" class="btn btn-secondary">옵션등록</button>
			</td>
		
			
        </tr>
</table>
 --%>




</body>
</html>