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
                <form method="post" action="changePw">
					<div class="form-floating mb-3">
					    <input class="form-control" type="password" name="store_pw" id="store_pw" 
					    						required  placeholder="새로운 비밀번호">
					</div>
					<div class="form-text mb-4" id="pwMessage"></div>
					
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_pw_check"  required  type="password" placeholder="비밀번호 확인" id="store_pw_check">
                    </div>
             		<div class="form-text mb-4" id="passwordMessage"></div>
             		
             		
                	<input type="hidden" name="store_id" value="${foundId}">
                	
                    <button class="btn btn-success opacity-50 form-control py-2 mt-3" id="btn_success">완료</button>
       
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
$(document).ready(function() {
	$("#store_pw").keyup(checkPasswordStrength);
    $("#store_pw_check").keyup(matchPasswords);
	
	$("#btn_success").click(function(event){
		var store_pw = $("#store_pw").val();
		var store_pw_check = $("#store_pw_check").val();
		
		var pwMessage = $("#pwMessage").text();
	    
		 if (store_pw === store_pw_check && store_pw.trim() !== "" && pwMessage === "비밀번호 조건을 충족합니다." ) {
	            alert("비밀번호가 변경되었습니다.");
	}else {
		alert("비밀번호와 비밀번호 확인을 다시 확인해주세요.");
		event.preventDefault(); // 폼 제출을 막음
	}
		
	});
});


function checkPasswordStrength() {
    var password = $("#store_pw").val();
    var pwMessage = $("#pwMessage");
    var strongRegex = new RegExp(
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})"
    );

    if (strongRegex.test(password)) {
    	pwMessage.text("비밀번호 조건을 충족합니다.");
    	pwMessage.css("color", "green");
    } else {
    	pwMessage.text("비밀번호는 영문 대/소문자, 숫자, 특수문자를 조합하여 8자 이상 입력해야 합니다.");
    	pwMessage.css("color", "red");
    	$("#btn_success").prop("disabled", true); // 버튼 비활성화
    }

    matchPasswords();
}

function matchPasswords() {
    var password = $("#store_pw").val();
    var passwordCheck = $("#store_pw_check").val();
    
    var passwordMessage = $("#passwordMessage");

    if (passwordCheck === "") {
        // passwordCheck 값이 비어있을 때 처리
        passwordMessage.text(""); // 문구를 비우거나 원하는 내용을 추가
        $("#btn_success").prop("disabled", true); // 버튼 비활성화
    } else if (password === passwordCheck) {
        passwordMessage.text("비밀번호 일치");
        passwordMessage.css("color", "green");
        $("#btn_success").prop("disabled", false); // 비밀번호가 일치하면 버튼 활성화
        
    } else {
        passwordMessage.text("비밀번호 불일치");
        passwordMessage.css("color", "red");
        $("#btn_success").prop("disabled", true); // 비밀번호가 불일치하면 버튼 비활성화
    }

}

</script>


</body>
</html>