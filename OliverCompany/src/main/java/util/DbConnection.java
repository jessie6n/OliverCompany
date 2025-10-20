package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		DbConnection.getDb();
	}

	public static Connection getDb() {
		String url="jdbc:mysql://localhost:3306/OliverCompany";
		String username="root";
		String password="1234";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("no Driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no Connection");
		}
		
		return conn;
		
	}
}
