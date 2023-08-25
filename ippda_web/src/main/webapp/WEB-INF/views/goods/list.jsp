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
<!-- 사원정보목록이 없는 경우 -->
<c:forEach items="${goodslist}" var="vo">
<td><a> ${vo.goods_name}</a></td>
<td>${vo.goods_price}</td>

</c:forEach>

<table class="tb-list">
<colgroup>
<col width="80px"><col width="250px"><col width="300px"><col width="300px"><col width="140px">
</colgroup>
<tr>
<th>상품명</th><th>가격</th><th>세일퍼센트</th><th>상품이미지</th><th>상태</th></tr> 
<!-- 사원정보목록이 없는 경우 -->
<c:if test="${empty goodslist}">
<tr><td colspan="5">상품정보가 없습니다</td></tr>

</c:if>
<!-- 사원정보목록이 없는 경우 -->
<c:forEach items="${goodslist}" var="vo">
<tr><td>${vo.goods_name}</td>
<td><a class="text-link" href="info?id=${vo.goods_name}"> ${vo.goods_name}</a></td>
<td>${vo.goods_price}</td>
<td>${vo.goods_sale_percent}</td>
</c:forEach>

</table>
</body>
</html>