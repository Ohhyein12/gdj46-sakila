package dao;

import java.sql.*;
import java.util.*;
import util.DBUtil;

public class RewardReportDao {
	public Map<String, Object> rewardReport(int minMonthlyPurchases, double minDollarAmountPurchased) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null; 
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); // rm 담을 리스트
		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{call rewards_report(?, ?, ?)}");
			stmt.setInt(1, minMonthlyPurchases);
			stmt.setDouble(2, minDollarAmountPurchased);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();

			while(rs.next()) {
				Map<String, Object> rm = new HashMap<String, Object>();
				rm.put("customerId", rs.getInt(1));
				rm.put("storeId", rs.getInt(2));
				rm.put("firstName", rs.getString(3));
				rm.put("lastName", rs.getString(4));
				rm.put("email", rs.getString(5));
				rm.put("addressId", rs.getInt(6));
				rm.put("active", rs.getInt(7));
				rm.put("createDate", rs.getString(8));
				rm.put("lastUpdate", rs.getString(9));
				
				// 디버깅 
				System.out.println(rs.getInt(1) + " <--customerId");
				System.out.println(rs.getInt(2) + " <--storeId");
				System.out.println(rs.getString(3) + " <--firstName");
				System.out.println(rs.getString(4) + " <--lastName");
				System.out.println(rs.getString(5) + " <--email");
				System.out.println(rs.getInt(6) + " <--addressId");
				System.out.println(rs.getInt(7) + " <--active");
				System.out.println(rs.getString(8) + " <--createDate");
				System.out.println(rs.getString(9) + " <--updateDate");
				list.add(rm);
			}
			count = stmt.getInt(3); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	
	public static void main(String[] args) {
		RewardReportDao rewardReportDao = new RewardReportDao();
		int minMonthlyPurchases = 1;
		double minDollarAmountPurchased = 10.0;
		Map<String, Object> map = rewardReportDao.rewardReport(minMonthlyPurchases, minDollarAmountPurchased);
		List<Map<String, Object>> list = (List<Map<String, Object>>)map.get("list");
		int count = (Integer)map.get("count");
		System.out.println("count->"+count);
		
	}
}
