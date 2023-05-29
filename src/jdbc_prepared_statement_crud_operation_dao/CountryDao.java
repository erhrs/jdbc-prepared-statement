package jdbc_prepared_statement_crud_operation_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_prepared_statement_crud_operation_connection.CountryConnection;
import jdbc_prepared_statement_crud_operation_dto.Country;


public class CountryDao {
	Connection con = CountryConnection.getCountryConnection();
	
	/*
	 * Save country name
	 */
	public Country saveCountry(Country country) {
		String insertCountryQuery = "insert into country values(?,?,?,?)";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(insertCountryQuery);
			pstmt.setInt(1, country.getCountryId());
			pstmt.setString(2, country.getCountryName());
			pstmt.setString(3, country.getCountryCapital());
			pstmt.setInt(4, country.getCountryStates());
			
			pstmt.executeUpdate();
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
	}
	public void deleteById(int id) {
		String deleteQuery = "delete from country where countryid=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);;
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Country getById(int countryid) {
		
		String selectQuery = "select * from country where countryid =?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, countryid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Country country = new Country();
				country.setCountryId(rs.getInt(1));
				country.setCountryName(rs.getString(2));
				country.setCountryCapital(rs.getString(3));
				country.setCountryStates(rs.getInt(4));
				System.out.println(country);
				return country;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	public List<Country> DisplyAll() {
		String displayAll = "Select * from country";
		try {
			PreparedStatement pstmt = con.prepareStatement(displayAll);
			ResultSet rs = pstmt.executeQuery();
			
			List<Country> countries = new ArrayList<Country>();
			while(rs.next()) {
				Country country = new Country();
				int id = rs.getInt("countryid");
				String name = rs.getString("countryname");
				String capital = rs.getString("countrycapital");
				int states = rs.getInt("countrystates");
				
				country.setCountryId(id);
				country.setCountryName(name);
				country.setCountryCapital(capital);
				country.setCountryStates(states);
				
				countries.add(country);
			}
			return countries;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public int updateCapital(int id, String capital) {
		String updateCapQuery = "update country set countrycapital = ? where countryid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(updateCapQuery);
			pstmt.setString(1, capital);
			pstmt.setInt(2, id);
			
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	

}

