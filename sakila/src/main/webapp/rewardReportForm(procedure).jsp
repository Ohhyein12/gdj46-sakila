<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rewardReport(procedure)</title>
</head>
<body>
	<h1>rewardReport(procedure)</h1>
	<form method="post" action="<%=request.getContextPath()%>/rewardReportAction(procedure).jsp">
		<table border = "1">
			<thead>
				<tr>
					<td>minMonthlyPurchases</td>
					<td>minDollarAmountPurchased</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="minMonthlyPurchases"></td>
					<td><input type="text" name="minDollarAmountPurchased"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">전송</button>
	</form>
</body>
</html>