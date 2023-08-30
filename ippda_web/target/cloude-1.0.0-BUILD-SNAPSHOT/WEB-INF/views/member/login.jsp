<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.gradient-custom {
/* fallback for old browsers */
background: #534A5C;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(83, 74, 92, 1), rgba(89, 75, 90, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(83, 74, 92, 1), rgba(89, 75, 90, 1));
}
</style>
</head>
<body>
<section class="vh-100 gradient-custom">
    <form method="post" action="ippdaLogin" id="loginForm">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
 
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">
			<img class="fw-bold mb-2 text-uppercase" src="/cloude/img/logotrans.png">
              <p class="text-white-50 mb-5">상점 아이디와 비밀번호를 입력해주세요!</p>

              <div class="form-outline form-white mb-4">
                <input type="text" id="typeEmailX" class="form-control form-control-lg" placeholder="아이디" name="store_id" />
                <label class="form-label" for="typeEmailX">아이디</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" placeholder="비밀번호" name="store_pw" required="required" />
                <label class="form-label" for="typePasswordX">비밀번호</label>
              </div>

              <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="findid">아이디</a> 또는 <a class="text-white-50" href="findpw"> 비밀번호를 잊으셨나요?</a></p>

              <button class="btn btn-outline-light btn-lg px-5" type="submit">로그인</button>

              <div class="d-flex justify-content-center text-center mt-4 pt-1">
                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
              </div>

            </div>

            <div>
              <p class="mb-0">등록되지 않은 회원이시라면? <a href="join" class="text-white-50 fw-bold">회원등록</a>
              </p>
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
	 $("#loginForm").submit(function(event) {
     event.preventDefault(); // 기본 제출 동작 방지

     var formData = $(this).serialize(); // 폼 데이터를 직렬화

     $.ajax({
        type: "POST",
         url: $(this).attr("action"),
         data: formData,
         success: function(response) {
           // 서버 응답을 처리하는 코드 작성
           // 예: 로그인 성공 시 페이지 리다이렉트
           if (response === "success") {
             window.location.href = "sales";
           } else {
             alert("로그인 실패! 아이디와 비밀번호를 확인하세요.");
             
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