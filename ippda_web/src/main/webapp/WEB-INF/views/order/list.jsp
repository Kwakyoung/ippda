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
		<form action="">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<table class="table table-dark">
					<colgroup>
						<col width="100px">
						<col width="200px">
						<col width="400px">
						<col width="100px">
						<col width="100px">
						<col width="100px">
						<col width="100px">
						<col width="100px">
					</colgroup>
					<tr>

						<th>상품명</th>
						<th>주문날짜</th>
						<th>주소</th>
						<th>색상</th>
						<th>사이즈</th>
						<th>수량</th>
						<th>가격</th>
						<th>상태</th>


					</tr>
			
						<c:if test="${empty page.list}">
							<tr>
								<td colspan="5">상품정보가 없습니다</td>
							</tr>
						</c:if>
						<c:forEach items="${page.list}" var="vo">
							<tr>
								<td>${vo.goods_no}</td>
								<td>${vo.order_date}</td>
								<td>${vo.order_address}</td>
								<td>${vo.order_color}</td>
								<td>${vo.order_size}</td>
								<td>${vo.order_cnt}</td>
								<td>${vo.order_price}</td>




							</tr>
						</c:forEach>

				</table>
			</div>
		</div>
	</div>

	</form>
	<form>
		<input type="hidden" name="curPage" value="1"> <input
			type="hidden" name="id">
	</form>

	<jsp:include page="/WEB-INF/views/include/page.jsp"></jsp:include>



</body>
</html>