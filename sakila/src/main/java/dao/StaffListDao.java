package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.StaffList;

public class StaffListDao {
	
	public List<StaffList> selectStaffList() {
		List<StaffList> list = new ArrayList<StaffList>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM staff_list ORDER BY ID";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				StaffList s = new StaffList();
				s.setID(rs.getInt("ID"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				s.setZipCode(rs.getString("zip code"));
				s.setPhone(rs.getString("phone"));
				s.setCity(rs.getString("city"));
				s.setCountry(rs.getString("country"));
				s.setSID(rs.getInt("SID"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
