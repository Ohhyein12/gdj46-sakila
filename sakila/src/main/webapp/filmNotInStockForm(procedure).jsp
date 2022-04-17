<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filmNotInStock(procedure)</title>
</head>
<body>
	<h1>filmNotInStock(procedure)</h1>
	
	<form method="post" action="<%=request.getContextPath()%>/filmNotInStockAction(procedure).jsp">
		<table border = "1">
			<thead>
				<tr>
					<td>filmId</td>
					<td>storeId</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="filmId"></td>
					<td><input type="text" name="storeId"></td>
				</tr>	
			</tbody>
		</table>
		<button type="submit">전송</button>
	
	</form>
</body>
</html>