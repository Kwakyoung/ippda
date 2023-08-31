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
	 
 .gradient-custom {
/* fallback for old browsers */
background: #534A5C;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(83, 74, 92, 1), rgba(89, 75, 90, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(83, 74, 92, 1), rgba(89, 75, 90, 1));
}

.btn-text, .btn-text-check {
        font-size: 0.7rem; /* 원하는 크기로 조정 */
    }
    
.btn.btn-outline-success.opacity-50.form-control.form-control-lg {
    height: auto;
}
 </style>
</head>
<body>
<section class="vh-100 gradient-custom">
 
 <form method="post" action="findingid" id="findid">
	 <div class="container py-5 h-100">
   	 <div class="row d-flex justify-content-center align-items-center h-100">
 
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
        
          <div class="card-body p-5 text-center">
          
          <div class="mb-md-5 mt-md-4 pb-5">
                <div class="text-center mb-4">
        <div style="display: flex; justify-content: space-between;">
        	<a href="login">로그인 하러가기</a>
        	<a href="findpw">비밀번호 찾기</a>
        </div>
        	<div class="mb-md-5 mt-md-4 pb-5">
                <div class="text-center mb-4">
        		<img src="<c:url value='/img/goodlogo.png'/>">
        		<p class="text-white-75 mb-5">아이디 찾기</p>
        		</div>	
        			
					<div class="form-floating mb-3">
					    <input class="form-control form-control-lg" type="text" name="store_ceo" id="store_ceo" required  placeholder="이름">
					</div>
					
					<div class="row">
			 			<div class="form-floating mb-3 col-md-8">
                        	<input class="form-control form-control-lg" name="store_phone"  required  id="store_phone" type="text" placeholder="휴대폰 번호" autocomplete="off">
                        	
                    	</div>
			 			<div class="col-md-4">
			 				<button class="btn btn-outline-success opacity-50 form-control form-control-lg"  id="btn_phone">
			 				<span class="btn-text">인증번호<br>발송</span></button>
			 			</div>
			 		</div>

	                <div class="row">    
	                    <div class="form-floating mb-3 col-md-8">
                        	<input class="form-control form-control-lg" name="store_phone_check"  required disabled id="store_phone_check" type="text" placeholder="인증 번호" autocomplete="off">
                    	</div>
	                    <div class="col-md-4">
			 				<button class="btn btn-outline-success opacity-50 form-control form-control-lg" disabled id="btn_check">
			 				<span class="btn-text-check">인증번호<br>확인</span></button>
			 			</div>
                    </div>
                    
                    <div class="mt-3">
	                    <button class="btn btn-outline-light btn-lg" type="submit" id="btn_findid">아이디 찾기</button>
             		</div>
                
            </div>
        </div>
    </div>
   
    
</div>
	</div>
	</div>
	</div>
	</div>
	</form>
	</section>
<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"/>


<script>
$(document).ready(function() {
	  $("#btn_phone").click(function(event) {
	    event.preventDefault(); // 기본 제출 동작 방지
		
	    var store_phone = $("#store_phone").val();
	    var store_ceo = $("#store_ceo").val();
	    
	    if (store_ceo.trim() === "" || store_phone.trim() === "" || isNaN(store_phone)) {
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
		      $(".btn-text-check").text("인증 완료");

		    } else {
		      alert("인증번호가 일치하지 않습니다.");
		    }
		  });
	  
	  $("#btn_findid").click(function(event) {
		  var btnCheckText = $(".btn-text-check").text();
		  
		  if (btnCheckText === "인증 완료") {
			  	
		  } else {
			event.preventDefault(); // 기본 제출 동작 방지
		    alert("휴대폰 인증을 해주세요.");
		  }
		});
	  
	  
	  
	  $("#findid").submit(function(event) {
		    event.preventDefault(); // 기본 제출 동작 방지

		    var store_ceo = $("#store_ceo").val();
	        var store_phone = $("#store_phone").val();
	        
	        var requestData = {
	            store_ceo: store_ceo,
	            store_phone: store_phone
	        };
		    $.ajax({
		        type: "POST",
		        url: $(this).attr("action"),
		        data: requestData,
		        success: function(response) {
		          // 서버 응답을 처리하는 코드 작성
		          // 예: 로그인 성공 시 페이지 리다이렉트
		          console.log(requestData);
		          if (response === "success") {
		            window.location.href = "findidresult";
		            
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