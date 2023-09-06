<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
     <div class="social-links d-none d-md-block">
     </div>
      <div class="social-links d-none d-md-block">
        <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
        <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
        <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
        <a href="<c:url value='/logout'/>">로그아웃</a>
      </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">
<a href="<c:url value='/sales'/>"> <img src="<c:url value='/img/logotrans.png'/>">  </a>
 
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto  ${category eq 'home' ? 'active' : '' }"  href="<c:url value='/sales'/>">홈</a></li>
          <li class="dropdown"><a class=" ${category eq 'goods' ? 'active' : '' }"  href="<c:url value="/goods/list"/>"><span>상품</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a   href="<c:url value="/goods/list"/>">상품 목록</a></li> 
              <li><a   href="<c:url value="/goods/basicinfo"/>">상품 등록</a></li> 
             </ul>
              
          <li><a class="nav-link ${category eq 'order' ? 'active' : ''}" href="<c:url value='/order/list'/>">주문</a></li>
          <li><a class="nav-link ${category eq 'datas' ? 'active' : ''}" href="<c:url value='/data/list'/>">데이터</a></li>
         <!--  <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li> -->
          <li><a class="nav-link scrollto ${category eq 'review' ? 'active' : ''}" href="<c:url value='/review/list'/>">리뷰관리</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
