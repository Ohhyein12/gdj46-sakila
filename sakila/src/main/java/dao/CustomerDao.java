package dao;

import java.sql.*;
import java.util.*;

import util.DBUtil;
import vo.Customer;


public class CustomerDao {
	
	public List<Customer> selectCustomerListByPage(int beginRow, int rowPerPage) {
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM customer_list ORDER BY ID LIMIT ?, ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				Customer c = new Customer();
				c.setID(rs.getInt("ID"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setZipCode(rs.getString("zip code"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				c.setNotes(rs.getString("notes"));
				c.setSID(rs.getInt("SID"));
				list.add(c);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close(); stmt.close(); conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return list;
	}
	
	public int totalRowCnt() {
		int row = 0;
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT count(*) cnt FROM customer_list";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt("cnt");
				System.out.println(row); // row디버깅
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
		
			try {
				rs.close(); stmt.close(); conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		}
	return row;
	}
	
}

