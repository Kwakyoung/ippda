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

canvas#chart {
            width: 1050px; /* 원하는 너비로 설정 */
 
        }

</style>
</head>

<body>
  <section id="breadcrumbs" class="breadcrumbs">
	    <div class="container mt-2">
			<h2>주문 내역</h2>
		</div>
   </section>

	<div class="custom-padding">
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link">월별 주문 건수</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link">월별 매출 금액</a>
	  </li>
	</ul>

<div id='tab-content' class="m-md-2 m-lg-3" style='height:520px'>

	<!-- <div class="tab text-center mt-4">
			<div class="form-check form-check-inline">
			  <label>
				  <input class="form-check-input" type="radio" name="unit" value="mprice" checked>월별 판매 금액
			  </label>
			</div>
			<div class="form-check form-check-inline">
			  <label>
				  <input class="form-check-input" type="radio" name="unit" value="month">월별 판매 개수
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
	</div> -->
	
	<div>
	  <canvas id="chart" class="h-100 m-auto"></canvas>
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




	
	

function goods_date(){
	initCanvas();
	
	$.ajax({
		url: 'sell/month',
	}).done(function( response ){
		console.log( response )
		var info = {};
		info.category = [], info.datas = [], info.colors = [];
		$(response).each(function(){
			info.category.push( this.UNIT );
			info.datas.push( this.COUNT );
			//부서원수에 따라 색상 적용: 0:10미만(0~9), 1:20미만(10~19), ... 12/10:1.2
			info.colors.push( colors[ Math.floor(this.COUNT/10) ] );
		})
		console.log( info );
		
		barChart( info );
		
	})
	
	//sampleChart();
} 	

function goods_category(){
	initCanvas();
	
	$.ajax({
		url: 'sell/mprice',
	}).done(function( response ){
		console.log( response )
		var info = {};
		info.category = [], info.datas = [], info.colors = [];
		$(response).each(function(){
			info.category.push( this.UNIT );
			info.datas.push( this.PRICE );
			//부서원수에 따라 색상 적용: 0:10미만(0~9), 1:20미만(10~19), ... 12/10:1.2
			info.colors.push( colors[ Math.floor(this.COUNT/10) ] );
		})
		console.log( info );
		
		lineChart( info );
		
	})
	
	//sampleChart();
} 	




function barChart( info ){
	$('#tab-content').css('height', '520');
	visual = new Chart( $('#chart') , {
	    type: 'bar',
	    data: {
	      labels: info.category,
	      datasets: [{
	        label: '판매 수',
	        data: info.datas,
	        //borderWidth: 2,
	        barPercentage: 0.5,
	        backgroundColor: info.colors,
	      }]
	    },
	    options: {
	    	maintainAspectRatio: false, //크기조정시 캔버스 가로세로비율 유지X(기본O)
	    	responsive: false, //컨테이너 크기 변경시 캔버스 크기 조정X(기본O)
	    	layout: {
	    		padding: { top: 30, bottom: 20 }
	    	},
	    	plugins: {
	    		legend: { display: false }, //기본 범례 안 보이게
	    		datalabels: {
	    			formatter: function( value ){
	    				//return value + '명';
	    				return `\${value}명`;
	    			}
	    		},
	    		/*  
	    		autocolors: {  //자동색상 적용하는 경우
	    	        mode: 'data'
    	        },
	    		*/
	    	},
	    	
	      	scales: {
		        y: {
		          beginAtZero: true,
		          title: { text: '월별 주문 건수', display: false }
		        }
		    },
	    }
	});
	makeLegend();
}



function lineChart( info ){
	$('#tab-content').css('height', '540');
	visual = new Chart( $('#chart') , {
		type: 'line',
		data: {
			labels: info.category,
			datasets: [{
		        label: '판매 금액',
		        data: info.datas,
		        borderColor: '#123',  //그래프선, point테두리에 적용
		        tension: 0, //0:완전꺽은선, 1:곡선
		        pointRadius: 4, //point반지름
		        pointBackgroundColor: '#fff', 
	      	}]
		},
	    options: {
	    	maintainAspectRatio: false, //크기조정시 캔버스 가로세로비율 유지X(기본O)
	    	responsive: false, //컨테이너 크기 변경시 캔버스 크기 조정X(기본O)
	    	layout: {
	    		padding: { top: 30  }
	    	},
	    	plugins: {
	    		legend: { display: false }, //기본 범례 안 보이게
	    		datalabels: {
	    			formatter: function(v){
						return v==0 ? '' : `\${v}명`;
	    			}
	    		},
	    	},
	    	
	      	scales: {
		        y: {
		          beginAtZero: true,
		          title: { text: '월별 매출 금액', display: false }
		        }
		    },
	    }
	});
	$('#legend').remove();
}






//데이터수치범위에 해당하는 범례 만들기
function makeLegend(){
	$('#legend').remove();
	
	var tag = 
	`<ul class="row d-flex justify-content-center m-0 mt-4 p-0 small" id='legend'>`;
	
	for(var no=0; no<=6; no++){
		tag +=
			`<li class="col-auto"><span></span><font>\${no*10}~\${no*10+9}개</font></li>`;
	}
	tag +=
	`<li class="col-auto"><span></span><font>\${no*10}개이상</font></li>
	</ul>`;
	$('#tab-content').after( tag );
	
	$('#legend span').each(function(idx, item){
		$(this).css('background-color', colors[idx] );
	})
}

//데이터수치 범위에 따라 지정할 색상
var colors = [ '#075be3', '#07e324','#e31207',  '#b307e3'
				, '#f0c402', '#eb7b05', '#05e0eb', '#5d05eb', '#752302' , '#d14f9f'];














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