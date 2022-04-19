<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filmNotInStock(procedure)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
	.bottom { margin-bottom:60px; }
	.top { margin-top: 30px; }
</style>
</head>
<body>
	<!-- 메인 메뉴 시작 -->
	<jsp:include page ="/inc/upMenu.jsp"></jsp:include>
	<!-- include시 컨텐츠명(프로젝트이름)을 명시하지 않는다 -->
	<!-- 메인 메뉴 끝 -->
	<div class="container">
		<h1 class="bottom top">filmNotInStock(procedure)</h1>
		
		<form method="post" action="<%=request.getContextPath()%>/filmNotInStockAction(procedure).jsp">
			<table class = "table table-bordered">
				<thead>
					<tr>
						<th>filmId</th>
						<th>storeId</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="filmId" class = "form-control"></td>
						<td><input type="text" name="storeId" class = "form-control"></td>
					</tr>	
				</tbody>
			</table>
			<button type="submit" class="btn btn-warning">전송</button>
		</form>
	</div>
</body>
</html>