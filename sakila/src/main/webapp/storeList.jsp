<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*"%>
<%@ page import ="dao.*"%>
<%
	StoreDao storeDao = new StoreDao();
	List<Map<String, Object>> list = storeDao.selectStoreList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store List</title>
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
		<h1 style="margin-bottom:60px" class = "text-center" >Store List</h1>
		<table class = "table">
			<thead>
				<tr>
					<th>storeId</th>
					<th>staffId</th>
					<th>staffName</th>
					<th>addressId</th>
					<th>staffAddress</th>
					<th>lastUpdate</th>	
				</tr>
			</thead>
			<tbody>
				<%
					for(Map m : list) {
				%>
						<tr>
							<td><%=m.get("storeId")%></td>
							<td><%=m.get("staffId")%></td>
							<td><%=m.get("staffName")%></td>
							<td><%=m.get("addressId")%></td>
							<td><%=m.get("staffAddress")%></td>
							<td><%=m.get("lastUpdate")%></td>
						</tr>
				<%
					}
				%>
			
			</tbody>
		</table>
	</div>
</body>
</html>