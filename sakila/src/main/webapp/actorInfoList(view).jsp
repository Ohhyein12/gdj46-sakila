<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	ActorInfoDao actorinfoDao = new ActorInfoDao();

	int rowPerPage = 10;
	int currentPage = 1; // 현재페이지
	
	// 만약 첫페이지라면 이전페이지 없게 만들기
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int beginRow = (currentPage-1)*rowPerPage;
	List<ActorInfo> list = actorinfoDao.selectActorInfoListByPage(beginRow, rowPerPage);
	//다음 페이징
	// totalRow 구해야함
	//토탈페이지 
	int totalRow = actorinfoDao.totalRowCnt();
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
<title>actorIntoList(view)</title>
</head>
<body>
	<h1>actorInfo</h1>
	<table border=1px>
		<thead>
			<tr>
				<th>actorId</th>
				<th>fistName</th>
				<th>lastName</th>
				<th>filmInfo</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(ActorInfo a : list) {
			%>
					<tr>	
						<td><%=a.getActorId()%></td>
						<td><%=a.getFirstName()%></td>
						<td><%=a.getLastName()%></td>
						<td><%=a.getFilmInfo()%></td>
					</tr>
		<%
				}
		%>
		</tbody>
	</table>
	<%
		if(currentPage > 1) {
	%>
			<a href="<%=request.getContextPath()%>/actorInfoList(view).jsp?currentPage=<%=currentPage-1%>">이전</a>
	<%
		}
		if(currentPage < lastPage) {
	%>
			<a href="<%=request.getContextPath()%>/actorInfoList(view).jsp?currentPage=<%=currentPage+1%>">다음</a>
	<%
		}
	%>
</body>
</html>