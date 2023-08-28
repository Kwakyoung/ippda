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
        <div class="card shadow-lg border-0 rounded-lg px-3 py-5">
        	<h3 class="text-center">
        		<a href="<c:url value='/sales'/>"><img src="<c:url value='/img/whitelogo.png'/>"></a>
        		<p>새 비밀번호로 변경하기</p>
        	</h3>
            <div class="card-body">
                <form method="post" action="login">
					<div class="form-floating mb-3">
					    <input class="form-control" type="password" name="store_pw" 
					    						required  placeholder="비밀번호">
					    <label>새로운 비밀번호</label>
					</div>
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_pw_check"  required  type="password" placeholder="비밀번호 확인">
                        <label>비밀번호 확인</label>
                    </div>
             		
                
                    <button class="btn btn-success opacity-50 form-control py-2 mt-3">완료</button>
       
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
	

</script>
</body>
</html>