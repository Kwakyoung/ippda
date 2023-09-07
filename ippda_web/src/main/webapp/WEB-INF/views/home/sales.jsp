<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="search-container">
    <!-- 검색 폼 시작 -->
    <form class="search-form" action="/search" method="GET">
        <label class="search-label" for="searchInput"></label>
        <input class="search-input" type="text" id="searchInput" name="q" placeholder="검색어를 입력하세요...">
        <input class="search-button" type="submit" value="검색">
    </form>
    <!-- 검색 폼 끝 -->
</div>
	<!-- ======= Hero Section ======= -->
	<section id="hero" class="d-flex align-items-center";">

		<div class="container position-relative text-center"
			data-aos="fade-up" data-aos-delay="500">
			<a href='https://i.postimg.cc/BvJSMGV3/cap3.png' target='_blank'>
				<img src='https://i.postimg.cc/BvJSMGV3/cap3.png' border='0'
				alt='img1' style='width: 300px; height: 200px;' />
			</a> <a href='https://i.postimg.cc/QCT0Fvs9/cap2.png' target='_blank'>
				<img src='https://i.postimg.cc/QCT0Fvs9/cap2.png' border='0'
				alt='img2' style='width: 300px; height: 200px;' />
			</a> <a href='https://i.postimg.cc/MTzcjj87/cap4.png' target='_blank'>
				<img src='https://i.postimg.cc/MTzcjj87/cap4.png' border='0'
				alt='img3' style='width: 300px; height: 200px;' />
			</a> <a href='https://i.postimg.cc/8Pvy1jTp/cap5.png' target='_blank'>
				<img src='https://i.postimg.cc/8Pvy1jTp/cap5.png' border='0'
				alt='img4' style='width: 300px; height: 200px;' />
			</a> <a href='https://i.postimg.cc/y8HXTjc9/cap6.png' target='_blank'>
				<img src='https://i.postimg.cc/y8HXTjc9/cap6.png' border='0'
				alt='img5' style='width: 300px; height: 200px;' />
			</a><a href='https://i.postimg.cc/zBv2C7K5/cap7.png' target='_blank'>
				<img src='https://i.postimg.cc/zBv2C7K5/cap7.png' border='0'
				alt='img6' style='width: 300px; height: 200px;' />
			</a>

			<h2 style="text-align: center; text-decoration: underline;">IPPDA에서
				인기 많은 상품</h2>

			<a href="#about" class="btn-get-started scrollto"
				style="float: right;">다른 상품 둘러보기</a>

		</div>
	</section>
	<!-- End Hero -->


</body>
</html>