<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col mx-auto">

	<form action="update" method="post" enctype="multipart/form-data" id="update">
<h3 class="my-4">주문정보</h3>
<input type="text" name="order_no" value="${orderInfo.order_no }" style="display: none">
<table class="table align-middle mb-0 bg-white">
<colgroup><col width="180px"><col>
		<col width="160px"><col width="160px">
		<col width="100px"><col width="100px">
</colgroup>
<tr><th>상품명</th>
	<td colspan="5">${orderInfo.order_goods_name }</td>
</tr>
<tr><th>주문날짜</th>
	<td colspan="5">${orderInfo.order_date }</td>
</tr>
<tr>
	<th>상태</th>
	<c:choose>
	<c:when test="${orderInfo.order_status eq '취소' }">
		<td colspan="5">취소</td>
	</c:when>
	<c:otherwise>
	<td>
			<select class="form-control" name="order_status" id="order_status"
				title="상품 스타일">
				<option value="${orderInfo.order_status }">${orderInfo.order_status }</option>
				<option value="배송준비중">배송준비중</option>
				<option value="배송중">배송중</option>
				<option value="배송완료">배송완료</option>
				<option value="취소">취소</option>
			</select>
	</td>
	</c:otherwise>
	</c:choose>
	</tr>
	<tr>
	<th >주소</th>
	<td colspan="5">${orderInfo.order_address }</td>
	</tr>
<tr><th>색상</th>
	<td colspan="5">${orderInfo.order_color } </td>
</tr>
<tr><th>사이즈</th>
	<td colspan="5">${orderInfo.order_size } </td>
</tr>

<tr><th>수량</th>
	<td colspan="5">${orderInfo.order_cnt } </td>
</tr>


</table>
<div class="btn-toolbar gap-2 my-3 justify-content-center">
	<a class="btn btn-primary" id="btn-list">주문목록</a>
		<button type="submit" class="btn btn-secondary" >주문수정</button>
	<a class="btn btn-primary" id="btn-delete">주문삭제</a>
</div>

</form>
</div>
</body>

<script type="text/javascript">

$('#btn-list, #btn-modify, #btn-delete').click(function(){
	var id = $(this).attr('id');
	id = id.substr( id.indexOf('-')+1 );
	
	if( id=='delete'){
		modalAlert('danger', '방명록 삭제', '이 방명록 글을 삭제하시겠습니까?')
		new bootstrap.Modal('#modal-alert').show()
	}else
		$('form').attr( 'action', id ).submit()
})

//모달창으로 삭제여부 confirm 시 예 버튼 클릭할때만 서브밋
$('#modal-alert .btn-danger').click(function(){
	$('form').attr( 'action', 'delete' ).submit()
})
</script>
</html>