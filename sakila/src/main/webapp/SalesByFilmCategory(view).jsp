<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	SalesDao salesDao = new SalesDao();
	List<SalesByFilmCategory> list = salesDao.selectSalesFilmCategoryList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SalesByFilmCategory(view)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<!-- 메인 메뉴 시작 -->
	<jsp:include page ="/inc/upMenu.jsp"></jsp:include>
	<!-- include시 컨텐츠명(프로젝트이름)을 명시하지 않는다 -->
	<!-- 메인 메뉴 끝 -->
	<br>
	<br>
	<div class = "container-fuild">
		<h1 style="margin-bottom:60px" class = "text-center" >actorInfo</h1>
		<table  class = "table">
			<thead>
				<tr>
					<th>category</th>
					<th>TotalSales</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(SalesByFilmCategory s : list) {
				%>
						<tr>	
							<td><%=s.getCategory()%></td>
							<td><%=s.getTotalSales()%></td>
	
						</tr>
			<%
					}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>