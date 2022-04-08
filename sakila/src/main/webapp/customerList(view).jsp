<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	CustomerDao customerDao = new CustomerDao();
	
	int rowPerPage = 10;
	int currentPage = 1; // 현재페이지
	
	
	// 만약 첫페이지라면 이전페이지 없게 만들기
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int beginRow = (currentPage-1)*rowPerPage;
	List<Customer> list = customerDao.selectCustomerListByPage(beginRow, rowPerPage);
	
	//다음 페이징 
	int totalRow = customerDao.totalRowCnt();
	//lastpage 구하기
	int lastPage = totalRow / rowPerPage;
	if(totalRow % rowPerPage != 0) {
		lastPage = (totalRow / rowPerPage) + 1;
	}
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerList(view)</title>
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
		<h1 style="margin-bottom:60px" class = "text-center" >customerList</h1>
		<table class = "table">
			<thead>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>address</th>
					<th>zipCode</th>
					<th>phone</th>
					<th>city</th>
					<th>country</th>
					<th>notes</th>
					<th>SID</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Customer c : list) {
				%>
						<tr>
							<td><%=c.getID()%></td>
							<td><%=c.getName()%></td>
							<td><%=c.getAddress()%></td>
							<td><%=c.getZipCode()%></td>
							<td><%=c.getPhone()%></td>
							<td><%=c.getCity()%></td>
							<td><%=c.getCountry()%></td>
							<td><%=c.getNotes()%></td>
							<td><%=c.getSID()%></td>
						</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<ul class="pagination">
		<%
			if(currentPage > 1) {
		%>
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/customerList(view).jsp?currentPage=<%=currentPage-1%>">이전</a></li>
		<%
			}
			if(currentPage < lastPage) {
		%>
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/customerList(view).jsp?currentPage=<%=currentPage+1%>">다음</a></li>
		<%
			}
		%>
		</ul>
	</div>
</body>
</html>