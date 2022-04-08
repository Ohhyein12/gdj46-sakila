<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="list-group list-group-horizontal">
		<a href="<%=request.getContextPath()%>/index.jsp" class="list-group-item list-group-item list-group-item-action list-group-item-warning text-center">Index</a>
		<a href="<%=request.getContextPath()%>/viewIndex.jsp" class="list-group-item list-group-item list-group-item-action list-group-item-warning text-center">View</a>
		<a href="<%=request.getContextPath()%>/procedureIndex.jsp" class="list-group-item list-group-item list-group-item-action list-group-item-warning text-center">Procedure</a>
		<a href="<%=request.getContextPath()%>/searchIndex.jsp" class="list-group-item list-group-item list-group-item-action list-group-item-warning text-center">Search</a>
	</div>
</body>
</html>