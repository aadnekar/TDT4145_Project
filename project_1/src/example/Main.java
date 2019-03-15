package example;

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		createTable();
//		post();
		get();
	}
	
	
	public static ArrayList<String> get() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(
						"select first, last from dirtyDancer"
					);
			ResultSet rs  = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(rs.next()) {
				System.out.print(rs.getString("first"));
				System.out.print(" ");
				System.out.println("last");
				
				array.add(rs.getString("last"));
			}
			System.out.println("All records have been selected!");
			return array;
		} catch(Exception e) {
			System.out.println("db error during select: " + e);
			return null;
		}
		
	}
	
	public static void post() throws Exception {
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement(
						"Insert into dirtyDancer (first, last) values ('"
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
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS dirtyDancer(" + 
															"id int NOT NULL AUTO_INCREMENT, " + 
															"first varchar(255), " +
															"last varchar(255), " +
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
