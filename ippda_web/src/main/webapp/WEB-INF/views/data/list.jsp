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
</style>
</head>

<body>
  <section id="breadcrumbs" class="breadcrumbs">
    <div class="container">
<h2>데이터</h2>


</div>
</section>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link">지역별</a>
  </li>
  <li class="nav-item">
    <a class="nav-link">카테고리별</a>
  </li>
</ul>
<div>
  <canvas id="myChart"></canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js/dist/chart.umd.js"></script> <!-- 차트라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script> <!-- 데이터라벨 라이브러리 -->
<!-- <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-autocolors"></script> --> 
<!-- 색상자동생성 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-autocolors@0.2.2/dist/chartjs-plugin-autocolors.min.js"></script>
</body>
<script>
const ctx = document.getElementById('myChart');

new Chart(ctx, {
  type: 'line',
  data: {
    labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
    datasets: [{
      label: '# of Votes',
      data: [12, 19, 3, 5, 2, 3],
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

</script>
</html>