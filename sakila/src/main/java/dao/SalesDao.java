package dao;

import java.sql.*;
import java.util.*;

import vo.*;

import util.DBUtil;

public class SalesDao {
	
	public List<SalesByFilmCategory> selectSalesFilmCategoryList() {
		List<SalesByFilmCategory> list = new ArrayList<SalesByFilmCategory>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM sales_by_film_category";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				SalesByFilmCategory s = new SalesByFilmCategory();
				s.setCategory(rs.getString("category"));
				s.setTotalSales(rs.getDouble("total_sales"));
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
	
	public List<SalesByStore> selectSalesByStoreList() {
		List<SalesByStore> list = new ArrayList<SalesByStore>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM sales_by_store";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				SalesByStore s = new SalesByStore();
				s.setStore(rs.getString("store"));
				s.setManager(rs.getString("manager"));
				s.setTotalSales(rs.getDouble("Total_sales"));
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
