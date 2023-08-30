<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
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

  <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">
		<ol>
          <li><a href="<c:url value="/goods/list"/>">상품</a></li>
          <li>상품 목록</li>
        </ol>
        <h2>상품 목록</h2>		
  	

      </div>
    </section><!-- End Breadcrumbs -->
<form method="post" action="list">
    <section class="inner-page">
      <div class="container">
     	 <table class="table table-striped align-middle mb-0 bg-white">
  <thead class="table-dark">
    <tr>
      <th>상품명</th>
      <th>총 상품가격</th>
      <th>가격</th>
      <th>세일퍼센트</th>
      <th>상품이미지</th>
      <th>상태</th>
      <th>등록일자</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${page.list}" var="vo">
    <tr>
      <td>
        <div class="d-flex align-items-center">
      		<a class="text-link" href="info?goods_no=${vo.goods_no}">${vo.goods_name}</a>
          </div>
      </td>
      <td>
        <p class="fw-normal mb-1">
        
        
        ${vo.goods_sale_price} 원</p>
      </td>
      <td>
           <p class="fw-normal mb-1">${vo.goods_price} 원</p>
      </td>
      <td> 
  
      <c:choose>
      	<c:when test="${vo.goods_sale_percent  != 0}">
      	      <span class="text-success">
      <i class="fas fa-caret-down me-1"></i>
      ${vo.goods_sale_percent}%</span>
      	</c:when>
      	<c:otherwise>
      		 ${vo.goods_sale_percent}%
      	</c:otherwise>
      </c:choose>
      </td>
      <td><img src="${vo.goods_main_image}" alt="상품 이미지"></td>
      
      <c:choose>
      	<c:when test="${vo.goods_status eq '판매중'}">
 			<td><span class="badge badge-success rounded-pill d-inline" style="padding: 5px;">판매중</span></td>
      	</c:when>
      	 	<c:when test="${vo.goods_status eq '품절'}">
 			<td><span class="badge badge-danger rounded-pill d-inline" style="padding: 5px;">품절&nbsp; &nbsp;</span></td>
      	</c:when>
      	<c:otherwise>
      		<td>${vo.goods_status}</td>
      	</c:otherwise>
      </c:choose>
      <td>${vo.goods_date}</td>
      <td>
     <div class="btn-group" role="group">
  <button type="button" class="btn btn-light"onclick="location='modify?goods_no=${vo.goods_no}'" >상품수정</button>        
  <button type="button" class="btn btn-light"onclick="location='option?goods_no=${vo.goods_no}'" >옵션등록</button>        
  <button type="button" class="btn btn-light"onclick="location='modify/option?goods_no=${vo.goods_no}'">옵션수정</button> 
</div>
      </td>
    </tr>
   </c:forEach>
   </tbody>
</table>

      </div>
    </section>
                                                              
         
     
















<%-- 

<table class="table table-dark table-striped">
    <colgroup>
        <col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px">
        <col width="100px"><col width="100px"><col width="100px">
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
            <th></th>
    </tr> 
    <c:if test="${empty page.list}">
        <tr><td colspan="5">상품정보가 없습니다</td></tr>
    </c:if>
    <c:forEach items="${page.list}" var="vo">
        <tr>
            <td><a class="text-link" href="info?goods_no=${vo.goods_no}">${vo.goods_name}</a></td>
        	<td>${vo.goods_sale_price} 원</td>
            <td>${vo.goods_price} 원</td>
            <td>${vo.goods_sale_percent}%</td>
            <td><img src="${vo.goods_main_image}" alt="상품 이미지"></td>
            <td>${vo.goods_status}</td>
            <td>${vo.goods_date}</td>
            
            <td class="col-auto">
				<button type="button" onclick="location='modify?goods_no=${vo.goods_no}'" class="btn btn-secondary">상품수정</button>
			</td>
            	<td class="col-auto">
				<button type="button" onclick="location='option?goods_no=${vo.goods_no}'" class="btn btn-secondary">옵션등록</button>
			</td>
			 	<td class="col-auto">
				<button type="button" onclick="location='modify/option?goods_no=${vo.goods_no}'" class="btn btn-secondary">옵션수정</button>
			</td>
			
        </tr>
    </c:forEach>

</table> --%>
<input type="hidden" name="curPage" value="1">
<input type="hidden" name="id">
</form>

<jsp:include page="/WEB-INF/views/include/page.jsp"></jsp:include>

</body>
</html>