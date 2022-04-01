<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
	.jb-wrap { padding: 100px 10px; } /*세로 길이 조절*/
	.text-center {float:none; margin:0 auto;} /* 가운데 정렬 */
</style>
</head>
<body>
	<h1 class="jumbotron text-center" style="margin-bottom:0">INDEX</h1>
	<div class = "container jb-wrap">
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/storeList.jsp" class="text-center">Store List</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/staffList.jsp" class="text-center">Staff List</a></li>
		</ul>
	</div>
</body>
</html>