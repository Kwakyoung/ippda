<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .link-container {
 	display : flex;
 	gap : 15px;
 }
 
 a {
 	color : #666;
 }
 
 a:hover {
 	color : #000;
 }
</style>
</head>
<body>

<div class="row justify-content-center h-100 align-items-center">
    <div class="col-md-9 col-lg-7 col-xl-5">
        <div class="card shadow-lg border-0 rounded-lg px-3 py-5">
        	<h3 class="text-center mb-3.5">
        		<a href="<c:url value='/sales'/>"><img src="<c:url value='/img/whitelogo.png'/>"></a>
        	</h3>
            <div class="card-body">
                <form method="post" action="ippdaLogin">
					<div class="form-floating mb-3">
					    <input class="form-control" type="text" name="store_id" 
					    						required  placeholder="아이디">
					    <label>아이디</label>
					</div>
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_pw"  required  type="password" placeholder="비밀번호">
                        <label>비밀번호</label>
                    </div>
             	
                <div class="d-flex align-items-center justify-content-between mt-1 mb-4">
                    <a class="small" href="register">회원가입</a>
                    
                    <div class ="link-container">
                    <a class="small" href="findid">아이디 찾기</a>
                    <a class="small" href="findpw">비밀번호 찾기</a>
                    </div>
                    
                </div>
                    <button class="btn btn-success opacity-50 form-control py-2">로그인</button>
       
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>

$(function(){
	modalAlert( "warning", "로그인 실패", "아이디나 비밀번호가 일치하지 않습니다!" );
	
	if( ${not empty fail} ){ //로그인 실패인 경우
		new bootstrap.Modal( $('#modal-alert') ).show();
	}
})

$('#modal-alert .btn-ok').click(function(){
	$('[name=userid]').focus();
})

</script>
</body>
</html>