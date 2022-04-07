package dao;

import java.sql.*;
import java.util.*;

import util.DBUtil;
import vo.FilmList;

public class NicerButSlowerFilmListDao {

	// nicer_but_slower_film_list (view) 리스트 구현 위한 메서드
	public List<FilmList> selectNicerButSlowerFilmListByPage(int beginRow, int rowPerPage) {
		List<FilmList> list = new ArrayList<FilmList>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM nicer_but_slower_film_list ORDER BY FID LIMIT ?, ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				FilmList f = new FilmList();
				f.setFid(rs.getInt("FID"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				f.setCategory(rs.getString("category"));
				f.setPrice(rs.getDouble("price"));
				f.setLength(rs.getInt("length"));
				f.setRating(rs.getString("rating"));
				f.setActors(rs.getString("actors"));
				list.add(f);
			}
		} catch(SQLException e) {
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
	//===========================================
	//  nicerButSlowerFilmList(view)구현 위한 totalRow 반환하는 메서드 
	
	public int totalRowCnt() {
		
		int row = 0;
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT count(*) cnt FROM nicer_but_slower_film_list";
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
