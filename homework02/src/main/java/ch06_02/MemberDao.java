package ch06_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Blob;

public class MemberDao {
	
	DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	private static final String SELECT_BY_ID = "Select id, year, week, type, age, county, visit, tatlevisits from Enterovirus where id = ?";

	public MemberBean select(Integer id) {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		) {
			stmt.setInt(1, id);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new MemberBean();
					result.setId(rset.getInt("id"));;
					result.setYear(rset.getInt("year"));
					result.setWeek(rset.getInt("week"));
					result.setType(rset.getString("type"));
					result.setAge(rset.getString("age"));
					result.setCounty(rset.getString("county"));
					result.setVisit(rset.getInt("visit"));
					result.setTatlevisits(rset.getInt("tatlevisits"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private static final String SELECT_ALL = "Select id, year, week, type, age, county, visit, tatlevisits from Enterovirus";
	
	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();				
		) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setId(rset.getInt("id"));;
				temp.setYear(rset.getInt("year"));
				temp.setWeek(rset.getInt("week"));
				temp.setType(rset.getString("type"));
				temp.setAge(rset.getString("age"));
				temp.setCounty(rset.getString("county"));
				temp.setVisit(rset.getInt("visit"));
				temp.setTatlevisits(rset.getInt("tatlevisits"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	private static final String INSERT = "Insert into Enterovirus (id, year, week, type, age, county, visit, tatlevisits) values (?, ?, ?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setInt(1, bean.getId());
			stmt.setInt(2, bean.getYear());
			stmt.setInt(3, bean.getWeek());
			stmt.setString(4, bean.getType());
			stmt.setString(5, bean.getAge());
			stmt.setString(6, bean.getCounty());
			stmt.setInt(7, bean.getVisit());
			stmt.setInt(8, bean.getTatlevisits());
			stmt.executeUpdate();

		} 
		return result;
	}

	private static final String DELETE = "Delete from Enterovirus where id=?";

	public int delete(int id) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}