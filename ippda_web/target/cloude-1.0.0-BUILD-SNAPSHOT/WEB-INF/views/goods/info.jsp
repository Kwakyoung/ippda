<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>