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
      <th>상품명</th>
      <th>닉네임</th>
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
  
            <p class="fw-bold mb-1">${vo.goods_name}</p>
      
      </td>
      <td>
        <p class="fw-normal mb-1">${vo.member_nickname}</p>
      </td>
    
      <td>${vo.insert_date}</td>
      <td>
      	${vo.content}
      </td>
       <td>
      	${vo.rating }
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