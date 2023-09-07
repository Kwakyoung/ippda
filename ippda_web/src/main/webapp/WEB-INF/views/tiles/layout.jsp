<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
         <meta content="" name="description">
 	 <meta content="" name="keywords">
 	 <title>IPPDA</title>
 		
     <c:set var="now" value="<%=new java.util.Date() %>"/>
    <link href="<c:url value='/css/styles.css?${now}'/>" rel="stylesheet" />
         <!-- Favicon-->
     <link rel="icon" type="image/logo" href="<c:url value='/img/logo.png' />" />
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/glightbox/3.2.0/css/glightbox.min.css"  />
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/10.2.0/swiper-bundle.min.css"  />
     <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
     <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />

  	 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
     <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.1/css/bootstrap-grid.min.css" />
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" >
       
     <script src="https://cdnjs.cloudflare.com/ajax/libs/glightbox/3.2.0/js/glightbox.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/10.2.0/swiper-bundle.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.isotope/3.0.6/isotope.pkgd.min.js"></script>
     <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
     <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" ></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" ></script>
     <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
     
     <script src="<c:url value='/js/main.js'/>"></script>
    </head>
    <body>
     <tiles:insertAttribute name="header" />
       <main id="main">
     <tiles:insertAttribute name="container" />
     	</main>
     <tiles:insertAttribute name="footer" />
     
   	<jsp:include page="/WEB-INF/views/include/modal_alert.jsp"></jsp:include>
     <script>
     const intervalID = setInterval(popAlarm, 5000);
function orderNo(){
	var orderNo = '';
		 $('#modal-alert table tbody tr').each(function(){
		orderNo += (orderNo=='' ? '' : ',') + $(this).data('order');
		 })
	return orderNo;
}

var modalTitle = document.getElementById('confirmModalLabel');
modalTitle.innerText = '주문내역';

$(function(){
	popAlarm() 

	
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
