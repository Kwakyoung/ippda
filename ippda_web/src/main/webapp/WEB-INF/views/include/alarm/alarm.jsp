<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<table class="table table-dark table-striped">
<thead><tr><th>옵션</th><th>색상</th><th>상태</th></tr></thead>
<tbody>
<c:forEach items="${alarmList}" var="alarm">
<tr data-order="${alarm.order_no }"><td>${alarm.goods_option_no }</td>
<td>${alarm.order_color }</td>
<td>${alarm.order_status }</td>
</tr>
</c:forEach>
</tbody>
</table>