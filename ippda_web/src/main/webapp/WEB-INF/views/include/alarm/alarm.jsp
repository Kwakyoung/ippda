<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<table class="table table-dark table-striped">

<thead><tr><th style="display: none">옵션</th><th>상태</th><th>주문날짜</th><th>주소</th><th>색상</th><th>사이즈</th><th>수량</th><th>가격</th></tr></thead>
<tbody>
<c:forEach items="${alarmList}" var="alarm">
<tr data-order="${alarm.order_no }"><td style="display: none">${alarm.goods_option_no }</td>
<td>${alarm.order_status }</td>
<td>${alarm.order_date }</td>
<td>${alarm.order_address }</td>
<td>${alarm.order_color }</td>
<td>${alarm.order_size }</td>
<td>${alarm.order_cnt }</td>
<td>${alarm.order_price }</td>
</tr>
</c:forEach>
</tbody>
</table>