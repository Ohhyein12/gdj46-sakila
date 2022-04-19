<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	StaffListDao staffListDao = new StaffListDao();
	List<StaffList> list = staffListDao.selectStaffList();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StaffList(view)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<!-- 메인 메뉴 시작 -->
	<jsp:include page ="/inc/upMenu.jsp"></jsp:include>
	<!-- include시 컨텐츠명(프로젝트이름)을 명시하지 않는다 -->
	<!-- 메인 메뉴 끝 -->
	<br>
	<br>
	<div class = "container_fluid">
		<h1 style="margin-bottom:60px" class = "text-center" >StaffList</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>address</th>
					<th>zipCode</th>
					<th>phone</th>
					<th>city</th>
					<th>country</th>
					<th>SID</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(StaffList s : list) {
				%>
						<tr>	
							<td><%=s.getID()%></td>
							<td><%=s.getName()%></td>
							<td><%=s.getAddress()%></td>
							<td><%=s.getZipCode()%></td>
							<td><%=s.getPhone()%></td>
							<td><%=s.getCity()%></td>
							<td><%=s.getCountry()%></td>
							<td><%=s.getSID()%></td>
						</tr>
			<%
					}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>