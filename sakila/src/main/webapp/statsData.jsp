<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>
<%
	StatsDataDao statsDataDao = new StatsDataDao();
	List<Map<String,Object>> amountByCustomer = statsDataDao.amountByCustomer();
	List<Map<String,Object>> amountByCustomerOne = statsDataDao.amountByCustomerOne();
	List<Map<String,Object>> amountByRentalRate = statsDataDao.amountByRentalRate();
	List<Map<String,Object>> amountByRating = statsDataDao.amountByRating();
	List<Map<String,Object>> languageByFilm = statsDataDao.languageByFilm();
	List<Map<String,Object>> lengthByFilm = statsDataDao.lengthByFilm();
	List<Map<String,Object>> storeDayOfWeekPayment = statsDataDao.storeDayOfWeekPayment();
	List<Map<String,Object>> customerByRental = statsDataDao.customerByRental();
	List<Map<String,Object>> actorByFilm = statsDataDao.actorByFilm();
	List<Map<String,Object>> staffByRental = statsDataDao.staffByRental();
	List<Map<String,Object>> storeByInventory = statsDataDao.storeByInventory();

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. amountByCustomer(180달러 이상)</h2>
	<table border="1">
		<tr>
			<th>고객아이디</th>
			<th>고객이름</th>
			<th>총지불액</th>
		</tr>
	<%
		for(Map<String, Object> m: amountByCustomer) {
	%>	
			<tr>	
				<td><%=m.get("customerId")%></td>
				<td><%=m.get("name")%></td>
				<td><%=m.get("total")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>2. 제일 많이 빌려간 사람(횟수)</h2>
	<table border="1">
		<tr>
			<th>고객아이디</th>
			<th>매장아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소아이디</th>
			<th>활성화</th>
			<th>생성 날짜</th>
			<th>마지막업데이트 날짜</th>
		</tr>
	<%
		for(Map<String, Object> m: amountByCustomerOne) {
	%>	
			<tr>	
				<td><%=m.get("customerId")%></td>
				<td><%=m.get("storeId")%></td>
				<td><%=m.get("firstName")%> <%=m.get("lastName")%></td>
				<td><%=m.get("email")%></td>
				<td><%=m.get("addressId")%></td>
				<td><%=m.get("active")%></td>
				<td><%=m.get("createDate")%></td>
				<td><%=m.get("lastUpdate")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>3. 대여료별 영화 개수</h2>
	<table border="1">
		<tr>
			<th>대여료</th>
			<th>총 영화개수</th>
		</tr>
	<%
		for(Map<String, Object> m: amountByRentalRate) {
	%>	
			<tr>	
				<td><%=m.get("rentalRate")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>4. 등급별 영화 개수</h2>
	<table border="1">
		<tr>
			<th>등급</th>
			<th>총 영화개수</th>
		</tr>
	<%
		for(Map<String, Object> m: amountByRating) {
	%>	
			<tr>	
				<td><%=m.get("rating")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>5. 언어별 영화 개수</h2>
	<table border="1">
		<tr>
			<th>언어</th>
			<th>총 영화개수</th>
		</tr>
	<%
		for(Map<String, Object> m: languageByFilm) {
	%>	
			<tr>	
				<td><%=m.get("name")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>6. 상영 시간별 영화 개수</h2>
	<table border="1">
		<tr>
			<th>상영 시간</th>
			<th>총 영화개수</th>
		</tr>
	<%
		for(Map<String, Object> m: lengthByFilm) {
	%>	
			<tr>	
				<td><%=m.get("runTime")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>7. 해당 매장별 요일별 매출</h2>
	<table border="1">
		<tr>
			<th>매장아이디</th>
			<th>요일</th>
			<th>매출</th>
		</tr>
	<%
		for(Map<String, Object> m: storeDayOfWeekPayment) {
	%>	
			<tr>	
				<td><%=m.get("storeId")%></tdm>
				<td><%=m.get("DAYOFWEEK")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>8. 고객별 빌린 횟수</h2>
	<table border="1">
		<tr>
			<th>고객아이디</th>
			<th>횟수</th>
		</tr>
	<%
		for(Map<String, Object> m: customerByRental) {
	%>	
			<tr>	
				<td><%=m.get("customerId")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>

	<h2>9. 배우별 영화 출연 횟수</h2>
	<table border="1">
		<tr>
			<th>배우아이디</th>
			<th>배우이름</th>
			<th>횟수</th>
		</tr>
	<%
		for(Map<String, Object> m: actorByFilm) {
	%>	
			<tr>	
				<td><%=m.get("actorId")%></td>
				<td><%=m.get("actorName")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>10. 직원별 고객에게 빌려준 횟수</h2>
	<table border="1">
		<tr>
			<th>직원아이디</th>
			<th>횟수</th>
		</tr>
	<%
		for(Map<String, Object> m: staffByRental) {
	%>	
			<tr>	
				<td><%=m.get("staffId")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<h2>11. 매장별 영화 소지 개수</h2>
	<table border="1">
		<tr>
			<th>매장아이디</th>
			<th>개수</th>
		</tr>
	<%
		for(Map<String, Object> m: storeByInventory) {
	%>	
			<tr>	
				<td><%=m.get("storeId")%></td>
				<td><%=m.get("cnt")%></td>
			</tr>
	<%
		}
	%>
	</table>
</body>
</html>