package jdbc_prepared_statement_crud_operation_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CountryConnection {
	public static Connection getCountryConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hrs_java";
			String user = "root";
			String pass = "j2ee@2023";
			
			return DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
