<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "vo.*" %>
<%
	CategoryDao categoryDao = new CategoryDao();
	List<Category> categoryList = categoryDao.selectCategoryList();	
	FilmDao filmDao = new FilmDao();
	List<Double> priceList = filmDao.selectFilmPriceList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filmSearchForm</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
		<h1 style = "margin-bottom:50px" class ="text-center">필름 리스트 뷰 검색</h1>
		<form action="<%=request.getContextPath()%>/filmSearchAction.jsp" method="post">
			<table class="table table-bordered">
				<colgroup>
					<col width = "20%">
					<col width = "*">
				</colgroup>
				<tr>
					<th class = "table-warning text-center">카테고리</th>
					<td>
						<select name="category" class="form-control">
							<option value="">카테고리선택</option>
							<%
								for(Category c : categoryList) {
							%>
									<option value="<%=c.getName()%>" ><%=c.getName()%></option>
							<%		
								}
							%>
						</select>				
					</td>
				</tr>
				<tr>
					<th class = "table-warning text-center">등급</th>
					<td>
						<select name="rating" class="form-control">
							<option value="">등급선택</option>
							<option value="G">G</option>
							<option value="PG">PG</option>
							<option value="PG-13">PG-13</option>
							<option value="R">R</option>
							<option value="NC-17">NC-17</option>
						</select>
					</td>
				</tr>
				<tr>
					<th class = "table-warning text-center">대여료</th>
					<td>
						<div><input type="radio" name="price" value="" checked="checked">선택안함</div>
						<%
							for(Double p : priceList) {
						%>
								<div><input type="radio" name="price" value="<%=p%>"><%=p%></div>
						<%		
							}
						%>
					</td>
				</tr>
				<tr>
					<th class = "table-warning text-center">영화시간</th>
					<td>
						<div><input type="radio" name="length" value="" checked="checked">선택안함</div>
						<div><input type="radio" name="length" value="0">1시간 미만</div><!-- lenght < 60 -->
						<div><input type="radio" name="length" value="1">1시간 이상</div><!-- lenght >= 60 -->
					</td>
				</tr>
				<tr>
					<th class = "table-warning text-center">제목 검색</th>
					<td>
						<input type="text" name="title" class = "form-control">
					</td>
				</tr>
				<tr>
					<th class = "table-warning text-center">배우 검색</th>
					<td>
						<input type="text" name="actor" class = "form-control">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-outline-dark btn-light float-right">검색</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
