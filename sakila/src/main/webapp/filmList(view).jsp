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
</head>
<body>
	<h1>filmList</h1>
	<table border="1">
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
	<%
		if(currentPage > 1) {
	%>
			<a href="<%=request.getContextPath()%>/filmList(view).jsp?currentPage=<%=currentPage-1%>">이전</a>
	<%
		}
		if(currentPage < lastPage) {
	%>
			<a href="<%=request.getContextPath()%>/filmList(view).jsp?currentPage=<%=currentPage+1%>">다음</a>
	<%
		}
	%>
</body>
</html>