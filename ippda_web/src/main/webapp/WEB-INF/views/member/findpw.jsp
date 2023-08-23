<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<div class="row justify-content-center h-100 align-items-center">
    <div class="col-md-9 col-lg-7 col-xl-5">
        <div class="card shadow-lg border-0 rounded-lg px-3 py-4">
        <a href="login">로그인 화면으로</a>
        	<h3 class="text-center">
        		<a href="<c:url value='/sales'/>"><img src="<c:url value='/img/whitelogo.png'/>"></a>
        		<p>비밀번호 찾기</p>
        	</h3>
            <div class="card-body">
                <form method="post" action="findpwresult">
					<div class="form-floating mb-3">
					    <input class="form-control" type="text" name="store_id" 
					    						required  placeholder="아이디">
					    <label>아이디</label>
					</div>
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_phone"  required  type="text" placeholder="휴대폰 번호">
                        <label>휴대폰 번호 입력</label>
                       
                    </div>
             		<div class="form-floating mb-3 toggleable" style="display: none;">
                        <input class="form-control" name="store_phone_check"  required  type="text" placeholder="인증번호" autocomplete="off">
                        <label>인증번호 입력</label>
                    </div>
                
                    <button class="btn btn-success opacity-50 form-control py-2 mt-3">인증번호 보내기</button>
       
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>

const button = document.querySelector('.btn-success');
const toggleableDiv = document.querySelector('.toggleable');

	button.addEventListener('click', function() {
   	 	toggleableDiv.style.display = 'block';
});
	

</script>
</body>
</html>