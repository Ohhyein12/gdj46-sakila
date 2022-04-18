package dao;

import java.sql.*;
import java.util.*;

import util.DBUtil;


public class StatsDataDao {
	public List<Map<String, Object>> amountByCustomer() {
	      List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      conn = DBUtil.getConnection();
	      String sql = "SELECT p.customer_id customerId,"
	            + "      concat(c.first_name,' ', c.last_name) name,"
	            + "      sum(p.amount) total"
	            + "      FROM payment p INNER JOIN customer c"
	            + "      ON p.customer_id = c.customer_id"
	            + "      GROUP BY p.customer_id"
	            + "      HAVING sum(p.amount) > 180"
	            + "      ORDER BY SUM(p.amount) DESC";
	      try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("customerId",rs.getInt("customerId"));
	            m.put("name",rs.getString("name"));
	            m.put("total",rs.getInt("total"));
	            list.add(m);
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
	public List<Map<String, Object>> amountByRentalRate() {
		  List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      conn = DBUtil.getConnection();
	      String sql = "SELECT rental_rate rentalRate,"
		      		+ "		COUNT(*) cnt"
		    		+"		FROM film"
		    		+"		GROUP BY rental_rate"
		    		+"		ORDER BY COUNT(*) DESC";
	      try {
		         stmt = conn.prepareStatement(sql);
		         rs = stmt.executeQuery();
		         while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("rentalRate",rs.getDouble("rentalRate"));
		            m.put("cnt",rs.getInt("cnt"));
		            list.add(m);
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
	
	public List<Map<String, Object>> amountByRating() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      conn = DBUtil.getConnection();
	      String sql = "SELECT rating,"
	      		+"			COUNT(*) cnt"
	    		+" 			FROM film"
	    		+"  		GROUP BY rating"
	    		+"			ORDER BY COUNT(*) DESC";
	    		
	      try {
		         stmt = conn.prepareStatement(sql);
		         rs = stmt.executeQuery();
		         while(rs.next()) {
		            Map<String, Object> m = new HashMap<>();
		            m.put("rating",rs.getString("rating"));
		            m.put("cnt",rs.getInt("cnt"));
		            list.add(m);
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
	
	public List<Map<String, Object>> amountByCustomerOne() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    conn = DBUtil.getConnection();
	    String sql = "SELECT *"
	    	+"			FROM customer"
	    	+"			WHERE customer_id = (SELECT customer_id"
	    	+"								FROM payment"
	    	+"								GROUP BY customer_id"
	    	+"								ORDER BY COUNT(*) DESC"
	    	+"								LIMIT 0,1)";
	    try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("customerId",rs.getInt("customer_id"));
	            m.put("storeId",rs.getInt("store_id"));
	            m.put("firstName",rs.getString("first_name"));
	            m.put("lastName",rs.getString("last_name"));
	            m.put("email",rs.getString("email"));
	            m.put("addressId",rs.getInt("address_id"));
	            m.put("active",rs.getInt("active"));
	            m.put("createDate",rs.getString("create_date"));
	            m.put("lastUpdate",rs.getString("last_update"));
	            list.add(m);
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
	public List<Map<String, Object>> languageByFilm() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    conn = DBUtil.getConnection();
	    String sql = "SELECT l.name,"
	    		+"		COUNT(*) cnt"
	    		+"		FROM film f INNER JOIN language l"
	    		+"		ON f.language_id = l.language_id"
	    		+"		GROUP BY l.name";
	    try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("name",rs.getString("name"));
	            m.put("cnt",rs.getInt("cnt"));
	            list.add(m);
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
	
	public List<Map<String, Object>> lengthByFilm() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    conn = DBUtil.getConnection();
	    String sql = "SELECT t.length2 AS runTime , COUNT(*) as cnt"
	    		+"		FROM ( SELECT title, LENGTH,"
	    		+"				CASE WHEN LENGTH<60 THEN 'less 60'" 
	    		+"					 WHEN LENGTH BETWEEN 61 AND 120 THEN 'between 61 and 120'"
	    		+"					 WHEN LENGTH BETWEEN 121 AND 180 THEN 'between 121 and 180'" 
	    		+"					 ELSE 'more 180'" 
	    		+"				END LENGTH2,"
	    		+"				CASE WHEN LENGTH<60 THEN 1"
	    		+"					 WHEN LENGTH BETWEEN 61 AND 120 THEN 2"
	    		+"					 WHEN LENGTH BETWEEN 121 AND 180 THEN 3"
	    		+"					 ELSE 4"
	    		+"				END LENGTH_ORDER"
	    		+"		FROM film) t"
	    		+"		GROUP BY t.length_order ORDER BY t.length_order asc";
	    try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("runTime",rs.getString("runTime"));
	            m.put("cnt",rs.getInt("cnt"));
	            list.add(m);
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
	public List<Map<String, Object>> storeDayOfWeekPayment () {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    conn = DBUtil.getConnection();
	    String sql = "SELECT s.store_id,"
	    		+"		CASE t.w"
				+"		WHEN 0 THEN '월'"
				+"		WHEN 1 THEN '화'"
				+"		WHEN 2 THEN '수'"
				+"		WHEN 3 THEN '목'"
				+"		WHEN 4 THEN '금'"
				+"		WHEN 5 THEN '토'"
				+"		WHEN 6 THEN '일'"
				+"	END DAYOFWEEK,t.cnt"
				+"	FROM (SELECT staff_id, WEEKDAY(payment_date) w, COUNT(*) cnt"
				+"		  FROM payment"
				+"	GROUP BY staff_id, WEEKDAY(payment_date)) t"
				+"	INNER JOIN staff s"
				+"	ON t.staff_id = s.staff_id"
				+"	ORDER BY s.store_id, t.w ASC";
	    try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("storeId",rs.getInt("store_id"));
	            m.put("DAYOFWEEK",rs.getString("DAYOFWEEK"));
	            m.put("cnt",rs.getInt("cnt"));
	            list.add(m);
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
	
	public List<Map<String, Object>> customerByRental() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    conn = DBUtil.getConnection();
	    String sql ="SELECT customer_id, COUNT(*) cnt"
	    		+"	FROM rental" 
	    		+"	GROUP BY customer_id";
	    try {
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("customerId",rs.getInt("customer_id"));
	            m.put("cnt",rs.getInt("cnt"));
	            list.add(m);
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
	
	public List<Map<String, Object>> actorByFilm() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql ="SELECT f.actor_id actorId,\r\n"
				+ "		a.actorName actorName,\r\n"
				+ "		COUNT(*) cnt\r\n"
				+ "FROM(SELECT actor_id,\r\n"
				+ "		CONCAT(first_name,' ',last_name) actorName\r\n"
				+ "		FROM actor) a\r\n"
				+ "INNER JOIN film_actor f\r\n"
				+ "ON f.actor_id = a.actor_id\r\n"
				+ "GROUP BY f.actor_id\r\n";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("actorId",rs.getInt("actorId"));
				m.put("actorName",rs.getString("actorName"));
				m.put("cnt",rs.getInt("cnt"));
				list.add(m);
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
	
	
	public List<Map<String, Object>> staffByRental() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql ="SELECT staff_id, COUNT(*) cnt\r\n"
				+ "FROM rental\r\n"
				+ "GROUP BY staff_id";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("staffId",rs.getInt("staff_id"));
				m.put("cnt",rs.getInt("cnt"));
				list.add(m);
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
	
	public List<Map<String, Object>> storeByInventory() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql ="SELECT store_id, COUNT(*) cnt\r\n"
				+ "FROM inventory\r\n"
				+ "GROUP BY store_id";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("storeId",rs.getInt("store_id"));
				m.put("cnt",rs.getInt("cnt"));
				list.add(m);
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
	
	public List<Map<String, Object>> amountByfilm() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql ="SELECT \r\n"
				+ "		f.title title,\r\n"
				+ "		SUM(p.amount) total\r\n"
				+ "FROM payment p\r\n"
				+ "INNER JOIN rental r\r\n"
				+ "ON p.rental_id = r.rental_id\r\n"
				+ "INNER JOIN inventory i \r\n"
				+ "ON i.inventory_id = r.inventory_id\r\n"
				+ "INNER JOIN film f\r\n"
				+ "ON f.film_id = i.film_id\r\n"
				+ "GROUP BY f.film_id";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("title",rs.getString("title"));
				m.put("total",rs.getInt("total"));
				list.add(m);
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
	
	public List<Map<String, Object>> cntByfilm() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		String sql ="SELECT\r\n"
				+ "		f.title,\r\n"
				+ "		COUNT(*) cnt\r\n"
				+ "FROM rental r\r\n"
				+ "INNER JOIN inventory i\r\n"
				+ "ON r.inventory_id = i.inventory_id\r\n"
				+ "INNER JOIN film f\r\n"
				+ "ON f.film_id = i.film_id\r\n"
				+ "GROUP BY f.film_id";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("title",rs.getString("title"));
				m.put("cnt",rs.getInt("cnt"));
				list.add(m);
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
