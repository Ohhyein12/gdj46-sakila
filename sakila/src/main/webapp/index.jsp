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
			<!-- view 7개 리스트 -->
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/actorInfoList(view).jsp">actorInfoList(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/customerList(view).jsp">customerList(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/filmList(view).jsp">filmList(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/nicerButSlowerFilmList(view).jsp">nicerButSlowerFilmList(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/salesByFilmCategory(view).jsp">salesByFilmCategory(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/salesByStore(view).jsp">salesByStore(view)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/staffListView(view).jsp">staffList(view)</a></li>
			<!-- procedure 3개 결과 화면 -->
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/filmInStockForm(procedure).jsp">filmInStock(procedure)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/filmNotInStockForm(procedure).jsp">filmNotInStock(procedure)</a></li>
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/rewardsReportForm(procedure).jsp">rewardsReport(procedure)</a></li>
			<!-- 상세 검색 -->			
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/filmSearchForm.jsp">필름 상세검색</a></li> 
			<li class="list-group-item"><a href="<%=request.getContextPath()%>/rentalSearchForm.jsp">대여 상세검색</a></li> 
		</ul>
	</div>
</body>
</html>