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
<h3 class="my-4">상품 목록</h3>


<form method="post" action="list">
	<div class="col-auto">
		<div class="input-group">
			<select class="form-select" name="search">
				<option value="s1" ${page.search eq 's1' ? 'selected' : ''}>전체</option>
				<option value="s2" ${page.search eq 's2' ? 'selected' : ''}>제목</option>
				<option value="s3" ${page.search eq 's3' ? 'selected' : ''}>내용</option>
				<option value="s4" ${page.search eq 's4' ? 'selected' : ''}>작성자</option>
				<option value="s5" ${page.search eq 's5' ? 'selected' : ''}>제목+내용</option>
			</select>
			<input type="text" name="keyword" class="form-control" value="${page.keyword}">
			<button class="btn btn-primary px-3">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</div>
	</div>





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
    <c:if test="${empty goodslist}">
        <tr><td colspan="5">상품정보가 없습니다</td></tr>
    </c:if>
    <c:forEach items="${goodslist}" var="vo">
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
</table>
<input type="hidden" name="curPage" value="1">
<input type="hidden" name="id">
</form>
</body>
</html>