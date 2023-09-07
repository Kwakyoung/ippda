<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background:;
}
</style>
</head>
<body>
<form method="post" action="list">
<table class="container table align-middle mb-0 bg-white">
  <thead class="bg-light">
    <tr>
      <th>상품명</th>
      <th>주문날짜</th>
      <th>상태</th>
      <th>주소</th>
      <th>색상</th>
      <th>사이즈</th>
      <th>수량</th>
    </tr>
  </thead>
  <tbody>
  	<c:if test="${empty page.list}">
							<tr>
								<td colspan="7">주문정보가 없습니다.</td>
							</tr>
						</c:if>
  			<c:forEach items="${page.list}" var="vo">
    <tr>
      <td>
        <div class="d-flex align-items-center">
          <img
              src="https://mdbootstrap.com/img/new/avatars/8.jpg"
              alt=""
              style="width: 45px; height: 45px"
              class="rounded-circle"
              />
          <div class="ms-3">
            <p class="fw-bold mb-1">${vo.order_goods_name}</p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1">${vo.order_date}</p>
      </td>
      <c:choose>
      	<c:when test="${vo.order_status eq '결제완료'}">
 			<td><span class="badge badge-success rounded-pill d-inline" style="padding: 5px;">결제완료</span></td>
      	</c:when>
      	<c:when test="${vo.order_status eq '배송준비중'}">
 			<td><span class="badge badge-success rounded-pill d-inline" style="padding: 5px;">배송준비중</span></td>
      	</c:when>
      	  	<c:when test="${vo.order_status eq '배송중'}">
 			<td><span class="badge badge-success rounded-pill d-inline" style="padding: 5px;">배송중</span></td>
      	</c:when>
      	  	  	<c:when test="${vo.order_status eq '배송완료'}">
 			<td><span class="badge badge-success rounded-pill d-inline" style="padding: 5px;">배송완료</span></td>
      	</c:when>
      	 	<c:when test="${vo.order_status eq '취소'}">
 			<td><span class="badge badge-danger rounded-pill d-inline" style="padding: 5px;">취소&nbsp; &nbsp;</span></td>
      	</c:when>
      	<c:otherwise>
      		<td>${vo.goods_status}</td>
      	</c:otherwise>
      </c:choose>
      <td>${vo.order_address}</td>
      <td>
      	${vo.order_color }
      </td>
       <td>
      	${vo.order_size }
      </td>
           <td>
      	${vo.order_cnt }
      </td>
      <td>
        <button type="button" id="modify" class="btn-outline-primary btn-sm"onclick="location='info?order_no=${vo.order_no}'" >
  <i class="fas fa-magic"></i>
  주문정보
</button>
</td>
    </tr>
   	
    </c:forEach>
  </tbody>
</table>


		<input type="hidden" name="curPage" value="1"> 
		<input type="hidden" name="id">
	</form>

	<jsp:include page="/WEB-INF/views/include/page.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){

	
	$('td').addClass('align-middle');
	


</script>

</body>
</html>