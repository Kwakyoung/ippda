<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<nav>
  <ul class="pagination mt-3 justify-content-center">
    
    <!-- 이전블럭 -->
    <c:if test="${page.curBlock gt 1 }">
    	<li class="page-item"> <!-- 처음으로 -->
    		<a class="page-link" onclick="page(1)"><i class="fa-solid fa-angles-left"></i></a>
    	</li>
    	<li class="page-item"> <!-- 이전으로 -->
<%--     		<a class="page-link" onclick="page(${page.beginPage-1})"><i class="fa-solid fa-angle-left"></i></a> --%>
    		<a class="page-link" onclick="page(${page.beginPage-page.blockPage})"><i class="fa-solid fa-angle-left"></i></a>
    	</li>
    </c:if>
    
    <c:forEach var="no" begin="${page.beginPage}" end="${page.endPage}">
	    <c:if test="${no eq page.curPage}">
	    	<li class="page-item"  aria-current="page"><a class="page-link active btn-dark">${no}</a></li>
	    </c:if>
	    <c:if test="${no ne page.curPage}">
	   	 	<li class="page-item "><a class="page-link" onclick="page(${no})">${no}</a></li>
	    </c:if>
    </c:forEach>
    <!-- 다음블럭 -->    
    <c:if test="${page.curBlock lt page.totalBlock }">
    <li class="page-item"> <!-- 다음 -->
    	<a class="page-link" onclick="page(${page.endPage+1})"><i class="fa-solid fa-angle-right"></i></a>
    </li>
    <li class="page-item"> <!-- 마지막 -->
    	<a class="page-link" onclick="page(${page.totalPage})"><i class="fa-solid fa-angles-right"></i></a>
    </li>
    </c:if>
    
  </ul>
</nav>

<script>
function page(no){
	$('[name=curPage]').val( no );
	$('form').submit()
}
</script>