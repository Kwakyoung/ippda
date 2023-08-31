<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="insert">

			<input class="form-control input-lg" type="text" placeholder="store_no" name="${loginInfo.store_no}" /> 
			
			<input class="form-control input-lg" type="text"placeholder="goods_name" name="goods_name" />
			
			<input class="form-control input-lg" type="text"placeholder="goods_price" name="goods_price" />
			
			<input class="form-control input-lg" type="text"placeholder="goods_sale_percent" name="goods_sale_percent" />
			
			<input class="form-control input-lg" type="text"placeholder="goods_info" name="goods_info" />
			
			<input class="form-control input-lg" type="text"placeholder="goods_gender" name="goods_gender" />
			
			<input class="form-control input-lg" type="text"placeholder="goods_status" name="goods_status" />
			 <p><strong>Username:</strong>${loginInfo.store_name}</p>
			
			 <button type="submit" class="btn btn-secondary my-4">입력완료</button>


	</form>
</body>
</html>