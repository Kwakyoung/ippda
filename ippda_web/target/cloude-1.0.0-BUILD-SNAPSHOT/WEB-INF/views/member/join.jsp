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
        		<img src="<c:url value='/img/whitelogo.png'/>">
        		<p>회원 정보를 입력 후, 가입을 <br> 완료해주세요</p>
        	</h3>
        	
            <div class="card-body">
            
                <form method="post" action="register">
                
                	<div class="form-floating mb-3">
					    <input class="form-control" type="text" name="store_ceo" id="store_ceo" required  placeholder="이름">
					    <label>회원명</label>
					</div>
					
					<div class=row>
						<div class="form-floating mb-3 col-md-8">
						    <input class="form-control" type="text" name="store_id" id="store_id" required  placeholder="아이디">
						    <label style="left:10px;">아이디</label>
						</div>
						<div class="col-md-4">
			 				<button class="btn btn-success opacity-50 form-control py-3"  id="btn_idcheck">
			 				중복확인</button>
			 			</div>
					</div>
					
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_pw" id="store_pw" required  type="password" placeholder="비밀번호">
                        <label>비밀번호</label>
                    </div>
                    <div class="form-text" id="pwMessage"></div>
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_pw_check" id="store_pw_check" required  type="password" placeholder="비밀번호 확인" >
                        <label>비밀번호 확인</label>
                    </div>
                    <div class="form-text" id="passwordMessage"></div>
                    
                    
                    <div class="form-floating mb-3">
                        <input class="form-control" name="store_email" id="store_email" required  type="email" placeholder="이메일">
                        <label>이메일</label>
                    </div>
                          		
                
                    <button class="btn btn-success opacity-50 form-control py-2 mt-3" id="btn_success">완료</button>
       
                </form>
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
$(document).ready(function() {
    $("#btn_idcheck").click(function(event) {
    	event.preventDefault(); // 기본 제출 동작 방지
    	
        var store_id = $("#store_id").val();
        var store_ceo = $("#store_ceo").val();
        
        if (store_ceo.trim() === "" || store_id.trim() === "") {
	        alert("올바르게 작성해주세요.");
	        return;
        }
        
        $.ajax({
            url: "idcheck", // 서버의 URL 설정
            type: "POST",
            data: { store_id: store_id },
            success: function(response) {
                if (response === "success") {
                	$("#modal-alert").modal("show");
                    
                } else {
                    alert("이미 존재하는 아이디입니다.");
                }
            }
        });
    });
    
    
    // 확인 버튼 클릭 시 동작
    $("#confirmButton").click(function() {
        // 여기에 확인 시 동작할 코드를 작성하세요.
        // 예를 들어, 회원 가입 등의 프로세스를 계속 진행할 수 있습니다.
	    $("#store_id").prop("disabled", true);
    	$("#btn_idcheck").prop("disabled", true);
    	$("#btn_idcheck").text("중복확인 완료");
        // 모달 닫기
        $("#modal-alert").modal("hide");
    });
    
    
    // 취소 버튼 클릭 시 동작
    $("#cancle").click(function() {
        $("#modal-alert").modal("hide");
    });
    

    // 회원가입 처리
    $("#btn_success").click(function(event) {
        
        var btn_idcheck = $("#btn_idcheck").text();
        var pwMessage = $("#pwMessage").text();
        var store_id = $("#store_id").val();
		var store_ceo = $("#store_ceo").val();
        var store_pw = $("#store_pw").val();
        var store_email = $("#store_email").val();
 
		  if (btn_idcheck === "중복확인 완료" && pwMessage === "비밀번호 조건을 충족합니다.") {
			  $.ajax({
		            url: "register", // 서버의 URL 설정
		            type: "POST",
		            data: {
		                store_ceo: store_ceo,
		                store_id: store_id,
		                store_pw: store_pw,
		                store_email: store_email
		            },
		            success: function(response) {
		                if (response === "success") {
		                    window.location.href = "login";
		                    alert("회원가입을 축하합니다.")
		                } else {
		                    alert("회원 가입 중 오류가 발생했습니다.");
		                }
		            }
		        }); 	

		  } else {
			event.preventDefault(); // 기본 제출 동작 방지
		    alert("아이디 중복확인 또는 비밀번호 조건을 확인해주세요.");
		  }
    });
    
    $("#store_pw").keyup(checkPasswordStrength);
    $("#store_pw_check").keyup(matchPasswords);
    
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