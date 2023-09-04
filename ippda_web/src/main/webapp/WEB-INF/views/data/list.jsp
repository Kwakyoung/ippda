<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#legend span { width:44px; height:17px; margin-right: 5px }
#legend li { display: flex; align-items: center; }
ul.nav-tabs li {
    cursor: pointer;
}

.custom-padding{
	padding:100px;
}

</style>
</head>

<body>
  <section id="breadcrumbs" class="breadcrumbs">
	    <div class="container mt-2">
			<h2>판매내역</h2>
		</div>
   </section>

<div class="custom-padding">
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link">기간별</a>
  </li>
  <li class="nav-item">
    <a class="nav-link">카테고리별</a>
  </li>
</ul>

<div id='tab-content' class="m-md-2 m-lg-3">

	<div class="tab text-center mt-4">
			<div class="form-check form-check-inline">
			  <label>
				  <input class="form-check-input" type="radio" name="unit" value="year" checked>년도별
			  </label>
			</div>
			<div class="form-check form-check-inline">
			  <label>
				  <input class="form-check-input" type="radio" name="unit" value="month">월별
			  </label>
			</div>
	</div>

	<div class="tab text-center mt-4">
		<div class="form-check form-check-inline">
		  <label>
			  <input class="form-check-input" type="radio" name="chart" value="bar" checked>막대그래프
		  </label>
		</div>
		<div class="form-check form-check-inline">
		  <label>
			  <input class="form-check-input" type="radio" name="chart" value="dounut">도넛그래프
		  </label>
		</div>
	</div>
	
	<div>
	  <canvas id="chart"></canvas>
	</div>
	</div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.umd.js"></script> <!-- 차트라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script> <!-- 데이터라벨 라이브러리 -->
<!-- <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-autocolors"></script> --> 
<!-- 색상자동생성 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-autocolors@0.2.2/dist/chartjs-plugin-autocolors.min.js"></script>
</body>
<script>
const ctx = document.getElementById('chart');
Chart.defaults.font.size = 16;
const apiUrl = 'http://localhost:8080/ippda/data/sell/month';

new Chart(ctx, {
	  type: 'line',
	  data: {
	    labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
	    datasets: [{
	      label: '판매그래프',
	      data: [3, 19, 3, 5, 2, 3],
	      borderWidth: 1
	    }]
	  },
	  options: {
	    scales: {
	      y: {
	        beginAtZero: true
	      }
	    }
	  }
	});
	



function initCanvas(){
	$('canvas#chart').remove();
	$('#tab-content').append( `<canvas id="chart"></canvas>` );
}


$('ul.nav-tabs li').on({
	'click': function(){
		$('ul.nav-tabs li a').removeClass('active');
		$(this).children('a').addClass('active');
		
		var idx = $(this).index();
		$('#tab-content .tab').addClass('d-none');
		$('#tab-content .tab').eq(idx).removeClass('d-none');
		
		if(idx==0) 				goods_date(); 			//기간별 조회
		else if(idx==1) 		goods_category();		//카테고리별 조회
		else initCanvas();
	},
	
	'mouseover': function(){
		$(this).addClass('shadow');
	},
	
	'mouseleave': function(){
		$(this).removeClass('shadow');
	},
})



$(function(){
	$('ul.nav-tabs li').eq(0).trigger( 'click' );
})
</script>
</html>