<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*"%>
<%@ page import = "java.util.*" %>
<%
	
	request.setCharacterEncoding("utf-8"); // 한글 인코딩
	RewardReportDao rewardReportDao = new RewardReportDao();

	int minMonthlyPurchases = Integer.parseInt(request.getParameter("minMonthlyPurchases"));
	double minDollarAmountPurchased = Double.parseDouble(request.getParameter("minDollarAmountPurchased"));
	
	//디버깅
	System.out.println(minMonthlyPurchases+"<--minMonthlyPurchases");
	System.out.println(minDollarAmountPurchased+"<--minDollarAmountPurchased");
	
	Map<String, Object> map = rewardReportDao.rewardReport(minMonthlyPurchases, minDollarAmountPurchased);
	List<Map<String, Object>> list = (List<Map<String, Object>>)map.get("list");
	int count = (Integer)map.get("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>최소 구매  <%=minMonthlyPurchases%> 회 이상, 
	최소 구매 금액 <%=minDollarAmountPurchased %> 이상 고객 목록(<%=count%>명)</h4>
	<table border = "1">
		<thead>
			<tr>
				<th>고객 번호</th>
				<th>매장 번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소 번호</th>
				<th>활성화</th>
				<th>생성일자</th>
				<th>마지막 업데이트 일자</th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<%
				for(Map<String, Object> m : list) {
			%>
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
			
		</tbody>
	
	</table>
	
	
</body>
</html>