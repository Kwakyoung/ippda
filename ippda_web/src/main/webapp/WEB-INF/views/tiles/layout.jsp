<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>IPPDA</title>
        <c:set var="now" value="<%=new java.util.Date() %>"/>
         <!-- Favicon-->
        <link rel="icon" type="image/logo" href="<c:url value='/img/logo.png' />" />
        
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
             <link href="<c:url value='/css/styles.css?${now }'/>" rel="stylesheet" />
<%--         <link href="<c:url value='/css/common.css?${now }'/>" rel="stylesheet" /> --%>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<c:url value='/'/>">IPPDA</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	                      	
		                <li class="nav-item dropdown">
		                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
		                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
		                        <li><a class="dropdown-item" href="#!">내정보</a></li>
		                        <li><a class="dropdown-item" href="#!">알람</a></li>
		                        <li><hr class="dropdown-divider" /></li>
		                        <li><a class="dropdown-item" href="<c:url value='/'/>">로그아웃</a></li>
		                    </ul>
		                </li>
	                
            </ul>
        </nav>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">홈</div>
                            <a class="nav-link" href="<c:url value='/sales'/>">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                공지사항
                            </a>
                          
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                상품
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<c:url value="/goods/list"/>">상품 목록</a>
                                    <a class="nav-link" href="<c:url value='/goods/basicinfo'/>">상품 등록</a>
                                </nav>
                            </div>
                       <a class="nav-link" href="<c:url value='/order/list'/>">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                주문
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                         
                            </div>
                            <div class="sb-sidenav-menu-heading">더보기</div>
                            <a class="nav-link" href="<c:url value='/test/home'/>">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                테스트
                            </a>
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                테이블
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            
            </div>
            
            <div id="layoutSidenav_content">
            	<main>
		                       <!-- Page content-->
		            <div class="container-fluid">
		                <tiles:insertAttribute name="container"/>
		            </div>
            
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/include/modal_alert.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
     
     <script>
     const intervalID = setInterval(popAlarm, 3000);
function orderNo(){
	var orderNo = '';
		 $('#modal-alert table tbody tr').each(function(){
		orderNo += (orderNo=='' ? '' : ',') + $(this).data('order');
		 })
	return orderNo;
}

$(function(){
// 	popAlarm() 
	
	$('#modal-alert  #confirmButton').click(function(){
		$(this).attr( 'data-bs-dismiss',"modal"); 
		
		$.ajax({
    		url: '<c:url value="/order/status/ing" />',
    		data: { orderNo: orderNo() }
    	}).done(function( ){
    		$(this).attr( 'data-bs-dismiss',"");
    	})
	})
	
	$('#modal-alert  #cancel').click(function(){
		$.ajax({
    		url: '<c:url value="/order/status/cancel" />',
    		data: { orderNo: orderNo() }
    	}).done(function( ){
    	})
	})
	
})
     function popAlarm(){
    	$.ajax({
    		url: '<c:url value="/order/alarm" />',
    	}).done(function( response ){
    		$('#modal-alert .modal-body').html(response)
    		if( $('#modal-alert .modal-body table tbody tr').length > 0 ){
    			new bootstrap.Modal( $('#modal-alert') ).show();
    		}
    	})
     }
     </script>
    </body>
</html>
