<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	FilmDao filmDao = new FilmDao();
	
	int rowPerPage = 10;
	int currentPage = 1; // 현재페이지
	
	// 만약 첫페이지라면 이전페이지 없게 만들기
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int beginRow = (currentPage-1)*rowPerPage;
	
	List<FilmList> list = filmDao.selectfilmListByPage(beginRow, rowPerPage);
	//다음 페이징
	// totalRow 구해야함
	//토탈페이지 
	int totalRow = filmDao.totalRowCnt();
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
<title>filmList(view)</title>
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
		<h1 style="margin-bottom:60px" class = "text-center" >filmList</h1>
		<table  class = "table">
			<thead>
				<tr>
					<th>FID</th>
					<th>title</th>
					<th>description</th>
					<th>category</th>
					<th>price</th>
					<th>length</th>
					<th>rating</th>
					<th>actors</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(FilmList p : list) {
				%>
						<tr>	
							<td><%=p.getFid()%></td>
							<td><%=p.getTitle()%></td>
							<td><%=p.getDescription()%></td>
							<td><%=p.getCategory()%></td>
							<td><%=p.getPrice()%></td>
							<td><%=p.getLength()%></td>
							<td><%=p.getRating()%></td>
							<td><%=p.getActors()%></td>
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
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/filmList(view).jsp?currentPage=<%=currentPage-1%>">이전</a></li>
		<%
			}
			if(currentPage < lastPage) {
		%>
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/filmList(view).jsp?currentPage=<%=currentPage+1%>">다음</a></li>
		<%
			}
		%>
		</ul>
	</div>
</body>
</html>