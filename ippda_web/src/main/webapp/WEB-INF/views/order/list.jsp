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

<table class="table table-dark table-striped">
    <colgroup>
        <col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px"><col width="200px">
        <col width="100px"><col width="100px"><col width="100px">
    </colgroup>
    <tr>
<!--         <th>상품명</th> -->
<!--         <th>총 상품가격</th> -->
<!--         <th>가격</th> -->
<!--         <th>세일퍼센트</th> -->
<!--         <th>상품이미지</th> -->
<!--         <th>상태</th> -->
<!--         <th>등록일자</th> -->
<!--           <th></th> -->
            <th></th>
            <th></th>
    </tr> 
    <c:if test="${empty page.list}">
        <tr><td colspan="5">상품정보가 없습니다</td></tr>
    </c:if>
    <c:forEach items="${page.list}" var="vo">
        <tr>
            <td><a class="text-link"></a></td>
        	<td>${vo.order_no} </td>
       
 
        </tr>
    </c:forEach>
</table>
<form>
<input type="hidden" name="curPage" value="1">
<input type="hidden" name="id">
</form>

<jsp:include page="/WEB-INF/views/include/page.jsp"></jsp:include>



</body>
</html>