<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	FilmDao filmDao = new FilmDao();
	
	
	int filmId = Integer.parseInt(request.getParameter("filmId"));
	int storeId = Integer.parseInt(request.getParameter("storeId"));
	
	System.out.println(filmId +"-->filmId");
	System.out.println(storeId + "-->storeId");

	Map<String, Object> map = filmDao.filmNotInStockCall(filmId, storeId);
	List<Integer> list = (List<Integer>)map.get("list");
	int count = (Integer)map.get("count");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지점별재고</h1>
	<h4><%=filmId%>번 영화는 <%=storeId%>번 가게에 <%=count%>개 없습니다</h4>
	<table>
		<tr>
			<%
				for(int id : list) {
			%>
					<td><%=id%></td>
			<%
				}
			%>
		</tr>
	</table>
	
</body>
</html>