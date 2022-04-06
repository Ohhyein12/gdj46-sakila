package dao;

import java.sql.*;
import java.util.*;
import util.DBUtil;
import vo.*;

public class FilmDao {
	//검색 기능 구현위한 메서드
	public List<FilmList> selectFilmListSearch(int beginRow, int rowPerPage, String category, String rating, double price, int length, String title, String actor) {		
		List<FilmList> list = new ArrayList<FilmList>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			// 동적쿼리
			String sql = "SELECT fid,title,description,category,price,length,rating,actors FROM film_list WHERE title LIKE ? AND actors LIKE ?";
			if(category.equals("") && rating.equals("") && price==-1 && length==-1) { // 다 입력되지않았을때
				sql += " ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setInt(3, beginRow);
				stmt.setInt(4, rowPerPage);
			} else if(category.equals("") && rating.equals("") && price==-1 && length!=-1) { // length만 입력되었다(영화시간)
				if(length == 0) {
					sql += " AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setInt(3, beginRow);
				stmt.setInt(4, rowPerPage);
				
			} else if(category.equals("") && rating.equals("") && price!=-1 && length==-1) { // price만 입력(대여료)
				sql += " AND price=? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setDouble(3, price);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);
				
			} else if(!category.equals("") && rating.equals("") && price==-1 && length==-1) { // category만 입력된경우
				sql += " AND category=? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);
				
			} else if(!category.equals("") && !rating.equals("") && price==-1 && length==-1) { // category랑 rating 입력된경우
				sql += " AND category=? AND rating=? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setInt(5, beginRow);
				stmt.setInt(6, rowPerPage);	
			} else if(!category.equals("") && rating.equals("") && price!=-1 && length==-1) { // category랑 대여료 입력된경우
				sql += " AND category=? AND price = ? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setDouble(4, price);
				stmt.setInt(5, beginRow);
				stmt.setInt(6, rowPerPage);	
			} else if(!category.equals("") && rating.equals("") && price==-1 && length!=-1) { // category랑 영화시간 입력된경우
				if(length == 0) {
					sql += " AND category=? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND category=? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);	
				
			} else if(!category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // category랑 등급, 대여료 입력된경우
				sql += " AND category=? AND rating =? AND price = ? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
				stmt.setInt(6, beginRow);
				stmt.setInt(7, rowPerPage);	
			} else if(!category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // category랑 등급, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category=? AND rating =? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND category=? AND rating =? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setInt(6, beginRow);
				stmt.setInt(7, rowPerPage);	
			} else if(!category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // category랑 대여로, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category=? AND rating =? AND price = ? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND category=? AND rating =? AND price = ? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
				stmt.setInt(6, beginRow);
				stmt.setInt(7, rowPerPage);
				
			} else if(category.equals("") && !rating.equals("") && price==-1 && length==-1) { // 등급만 입력된 경우
				sql += " AND rating =? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);	
				
			} else if(category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // 등급과 대여료 입력된 경우
				sql += " AND rating =? AND price =? ORDER BY fid LIMIT ?, ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setDouble(4, price);				
				stmt.setInt(5, beginRow);
				stmt.setInt(6, rowPerPage);
				
			} else if(category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 등급과 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND rating =? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND rating =? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);	
			} else if(category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 등급과 대여료 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND rating =? AND price =? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND rating =? AND price =? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setDouble(4, price);
				stmt.setInt(5, beginRow);
				stmt.setInt(6, rowPerPage);	
				
			} else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // 대여료 ,영화시간 입력된 경우
				if(length == 0) {
					sql += " AND price =? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND price =? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setDouble(3, price);
				stmt.setInt(4, beginRow);
				stmt.setInt(5, rowPerPage);	
			} else if(!category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 카테고리 등급, 대여료, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category =? AND rating =? AND price=? AND length<60 ORDER BY fid LIMIT ?, ?";
				} else if(length == 1) {
					sql += " AND category =? AND rating =? AND price=? AND length>=60 ORDER BY fid LIMIT ?, ?";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
				stmt.setInt(6, beginRow);
				stmt.setInt(7, rowPerPage);	
			}

            rs = stmt.executeQuery();
			while(rs.next()) {
				FilmList f = new FilmList();
				f.setFid(rs.getInt("fid"));
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
		}
		return list;
	}
	// =================================================================================
	// 검색기능 위해 검색 조건이 바뀔때마다 전체 행 수 구하는 메서드
	public int totalRow(String category, String rating, double price, int length, String title, String actor) { // 전체 행 수 구하는 메서드
		int totalRow = 0;
	      
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
		    String sql = "SELECT count(*) cnt FROM film_list WHERE title LIKE ? AND actors LIKE ?";
		    if(category.equals("") && rating.equals("") && price==-1 && length==-1) { // 다 입력되지않았을때
		    	  sql += " ORDER BY fid ";
		    	  stmt = conn.prepareStatement(sql);
		    	  stmt.setString(1, "%"+title+"%");
		    	  stmt.setString(2, "%"+actor+"%");
		    	  
		    } else if(category.equals("") && rating.equals("") && price==-1 && length!=-1) { // length만 입력되었다(영화시간)
				if(length == 0) {
					sql += " AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				
		    } else if(category.equals("") && rating.equals("") && price!=-1 && length==-1) { // price만 입력(대여료)
				sql += " AND price=? ORDER BY fid";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setDouble(3, price);
				
		    } else if(!category.equals("") && rating.equals("") && price==-1 && length==-1) { // category만 입력된경우
				sql += " AND category=? ORDER BY fid ";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				
		    } else if(!category.equals("") && !rating.equals("") && price==-1 && length==-1) { // category랑 rating 입력된경우
				sql += " AND category=? AND rating=? ORDER BY fid ";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				
		    } else if(!category.equals("") && rating.equals("") && price!=-1 && length==-1) { // category랑 대여료 입력된경우
				sql += " AND category=? AND price = ? ORDER BY fid";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setDouble(4, price);
				
		    } else if(!category.equals("") && rating.equals("") && price==-1 && length!=-1) { // category랑 영화시간 입력된경우
				if(length == 0) {
					sql += " AND category=? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND category=? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				
		    } else if(!category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // category랑 등급, 대여료 입력된경우
				sql += " AND category=? AND rating =? AND price = ? ORDER BY fid";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
				
		    } else if(!category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // category랑 등급, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category=? AND rating =? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND category=? AND rating =? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				
		    } else if(!category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // category랑 대여로, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category=? AND rating =? AND price = ? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND category=? AND rating =? AND price = ? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
		    
		    } else if(category.equals("") && !rating.equals("") && price==-1 && length==-1) { // 등급만 입력된 경우
				sql += " AND rating =? ORDER BY fid";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				
		    } else if(category.equals("") && !rating.equals("") && price!=-1 && length==-1) { // 등급과 대여료 입력된 경우
				sql += " AND rating =? AND price =? ORDER BY fid";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setDouble(4, price);	
		
		    } else if(category.equals("") && !rating.equals("") && price==-1 && length!=-1) { // 등급과 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND rating =? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND rating =? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				
		    } else if(category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 등급과 대여료 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND rating =? AND price =? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND rating =? AND price =? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, rating);
				stmt.setDouble(4, price);
		   
		    } else if(category.equals("") && rating.equals("") && price!=-1 && length!=-1) { // 대여료 ,영화시간 입력된 경우
				if(length == 0) {
					sql += " AND price =? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND price =? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setDouble(3, price);
			
		    } else if(!category.equals("") && !rating.equals("") && price!=-1 && length!=-1) { // 카테고리 등급, 대여료, 영화시간 입력된 경우
				if(length == 0) {
					sql += " AND category =? AND rating =? AND price=? AND length<60 ORDER BY fid";
				} else if(length == 1) {
					sql += " AND category =? AND rating =? AND price=? AND length>=60 ORDER BY fid";
				}
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+title+"%");
				stmt.setString(2, "%"+actor+"%");
				stmt.setString(3, category);
				stmt.setString(4, rating);
				stmt.setDouble(5, price);
		    
		    }
		    rs = stmt.executeQuery();
		    
		    if(rs.next()) {
		    	totalRow = rs.getInt("cnt"); // 행 개수 저장한 cnt 넣기
		    	System.out.println("totalRow->" + totalRow);
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
		
		
	    return totalRow;
	}
	//====================================================
	
	public List<Double> selectFilmPriceList() {
		List<Double> list = new ArrayList<Double>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT DISTINCT price FROM film_list ORDER BY price";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble("price"));
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
	//==============================================
	//film_list view구현 위한 메서드
	
	public List<FilmList> selectfilmListByPage(int beginRow, int rowPerPage) {
		List<FilmList> list = new ArrayList<FilmList>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM film_list ORDER BY FID LIMIT ?, ?";
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
	//==============================================
	// filmList(view)구현 위한 totalRow 반환하는 메서드 
	
	public int totalRowCnt() {
		
		int row = 0;
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "SELECT count(*) cnt FROM film_list";
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
		
	// ===============================================
	// 프로시저 filmInStockCall 구현위한 메서드
	
	public Map<String, Object> filmInStockCall(int filmId, int storeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		// PreparedStatement : 쿼리를 실행
		// CallableStatement : 프로시저를 실행 
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<>();
		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{call film_in_stock(?, ?, ?)}");
			stmt.setInt(1, filmId);
			stmt.setInt(2, storeId);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1)); // rs.getInt("inventory_id")
			}
			count = stmt.getInt(3); // 프로시저 3번째 out변수 값
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	
	//===================================================
	// 프로시저 filmNotInStockCall 구현 위한 메서드

	public Map<String, Object> filmNotInStockCall(int filmId, int storeId) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		// PreparedStatement : 쿼리를 실행
		// CallableStatement : 프로시저를 실행 
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<>();
		Integer count = 0;
		conn = DBUtil.getConnection();
		try {
			stmt = conn.prepareCall("{call film_not_in_stock(?, ?, ?)}");
			stmt.setInt(1, filmId);
			stmt.setInt(2, storeId);
			stmt.registerOutParameter(3, Types.INTEGER);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1)); // rs.getInt("inventory_id")
			}
			count = stmt.getInt(3); // 프로시저 3번째 out변수 값
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("count", count);
		return map;
	}
	
	
	
	// 단위테스트
	public static void main(String[] args) {
		FilmDao filmDao = new FilmDao();
		int filmId = 7;
		int storeId = 2;
		Map<String, Object> map = filmDao.filmInStockCall(filmId, storeId);
		List<Integer> list = (List<Integer>)map.get("list");
		int count = (Integer)map.get("count");
		
		System.out.println(filmId + "번 영화는 "+ storeId +"번 가게에 "+count+"개 남음");
		for(int id : list) {
			System.out.println(id);
		
		}
	}
}