<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="list">
<table class="table align-middle mb-0 bg-white">
  <thead class="bg-light">
    <tr>
      <th>상품번호</th>
      <th>유저번호</th>
      <th>리뷰작성일</th>
      <th>내용</th>
      <th>별점</th>
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
            <p class="fw-bold mb-1">${vo.goods_no}</p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1">${vo.member_no}</p>
      </td>
    
      <td>${vo.insert_date}</td>
      <td>
      	${vo.content}
      </td>
       <td>
      	${vo.rating }
      </td>
  
      <td>
        <button type="button" id="modify" class="btn-outline-primary btn-sm"onclick="location='info?order_no=${vo.review_no}'" >
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