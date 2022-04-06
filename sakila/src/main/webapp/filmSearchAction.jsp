<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "dao.*"%>
<%@ page import = "vo.*"%>
<%
	String category = request.getParameter("category");
	String rating = request.getParameter("rating");
	double price = -1; // price 데이터가 입력되지 않았을때
	if(!request.getParameter("price").equals("")) {
		price = Double.parseDouble(request.getParameter("price"));
	}
	int length = -1; // length 데이터가 입력되지 않았을때
	if(!request.getParameter("length").equals("")) {
		length = Integer.parseInt(request.getParameter("length"));
	}
	String title = request.getParameter("title");
	String actor = request.getParameter("actor");
	
	int currentPage = 1;
	if(request.getParameter("currentPage") != null) { //이전, 다음 통해서 들어왔다면 
		currentPage = Integer.parseInt(request.getParameter("currentPage")); // currentPage에 요청받은 currentPage 넣기
	}
	//디버깅
	System.out.println(currentPage+"<--currentPage"); 
	
	int rowPerPage = 10;
	int beginRow = (currentPage-1)*rowPerPage; // 시작하는 페이지의 숫자 현재페이지가 변경되면 beginRow가 변경됨
	
	System.out.println("category->" + category);
	System.out.println("rating->" + rating);
	System.out.println("price->" + price);
	System.out.println("length->" + length);
	System.out.println("title->" + title);
	System.out.println("actor->" + actor);
	
	FilmDao filmDao = new FilmDao();
	List<FilmList> list = filmDao.selectFilmListSearch(beginRow ,rowPerPage ,category, rating, price, length, title, actor);
	int totalRow = filmDao.totalRow(category, rating, price, length, title, actor); // 총 행의 개수 받아오기
	
	//다음 버튼 페이징
	int lastPage = 0; //마지막 페이지
	if(totalRow % rowPerPage == 0) {
		lastPage = totalRow / rowPerPage; 
	} else { // 11,12와 같은 나워떨어지지않는 수라면 
		lastPage = (totalRow / rowPerPage) + 1;  
	}
	
	//디버깅
	System.out.println("totalRow->" + totalRow);
	System.out.println(list.size()); // 0
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<%
			for(FilmList f : list) {
		%>
				<tr>
					<td><%=f.getFid()%></td>
					<td><%=f.getTitle()%></td>
					<td><%=f.getDescription()%></td>
					<td><%=f.getCategory()%></td>
					<td><%=f.getPrice()%></td>
					<td><%=f.getLength()%></td>
					<td><%=f.getRating()%></td>
					<td><%=f.getActors()%></td>
				</tr>
		<%		
			}
		%>
		</table>
		<ul class="pagination">
		<%
		
			if(currentPage > 1)	 { // 페이지가 1보다 작을때 이전페이지가 존재해선 안되니
		%>
				 <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/filmSearchAction.jsp?currentPage=<%=currentPage-1%>&category=<%=category%>&rating=<%=rating%>&price=<%=price%>&length=<%=length%>&title=<%=title%>&actor=<%=actor%>">이전</a></li>
			
		<%
			}
		%>
		<!--  얘도 마지막페이지면 다음이 나와선 안됨 -->
		<%
			if(currentPage < lastPage) { 
		%>
			  	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/filmSearchAction.jsp?currentPage=<%=currentPage+1%>&category=<%=category%>&rating=<%=rating%>&price=<%=price%>&length=<%=length%>&title=<%=title%>&actor=<%=actor%>">다음</a></li>
		<%
			}
		%>
		</ul>
</body>
</html>
