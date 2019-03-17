package application;

import java.sql.*;
import java.util.Properties;

public class DBConn {

    protected Connection conn;
    
    
    public DBConn () {
    }
    
    // Want to use this function when connecting the DB
    public void connect() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Properties for user and password. Here the user and password are both 'paulr'
            Properties p = new Properties();
            p.put("user", "aadneka_test");
            p.put("password", "tdt4145");     
            conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/aadneka_kosegjeng",p);
        } catch (Exception e){
            throw new RuntimeException("Unable to connect", e);
    	} finally {
    		System.out.println("Connection to database");
    	}
    }
    
}
