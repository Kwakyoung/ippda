<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
        <div class="card shadow-lg border-0 rounded-lg px-3 py-4">
        <div style="display: flex; justify-content: space-between;">
        	<a href="login">로그인 하러가기</a>
        	<a href="findid">아이디 찾기</a>
        </div>
        	<h3 class="text-center">
        		<a href="<c:url value='/sales'/>"><img src="<c:url value='/img/whitelogo.png'/>"></a>
        		<p>비밀번호 찾기</p>
        	</h3>
            <div class="card-body">
            
                <form method="post" action="findingpw" id="findpw">
					
					<div class="form-floating mb-3">
					    <input class="form-control" type="text" name="store_id" id="store_id" required  placeholder="아이디">
					    <label>아이디</label>
					</div>
					
					<div class="row">
			 			<div class="form-floating mb-3 col-md-8">
                        	<input class="form-control" name="store_phone"  required  id="store_phone" type="text" placeholder="휴대폰 번호" autocomplete="off">
                        	<label style="left:10px;">휴대폰 번호 입력</label>
                    	</div>
			 			<div class="col-md-4">
			 				<button class="btn btn-success opacity-50 form-control py-3"  id="btn_phone">
			 				인증번호 발송</button>
			 			</div>
			 		</div>

	                <div class="row">    
	                    <div class="form-floating mb-3 col-md-8">
                        	<input class="form-control" name="store_phone_check"  required disabled id="store_phone_check" type="text" placeholder="인증 번호" autocomplete="off">
                        	<label style="left:10px;">인증번호 입력</label>
                    	</div>
	                    <div class="col-md-4">
			 				<button class="btn btn-success opacity-50 form-control py-3" disabled id="btn_check">
			 				인증 확인</button>
			 			</div>
                    </div>
                    
	                    <button class="btn btn-success opacity-50 form-control mt-2 mb-3" type="submit" id="btn_findpw">비밀번호 찾기</button>
                </form>
                
            </div>
        </div>
    </div>
   
    
</div>

<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
$(document).ready(function() {
	  $("#btn_phone").click(function(event) {
	    event.preventDefault(); // 기본 제출 동작 방지
		
	    var store_phone = $("#store_phone").val();
	    var store_id = $("#store_id").val();
	    
	    if (store_id.trim() === "" || store_phone.trim() === "" || isNaN(store_phone)) {
	        alert("올바르게 작성해주세요.");
	        return;
	      }
	    
	    $.ajax({
	        type: "GET",
	        url: "sms?store_phone" + store_phone,
	        data: { store_phone : store_phone },
	        success: function(response) {
	          if (response.result === "success") {
	        	  var Code = response.Code;
	        	  alert("인증번호 발송이 완료되었습니다.")
	        	  $("#btn_check").prop("disabled", false);
	        	  $("#store_phone_check").prop("disabled", false);
	        	  $("#btn_check").data("Code", Code); // 버튼에 인증번호 저장
	        	  console.log(Code);
	          } else {
	            alert("인증번호 발송에 실패했습니다.");
	          }
	        },
	        error: function() {
	          alert("오류가 발생했습니다.");
	        }
	      });
	    });
	  
	  
	  $("#btn_check").click(function() {
		  event.preventDefault(); // 기본 제출 동작 방지
		  
		    var enteredCode = $("#store_phone_check").val();
		    var Code = $("#btn_check").data("Code");
		    
		    if (enteredCode === Code) {
		      alert("인증이 완료되었습니다.");
		      $("#store_phone_check").prop("disabled", true);
		      $("#btn_check").prop("disabled", true);
		      $("#btn_check").text("인증 완료");

		    } else {
		      alert("인증번호가 일치하지 않습니다.");
		    }
		  });
	  
	  $("#btn_findpw").click(function(event) {
		  var btnCheckText = $("#btn_check").text();
		  
		  if (btnCheckText === "인증 완료") {
		    
			  
		  } else {
			event.preventDefault(); // 기본 제출 동작 방지
		    alert("휴대폰 인증을 해주세요.");
		  }
		});
	  
	  
	  $("#findpw").submit(function(event) {
		    event.preventDefault(); // 기본 제출 동작 방지

		    var store_id = $("#store_id").val();
	        var store_phone = $("#store_phone").val();
	        
	        var requestData = {
        		store_id: store_id,
	            store_phone: store_phone
	        };
		    $.ajax({
		        type: "POST",
		        url: $(this).attr("action"),
		        data: requestData,
		        success: function(response) {
		          // 서버 응답을 처리하는 코드 작성
		          // 예: 로그인 성공 시 페이지 리다이렉트
		          if (response === "success") {
		            window.location.href = "findpwresult";
		            consol.log(requestData);
		          } else {
		            alert("입력하신 정보가 없습니다.");
		          }
		        },
		        error: function() {
		          alert("오류가 발생했습니다.");
		        }
		      });
		    });
	  });
	  
	  
</script>


</body>
</html>