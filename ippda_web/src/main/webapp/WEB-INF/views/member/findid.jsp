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
        		<p>아이디 찾기</p>
        	</h3>
            <div class="card-body">
                <form method="post" action="findidresult">
					<div class="form-floating mb-3">
					    <input class="form-control" type="text" name="store_ceo" 
					    						required  placeholder="이름">
					    <label>이름</label>
    
					</div>
					
						<div class="row px-1">
				 			<div class="form-floating mb-3 col-md-8">
	                        	<input class="form-control" name="store_phone"  required  id="store_phone" type="text" placeholder="휴대폰 번호" autocomplete="off">
	                        	<label>휴대폰 번호 입력</label>
	                    	</div>
				 			<div class="col-auto">
				 				<a class="btn btn-success opacity-50 form-control py-3" id="btn_check">
				 				인증번호 발송</a>
				 			</div>
				 		</div>

	                    
	                    <div class="form-floating mb-3">
	                        <input class="form-control" name="store_phone_check"  required  id="store_phone_check" type="text" placeholder="인증번호" autocomplete="off">
	                        <label>인증번호 입력</label>
	                    </div>
	                    
	                    <button class="btn btn-success opacity-50 form-control mt-2 mb-3" id="findid">아이디 찾기</button>
                   
                    
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
$(document).ready(function(){
	$("#btn_check").click(function(){
		var InputValue = $("#store_phone").val();
		
		if (InputValue.trim() !==""){
			alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
			
			
		} else {
			alert("빈칸을 입력해주세요.")
		}
	
	});
	
});
	


</script>
</body>
</html>