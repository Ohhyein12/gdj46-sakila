package dao;

import java.util.*;
import java.sql.*;

public class StaffDao {
	public List<Map<String, Object>> selectStaffList() {
		List<Map<String, Object>> list = new ArrayList<>(); // 다형성
		//드라이버 로딩
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sakila","root","java1234");
			String sql = "SELECT"
					+ "		s1.store_id storeId,"
					+ "		s1.staff_id staffId,"
					+ "		CONCAT(s1.first_name,' ',s1.last_name) staffName,"
					+ "		s1.email email,"
					+ "		s1.active,"
					+ "		s1.username userName,"
					+ "		s1.password,"
					+ "		s1.address_id addressId,"
					+ "		CONCAT(a.address, ifnull(a.address2, ''),district) staffAddress,"
					+ "		s1.last_update lastUpdate"
					+ " FROM staff s1"
					+ " inner JOIN address a"
					+ " INNER JOIN store s2 "
					+ " ON s1.address_id = a.address_id"
					+ " AND s1.store_id = s2.store_id;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<> (); // 다형성
				map.put("storeId", rs.getInt("storeId"));
				map.put("staffId", rs.getInt("staffId"));
				map.put("staffName", rs.getString("staffName"));
				map.put("email", rs.getString("email"));
				map.put("active", rs.getInt("active"));
				map.put("userName", rs.getString("userName"));
				map.put("password", rs.getString("password"));
				map.put("addressId", rs.getInt("addressId"));
				map.put("staffAddress", rs.getString("staffAddress"));
				map.put("lastUpdate", rs.getString("lastUpdate"));
				list.add(map);
			}
		} catch (Exception e) { // ClassNotFoundException, SQLException 두개의 예외를 Exception으로 처리 -> 다형성 
			e.printStackTrace();
			System.out.println("예외 발생");
		} finally { 
			try {
				//DB자원 해지 - try절에서 예외가 발생하면 자원해지 못한상태에서 코드가 종료된다. finally절이 필요
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		
		return list;	
	}
	// selectStoreList() 테스트 코드
		public static void main(String[] args) {
			StaffDao dao = new StaffDao();
			List<Map<String, Object>> list = dao.selectStaffList();
			for(Map m : list) {
				System.out.print(m.get("storeId")+", ");
				System.out.print(m.get("staffId")+", ");
				System.out.print(m.get("staffName")+", ");
				System.out.print(m.get("email")+", ");
				System.out.print(m.get("active")+", ");
				System.out.print(m.get("userName")+", ");
				System.out.print(m.get("password")+", ");
				System.out.print(m.get("addressId")+", ");
				System.out.print(m.get("staffAddress")+", ");
				System.out.print(m.get("lastUpdate"));
				System.out.println("");
			}
	}	
	
}
