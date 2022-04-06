package dao;

import java.sql.Connection;

import java.sql.*;
import java.util.*;


import util.DBUtil;
import vo.ActorInfo;

public class ActorInfoDao {
	
	public List<ActorInfo> selectActorInfoListByPage(int beginRow, int rowPerPage) {
		List<ActorInfo> list = new ArrayList<ActorInfo>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM actor_info ORDER BY actor_id LIMIT ?, ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				ActorInfo a = new ActorInfo();
				a.setActorId(rs.getInt("actor_id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setFilmInfo(rs.getString("film_info"));
				list.add(a);
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
	
	public int totalRowCnt() {
		int row = 0;
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT count(*) cnt FROM actor_info";
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