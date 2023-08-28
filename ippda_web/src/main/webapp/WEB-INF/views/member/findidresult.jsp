<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	font-weight:bold;
}
</style>
</head>
<body>

<div class="row justify-content-center h-100 align-items-center">
    <div class="col-md-9 col-lg-7 col-xl-5">
        <div class="card shadow-lg border-0 rounded-lg px-3 py-4">
        <a href="login">로그인 화면으로</a>
        	<h3 class="text-center mb-5">
        		<img src="<c:url value='/img/whitelogo.png'/>">
        		<br>아이디 찾기 결과
        	</h3>

            <div class="card-body mt-2">
                <div class="text-center">
                	<h5>회원님의 휴대전화로<br>가입된 아이디는 아래와 같습니다.</h5>
                	<p class="mt-4" id="resultText">아이디는 : ${foundId} 입니다. </p>
                </div>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>



</body>
</html>