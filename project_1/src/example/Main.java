package example;

import java.sql.*;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) throws Exception {
		createTable();
		post();
		get();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate myObj;
//		myObj = LocalDate.now();
//		myObj = LocalDate.parse("2019-03-16", formatter);
//		System.out.println("Date: " + myObj);
	}
	
	
	public static ArrayList<String> get() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(
						"select name, date from date_table"
					);
			ResultSet rs  = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(" ");
				System.out.println("date");
				
				array.add(rs.getString("date"));
			}
			System.out.println("All records have been selected!");
			return array;
		} catch(Exception e) {
			System.out.println("db error during select: " + e);
			return null;
		}
		
	}
	
	public static void post() throws Exception {
		final String var1 = "Game med Ole Martin";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate temp = LocalDate.parse("2019-03-17", formatter);
		System.out.println("Date convert: " + temp);
		Date var2 = Date.valueOf(temp);
		System.out.println("Date to be inserted: " + var2);
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement(
						"Insert into date_table (name, date) values ('"
					+	var1 + "', '"
					+	var2 + "')"
					);
			posted.executeUpdate();
		} catch(Exception e) {
			System.out.println("db error during post: " + e);
		} finally {
			System.out.println("Insert completed");
		}
	}
	
	
	public static void createTable() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS date_table(" + 
															"id int NOT NULL AUTO_INCREMENT, " + 
															"name varchar(255), " +
															"date Date, " +
															"PRIMARY KEY(id));");
			create.executeUpdate();
		} catch(Exception e) {
			System.out.println("error during creation of Table = " + e);			
		} finally {
			System.out.println("createTable function complete.");
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/java_database";
			String username = "myDatabaseUser";
			String password = "password!321";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to: " + url);
			return conn;
		} catch(Exception e) {
			System.out.println("db error during connection to java_database: " + e);
		}
		return null;
	}
	
//	public static void close(Connection conn) throws Exception {
//		try {
//			if (conn != null) {
//				conn.close();
//			}
//		} catch(Exception e) {
//			System.out.println("db error during connection close: " + e);
//		} finally {
//			System.out.println("Closed connection!");
//		}
//	}
}
